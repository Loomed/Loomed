package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RedirectController {
	SCHEDULE ("redirect:/schedule"),
	;

	final String redirectName;
}
