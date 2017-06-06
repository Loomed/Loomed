package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Maps;
import jp.co.example.entity.Users;
import jp.co.example.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	UsersDao UsersDao;

	public List<Users> Member(List<Maps> UserMap, int userComId, int nowTrainingId) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//←ここから
		List<Users> members = new ArrayList<>();
		int nowRoomFlag = 0;

		for(int i=0;i<UserMap.size();i++){
			log.info(LogEnum.IF.getLogValue() + "UserMap.get(i).getTrainingId() == nowTrainingId");
			if(UserMap.get(i).getTrainingId() == nowTrainingId){
				log.info(LogEnum.TRUE.getLogValue() + "nowRoomFlag = 1");
				nowRoomFlag = 1;
			}else{
				log.info(LogEnum.FALSE.getLogValue() + "nowRoomFlag = 0のまま");
			}
		}

		switch(nowRoomFlag){
			case 0:
				members = UsersDao.FindCompMember(userComId);
				break;
			case 1:
				members = UsersDao.FindRoomMember(nowTrainingId);
				break;
			default:
				break;
		}
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return members;

//		log.info(LogEnum.IF.getLogValue() + "myRoomId == nowRoomId");
//		if( == nowRoomId){
//			log.info(LogEnum.TRUE.getLogValue() + "FindRoomMemberから自身と同じ教室メンバーを受け取る");
//			//members = UsersDao.FindRoomMember(myRoomId);
//		}else{
//			log.info(LogEnum.FALSE.getLogValue() + "FindCompMemberから自身と同じ企業メンバーを受け取る");
//			//members = UsersDao.FindCompMember(comId);
//		}
//
//		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
//		return members;
	}

}