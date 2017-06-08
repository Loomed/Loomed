package jp.co.example.dao;

import java.sql.Timestamp;
import java.util.List;

import jp.co.example.entity.Projectors;

/**
 * プロジェクタを操作するDAOインターフェース
 * @author Yukihiro Yoshida
 *
 */
public interface ProjectorsDao {
	/**
	 * 教室IDから一日分のプロジェクタ予約を取得するSQL文を実行するメソッド
	 * ある日付の0:00:00~23:59:59の時間を取得する
	 * @param trainingId 検索する教室ID
	 * @param dateMin 検索する日付(0:00:00)
	 * @param dateMax 検索する日付(23:59:59)
	 * @return 検索結果のレコード
	 */
	List<Projectors> selectProjectorsWhereTrainingIdAndDate(Integer trainingId, Timestamp dateMin, Timestamp dateMax);

	/**
	 * 教室IDから一日の特定の時間のプロジェクタ予約レコードを取得するSQL文を実行するメソッド
	 * @param trainingId 検索する教室ID
	 * @param dateTime 検索する日時
	 * @return 検索結果のレコード
	 */
	List<Projectors> selectProjectorsWhereTrainingIdAndDateTime(Integer trainingId, Timestamp dateTime);

	/**
	 * プロジェクタ予約の削除をするSQL文を実行するメソッド
	 * @param projectorId 削除するプロジェクタID
	 * @return 更新したレコード件数
	 */
	int deleteWhereProjectorId(Integer projectorId);

	/**
	 * プロジェクタ予約の追加をするSQL文を実行するメソッド
	 * @param trainingId 追加項目
	 * @param projectorNumber 追加項目
	 * @param userId 追加項目
	 * @param reserveTime 追加項目
	 * @return 更新したレコード件数
	 */
	int insertProjectoReserve(Integer trainingId, Integer projectorNumber, Integer userId, Timestamp reserveTime);
}
