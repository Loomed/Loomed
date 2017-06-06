package jp.co.example.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	private Integer userId;
	private String password;
	private String userName;
	private Integer companyId;
	private Integer authority;
}
