package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ForwardController {

	HOME("forward:home"),
	INDEX("forward:index"),
	LOGIN("forward:login"),
	MAIL("forward:mail"),
	MEMBER("forward:member"),
	ROOTHOME("forward:roothome"),
	SCHEDULE("forward:schedule"),
	SHARECONFIG("forward:shareconfig"),
	TRAININGCHANGE("forward:trainingchange"),
	TRAININGCONFIG("forward:trainingconfig"),
	USERCHANGE("forward:userchange"),
	USERCONFIG("forward:userconfig"),
	USERINFO("forward:userinfo"),
	;

	final String ForwardName;
}
