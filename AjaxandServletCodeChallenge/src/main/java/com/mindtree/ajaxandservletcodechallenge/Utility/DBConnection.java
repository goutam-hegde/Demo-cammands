package com.mindtree.ajaxandservletcodechallenge.Utility;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {

	public Connection createConnection() throws SQLException;
}
