package jp.co.example.service;

import java.util.List;

import jp.co.example.form.*;

/**
 * スケジュールのサービス層
 * @author Yukihiro Yoshida
 *
 */
public interface ScheduleService {
	/**
	 * ユーザのスケジュールを取得するメソッド
	 * @param userId 取得するユーザID
	 * @param date 取得するスケジュールの日付
	 * @return 取得したスケジュールリスト
	 */
	List<ScheduleForm> getSchedule(Integer userId, String date);

	/**
	 * プロジェクタの予約状況を静的に取得するメソッド
	 * @param trainingId 取得する教室ID
	 * @param date 取得する日付
	 * @param time 取得する時間
	 * @return 取得したプロジェクタリスト
	 */
	List<ProjectorForm> getProjectorJson(Integer trainingId, String date, String time);

	/**
	 * プロジェクタの参照権限があるか判断するメソッド
	 * @param userId 取得するユーザID
	 * @param trainingId 取得する教室のID
	 * @return true...権限あり false...権限なし
	 */
	boolean isProjectorAuthority(Integer userId, Integer trainingId);

	/**
	 * プロジェクタの予約を行う際に選択出来るユーザを取得するメソッド
	 * @param userId 取得するユーザID
	 * @param trainingId 取得する教室ID
	 * @return ユーザIDとユーザ名を格納できる専用のフォームクラスリスト
	 */
	List<ReserveUserNameForm> getReserveUserNameJson(Integer userId, Integer trainingId);

	/**
	 * スケジュールの更新をかけるメソッド
	 * @param scheduleId 更新をかけるスケジュールID
	 * @param date 変更項目
	 * @param hour 変更項目
	 * @param minute 変更項目
	 * @param content 変更項目
	 * @param important 変更項目
	 * @return SQLの変更件数
	 */
	int scheduleApdate(String scheduleId, String date, String hour, String minute, String content, String important);

	/**
	 * スケジュールを削除するメソッド
	 * @param scheduleId 削除するスケジュールID
	 * @return SQLの変更件数
	 */
	int scheduleDelete(String scheduleId);

	/**
	 * スケジュールを追加するメソッド
	 * @param userId 追加するユーザID
	 * @param date 追加する日付
	 * @param hour 追加する時間
	 * @param minute 追加する時間
	 * @param content 追加する内容
	 * @param important 追加する重要度
	 * @return SQLの変更件数
	 */
	int scheduleInsert(Integer userId, String date, String hour, String minute, String content, String important);

	/**
	 * プロジェクタの予約解除を行うメソッド
	 * @param projectorId 予約解除するプロジェクタID
	 * @return SQLの変更件数
	 */
	int projectorReserveRelease(String projectorId);

	/**
	 * プロジェクタを予約するメソッド
	 * プロジェクタの予約が終わると自動的にスケジュールの追加(scheduleInsertメソッドの実行)が行われる
	 * @param trainingId 予約する教室ID
	 * @param number 予約するプロジェクタ番号
	 * @param userId 予約するユーザID
	 * @param date 予約する日付
	 * @param time 予約する時間
	 * @param content 予約する内容
	 * @return SQLの変更件数
	 */
	int projectorReserve(Integer trainingId, String number, String userId, String date, String time, String content);
}
