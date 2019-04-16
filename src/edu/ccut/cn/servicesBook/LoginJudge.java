package edu.ccut.cn.servicesBook;

import java.sql.SQLException;

import com.sun.org.apache.xpath.internal.operations.And;

import edu.ccut.cn.db.UserDB;

public class LoginJudge {

	public  boolean loginYes(String id,String userName) {
		UserDB studentsDB =new UserDB();
		String sql = "select * from students where  id='"+id+"' and name='"+userName+"'";
		return studentsDB.loginYes(sql);
	}
	

}
