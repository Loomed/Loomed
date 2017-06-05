package jp.co.example.controller;

import org.hibernate.validator.constraints.NotBlank;

public class LoginForm {
	@NotBlank
	private Integer userId;
	@NotBlank
	private String password;
	private String page;

	public Integer getId() {
		return userId;
	}

	public void setId(Integer userId) {
		this.userId = userId;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
}