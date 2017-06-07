package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import enums.*;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import jp.co.example.form.*;
import jp.co.example.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class ScheduleController {

	@Autowired
	ScheduleService ss;

	@RequestMapping("/schedule")
	public String schedule(HttpSession session, Model model, @RequestParam("date") String date) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(LogEnum.METHOD_PARAM.getLogValue() + date);

		Users user = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());
		Trainings room = (Trainings) session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());

		// テストデータ
		user = new Users(1, "pass", "山田 太郎", 1, 0);
		room = new Trainings(2, "Java研修", 2, "");
		session.setAttribute(ScopeKey.LOGINUSER.getScopeKey(), user);
		session.setAttribute(ScopeKey.LOGINROOM.getScopeKey(), room);
		log.info(room.toString());

		// ユーザー情報を確認(未完成)
		log.info(LogEnum.IF.getLogValue() + "user == null");
		if (user == null) {
			log.info(LogEnum.TRUE.getLogValue());

			// ログインへ戻る処理を書く
		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		// 部屋情報を確認(未完成)
		log.info(LogEnum.IF.getLogValue() + "room == null");
		if (room == null) {
			log.info(LogEnum.TRUE.getLogValue());

			// インデックスへ戻る処理を書く
		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		// スケジュールを取得
		List<ScheduleForm> list = ss.getSchedule(user.getUserId(), date);
		model.addAttribute("list", list);
		boolean projectorAuthority;

		// プロジェクタ参照権限があるかチェック
		log.info(LogEnum.IF + "AutorityCheck");
		if (user.getAuthority().equals(Authority.ROOT.getAuthority())) {
			log.info("ROOT");
			// ログインユーザがルートの場合全てのプロジェクタ権限あり
			projectorAuthority = true;
		} else if (user.getAuthority().equals(Authority.CHARGE.getAuthority())) {
			log.info("CHARGE");
			// ログインユーザが担当者の場合全てのプロジェクタ権限なし
			projectorAuthority = false;
		} else {
			log.info("LECTURER or STUDENT");

			projectorAuthority = ss.isProjectorAuthority(user.getUserId(), room.getTrainingId());
		}
		log.info(LogEnum.IF_PARAM.getLogValue() + projectorAuthority);
		// プロジェクタ権限を格納
		model.addAttribute("projectorAuthority", projectorAuthority);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.SCHEDULE.getPageName();
	}

	@RequestMapping(value = "projectorJson")
	@ResponseBody
	public List<ProjectorForm> projector(HttpSession session, @RequestParam("time") String time,
			@RequestParam("date") String date) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(LogEnum.METHOD_PARAM.getLogValue() + date);
		log.info(LogEnum.METHOD_PARAM.getLogValue() + time);

		// timeに値が入っていなければ空リストを返す
		if (time == null || "".equals(time)) {
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return new ArrayList<>();
		}

		// sessionLOGINLOOMは一時的
		//session.removeAttribute(ScopeKey.LOGINROOM.getScopeKey());
		Users user = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());
		Trainings room = (Trainings) session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());

		// テストデータ
		//user = new Users(1, "pass", "山田 太郎", 1, 0);
		//room = new Trainings(2, "Java研修", 2, "");

		// ユーザー情報を確認(未完成)
		log.info(LogEnum.IF.getLogValue() + "user == null");
		if (user == null) {
			log.info(LogEnum.TRUE.getLogValue());

			// ログインへ戻る処理を書く
		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		// 部屋情報を確認(未完成)
		log.info(LogEnum.IF.getLogValue() + "room == null");
		if (room == null) {
			log.info(LogEnum.TRUE.getLogValue());

			// インデックスへ戻る処理を書く
		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		List<ProjectorForm> list = ss.getProjectorJson(room.getTrainingId(), date, time);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}

	@RequestMapping(value = "reserveNameJson")
	@ResponseBody
	public List<ReserveUserNameForm> projector(HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Integer trainingId = ((Trainings)session.getAttribute(ScopeKey.LOGINROOM.getScopeKey())).getTrainingId();
		Integer userId = ((Users)session.getAttribute(ScopeKey.LOGINUSER.getScopeKey())).getUserId();

		List<ReserveUserNameForm> list = ss.getReserveUserNameJson(trainingId, userId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}
}
