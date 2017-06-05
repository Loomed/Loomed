package jp.co.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import enums.LogEnum;
import jp.co.example.entity.Users;
import jp.co.example.service.Generalized;
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

		// 入力されたidがintかどうか判定
		log.info(LogEnum.IF.getLogValue() + "Generalized.isNum(id)");
		if (Generalized.isNum(id)) {
			log.info(LogEnum.IF.getLogValue() + "(Generalized.isNum(id) == true)");
			LoginId = Integer.parseInt(id);
		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		// 入力されたpassが0文字以上か判定
		log.info(LogEnum.IF.getLogValue() + "Generalized.isNum(id)");
		if (pass.length() > 0) {
			log.info(LogEnum.IF.getLogValue() + "(pass.length() > 0 == true)");
			LoginPass = pass;
		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		// ログイン判定
		Users LoginUser = IndexService.LoginJudge(LoginId, LoginPass);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return null;

	}

}
