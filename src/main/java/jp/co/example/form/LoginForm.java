package jp.co.example.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
	@NotNull
	private Integer userId;
	@NotBlank
	private String password;
	private String page;//
}