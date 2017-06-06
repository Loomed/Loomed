package jp.co.example.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import enums.LogEnum;
import jp.co.example.dao.*;
import jp.co.example.entity.*;
import jp.co.example.form.ProjectorForm;
import jp.co.example.form.ScheduleForm;
import jp.co.example.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	private static final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	private static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("HH:mm");
	private static final String SELECT_ALL = "All";
	private static final String[] TIME_SPAN = { "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30",
			"13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30",
			"19:00", "19:30", };

	@Autowired
	SchedulesDao sd;

	@Autowired
	ProjectorsDao pd;

	@Autowired
	UsersDao ud;

	@Autowired
	TrainingsDao td;

	@Override
	public List<ScheduleForm> getSchedule(Integer userId, String date) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		try {
			Timestamp dateMin = new Timestamp(SDF_DATETIME.parse(date + " 0:0:0").getTime());
			Timestamp dateMax = new Timestamp(SDF_DATETIME.parse(date + " 23:59:59").getTime());
			List<Schedules> list = sd.selectScheduleWhereUserIdAndDate(userId, dateMin, dateMax);

			List<ScheduleForm> listForm = new ArrayList<>();
			Timestamp ts = null;
			// jsp用にtimestampをStringに変換
			for (int i = 0; i < list.size(); i++) {
				ts = list.get(i).getUploadDatetime();
				listForm.add(new ScheduleForm(SDF_TIME.format(ts), list.get(i).getScheduleContents(),
						list.get(i).isImportant()));
			}

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return listForm;
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			log.info(Util.getMethodName() + LogEnum.EXCEPTION.getLogValue());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ProjectorForm> getProjectorJson(Integer trainingId, String date, String time) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Projectors> list = new ArrayList<>();
		try {
			//プロジェクタSELECT処理
			log.info(LogEnum.IF.getLogValue() + "SELECT_ALL.equals(time)");
			if (SELECT_ALL.equals(time)) {
				// 全時間帯のプロジェクタを参照する場合
				log.info(LogEnum.TRUE.getLogValue());

				Timestamp dateMin = new Timestamp(SDF_DATETIME.parse(date + " 0:0:0").getTime());
				Timestamp dateMax = new Timestamp(SDF_DATETIME.parse(date + " 23:59:59").getTime());
				list = pd.selectProjectorsWhereTrainingIdAndDate(trainingId, dateMin, dateMax);
			} else {
				//指定の時間帯を参照する場合
				log.info(LogEnum.FALSE.getLogValue());

				Timestamp dateTime = new Timestamp(SDF_DATETIME.parse(date + " " + time).getTime());
				log.info("PARAM" + dateTime);
				log.info("PARAM" + trainingId);
				log.info("PARAM" + pd.toString());
				list = pd.selectProjectorsWhereTrainingIdAndDateTime(trainingId, dateTime);
			}

			List<ProjectorForm> listForm;
			// 末尾にヌルポ回避用データを追加
			list.add(new Projectors(
					-1, -1, -1, -1, new Timestamp(SDF_DATETIME.parse("1900/1/1 0:0:0").getTime())));
			// プロジェクタの数を取得
			int projectorCount = td.getTraining(trainingId).getProjectorCount();

			if(SELECT_ALL.equals(time)) {
				listForm = ScheduleServiceImpl.valueOfProjectorFormTimeAll(list, ud, time, projectorCount);
			} else {
				listForm = ScheduleServiceImpl.valueOfProjectorFormTimeSelect(list, ud, time, projectorCount);
			}

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return listForm;

		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return null;
	}

	/**
	 * 時間を指定した際
	 * プロジェクタ予約をSchedule.jspに表示できるリストに置き換える
	 * @param list SELECTしたプロジェクタ
	 * @param ud ユーザーDAO
	 * @param time プロジェクタの時刻
	 * @param projectorCount プロジェクタの数
	 * @return Schedule.jspに表示させるリスト
	 */
	private static List<ProjectorForm> valueOfProjectorFormTimeSelect(List<Projectors> list, UsersDao ud, String time, int projectorCount) {
		List<ProjectorForm> listForm = new ArrayList<>();
		Users projectorUser;
		int listIndex = 0;

		for(int i = 0; i < projectorCount; i++) {
			//プロジェクタの数だけまわす
			log.info(LogEnum.IF.getLogValue() + "list.get(listIndex).getProjectorNumber() == i + 1");
			if(list.get(listIndex).getProjectorNumber() == i + 1) {
				//プロジェクタ番号がレコードがある場合
				log.info(LogEnum.TRUE.getLogValue());

				projectorUser = ud.findById(list.get(listIndex).getUserId());
				listForm.add(new ProjectorForm(time, "プロジェクタ" + (i + 1), projectorUser.getUserName()));
				listIndex++;
			} else {
				log.info(LogEnum.FALSE.getLogValue());

				listForm.add(new ProjectorForm(time, "プロジェクタ" + (i + 1), "予約なし"));
			}
		}

		return listForm;
	}

	/**
	 * 全てを参照した際
	 * プロジェクタ予約をSchedule.jspに表示できるリストに置き換える
	 * @param list SELECTしたプロジェクタ
	 * @param ud ユーザーDAO
	 * @param time プロジェクタの時刻
	 * @param projectorCount プロジェクタの数
	 * @return Schedule.jspに表示させるリスト
	 */
	private static List<ProjectorForm> valueOfProjectorFormTimeAll(List<Projectors> list, UsersDao ud, String time, int projectorCount) {
		List<ProjectorForm> listForm = new ArrayList<>();
		Users projectorUser;
		int listIndex = 0;

		log.info(LogEnum.FOR.getLogValue() + "int i = 0; i < TIME_SPAN.length; i++" + LogEnum.START.getLogValue());
		for (int i = 0; i < TIME_SPAN.length; i++) {
			// 時間ごとにループをする
			// jsp用にtimestampをStringに変換
			log.info(LogEnum.FOR.getLogValue() + "int j = 0; j < projectorCount; j++" + LogEnum.START.getLogValue());
			for (int j = 0; j < projectorCount; j++) {
				String timeForm = SDF_TIME.format(list.get(listIndex).getReserveTime());
				log.info(timeForm);
				// プロジェクタの数だけループ
				// テーブルがない場合予約なしを追加する
				log.info(LogEnum.IF.getLogValue() + "TIME_SPAN[i].equals(timeForm) && list.get(listIndex).getProjectorNumber() == j + 1");
				if(TIME_SPAN[i].equals(timeForm) && list.get(listIndex).getProjectorNumber() == j + 1 ) {
					//Projectorのlistに時間が同じなおかつ、プロジェクタ番号が同じの場合のレコードがある場合
					log.info(LogEnum.TRUE.getLogValue());

					projectorUser = ud.findById(list.get(listIndex).getUserId());
					listForm.add(new ProjectorForm(timeForm, "プロジェクタ" + (j + 1), projectorUser.getUserName()));
					listIndex++;
				} else {
					//ない場合
					log.info(LogEnum.FALSE.getLogValue());

					listForm.add(new ProjectorForm(TIME_SPAN[i], "プロジェクタ" + (j + 1), "予約なし"));
				}
			}
			log.info(LogEnum.FOR.getLogValue() + "int j = 0; j < projectorCount; j++" + LogEnum.END.getLogValue());
		}
		log.info(LogEnum.FOR.getLogValue() + "int i = 0; i < TIME_SPAN.length; i++" + LogEnum.END.getLogValue());

		return listForm;
	}

}
