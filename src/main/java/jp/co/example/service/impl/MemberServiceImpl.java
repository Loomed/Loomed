package jp.co.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Users;
import jp.co.example.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	UsersDao UsersDao;

	public List<Users> Member(int roomId, int comId) {
		// return UserDao.FindMember(roomId,comId);←ここから
		return null;
	}

}