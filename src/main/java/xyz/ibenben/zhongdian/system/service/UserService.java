package xyz.ibenben.zhongdian.system.service;


import xyz.ibenben.zhongdian.system.entity.SysUser;



public interface UserService {
	public int getUserName(String username);
	public String getUser(SysUser user);
}
