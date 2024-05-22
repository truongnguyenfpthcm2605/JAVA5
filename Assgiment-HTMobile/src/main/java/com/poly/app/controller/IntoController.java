package com.poly.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.app.Impl.MailerServiceImpl;
import com.poly.app.Impl.OrdersDetailSeviceImpl;
import com.poly.app.Impl.ShoppingCartServiceImpl;
import com.poly.app.Impl.UsersServiceImpl;
import com.poly.app.dto.UsersRegister;
import com.poly.app.enity.OrdersDetail;
import com.poly.app.enity.Users;
import com.poly.app.service.CookieService;
import com.poly.app.service.ParamService;
import com.poly.app.service.SessionSevice;
import com.poly.app.util.AES;
import com.poly.app.util.Keyword;

import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;

@Controller
public class IntoController {

	@Autowired
	AES cryptCode;

	@Autowired
	UsersServiceImpl usersServiceImpl;

	@Autowired
	CookieService cookieService;

	@Autowired
	SessionSevice sessionSevice;

	@Autowired
	ParamService paramService;

	@Autowired
	ShoppingCartServiceImpl shoppingCartServiceImpl;

	@Autowired
	OrdersDetailSeviceImpl ordersDetailSeviceImpl;

	@Autowired
	MailerServiceImpl mailerServiceImpl;

	@ModelAttribute("numberCartItem")
	public int getnumberCartItem() {
		return shoppingCartServiceImpl.getCount() != 0 ? shoppingCartServiceImpl.getCount() : 0;
	}

	private static final String code = Keyword.keyCodeRandom();

	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("userRegister", new UsersRegister());
		return "register";
	}

	@PostMapping("register")
	public String confirmRegister(@Valid @ModelAttribute("userRegister") Optional<UsersRegister> usr,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Nhập dữ liệu chưa đúng !");
		} else {
			UsersRegister us = usr.get();
			if (usersServiceImpl.findByEmail(us.getEmail()) != null) {
				model.addAttribute("message", "Email này đã được đăng kí, bạn có thể đăng nhập ngay bên dưới !");
			} else if (!us.getPassword().equals(us.getConfirm())) {
				model.addAttribute("cofirmError", "Xác nhận mật khẩu chưa đúng !");
			} else if (!us.getCodeKey().equals(code)) {
				model.addAttribute("keyError", "Xác nhận chưa đúng !");
			} else {
				Users user = getUser(us);
				if (usersServiceImpl.save(user) != null) {
					sessionSevice.setAttribute(Keyword.acc, user);
					return "redirect:/index";
				}

			}
		}

		return "register";
	}

	public Users getUser(UsersRegister us) {
		Users user = new Users();
		user.setEmail(us.getEmail());
		user.setFullname(us.getFullname());
		user.setGender(us.getGender());
		user.setBirthday(us.getBirth());
		user.setPassword(AES.encrypt(us.getPassword(), Keyword.keyCode));
		user.setImg(null);
		user.setActive(true);
		user.setRole(false);
		user.setCreateday(new Date());
		user.setUpdateday(new Date());
		return user;
	}

	@GetMapping("/register/mail")
	@ResponseBody
	public ResponseEntity<String> sendMail(@RequestParam("codemail") Optional<String> email) {
		mailerServiceImpl.queue(email.orElse("abc@gmail.com"), "Mã Xác Nhận Từ HTMobile",
				"    <div style=\"width:80%; margin:0 auto;text-align: center ;\">\r\n"
						+ "            <h1 style=\"color:#080202 ;\">HTMobile</h1>\r\n"
						+ "            <p >Dùng mã này để xác minh địa chỉ email của bạn trên Facebook</p>\r\n"
						+ "            <p>Xin chào Bạn,Chúng tôi cần xác minh địa chỉ email của bạn để đảm bảo là có thể liên hệ với bạn sau khi xem xét ID.</p>\r\n"
						+ "           \r\n"
						+ "            <p>Chúng tôi cần xác minh địa chỉ email của bạn để đảm bảo là có thể liên hệ với bạn sau khi xem xét ID.</p>\r\n"
						+ "            <h5>Mã xác nhận</h5>\r\n" + "             <h2 style=\"color: #116D6E ;\">" + code
						+ "</h2>    \r\n" + "             <br>\r\n"
						+ "              <p style=\"font-size: 15px;font-weight: 200;\">Tin nhắn này được gửi tới bạn theo yêu cầu của HTMobile.\r\n"
						+ "                HTMobile © 2023 All rights re6served. Privacy Policy|T&C|System Status</p>\r\n"
						+ "    </div> ");
		return ResponseEntity.ok("Mã xác nhận đã được gửi đến email.");
	}

	@GetMapping("login")
	public String login(Model model) {

		return "login";
	}

	@PostMapping("login")
	public String checkLogin(Model model, @RequestParam("email") Optional<String> email,
			@RequestParam("password") Optional<String> password,
			@RequestParam(name = "check", required = false) Boolean remember) {

		boolean rememberMe = remember != null ? remember : false;
		String passCode = AES.encrypt(password.orElse("none"), Keyword.keyCode);
		Users user = usersServiceImpl.checkLogin(email.orElse("none"), passCode);

		if (user != null) {
			int day = rememberMe ? 1 : 0;
			cookieService.add("username", email.orElse("none"), day);
			sessionSevice.setAttribute(Keyword.acc, user);
			String uri = sessionSevice.getAttribute("security-uri");

			if (uri != null) {
				return "redirect:" + uri;
			} else {
				return "redirect:/index";
			}
		}
		model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
		return "login";
	}

	@GetMapping("logout")
	public String logout() {
		sessionSevice.removeAttribute(Keyword.acc);
		return "redirect:/index";
	}

	@GetMapping("history")
	public String history(Model model) {
		Users users = sessionSevice.getAttribute(Keyword.acc);
		List<OrdersDetail> list = ordersDetailSeviceImpl.findOrdersDetailsByUserId(users.getId());
		model.addAttribute("listHistory", list);
		return "history";
	}

}
