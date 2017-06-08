package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Authority {
	ROOT(0),//ルート
	LECTURER(1),//講師
	CHARGE(2),//担当者
	STUDENT(3),//生徒
	;

	final int authority;

}
