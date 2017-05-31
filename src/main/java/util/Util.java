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
}

