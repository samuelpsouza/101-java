package dev.ssouza.metamodels.orm;

import java.sql.PreparedStatement;

import dev.ssouza.metamodels.util.Metamodel;

public class EntityManagerImpl<T> implements EntityManager<T> {

	@Override
	public void persist(T t) {
		Metamodel metamodel = Metamodel.of(t.getClass());
		String sql = metamodel.buildInsertRequest();
		
		PreparedStatement statement = prepareStatementSql(sql).andParameters(t);
		statement.executeUpdate();
	}

}
