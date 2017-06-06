package jp.co.example.form;

import org.hibernate.validator.constraints.NotBlank;


public class MailForm {
//	@NotBlank
//	private String name;
	@NotBlank
	private String mailTitle;
	@NotBlank
	private String mailContents;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getMailTitle() {
		return mailTitle;
	}
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
	public String getM8ailContents() {
		return mailContents;
	}
	public void setMailContents(String mailContents) {
		this.mailContents =mailContents;
	}

//	@Override
//	public String getUserName() {
//		// TODO 自動生成されたメソッド・スタブ
//		return name;
//	}
	@Override
	public String getTitle() {
		// TODO 自動生成されたメソッド・スタブ
		return mailTitle;

	}
	@Override
	public String getContents() {
		// TODO 自動生成されたメソッド・スタブ
		return mailContents;
	}




}
