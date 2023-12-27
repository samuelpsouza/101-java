package dev.ssouza.metamodels.util;

public class Metamodel<T> {

    private Class<T> clss;

    public static <T> Metamodel<T> of(Class<T> clss) {
        return new Metamodel<>(clss);
    }

    public Metamodel(Class<T> clss) {
        this.clss = clss;
    }

    public PrimaryKeyField getPrimaryKey() {
        return null;
    }

    public List<ColumnField> getColumns() {
        return null;
    }
}
