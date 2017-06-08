package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import enums.*;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import lombok.extern.slf4j.Slf4j;
import util.Util;

/**
 * ヘッダー用コントローラ
 *
 * @author Yukihiro Yoshida
 *
 */
@Controller
@Slf4j
public class CommonsController {

	/**
	 * ロゴをクリックしたときに通るコントローラ
	 *
	 * @param redirect
	 * @param session
	 * @return
	 */
	@RequestMapping("/logo")
	public String logoClick(RedirectAttributes redirect, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users user = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());
		Trainings room = (Trainings) session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());

		// データチェック
		String page = util.Util.sessionDataCheck(user, room);
		if (page != null) {
			return page;
		}
		redirect.addAttribute("page", room.getTrainingId());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return RedirectController.HOME.getRedirectName();

	}
}
