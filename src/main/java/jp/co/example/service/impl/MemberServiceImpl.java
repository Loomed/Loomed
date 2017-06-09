package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.CompaniesDao;
import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Companies;
import jp.co.example.entity.Maps;
import jp.co.example.entity.Users;
import jp.co.example.service.MemberService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Service
@Getter
@Setter
public class MemberServiceImpl implements MemberService {

	@Autowired
	UsersDao UsersDao;
	@Autowired
	CompaniesDao CompaniesDao;

	private static List<Companies> memberComp;

	@Override
	public List<Users> Member(List<Maps> UserMap, int userComId, int nowTrainingId, int Authority) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//←ここから
		List<Users> members = new ArrayList<>();
		int nowRoomFlag = 0;
		memberComp = null;

		for(int i=0;i<UserMap.size();i++){
			log.info(LogEnum.IF.getLogValue() + "Authority == 3");
			log.info(LogEnum.IF.getLogValue() + "UserMap.get(i).getTrainingId() == nowTrainingId");
			if(Authority == 2){
				log.info(LogEnum.TRUE.getLogValue() + "nowRoomFlag = 0");
			}else if(UserMap.get(i).getTrainingId() == nowTrainingId){
				log.info(LogEnum.TRUE.getLogValue() + "nowRoomFlag = 1");
				nowRoomFlag = 1;
			}else{
				log.info(LogEnum.FALSE.getLogValue() + "nowRoomFlag = 0のまま");
			}
		}

		switch(nowRoomFlag){
			case 0:
				members = UsersDao.FindCompMember(userComId,nowTrainingId);
				memberComp = CompaniesDao.FindRoomMemberComp(members);
				log.info("member:switch:0:"+members.size());
				break;
			case 1:
				members = UsersDao.FindRoomMember(nowTrainingId);
				memberComp = CompaniesDao.FindRoomMemberComp(members);
				log.info("member:switch:1:"+members.size());
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

	@Override
	public List<Companies> getMemberComp(){
		return memberComp;
	}

}