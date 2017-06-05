package jp.co.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.LogEnum;
import enums.ScopeKey;
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
	HttpServletRequest request;


	@RequestMapping("/member")
	public void getMember(HttpServletRequest request, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());



	}
}