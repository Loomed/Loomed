package myTest;

import jp.co.example.entity.Users;

public interface MyUserService {
	Users login(Users user);
	Users getUser(Users user);
}
