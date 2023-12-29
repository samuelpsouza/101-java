package dev.ssouza.metamodels;

import java.sql.SQLException;

import dev.ssouza.metamodels.model.Person;
import dev.ssouza.metamodels.orm.EntityManager;

public class WritingObjects {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SQLException {
		EntityManager<Person> em = EntityManager.of(Person.class);
		
		Person ssouza = new Person("Samuel", 31);
		Person lariza = new Person("Lariza", 28);
		
		em.persist(ssouza);
		em.persist(lariza);
	}
}
