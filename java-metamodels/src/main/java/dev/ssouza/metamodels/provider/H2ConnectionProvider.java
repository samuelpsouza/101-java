package dev.ssouza.metamodels.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dev.ssouza.metamodels.annotation.Provides;

public class H2ConnectionProvider {
	
	@Provides
	public Connection buildConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("", "", "");
		return connection;
	}
}
