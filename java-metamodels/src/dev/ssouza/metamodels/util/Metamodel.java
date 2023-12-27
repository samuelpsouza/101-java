package dev.ssouza.metamodels.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import dev.ssouza.metamodels.annotation.PrimaryKey;
import dev.ssouza.metamodels.annotation.Column;

import dev.ssouza.metamodels.util.PrimaryKeyField;
import dev.ssouza.metamodels.util.ColumnField;



public class Metamodel<T> {

    private Class<T> clss;

    public static <T> Metamodel<T> of(Class<T> clss) {
        return new Metamodel<>(clss);
    }

    public Metamodel(Class<T> clss) {
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
}
