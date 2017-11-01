package xyz.ibenben.zhongdian.system.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.ibenben.zhongdian.system.dao.BookDao;
import xyz.ibenben.zhongdian.system.entity.Book;
import xyz.ibenben.zhongdian.system.service.BookService;


import java.io.Serializable;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Transactional
	public void saveBook(Book book){
//		user = bookDao.selectByPrimaryKey(1);
//		user.setUsername("5566");
        bookDao.saveBook(book);
////		int i = 10/0;
//
//
//		Task temp = new Task();
//		task.setState(1);
//		List<Task> list = taskDao.selectByRowBounds(temp, new RowBounds(2, 12));
//		System.out.println(list.size());
//		for(Task t : list){
//			System.out.println(t.getName());
//		}
//
//		List<User> users = userDao.selectByState(1);
//		for(User u : users){
//			System.out.println(u.getUsername());
//		}
	}
	public List<Book> getBookList(){
		List<Book> books = bookDao.getBookList();
		return books;
	}
	public void updateBook(Book book){
		bookDao.updateBook(book);
	}
}
