package enums;

public enum JspPage {
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

	private final String pageName;

	JspPage(String pageName) {
		this.pageName = pageName;
	}

	public String getPageName() {
		return pageName;
	}
}
