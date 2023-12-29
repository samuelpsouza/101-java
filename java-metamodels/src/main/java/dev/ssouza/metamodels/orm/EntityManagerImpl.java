package dev.ssouza.metamodels.orm;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
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

		public PreparedStatement andParameters(T t)
				throws SQLException, IllegalArgumentException, IllegalAccessException {
			Metamodel metamodel = Metamodel.of(t.getClass());
			Class<?> primaryKeyType = metamodel.getPrimaryKey().getType();

			if (primaryKeyType == long.class) {
				statement.setLong(1, idGenerator.incrementAndGet());
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

	}
}
