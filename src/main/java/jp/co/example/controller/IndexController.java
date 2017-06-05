package jp.co.example.controller;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

@Getter
public class IndexController {
	@RequestMapping(value = "/index")
	public String postLogin(@Valid LoginForm form, BindingResult result, Model model){

	}

}
