package course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ccut.cn.db.BookDB;
import edu.ccut.cn.po.Book;

public class TestDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		BookDB dataBase = new BookDB();
		//dataBase.test();
		String sql = "select * from bookForm ";
		//ResultSet resultSet = dataBase.getResultSet(sql);
		List list =  dataBase.getResultList(sql);
		Book book = (Book) list.get(0);
		System.out.println(book.getIsbn()+book.getBookName()+book.getAuthor());
	}

}
