package edu.ccut.cn.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import edu.ccut.cn.po.Book;

public class BookDB {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	static Properties properties = null;
	static InputStream inputStream =null;
	
	static String driver=null;
	static String url =null;
	static String userName=null;
	static String password;
	
        static {
							    inputStream = BookDB.class.getClassLoader().getResourceAsStream("edu/ccut/cn/db/book_db.properties");
								properties = new Properties();
								try {
									properties.load(inputStream);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								 driver = properties.getProperty("jdbc.driver");
								url= properties.getProperty("jdbc.url");
								 userName= properties.getProperty("jdbc.userName");
								password = properties.getProperty("jdbc.password");
								System.out.println(driver + url + userName + password);							
         }
         
         
         
         public  ResultSet getResultSet(String sql) throws SQLException, ClassNotFoundException {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, userName, password);
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				return resultSet;		
         }
         
         public  List getResultList(ResultSet rs)  {
        	 //将rs逐条取出，并将每一项放在一个bean对应的值里
        	               List list = new ArrayList();
        	                try {
								while(rs.next())  { 
								              Book book=new Book();
								              book.setIsbn(rs.getString(1));
								              book.setBookName(rs.getString(2));
								              book.setAuthor(rs.getString(3));
								              book.setPrice(rs.getString(4));
								              book.setPublishHouse(rs.getString(5));
								              book.setTime(rs.getString(6));
								              book.setSummary(rs.getString(7));
								              list.add(book);
								 }
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}finally {
								this.closeStream();
							}
                  return list;
     }
         
         public  List<Book> getResultList(String sql) {
        	 //将rs逐条取出，并将每一项放在一个bean对应的值里
        	    List list = new ArrayList();
            	 try {
					Class.forName(driver);
					try {
						connection = DriverManager.getConnection(url, userName, password);
						System.out.println("sql语句是"+sql);
						preparedStatement = connection.prepareStatement(sql);
						resultSet = preparedStatement.executeQuery();
		        	               
		        	                while(resultSet.next())  { 
					        	                  Book book=new Book();
					        	                  book.setIsbn(resultSet.getString(1));
					        	                  book.setBookName(resultSet.getString(2));
					        	                  book.setAuthor(resultSet.getString(3));
					        	                  book.setPrice(resultSet.getString(4));
					        	                  book.setPublishHouse(resultSet.getString(5));
					        	                  book.setTime(resultSet.getString(6));
					        	                  book.setSummary(resultSet.getString(7));
					        	                  list.add(book);
		        	                 }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
				         this.closeStream();
				}
				
                  return list;
     }
         
//         public  boolean updateBook(Book book,String sql) {
//
//		        	 String isbn = book.getIsbn();
//		             String bookName=book.getBookName();
//		             String author =   book.getAuthor();
//		             	String price = book.getPrice();
//		             	String publishHouse =  book.getPublishHouse();
//		        	   String time  = book.getTime();
//		        	   String summary =  book.getSummary();
//            	 try {
//					Class.forName(driver);
//					try {
//						connection = DriverManager.getConnection(url, userName, password);
//						System.out.println("sql语句是"+sql);
//						preparedStatement = connection.prepareStatement(sql);
//						for(int i=0;i<book.)
//		        	               
//		        	                while(resultSet.next())  { 
//					        	              
//		        	                 }
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}finally {
//				         this.closeStream();
//				}
//				
//                  return list;
//     }
         
         
         public  boolean updateBooks(String sql,Book book) {
             try  {
            	 Class.forName(driver);
            	 connection = DriverManager.getConnection(url, userName, password);
				preparedStatement = connection.prepareStatement(sql);
				                 if(book!=null) {
				                		System.out.println("book的值是"+book.getBookName()+book.getAuthor()+book.getPrice()+book.getPublishHouse()+
				    							book.getTime()+book.getSummary()+book.getIsbn());
				                	 preparedStatement.setString(1, book.getBookName().toString());
				                	 preparedStatement.setString(2, book.getAuthor().toString());
				                	 preparedStatement.setString(3, book.getPrice().toString());
				                	 preparedStatement.setString(4, book.getPublishHouse().toString());
				                	 preparedStatement.setString(5, book.getTime().toString());
				                	 preparedStatement.setString(6, book.getSummary().toString());
				                	 preparedStatement.setString(7, book.getIsbn().toString());
				                 }
                 System.out.println("sql后的语句是"+sql);
                 preparedStatement.executeUpdate();
             } catch(Exception e){
                 e.printStackTrace();
             //    throw new RuntimeException(e.getMessage());
                 System.out.println("你好，出错了，没有擦汗巾去");
                return false;
             }finally{
               this.closeStream();
             }
             return true;
         
         }
         
         public  void closeStream() {
        	 if (resultSet != null) {
 				try {
 					resultSet.close();
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 			}
 			if (preparedStatement != null) {
 				try {
 					preparedStatement.close();
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 			}
 			if (connection != null) {
 				try {
 					connection.close();
 				} catch (SQLException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 			}
 		}
     
}
