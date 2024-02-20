package com;

import java.sql.SQLException;

public interface SignUpDAO {
	void insert(int id,String password) throws SQLException;
}
