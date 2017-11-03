package xyz.ibenben.zhongdian.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.ibenben.zhongdian.system.entity.Book;
import xyz.ibenben.zhongdian.system.service.BookService;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/getBook")
	@ResponseBody
	public List<Book> getBookList(){
		System.out.println("=========");
		List<Book> books=bookService.getBookList();
		return books;
	}
	@RequestMapping("/saveBook")
	@ResponseBody
	public void saveBook(String bookId,String bookName,String bookState,
						   String uploadAuthor,String phoneNumber){
		Book book=new Book();
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setBookState(bookState);
		book.setUploadAuthor(uploadAuthor);
		book.setPhoneNumber(phoneNumber);
		bookService.saveBook(book);
	}
	@RequestMapping("/updateBook")
	@ResponseBody
	public void updateBook(String id,String bookId,String bookName,String bookState,
						 String uploadAuthor,String phoneNumber){
		Book book=new Book();
		book.setId(Integer.parseInt(id));
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setBookState(bookState);
		book.setUploadAuthor(uploadAuthor);
		book.setPhoneNumber(phoneNumber);
		bookService.updateBook(book);
	}
}
