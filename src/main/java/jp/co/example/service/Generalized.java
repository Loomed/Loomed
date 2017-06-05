package jp.co.example.service;

public class Generalized {
	public static boolean isNum(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
