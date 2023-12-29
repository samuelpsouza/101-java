package dev.ssouza.metamodels.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2EntityManager<T> extends AbstractEntityManager<T> {
	@Override
	public Connection buildConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("", "", "");
		return connection;
	}
}
