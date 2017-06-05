package jp.co.example.form;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserChangeForm {
	private Integer userId;
	private String password;
	private String userName;
	private String companyId;
	private Integer authority;
}
