package com.poly.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ParamController {

			@RequestMapping(path ="/param/form",method = RequestMethod.GET)
			public String form() {
				return "form";
			}
			
			@RequestMapping(path = "/param/save/{x}", method = RequestMethod.POST)
			public String save(Model model ,@RequestParam("y") String y, @PathVariable String x) {
				model.addAttribute("x", x);
				model.addAttribute("y", y);
				return "form";
				
			}
}
