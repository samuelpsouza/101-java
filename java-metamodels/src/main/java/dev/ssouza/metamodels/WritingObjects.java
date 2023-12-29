package dev.ssouza.metamodels;

import java.sql.SQLException;

import dev.ssouza.metamodels.beanmanager.BeanManager;
import dev.ssouza.metamodels.model.Person;
import dev.ssouza.metamodels.orm.EntityManager;
import dev.ssouza.metamodels.orm.ManagedEntityManager;

public class WritingObjects {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SQLException {
		BeanManager beanManager = BeanManager.getInstance();
		EntityManager<Person> em = beanManager.getInstance(ManagedEntityManager.class);

		Person ssouza = new Person("Samuel", 31);
		Person lariza = new Person("Lariza", 28);
		
		em.persist(ssouza);
		em.persist(lariza);
	}
}
