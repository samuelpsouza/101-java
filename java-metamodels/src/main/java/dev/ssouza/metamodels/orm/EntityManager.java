package dev.ssouza.metamodels.orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface EntityManager<T> {
	
	void persist(T t) throws IllegalArgumentException, IllegalAccessException, SQLException;

	T find(Class<T> clss, Object primaryKey) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
}
