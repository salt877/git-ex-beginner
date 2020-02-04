package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("/create")
	public String create(@Validated UserForm form
			, BindingResult result
			, RedirectAttributes redirectAttributes
			,Model model) {
		if (result.hasErrors()) {
			return index(model);
		}
		return "exam04-result";
	}

	@RequestMapping("")
	public String index(Model model) {
		return "exam04";
	}

	@RequestMapping("/receive-info")
	public String receiveInfo(UserForm userForm, Model model) {
		model.addAttribute("name", userForm.getName());
		model.addAttribute("age", userForm.getAge());
		model.addAttribute("comment", userForm.getComment());

		return "exam04-result";

	}

}
