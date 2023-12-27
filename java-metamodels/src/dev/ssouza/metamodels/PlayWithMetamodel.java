package dev.ssouza.metamodels;

import java.util.List;

public class PlayWithMetamodel {
    public static void main(String[] args) {
        Metamodel<Person> metalmodel = Metamodel.of(Person.class);

        PrimaryKeyField PrimaryKeyField = metalmodel.getPrimaryKey();
        List<ColumnField> columnFields = metalmodel.getColumns();
    }
}
