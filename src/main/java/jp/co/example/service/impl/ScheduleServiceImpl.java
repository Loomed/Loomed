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
	private static final String[] TIME_SPAN = { "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30",
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
			log.info(LogEnum.IF.getLogValue() + "SELECT_ALL.equals(time)");
			if (SELECT_ALL.equals(time)) {
				// 全時間帯のプロジェクタを参照する場合
				log.info(LogEnum.TRUE.getLogValue());

				Timestamp dateMin = new Timestamp(SDF_DATETIME.parse(date + " 0:0:0").getTime());
				Timestamp dateMax = new Timestamp(SDF_DATETIME.parse(date + " 23:59:59").getTime());
				list = pd.selectProjectorsWhereTrainingIdAndDate(trainingId, dateMin, dateMax);
			} else {
				log.info(LogEnum.FALSE.getLogValue());

				Timestamp dateTime = new Timestamp(SDF_DATETIME.parse(date + " " + time).getTime());
				log.info("PARAM" + dateTime);
				log.info("PARAM" + trainingId);
				log.info("PARAM" + pd.toString());
				list = pd.selectProjectorsWhereTrainingIdAndDateTime(trainingId, dateTime);
			}

			List<ProjectorForm> listForm = new ArrayList<>();
			// 末尾に空データを追加
			list.add(new Projectors());
			// プロジェクトの数を取得
			int projectorCount = td.getTraining(trainingId).getProjectorCount();

			int listIndex = 0;
			Users projectorUser;
			Timestamp ts = null;

			if(SELECT_ALL.equals(time)) {

			} else {
				for(int i = 0; i < projectorCount; i++) {
					if(list.get(listIndex).getProjectorNumber() == i + 1) {
						//プロジェクタ番号が同じの場合のレコードがある場合
						log.info(LogEnum.TRUE.getLogValue());

						projectorUser = ud.findById(list.get(listIndex).getUserId());
						listForm.add(new ProjectorForm(time, "プロジェクタ" + list.get(listIndex).getProjectorNumber(),
								projectorUser.getUserName()));
					} else {
						log.info(LogEnum.FALSE.getLogValue());

						listForm.add(new ProjectorForm(TIME_SPAN[i], "プロジェクタ" + (i + 1), "予約なし"));
					}
				}
			}




//			// 時間ごとにループをする
//			log.info(LogEnum.FOR.getLogValue() + "int i = 0; i < TIME_SPAN.length; i++" + LogEnum.START.getLogValue());
//			for (int i = 0; i < TIME_SPAN.length; i++) {
//				// jsp用にtimestampをStringに変換
//				String timeForm = SDF_TIME.format(list.get(listIndex).getReserveTime());
//				log.info(LogEnum.FOR.getLogValue() + "int j = 0; j < projectorCount; j++" + LogEnum.START.getLogValue());
//				for (int j = 0; j < projectorCount; j++) {
//					// プロジェクタの数だけループ
//					// テーブルがない場合予約なしを追加する
//					log.info(LogEnum.IF.getLogValue() + "TIME_SPAN[i].equals(timeForm) && list.get(listIndex).getProjectorNumber() == j");
//					if(TIME_SPAN[i].equals(timeForm) && list.get(listIndex).getProjectorNumber() == j ) {
//						//Projectorのlistに時間が同じなおかつ、プロジェクタ番号が同じの場合のレコードがある場合
//						log.info(LogEnum.TRUE.getLogValue());
//
//						projectorUser = ud.findById(list.get(listIndex).getUserId());
//						listForm.add(new ProjectorForm(timeForm, "プロジェクタ" + list.get(listIndex).getProjectorNumber(),
//								projectorUser.getUserName()));
//						listIndex++;
//					} else {
//						//ない場合
//						log.info(LogEnum.FALSE.getLogValue());
//
//						listForm.add(new ProjectorForm(TIME_SPAN[i], "プロジェクタ" + j, "予約なし"));
//					}
//				}
//				log.info(LogEnum.FOR.getLogValue() + "int j = 0; j < projectorCount; j++" + LogEnum.END.getLogValue());
//			}
			log.info(LogEnum.FOR.getLogValue() + "int i = 0; i < TIME_SPAN.length; i++" + LogEnum.END.getLogValue());

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return listForm;

		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return null;
	}

}
