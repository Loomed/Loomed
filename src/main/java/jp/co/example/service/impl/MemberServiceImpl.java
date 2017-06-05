package jp.co.example.service.impl;

import java.util.*;

import org.springframework.stereotype.*;

import jp.co.example.dao.*;
import jp.co.example.entity.*;
import jp.co.example.service.*;

@Service
public class MemberServiceImpl implements MemberService {

	UsersDao UsersDao;

	public List<Users> Member(int roomId, int comId) {
		// return UserDao.FindMember(roomId,comId);←ここから
		return null;
	}

}