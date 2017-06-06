package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.LogEnum;
import enums.ScopeKey;
import jp.co.example.entity.Maps;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import jp.co.example.service.MemberService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Controller
@Getter
public class MemberController {
	@Autowired
	MemberService MemberService;
	@Autowired
	HttpServletRequest request;


	@RequestMapping("/member")
	public String getMember(HttpServletRequest request, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users LoginUser = null;
		Trainings nowTraining = null;
		List<Maps> UserMap = null;

		LoginUser = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());
		nowTraining = (Trainings) session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());
		UserMap = (List<Maps>) session.getAttribute(ScopeKey.USERMAP.getScopeKey());

		List<Users> members = new ArrayList<>();
		members = MemberService.Member(UserMap, LoginUser.getCompanyId(), nowTraining.getTrainingId());


		request.setAttribute(ScopeKey.MEMBERS.getScopeKey(),members);



		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return "member";
	}
}