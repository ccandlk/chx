package xyz.ibenben.zhongdian.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.ibenben.zhongdian.system.entity.SysUser;
import xyz.ibenben.zhongdian.system.service.UserService;

@Controller
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
	@RequestMapping("/goIn")
	public String goIn() {
		System.out.println("===goIn======");return "table";
	}

	@RequestMapping("/")
	public String index() {
		System.out.println("====index=====");return "index";
	}



	@RequestMapping("/getBooks")
	@ResponseBody
		public String getBooks(String username,String password) throws Exception {
		System.out.println("=========");
		SysUser user = new SysUser();
		user.setPassword(password);
		user.setUsername(username);
		System.out.println(userService.getUser(user));
		return userService.getUser(user);
	}
}
