package edu.ccut.cn.servicesRoot;

import java.util.List;

import edu.ccut.cn.db.RootDB;
import edu.ccut.cn.db.UserDB;
import edu.ccut.cn.po.ManagerRoot;
import edu.ccut.cn.po.User;

public class RootOperation {
			
			//这是管理员登陆验证页面的services
			public  boolean rootIsOk(String rootName,String rootPassword) {
				RootDB rootDB =new RootDB();
				String sql = "select * from root where  rootName='"+rootName+"' and rootPassword='"+rootPassword+"'";
				return rootDB.rootIsLogin(sql);
			}
			//添加管理员的services
		
			 public boolean   insertRoot(ManagerRoot managerRoot) {
			    	RootDB rootDB = new RootDB();    	 
			    	String sql ="insert  into root values(?,?)";
			    	//String sql = "select * from bookForm where  bookName=dataStructure";
			    	return rootDB.insertRoot(sql,managerRoot);	 	
			    }
			 
			//查询管理员的services		
			 public List  rootSelect(String rootName) {
				 System.out.println("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"+rootName);
			    	RootDB rootDB = new RootDB();    	 
			    	String sql ="select * from root where rootName='"+rootName+"'";
//			    	String [] parameters= {
//			    			rootName
//			    	};
			    	//String sql = "select * from bookForm where  bookName=dataStructure";
			    	return rootDB.rootResultList(sql);	 	
			    }
			 
			//查询所有的管理员的services		
			 public List  rootAllSelect() {
				 
			    	RootDB rootDB = new RootDB();    	 
			    	String sql ="select * from root ";
			    	return rootDB.rootAllResultList(sql);	 	
			    }
			 //删除管理源
			 public boolean  rootDelete(String rootName) {
			    	RootDB rootDB = new RootDB();    	 
			    	String sql ="delete from root where rootName='"+rootName+"'";
			    	return rootDB.rootDelete(sql);	 	
			    }
			 
			 
			//更新管理员的services
				
			 public boolean   rootUpdate(ManagerRoot managerRoot) {
			    	RootDB rootDB = new RootDB();    	 
			    	String sql ="update root set rootPassword=? where rootName=?";
			    	//String sql = "select * from bookForm where  bookName=dataStructure";
			    	return rootDB.rootUpdate(sql,managerRoot);	 	
			    }
}
