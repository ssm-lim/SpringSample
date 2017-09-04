package spring.web.app.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) throws Exception {
		return "/baseLayout/admin/index";
	}
}
