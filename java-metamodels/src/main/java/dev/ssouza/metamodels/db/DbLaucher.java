package dev.ssouza.metamodels.db;

import java.sql.SQLException;

import org.h2.tools.Server;

public class DbLaucher {
	public static void main(String[] args) throws SQLException {
		Server.main(args);
		System.out.println("DB Lauched");
	}
}
