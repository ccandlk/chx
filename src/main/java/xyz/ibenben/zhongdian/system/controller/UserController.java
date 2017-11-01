package xyz.ibenben.zhongdian.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyz.ibenben.zhongdian.system.entity.Book;
import xyz.ibenben.zhongdian.system.entity.User;
import xyz.ibenben.zhongdian.system.service.BookService;
import xyz.ibenben.zhongdian.system.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/system/user")
public class UserController {
	@Autowired
	private UserService userService;
	
//	@RequestMapping("/table")
//	public String table(String username,String password) {
//		User user = new User();
//		user.setPassword(password);
//		user.setUsername(username);
//		return "table.html";
//	}
	@RequestMapping("/1")
	public String login(String username,String password) {
//		User user = new User();
//		user.setPassword(password);
//		user.setUsername(username);
		//ModelAndView modelAndView = new ModelAndView("table");
		return "table";
	}
	@RequestMapping("/table")
		public ModelAndView table(Model model) throws Exception {
			//model.addAttribute("title"  ,"ceshi");
		ModelAndView modelAndView = new ModelAndView("books");
			return modelAndView;
		}
}
