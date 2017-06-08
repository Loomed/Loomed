package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RedirectController {
	SCHEDULE ("redirect:/schedule"), SHARECONFIG("redirect:/shareconfig"),
	;

	final String redirectName;
}
