package util;

import enums.*;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {
	/**
	 * 実行中のメソッド名を取得します。
	 *
	 * @author Yukihiro Yoshida
	 * @return メソッド名
	 */
	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	/**
	 * 実行中のクラス名を取得します。
	 *
	 * @author Yukihiro Yoshida
	 * @return クラス名
	 */
	public static String getClassName() {
		return Thread.currentThread().getStackTrace()[2].getClassName();
	}

	/**
	 * 権利IDから権利名を取得します
	 *
	 * @author sakata
	 * @param AuthorityId
	 * @return AuthorityName
	 */
	public static String getAuthorityName(int id) {
		String authorityName = null;

		switch (id) {
		case 0:
			authorityName = "ルートユーザ";
			break;
		case 1:
			authorityName = "講師";
			break;
		case 2:
			authorityName = "担当者";
			break;
		case 3:
			authorityName = "研修生";
			break;
		}

		return authorityName;
	}

	/**
	 * ユーザ情報と教室情報をチェック
	 *
	 * @author Yukihiro Yoshida
	 * @param user
	 *            ユーザ情報
	 * @param room
	 *            教室情報
	 * @return 情報がない場合、特定のjsp情報を送る ある場合はnull
	 */
	public static String sessionDataCheck(Users user, Trainings room) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		// ユーザ情報を確認
		String page = loginUserCheck(user);
		if (page != null) {
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return page;
		}

		// 部屋情報を確認
		log.info(LogEnum.IF.getLogValue() + "room == null");
		if (room == null) {
			log.info(LogEnum.TRUE.getLogValue());

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return ForwardController.INDEX.getForwardName();
			// インデックスへ戻る処理を書く
		} else {
			log.info(LogEnum.FALSE.getLogValue());

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return null;
		}
	}

	/**
	 * ユーザ情報をチェックする
	 *
	 * @author Yukihiro Yoshida
	 * @param user
	 *            ユーザ情報
	 * @return ユーザ情報がない場合index.jsp ある場合null
	 */
	public static String loginUserCheck(Users user) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		// ユーザー情報を確認
		log.info(LogEnum.IF.getLogValue() + "user == null");
		if (user == null) {
			log.info(LogEnum.TRUE.getLogValue());

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return JspPage.LOGIN.getPageName();
		} else {
			log.info(LogEnum.FALSE.getLogValue());

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return null;
		}
	}
}
