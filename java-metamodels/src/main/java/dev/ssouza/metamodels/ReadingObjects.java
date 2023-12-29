package dev.ssouza.metamodels;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import dev.ssouza.metamodels.beanmanager.BeanManager;
import dev.ssouza.metamodels.model.Person;
import dev.ssouza.metamodels.orm.EntityManager;
import dev.ssouza.metamodels.orm.ManagedEntityManager;

public class ReadingObjects {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		BeanManager beanManager = BeanManager.getInstance();
		EntityManager<Person> em = beanManager.getInstance(ManagedEntityManager.class);

		Person ssouza = em.find(Person.class, 1L);
		Person lariza = em.find(Person.class, 2L);
		
		System.out.println(ssouza);
		System.out.println(lariza);
	}
}
