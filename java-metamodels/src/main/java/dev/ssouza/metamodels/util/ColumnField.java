package dev.ssouza.metamodels.util;

import java.lang.reflect.Field;

import dev.ssouza.metamodels.annotation.Column;

public class ColumnField {
    private Field field;
    private Column column;

    public ColumnField(Field field) {
        this.field = field;
        this.column = this.field.getAnnotation(Column.class);
    }

	public String getName() {
		return column.name();
	}

	public Class<?> getType() {
		return field.getType();
	}

	public Field getField() {
		return field;
	}
    
}
