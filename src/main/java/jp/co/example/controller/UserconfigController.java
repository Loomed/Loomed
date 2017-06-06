package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import enums.LogEnum;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Controller
public class UserconfigController {

	//登録
	@RequestMapping(value = "/userconfig")
	public String getResistration() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERCONFIG.getPageName();
	}



	 //氏名
	//コメント解除するとエラー発生・・・別コントローラーで同じvalueの値がある為(UserInfoController)
	//UserInfoControllerで既に遷移ができているのでそちら参照。
	//↓残骸。使う機会なければ消して良いです。
	//@RequestMapping(value = "/userinfo")
	//public String getName() {
		//log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		//log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		//return JspPage.USERINFO.getPageName();
	//}


	//変更
	//氏名と同様の理由でUserChangeControler参照
	//↓残骸。使う機会なければ消して良いです。
//	@RequestMapping(value = "/userchange")
//	public String getuserChange() {
//		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
//		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
//		return JspPage.USERCHANGE.getPageName();
//	}

	//削除
	@RequestMapping(value = "/userdelete")
	public String getDelete() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERCONFIG.getPageName();
	}

}
