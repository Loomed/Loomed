package jp.co.example.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import enums.JspPage;

public class RootHomeController {
	@RequestMapping("/roothome")
	public String Home(@RequestParam("data") String data, @RequestParam("button") String button, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return JspPage.LOGIN.getPageName();
		}
		if ("userconfig".equals(button)) {
			return JspPage.USERCONFIG.getPageName();
		} else if ("trainingconfig".equals(button)) {
			return JspPage.TRAININGCONFIG.getPageName();
		} else if ("sharaconfig".equals(button)) {
			return JspPage.SHARECONFIG.getPageName();
		}

		return null;
	}

}
