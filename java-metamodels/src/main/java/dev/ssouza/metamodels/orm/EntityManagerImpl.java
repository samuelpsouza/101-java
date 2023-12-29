package dev.ssouza.metamodels.orm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import dev.ssouza.metamodels.util.ColumnField;
import dev.ssouza.metamodels.util.Metamodel;

public class EntityManagerImpl<T> implements EntityManager<T> {

	private AtomicLong idGenerator = new AtomicLong(0L);

	@Override
	public void persist(T t) throws IllegalArgumentException, IllegalAccessException, SQLException {
		Metamodel metamodel = Metamodel.of(t.getClass());
		String sql = metamodel.buildInsertRequest();

		PreparedStatement statement = prepareStatementSql(sql).andParameters(t);
		statement.executeUpdate();
	}

	private PreparedStatementWrapper prepareStatementSql(String sql) throws SQLException {
		Connection connection = DriverManager.getConnection("", "", "");
		PreparedStatement statement = connection.prepareStatement(sql);
		return new PreparedStatementWrapper(statement);
	}

	private class PreparedStatementWrapper {
		private PreparedStatement statement;

		public PreparedStatementWrapper(PreparedStatement statement) {
			this.statement = statement;
		}

		public PreparedStatement andParameters(T t) throws SQLException, IllegalArgumentException, IllegalAccessException {
			Metamodel metamodel = Metamodel.of(t.getClass());
			Class<?> primaryKeyType = metamodel.getPrimaryKey().getType();

			if (primaryKeyType == long.class) {
				long id = idGenerator.incrementAndGet();
				statement.setLong(1, id);
				Field field = metamodel.getPrimaryKey().getField();
				field.setAccessible(true);
				field.set(t, id);
			}

			for (int columnIndex = 0; columnIndex < metamodel.getColumns().size(); columnIndex++) {
				ColumnField columnField = metamodel.getColumns().get(columnIndex);
				Class<?> fieldType = columnField.getType();
				Field field = columnField.getField();

				field.setAccessible(true);
				Object value = field.get(t);

				if (fieldType == int.class) {
					statement.setInt(columnIndex + 2, (int) value);
				} else if (fieldType == String.class) {
					statement.setString(columnIndex + 2, (String) value);
				}
			}
			return statement;
		}

		public PreparedStatement andPrimaryKey(Object primaryKey) throws SQLException {
			if (primaryKey.getClass() == Long.class) {
				statement.setLong(1, (Long) primaryKey);
			}
			return statement;
		}

	}

	@Override
	public T find(Class<T> clss, Object primaryKey) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Metamodel metamodel = Metamodel.of(clss);
		String sql = metamodel.buildSelectRequest();
		PreparedStatement statement = prepareStatementSql(sql).andPrimaryKey(primaryKey);
		
		ResultSet resultSet = statement.executeQuery();
		
		return buildInstanceFrom(clss, resultSet);
	}

	private T buildInstanceFrom(Class<T> clss, ResultSet resultSet) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		Metamodel metamodel = Metamodel.of(clss);
		
		T t = clss.getConstructor().newInstance();
		Field primaryKeyField = metamodel.getPrimaryKey().getField();
		String primaryKeyColumnName = metamodel.getPrimaryKey().getName();
		Class<?> primaryKeyType = primaryKeyField.getType();
		
		resultSet.next();
		
		if(primaryKeyType == long.class) {
			long primaryKey = resultSet.getInt(primaryKeyColumnName);
			primaryKeyField.setAccessible(true);
			primaryKeyField.set(t, primaryKey);
		}
		
		for (ColumnField columnField : metamodel.getColumns()) {
			Field field = columnField.getField();
			Class<?> columnType = columnField.getType();
			String columnName = columnField.getName();
			field.setAccessible(true);
			
			if(columnType == int.class) {
				int value = resultSet.getInt(columnName);
				field.set(t, value);
			} else if (columnType == String.class){
				String value = resultSet.getString(columnName);
				field.set(t, value);
			}
		}
		return t;
	}
}
