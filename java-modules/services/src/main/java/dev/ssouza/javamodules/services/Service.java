package dev.ssouza.javamodules.services;

public interface Service<T> {
	public T create(T t);
	public T read(Integer id);
	public T update(T t);
	public Boolean delete(Integer id);
}
