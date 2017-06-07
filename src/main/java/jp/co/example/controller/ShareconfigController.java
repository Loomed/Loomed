package jp.co.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import enums.JspPage;
import enums.LogEnum;
import jp.co.example.service.ShareService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

//home・roothomeからの遷移を記述
@Slf4j
@Controller
public class ShareconfigController {
	@Autowired
	private ShareService SS;

	//roothomeからの遷移
	@RequestMapping("/shareconfig")
	//とりあえず表示する画面 select
	public String getShare(HttpSession session, HttpServletRequest reques, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.SHARECONFIG.getPageName();
	}

	//削除を処理
	@RequestMapping(value="/sharedelete", method = RequestMethod.POST)
	public String ShareDelete( HttpServletRequest reques, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.SHARECONFIG.getPageName();
	}



	//フラグ変更
	@RequestMapping(value="/shareupdate", method = RequestMethod.POST)
	public String ShareInsert( HttpServletRequest reques, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.SHARECONFIG.getPageName();
	}





}