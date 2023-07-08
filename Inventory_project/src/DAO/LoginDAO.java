package DAO;

import Model.Login;

import java.sql.*;
import ConnectionManager.ConnrctionManager;

public class LoginDAO 
{
	public boolean validate(Login login)throws ClassNotFoundException, SQLException 
	{
		//1.user input
		String username=login.getUsername();
		String password=login.getPassword();
		
		//connection java and jdbc
		ConnrctionManager conm = new ConnrctionManager();
		Connection con=conm.establishConnection();
		
		//1.Statement class declare
		Statement st=con.createStatement();
		
		//2.write query
		ResultSet rt= st.executeQuery("select * from login");
		while(rt.next())
		{
			//check username and password
		if(username.equals(rt.getString("username"))&& password.equals(rt.getString("password")))
		{
			conm.closeConnection();
			return true;
		}
		}

			conm.closeConnection();
			return false;
	}
}
		


