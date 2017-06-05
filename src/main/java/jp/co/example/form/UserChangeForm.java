package jp.co.example.form;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserChangeForm {
	@NotNull
	private Integer userId;
	@NotBlank
	private String password;
	@NotBlank
	private String userName;
	@NotBlank
	private String companyId;
	@NotNull
	private Integer authority;

	private String training;
}
