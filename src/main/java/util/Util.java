package util;

public class Util {
	 /**
     * 実行中のメソッド名を取得します。
     * @author Yukihiro Yoshida
     * @return メソッド名
     */
    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    /**
     * 実行中のクラス名を取得します。
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
    public static String getAuthorityName(int id)
	{
		String authorityName = null;

		switch(id){
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
}

