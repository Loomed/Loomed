package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	/*@RequestMapping("/home")
	public String Home(@RequestParam("button") String button, BindingResult result,
			Model model) {
				return null;
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		if (result.hasErrors()) {
			return JspPage.LOGIN.getPageName();
		}
		if ("userinfo".equals(button)) {
			return JspPage.USERINFO.getPageName();
		} else if ("member".equals(button)) {
			return JspPage.MEMBER.getPageName();
		} else if ("sharaconfig".equals(button)) {
			return JspPage.SHARECONFIG.getPageName();
		}
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
	}*/
	@RequestMapping("/home")
	public String getHome(){
		return JspPage.HOME.getPageName();
	}

}