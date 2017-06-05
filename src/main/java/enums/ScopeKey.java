package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ScopeKey {
	LOGINUSER("loginuser"),
	LOGINROOM("loginroom"),
	;

	final String scopeKey;
}
