package jp.co.example.form;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;

import jp.co.example.entity.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserChangeForm extends Users {
	@NotNull
	private Integer userId;
	@NotBlank
	private String password;
	@NotBlank
	private String userName;
	@NotNull
	private Integer companyId;
	@NotNull
	private Integer authority;

	private Integer trainingId;
}
