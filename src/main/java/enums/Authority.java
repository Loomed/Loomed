package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Authority {
	ROOT(0),//ルート
	LECTURER(1),//講師
	STUDENT(2),//生徒
	CHARGE(3),//担当者
	;

	final int authority;

}
