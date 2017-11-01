package xyz.ibenben.zhongdian.system.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.ibenben.zhongdian.common.BaseDao;
import xyz.ibenben.zhongdian.system.entity.Book;
import xyz.ibenben.zhongdian.system.entity.User;

import java.util.List;


public interface UserDao extends BaseDao<User>{

    @Select("select * from users where username=#{username}")
    public List<User> getUserName(User user);

    @Select("select * from users where username=#{username} and password=#{password}")
    public List<User> getUser(User user);

}
