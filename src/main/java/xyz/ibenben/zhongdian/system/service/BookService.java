package xyz.ibenben.zhongdian.system.service;

import xyz.ibenben.zhongdian.system.entity.Book;

import java.util.List;


public interface BookService {
	public void saveBook(Book book);
	public void updateBook(Book book);
	public List<Book> getBookList();
}
