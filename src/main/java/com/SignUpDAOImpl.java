package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpDAOImpl implements SignUpDAO {
	
	
	
	
	private Connection connection;

	public SignUpDAOImpl() {
		// TODO Load the DBUtil class
		connection = DBUtil.getConnection();
		System.out.println("impl's connection= " + connection.hashCode());
	}
	
	
	@Override
	public void insert(int id, String password) throws SQLException {
		
		String query = "insert into SignUp values (?,?)";

		PreparedStatement pst = connection.prepareStatement(query);
		
		pst.setInt(1,id);
		pst.setString(2, password);


		int res = pst.executeUpdate();
		System.out.println(res+" product inserted");

	}

}
