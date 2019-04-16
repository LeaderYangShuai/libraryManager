package edu.ccut.cn.servicesBook;

import java.util.List;

import edu.ccut.cn.db.BookDB;
import edu.ccut.cn.po.Book;

public class BookOperation {
			//查询图书
	    public List<Book>   getBook(String bookName) {
	    	BookDB bookDB = new BookDB();
	    	System.out.println("树的名称是"+bookName);
	    	String sql = "select * from bookForm where  bookName='"+bookName+"'";
	    	//String sql = "select * from bookForm where  bookName=dataStructure";
	    	List list =bookDB.getResultList(sql);
	    	return list;
	    }
	    
	    public List<Book>   getBookAccordAuthor(String author) {
	    	BookDB bookDB = new BookDB();
	    	System.out.println("树的作者是"+author);
	    	String sql = "select * from bookForm where  author='"+author+"'";
	    	//String sql = "select * from bookForm where  bookName=dataStructure";
	    	List list =bookDB.getResultList(sql);
	    	return list;
	    }
	    
	    public List<Book>   getBookAccordISBN(String isbn) {
	    	BookDB bookDB = new BookDB();
	    	System.out.println("树的ISBN是"+isbn);
	    	String sql = "select * from bookForm where  isbn='"+isbn+"'";
	    	//String sql = "select * from bookForm where  bookName=dataStructure";
	    	List list =bookDB.getResultList(sql);
	    	return list;
	    }
	    
	    public List<Book>   getAllBook(Object object) {
	    	BookDB bookDB = new BookDB();
	    	//System.out.println("树的ISBN是"+isbn);
	    	String sql = "select * from bookForm";
	    	//String sql = "select * from bookForm where  bookName=dataStructure";
	    	List list =bookDB.getResultList(sql);
	    	return list;
	    }
	    
	    public boolean   updateBook(Book book) {
	    	BookDB bookDB = new BookDB();
	    	 
	    	String sql ="update bookForm set bookName=?,author=?,price=?,publishHouse=?,time=?,summary=? where  isbn=?";
	    	//String sql = "select * from bookForm where  bookName=dataStructure";
	    	return bookDB.updateBooks(sql, book);	 	
	    }

}
