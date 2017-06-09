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
	private static final int ROOTHOME_ID = 1;

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

		if (room.getTrainingId() == ROOTHOME_ID) {
			//入った教室がルートホームだった場合
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return RedirectController.ROOTHOME.getRedirectName();
		} else {
			//それ以外
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return RedirectController.HOME.getRedirectName();
		}

	}
}
