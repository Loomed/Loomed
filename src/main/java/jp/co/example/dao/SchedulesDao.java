package jp.co.example.dao;

import java.sql.Timestamp;
import java.util.List;

import jp.co.example.entity.Schedules;
import jp.co.example.entity.Users;

/**
 * スケジュールテーブルを操作するDAOインターフェース
 *
 */
public interface SchedulesDao {
	/**
	 * 1ユーザのスケジュールを一日分取得するSQL文を実行するメソッド
	 * ある日付の0:00:00~23:59:59の時間を取得する
	 * @author Yukihiro Yoshida
	 * @param userId 検索するレコードのユーザID
	 * @param dateMin 取得する日付(0:00:00)
	 * @param dateMax 取得する日付(23:59:59)
	 * @return 検索結果のレコード
	 */
	List<Schedules> selectScheduleWhereUserIdAndDate(Integer userId, Timestamp dateMin, Timestamp dateMax);

	List<Schedules> getInpoSche(Users user);

	/**
	 * スケジュールの更新を行うSQL文を実行するメソッド
	 * @author Yukihiro Yoshida
	 * @param scheduleId 更新するレコードのスケジュールID
	 * @param content 更新項目
	 * @param dateTime 更新項目
	 * @param important 更新項目
	 * @return 更新したレコード件数
	 */
	int updateScheduleWhereScheduleId(Integer scheduleId, String content, Timestamp dateTime, boolean important);

	/**
	 * スケジュールの削除を行うSQL文を実行するメソッド
	 * @author Yukihiro Yoshida
	 * @param scheduleId 削除するレコードのスケジュールID
	 * @return 更新したレコード件数
	 */
	int deleteScheduleWhereScheduleId(Integer scheduleId);

	/**
	 * スケジュールの追加を行うSQL文を実行するメソッド
	 * @author Yukihiro Yoshida
	 * @param userId 追加項目
	 * @param content 追加項目
	 * @param dateTime 追加項目
	 * @param important 追加項目
	 * @return 更新したレコード件数
	 */
	int insertSchedule(Integer userId, String content, Timestamp dateTime, boolean important);
}
