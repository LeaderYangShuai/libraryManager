package edu.ccut.cn.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.ccut.cn.po.Book;
import edu.ccut.cn.po.ManagerRoot;
import edu.ccut.cn.po.User;

public class UserDB {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	static Properties properties = null;
	static InputStream inputStream =null;
	
	static String driver=null;
	static String url =null;
	static String jdbcuserName=null;
	static String password;
	
        static {
							    inputStream = BookDB.class.getClassLoader().getResourceAsStream("edu/ccut/cn/db/students_db.properties");
								properties = new Properties();
								try {
									properties.load(inputStream);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								 driver = properties.getProperty("jdbc.driver");
								url= properties.getProperty("jdbc.url");
								jdbcuserName= properties.getProperty("jdbc.userName");
								password = properties.getProperty("jdbc.password");
								System.out.println(driver + url + jdbcuserName + password);							
         }
        
        public boolean loginYes(String sql)  {
							       try {
											Class.forName(driver);
											try {
												connection = DriverManager.getConnection(url, jdbcuserName, password);
												System.out.println("查询学生的sql是"+sql);
												preparedStatement = connection.prepareStatement(sql);
												resultSet = preparedStatement.executeQuery();
												if (resultSet.next()) {
												 return true;			
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
							   	return false;
        } 
        
        //查询所有学生
        public  List userAllResultList(String sql) {
       	 //将rs逐条取出，并将每一项放在一个bean对应的值里
       	    List list = new ArrayList();
						try {
							Class.forName(driver);
							connection = DriverManager.getConnection(url, jdbcuserName, password);
							System.out.println("sql语句是"+sql);
							preparedStatement = connection.prepareStatement(sql);
							resultSet = preparedStatement.executeQuery();

						   	 while(resultSet.next()){
						   		User user = new User();
						   		user.setId(resultSet.getString(1));
						   		user.setName(resultSet.getString(2));
						   		 list.add(user);
						   	 }
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
							this.closeStream();
						}				
                 return list;
    }
      //查询学生
        public  List userResultList(String sql) {
       	 //将rs逐条取出，并将每一项放在一个bean对应的值里
       	    List list = new ArrayList();
						try {
							Class.forName(driver);
							connection = DriverManager.getConnection(url, jdbcuserName, password);
							System.out.println("sql语句是"+sql);
							preparedStatement = connection.prepareStatement(sql);
							resultSet = preparedStatement.executeQuery();
							System.out.println("preparedStatement的值是"+preparedStatement);

						   	 while(resultSet.next()){
						   		User user = new User();
						   		user.setId(resultSet.getString(1));
						   		user.setName(resultSet.getString(2));
						   		 list.add(user);
						   	 }
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally {
							this.closeStream();
						}				
                 return list;
    }
        //删除学生
        public  boolean userDelete(String sql) {
            boolean b = false;
					try {
						Class.forName(driver);
						connection = DriverManager.getConnection(url, jdbcuserName, password);
						System.out.println("sql语句是"+sql);
						preparedStatement = connection.prepareStatement(sql);
						if(preparedStatement.executeUpdate()>=1) {
							b=true;
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						this.closeStream();
					}				
             return b;
}
        public  boolean insertStudent(String sql,User student) {
            try  {
           	 Class.forName(driver);
           	 connection = DriverManager.getConnection(url, jdbcuserName, password);
				preparedStatement = connection.prepareStatement(sql);
				                 if(student!=null) {
				                	 preparedStatement.setString(1, student.getId());
				                	 preparedStatement.setString(2, student.getName());
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
        //更新学生信息
        public  boolean userUpdate(String sql,User user) {
        	boolean b= true;
            try  {
           	 Class.forName(driver);
           	 connection = DriverManager.getConnection(url, jdbcuserName, password);
				preparedStatement = connection.prepareStatement(sql);
				                 if(user!=null) {
				                	 preparedStatement.setString(1,user.getName() );
				                	 preparedStatement.setString(2, user.getId());
				                 }
              int i =   preparedStatement.executeUpdate();
              if (i>=1) {
            	  b= true;
            	  System.out.println("更新学生的结果是"+i);
			}
            } catch(Exception e){
                e.printStackTrace();
                System.out.println("你好，出错了，没有擦汗巾去");
                b= false;
              throw new RuntimeException(e.getMessage());
            }finally{
              this.closeStream();
            }
            return b;
        
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
