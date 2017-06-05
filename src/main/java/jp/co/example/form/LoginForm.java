package jp.co.example.form;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class LoginForm {
	@NotBlank
	private String userId;
	@NotBlank
	private String password;
	private String page;


}