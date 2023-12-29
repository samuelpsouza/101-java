package dev.ssouza.metamodels.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import dev.ssouza.metamodels.annotation.Column;
import dev.ssouza.metamodels.annotation.PrimaryKey;



public class Metamodel {

    private Class<?> clss;

    public static Metamodel of(Class<?> clss) {
        return new Metamodel(clss);
    }

    public Metamodel(Class<?> clss) {
        this.clss = clss;
    }

    public PrimaryKeyField getPrimaryKey() {
        Field[] fields = clss.getDeclaredFields();

        for (Field field : fields) {
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);

            if (primaryKey != null) {
                PrimaryKeyField primaryKeyField = new PrimaryKeyField(field);
                return primaryKeyField;
            }
        }

        throw new IllegalArgumentException("No primary key found in class " + clss.getSimpleName());
    }

    public List<ColumnField> getColumns() {
        final List<ColumnField> columnFields = new ArrayList<>();

        Field[] fields = clss.getDeclaredFields();

        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);

            if (column != null) {
                ColumnField columnField = new ColumnField(field);
                columnFields.add(columnField);
            }
        }

        return columnFields;
    }

	public String buildInsertRequest() {
		// insert into Person (id, name, age) values (?, ?, ?)
		
		String columnElement = buildColumnNamesElement();
		String questionMarksElement = buildQuestionMarksElement();
		
		return "insert into " + this.clss.getSimpleName() + " (" + columnElement + ") " + " values (" + questionMarksElement + ")";
	}

	private String buildQuestionMarksElement() {
		int numberOfColunms = getColumns().size() + 1;
		String questionMarksElement = IntStream
			.range(0, numberOfColunms)
			.mapToObj(index -> "?")
			.collect(Collectors.joining(", "));
		return questionMarksElement;
	}

	private String buildColumnNamesElement() {
		String primaryKeyColumnName = getPrimaryKey().getName();
		List<String> columnNames = getColumns()
				.stream()
				.map(ColumnField::getName)
				.toList();
		
		columnNames.add(0, primaryKeyColumnName);
		String columnElement = String.join(", ", columnNames);
		return columnElement;
	}
}
