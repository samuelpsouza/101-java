package dev.ssouza.metamodels.orm;

import java.sql.SQLException;

public interface EntityManager<T> {
	static <T> EntityManager<T> of(Class<T> clss){
		return new EntityManagerImpl<>();
	}
	
	void persist(T t) throws IllegalArgumentException, IllegalAccessException, SQLException;
}
