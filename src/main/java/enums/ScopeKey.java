package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ScopeKey {
	// LOGINUSER<Users>:現在ログインしているユーザ情報(1件)
	LOGINUSER("loginuser"),
	// LOGINROOM<Trainings>:現在見ている教室情報(1件)
	LOGINROOM("loginroom"),
	// USERMAP<List<Maps>>:現在ログインしているユーザに紐付けられている教室情報(複数)
	USERMAP("usermap"),
	// MEMBERS<List<Users>>:member.jspで表示するリスト
	MEMBERS("members"),
	;

	final String scopeKey;
}
