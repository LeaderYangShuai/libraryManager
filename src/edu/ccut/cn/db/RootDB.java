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
import java.util.List;
import java.util.Properties;

import edu.ccut.cn.po.Book;
import edu.ccut.cn.po.ManagerRoot;
import edu.ccut.cn.po.User;

public class RootDB {
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
							    inputStream = BookDB.class.getClassLoader().getResourceAsStream("edu/ccut/cn/db/root_db.properties");
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
        
        //验证是不是管理员正确登陆
        public boolean rootIsLogin(String sql)  {
							       try {
											Class.forName(driver);
											try {
												connection = DriverManager.getConnection(url, userName, password);
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
        
        //插入管理员
        public  boolean insertRoot(String sql,ManagerRoot managerRoot) {
        	boolean b= true;
            try  {
           	 Class.forName(driver);
           	 connection = DriverManager.getConnection(url, userName, password);
				preparedStatement = connection.prepareStatement(sql);
				                 if(managerRoot!=null) {
				                	 preparedStatement.setString(1, managerRoot.getRootName());
				                	 preparedStatement.setString(2, managerRoot.getRootPassword());
				                 }
                System.out.println("sql后的语句是"+sql);
                preparedStatement.executeUpdate();
            } catch(Exception e){
                e.printStackTrace();
            //    throw new RuntimeException(e.getMessage());
                System.out.println("你好，出错了，没有擦汗巾去");
               b= false;
            }finally{
              this.closeStream();
            }
            return b;
        
        }
        
        //查询管理员
        public  List rootResultList(String sql) {
       	 //将rs逐条取出，并将每一项放在一个bean对应的值里
       	    List list = new ArrayList();
						try {
							Class.forName(driver);
							connection = DriverManager.getConnection(url, userName, password);
							System.out.println("sql语句是"+sql);
							preparedStatement = connection.prepareStatement(sql);
							resultSet = preparedStatement.executeQuery();
							System.out.println("preparedStatement的值是"+preparedStatement);
//							if (parameters!=null && parameters.length>0) {
//										for (int i = 0; i < parameters.length; i++) {
//											preparedStatement.setString(i+1,parameters[i]);							
//										}
//							}else {
//								//preparedStatement.close();
//								sql ="select * from root";
//								preparedStatement = connection.prepareStatement(sql);
//							}

						   	 while(resultSet.next()){
						   		ManagerRoot managerRoot = new ManagerRoot();
						   		managerRoot.setRootName(resultSet.getString(1));
						   		managerRoot.setRootPassword(resultSet.getString(2));
						   		 list.add(managerRoot);
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
        
        //删除管理员
        public  boolean rootDelete(String sql) {
                   boolean b = false;
   						try {
   							Class.forName(driver);
   							connection = DriverManager.getConnection(url, userName, password);
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
        
        //查询管理员
        public  List rootAllResultList(String sql) {
       	 //将rs逐条取出，并将每一项放在一个bean对应的值里
       	    List list = new ArrayList();
						try {
							Class.forName(driver);
							connection = DriverManager.getConnection(url, userName, password);
							System.out.println("sql语句是"+sql);
							preparedStatement = connection.prepareStatement(sql);
							resultSet = preparedStatement.executeQuery();

						   	 while(resultSet.next()){
						   		ManagerRoot managerRoot = new ManagerRoot();
						   		managerRoot.setRootName(resultSet.getString(1));
						   		managerRoot.setRootPassword(resultSet.getString(2));
						   		 list.add(managerRoot);
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
        
        //更新管理员
        public  boolean rootUpdate(String sql,ManagerRoot managerRoot) {
        	boolean b= true;
            try  {
           	 Class.forName(driver);
           	 connection = DriverManager.getConnection(url, userName, password);
				preparedStatement = connection.prepareStatement(sql);
				                 if(managerRoot!=null) {
				                	 preparedStatement.setString(1,managerRoot.getRootPassword() );
				                	 preparedStatement.setString(2, managerRoot.getRootName());
				                 }
                System.out.println("sql后的语句是"+sql);
                preparedStatement.executeUpdate();
            } catch(Exception e){
                e.printStackTrace();
            //    throw new RuntimeException(e.getMessage());
                System.out.println("你好，出错了，没有擦汗巾去");
               b= false;
            }finally{
              this.closeStream();
            }
            return b;
        
        }
        
        
        //关闭流资源
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
