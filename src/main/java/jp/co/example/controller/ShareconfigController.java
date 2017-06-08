package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import enums.JspPage;
import enums.LogEnum;
import enums.RedirectController;
import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;
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
		List<Shares> list = new ArrayList<Shares>();
		//Trainings tra = (Trainings)session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());
		Trainings tra = new Trainings(5, "セキュリティ講座", 1, "セキュリティ講座としてSEA/J資格受験");
		try{
		list = SS.selectlist(tra.getTrainingId());
		}catch(NullPointerException e){
			reques.setAttribute("msg", "ファイルがアップロードされていません");
		}
		session.setAttribute("list", list);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.SHARECONFIG.getPageName();
	}

	//削除を処理
	@RequestMapping(value="/sharechange", method = RequestMethod.POST)
	public String ShareDelete(HttpSession session, HttpServletRequest reques, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		//Trainings tra = (Trainings)session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());
		Trainings tra = new Trainings(5, "セキュリティ講座", 1, "セキュリティ講座としてSEA/J資格受験");
		String upid = reques.getParameter("updateid");
		String radio = reques.getParameter("r1");
		List<Shares> list = new ArrayList<Shares>();
		boolean visible = true;
		int id =Integer.parseInt(upid);
		if("1".equals(radio)){
			visible = true;
		}else{
			visible = false;
		}

		SS.changeVisible(id,visible);
		list = SS.selectlist(tra.getTrainingId());
		session.setAttribute("list", list);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return RedirectController.SHARECONFIG.getRedirectName();
	}



	//フラグ変更
	@RequestMapping(value="/sharedelete", method = RequestMethod.POST)
	public String ShareInsert(HttpSession session, HttpServletRequest reques, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		//Trainings tra = (Trainings)session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());
		Trainings tra = new Trainings(5, "セキュリティ講座", 1, "セキュリティ講座としてSEA/J資格受験");
		Object upid = reques.getParameter("deleteid");
		List<Shares> list = new ArrayList<Shares>();
		System.out.println(upid);
		int id = Integer.parseInt((String) upid);
		SS.deleteShare(id);
		list = SS.selectlist(tra.getTrainingId());
		session.setAttribute("list", list);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return RedirectController.SHARECONFIG.getRedirectName();
	}





}