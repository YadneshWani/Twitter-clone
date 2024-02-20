package com;

import java.sql.SQLException;

public interface SignInDAO {
	boolean login(int id,String password) throws SQLException;
}
