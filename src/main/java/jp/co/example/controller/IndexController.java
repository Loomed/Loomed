package jp.co.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import enums.LogEnum;
import jp.co.example.entity.Users;
import jp.co.example.service.IndexService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Controller
@Getter
public class IndexController {
	@Autowired
	IndexService IndexService;
	HttpServletRequest request;

	@RequestMapping("/index")
	public String getIndex(@RequestParam("id") String id, @RequestParam("pass") String pass,
			HttpServletRequest request) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int LoginId = 0;
		String LoginPass = "";
		int LoginRoom = 0;


		// 入力されたidがintかどうか判定
		log.info(LogEnum.IF.getLogValue() + "IndexService.isNum(id)");
		if (IndexService.isNum(id)) {
			log.info(LogEnum.IF.getLogValue() + "IndexService.isNum(id)");
			LoginId = Integer.parseInt(id);
		} else {
			log.info(LogEnum.FALSE.getLogValue() + "/login");
			return "/login";
		}

		// 入力されたpassが0文字以上か判定
		log.info(LogEnum.IF.getLogValue() + "pass.length() > 0");
		if (pass.length() > 0) {
			log.info(LogEnum.IF.getLogValue() + "LoginPass == pass");
			LoginPass = pass;
		} else {
			log.info(LogEnum.FALSE.getLogValue() + "/login");
			return "/login";
		}


		//ログイン処理：未作成（id,passを送り、Usersを受け取る）
		Users LoginUser = IndexService.LoginJudge(LoginId, LoginPass);

		// ログイン判定
		log.info(LogEnum.IF.getLogValue() + "LoginUser == null");
		if(LoginUser == null){
			log.info(LogEnum.IF.getLogValue() + "/login");
			return "/login";
		}else{
			log.info(LogEnum.FALSE.getLogValue() + "MapsよりRoom番号をうけとる");
			//教室判定
			LoginRoom = IndexService.RoomJudge(LoginUser.getUserId());
		}

		//教室判定
//
//		log.info(LogEnum.IF.getLogValue() + "LoginUser != null");
//		if(LoginUser != null){
//			log.info(LogEnum.IF.getLogValue() + "LoginRoom = (番号)");
//			LoginRoom = IndexService.RoomJudge(LoginUser.getUserId());
//		}else{
//			log.info(LogEnum.FALSE.getLogValue());
//		}


		//判定処理
		log.info(LogEnum.IF.getLogValue() + "LoginUser == null || LoginRoom == 0");
		if(LoginUser == null || LoginRoom == 0){
			log.info(LogEnum.IF.getLogValue() + "/login");
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return "/login";
		}else{
			log.info(LogEnum.FALSE.getLogValue()+ "index.jsp");
			request.getSession().setAttribute("ScopeKey.LOGINUSER.getLogValue()", LoginUser);
			request.getSession().setAttribute("ScopeKey.LOGINROOM.getLogValue()", LoginRoom);
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return "index";
		}
	}
}
