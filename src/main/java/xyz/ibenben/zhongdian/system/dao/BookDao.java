package xyz.ibenben.zhongdian.system.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.ibenben.zhongdian.common.BaseDao;
import xyz.ibenben.zhongdian.system.entity.Book;

import java.util.List;


public interface BookDao extends BaseDao<Book>{
    @Select("select * from books")
    public List<Book> getBookList();
    @Insert("INSERT INTO books(bookId,bookName,bookState,uploadAuthor,phoneNumber)" +
            "VALUES (#{bookId},#{bookName},#{bookState},#{uploadAuthor},#{phoneNumber})")
    public void saveBook(Book book);
    @Update("update books b set bookId = #{bookId},bookName= #{bookName},bookState = #{bookState}," +
            "uploadAuthor= #{uploadAuthor},phoneNumber=#{phoneNumber} where id = #{id} ")
    public void updateBook(Book book);
}
