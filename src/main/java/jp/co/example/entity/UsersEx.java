package jp.co.example.entity;

import java.util.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UsersEx extends Users {
	private String companyName;
	private String authName;
	private List<Trainings> trainings;

	public UsersEx(Users user)
	{
		super.setUserId(user.getUserId());
		super.setPassword(user.getPassword());
		super.setUserName(user.getUserName());
		super.setCompanyId(user.getCompanyId());
		super.setAuthority(user.getAuthority());
	}
}
