package jp.co.example.form;

import org.hibernate.validator.constraints.*;

import lombok.*;

@Getter
@Setter
public class LoginForm {
	@NotBlank
	private Integer userId;
	@NotBlank
	private String password;
	private String page;
}