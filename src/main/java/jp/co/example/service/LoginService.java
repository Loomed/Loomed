package jp.co.example.service;

import jp.co.example.entity.Users;

public interface LoginService {
	public Users findByIdAndPass(Integer userId, String password);
}
