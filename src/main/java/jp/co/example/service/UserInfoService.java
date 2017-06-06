package jp.co.example.service;

import jp.co.example.entity.Maps;
import jp.co.example.entity.Users;

public interface UserInfoService {
	int Update(Users user, Maps map);
	Users getUser(Users user);//
}
