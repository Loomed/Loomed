package myTest;

import jp.co.example.entity.Users;

public interface MyUsersDao {
	Users LoginUser(int id, String pass);
}
