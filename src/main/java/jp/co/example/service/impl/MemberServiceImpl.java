package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Users;
import jp.co.example.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	UsersDao UsersDao;

	public List<Users> Member(int myRoomId, int comId, int nowRoomId) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//←ここから
		List<Users> members = new ArrayList<>();

		log.info(LogEnum.IF.getLogValue() + "myRoomId == nowRoomId");
		if(myRoomId == nowRoomId){
			log.info(LogEnum.TRUE.getLogValue() + "FindRoomMemberから自身と同じ教室メンバーを受け取る");
			//members = UsersDao.FindRoomMember(myRoomId);
		}else{
			log.info(LogEnum.FALSE.getLogValue() + "FindCompMemberから自身と同じ企業メンバーを受け取る");
			//members = UsersDao.FindCompMember(comId);
		}

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return members;
	}

}