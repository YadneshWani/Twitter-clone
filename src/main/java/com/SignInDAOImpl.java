package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInDAOImpl implements SignInDAO {

	
	
	private Connection connection;

	public SignInDAOImpl() {
		// TODO Load the DBUtil class
		connection = DBUtil.getConnection();
		System.out.println("impl's connection= " + connection.hashCode());
	}
	
	
	@Override
	public boolean login(int id, String password) throws SQLException {
		String query = "select * from signup where id=?";

		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setInt(1,id);

		ResultSet res = pst.executeQuery();
		if(res.next()) {
			String pass=res.getString(2);
			if(pass.equals(password)) {
				System.out.println("Id Present !");
				return true;
			}
		}
		return false;
		

	}

}
