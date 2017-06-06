package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import enums.LogEnum;
import enums.ScopeKey;
import jp.co.example.entity.Trainings;
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
	public String getIndex(@RequestParam("inputId") String id, @RequestParam("inputPassword") String pass,
			HttpServletRequest request, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int LoginId = 0;
		String LoginPass = "";
		int LoginRoom = 0;


		// 入力されたidがintかどうか判定
		log.info(LogEnum.IF.getLogValue() + "IndexService.isNum(id)");
		if (IndexService.isNum(id)) {
			log.info(LogEnum.TRUE.getLogValue() + "IndexService.isNum(id)");
			LoginId = Integer.parseInt(id);
		} else {
			log.info(LogEnum.FALSE.getLogValue() + "/login");
			return "/login";
		}

		// 入力されたpassが0文字以上か判定
		log.info(LogEnum.IF.getLogValue() + "pass.length() > 0");
		if (pass.length() > 0) {
			log.info(LogEnum.TRUE.getLogValue() + "LoginPass == pass");
			LoginPass = pass;
		} else {
			log.info(LogEnum.FALSE.getLogValue() + "/login");
			return "/login";
		}


		//ログイン処理：未作成（id,passを送り、Usersを受け取る。nullが戻ることも）
		Users LoginUser = IndexService.LoginJudge(LoginId, LoginPass);

		// ログイン成否判定：未作成（LoginUserがnullでなければRoom番号を受け取る）
		log.info(LogEnum.IF.getLogValue() + "LoginUser == null");
		if(LoginUser == null){
			log.info(LogEnum.TRUE.getLogValue() + "/login");
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

		//研修教室一覧受け取り
		List<Trainings> AllTrainings = IndexService.AllTrainings();


//
		//判定処理
		log.info(LogEnum.IF.getLogValue() + "LoginUser == null || LoginRoom == 0");
		if(LoginUser == null || LoginRoom == 0){
			log.info(LogEnum.TRUE.getLogValue() + "/login");
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return "/login";
		}else{
			log.info(LogEnum.FALSE.getLogValue()+ "index.jsp");
			session.setAttribute(ScopeKey.LOGINUSER.getScopeKey(), LoginUser);
			session.setAttribute(ScopeKey.LOGINROOM.getScopeKey(), LoginRoom);
			session.setAttribute("AllTrainings", AllTrainings);
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return "index";
		}
	}
}
