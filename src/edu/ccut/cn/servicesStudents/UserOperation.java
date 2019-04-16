package edu.ccut.cn.servicesStudents;

import java.util.List;

import edu.ccut.cn.db.BookDB;
import edu.ccut.cn.db.RootDB;
import edu.ccut.cn.db.UserDB;
import edu.ccut.cn.po.Book;
import edu.ccut.cn.po.ManagerRoot;
import edu.ccut.cn.po.User;

public class UserOperation {
	//这是管理员登陆验证页面的services
	public  boolean rootIsOk(String rootName,String rootPassword) {
		RootDB rootDB =new RootDB();
		String sql = "select * from students where  name='"+rootName+"' and rootPassword='"+rootPassword+"'";
		return rootDB.rootIsLogin(sql);
	}
	//添加管理员的services

	 public boolean   insertRoot(ManagerRoot managerRoot) {
	    	RootDB rootDB = new RootDB();    	 
	    	String sql ="insert  into root values(?,?)";
	    	//String sql = "select * from bookForm where  bookName=dataStructure";
	    	return rootDB.insertRoot(sql,managerRoot);	 	
	    }
	 
	//查询学生的services		
	 public List  userSelect(String userId) {
	    	UserDB userDB = new UserDB();    	 
	    	String sql ="select * from students where id='"+userId+"'";
	    	return userDB.userResultList(sql);	 	
	    }
	 
	//查询所有学生的services		
	 public List  userAllSelect() {
		 
	    	UserDB userDB = new UserDB();    	 
	    	String sql ="select * from students ";
	    	return userDB.userAllResultList(sql);	 	
	    }
	 //删除管理源
	 public boolean  userDelete(String userId) {
	    	UserDB userDB = new UserDB();    	 
	    	String sql ="delete from students where id='"+userId+"'";
	    	return userDB.userDelete(sql);	 	
	    }
	 
	 
	//更新管理员的services
		
	 public boolean   userUpdate(User user) {
	    	UserDB userDB = new UserDB();    	 
	    	String sql ="update students set name=? where id=?";
	    	//String sql = "select * from bookForm where  bookName=dataStructure";
	    	return userDB.userUpdate(sql,user);	 	
	    }
		 public boolean   insertStudent(User student) {
		    	UserDB studentsDB = new UserDB();
		    	 
		    	String sql ="insert  into students values(?,?)";
		    	//String sql = "select * from bookForm where  bookName=dataStructure";
		    	return studentsDB.insertStudent(sql, student);	 	
		    }

}
