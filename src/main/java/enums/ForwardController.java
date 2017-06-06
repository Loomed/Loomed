package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ForwardController {

	HOME("home"),
	INDEX("index"),
	LOGIN("login"),
	MAIL("mail"),
	MEMBER("member"),
	ROOTHOME("roothome"),
	SCHEDULE("schedule"),
	SHARECONFIG("shareconfig"),
	TRAININGCHANGE("trainingchange"),
	TRAININGCONFIG("trainingconfig"),
	USERCHANGE("userchange"),
	USERCONFIG("userconfig"),
	USERINFO("userinfo"),
	;

	final String ForwardName;
}
