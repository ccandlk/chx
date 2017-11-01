package xyz.ibenben.zhongdian.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.ibenben.zhongdian.system.dao.BookDao;
import xyz.ibenben.zhongdian.system.dao.UserDao;
import xyz.ibenben.zhongdian.system.entity.Book;
import xyz.ibenben.zhongdian.system.entity.User;
import xyz.ibenben.zhongdian.system.service.BookService;
import xyz.ibenben.zhongdian.system.service.UserService;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Transactional
	public int getUserName(User user){
		List<User> userList=userDao.getUserName(user);
		if(userList.size()!=0){
			return 1;
		}
		else return 0;
	}
	public String getUser(User user){
		List<User> users = userDao.getUser(user);
		if(users.size()!=0){
			return "1";
		}
		else if(users.size()==0 && getUserName(user)==1){
			return "0";
		}

			return "-1";
	}
}
