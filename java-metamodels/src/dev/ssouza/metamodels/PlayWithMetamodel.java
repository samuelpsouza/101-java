package dev.ssouza.metamodels;

import java.util.List;

import dev.ssouza.metamodels.model.Person;
import dev.ssouza.metamodels.util.PrimaryKeyField;
import dev.ssouza.metamodels.util.ColumnField;
import dev.ssouza.metamodels.util.Metamodel;


public class PlayWithMetamodel {
    public static void main(String[] args) {
        Metamodel<Person> metalmodel = Metamodel.of(Person.class);

        PrimaryKeyField primaryKeyField = metalmodel.getPrimaryKey();
        List<ColumnField> columnFields = metalmodel.getColumns();

        System.out.println("Primary key name = " + primaryKeyField.getName() + ", type = " + primaryKey.getType().getSimpleName());
    }
}
