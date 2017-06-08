package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RedirectController {
	SCHEDULE ("redirect:/schedule"),
	HOME ("redirect:/home"),
	INDEX ("redirect:/index"),
	SHARECONFIG("redirect:/shareconfig"),
	LOGIN("redirect:/login"),
	;

	final String redirectName;
}
