package xyz.ibenben.zhongdian.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.ibenben.zhongdian.system.dao.BookDao;
import xyz.ibenben.zhongdian.system.dao.UserDao;
import xyz.ibenben.zhongdian.system.entity.Book;
import xyz.ibenben.zhongdian.system.entity.SysUser;
import xyz.ibenben.zhongdian.system.service.BookService;
import xyz.ibenben.zhongdian.system.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Transactional
	public int getUserName(String username){
		SysUser userList=userDao.getUserName(username);
		if(userList!=null){
			return 1;
		}
		else return 0;
	}
	public String getUser(SysUser user){
		SysUser users = userDao.getUser(user);
		if(users!=null){
			return "1";
		}
		else if(users==null && getUserName(user.getUsername())==1){
			return "0";
		}

			return "-1";
	}

}
