package jp.co.example.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.example.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserChangeForm extends Users {
	@NotNull
	private Integer userId;//
	@NotBlank
	private String password;
	@NotBlank
	private String userName;
	@NotNull
	private Integer companyId;
	@NotNull
	private Integer authority;

	private String training;


}
