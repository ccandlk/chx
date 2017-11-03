package xyz.ibenben.zhongdian.system.dao;

import org.apache.ibatis.annotations.Select;
import xyz.ibenben.zhongdian.common.BaseDao;
import xyz.ibenben.zhongdian.system.entity.SysUser;


public interface UserDao extends BaseDao<SysUser>{

    @Select("select * from users where username=#{username}")
    public SysUser getUserName(String username);

    @Select("select * from users where username=#{username} and password=#{password}")
    public SysUser getUser(SysUser user);

}
