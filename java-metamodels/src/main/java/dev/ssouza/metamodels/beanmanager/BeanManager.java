package dev.ssouza.metamodels.beanmanager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import dev.ssouza.metamodels.annotation.Inject;
import dev.ssouza.metamodels.annotation.Provides;
import dev.ssouza.metamodels.orm.EntityManager;
import dev.ssouza.metamodels.provider.H2ConnectionProvider;

public class BeanManager {
	private static BeanManager instance = new BeanManager();

	private Map<Class<?>, Supplier<?>> registry = new HashMap<>();
	private BeanManager() {
		List<Class<?>> classes = List.of(H2ConnectionProvider.class);
		
		for (Class<?> clss : classes) {
			Method[] declaredMethods = clss.getDeclaredMethods();
			
			for (Method method : declaredMethods) {
				Provides provides = method.getAnnotation(Provides.class);
				
				if(provides != null) {
					Class<?> returnType = method.getReturnType();
					Supplier<?> supplier = () -> {
						try {
							if(!Modifier.isStatic(method.getModifiers())) {
								Object obj = clss.getConstructor().newInstance();
								return method.invoke(obj);
							} else {
								return method.invoke(null);
							}
						}catch (Exception e) {
							throw new RuntimeException();
						}
					};
					
					registry.put(returnType, supplier);
				}
			}
		}
	}

	public static BeanManager getInstance() {
		return instance;
	}

	public <T> T getInstance(Class<T> clss) {
		try {
			T t = clss.getConstructor().newInstance();
			
			Field[] declaredFields = clss.getDeclaredFields();
			
			for (Field field : declaredFields) {
				Inject inject = field.getAnnotation(Inject.class);
				
				if(inject != null) {
					Class<?> injectedFieldType = field.getType();
					Supplier<?> supplier = registry.get(injectedFieldType);
					Object objectToInject = supplier.get();
					field.setAccessible(true);
					field.set(t, objectToInject);
				}
			}
			
			return t;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
