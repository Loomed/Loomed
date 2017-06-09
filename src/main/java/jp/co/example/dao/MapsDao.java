package jp.co.example.dao;

import java.util.*;

import jp.co.example.entity.*;
import jp.co.example.form.*;

public interface MapsDao {

	List<Maps> selectWhereUserId(Integer userId);

	/**
	 * マップとユーザテーブルを結合し１教室に所属しているユーザIDとユーザ名を取得するSQL分を実行するメソッド
	 * 第一引数のユーザIDは検索結果から除外される
	 * @author Yukihiro Yoshida
	 * @param userId 除外するユーザID
	 * @param trainingId 検索する教室ID
	 * @return 検索結果
	 */
	List<ReserveUserNameForm> selectUserIDAndUserNameJoinUsers(Integer userId, Integer trainingId);

	int update(int userId, int trainingId);

	int delete(int userId);

}
