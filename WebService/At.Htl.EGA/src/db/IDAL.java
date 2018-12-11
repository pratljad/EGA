package db;

import java.util.List;

public interface IDAL<T> {

	List<T> Get();
	
	T Get(int id);
	
	void Delete(int id);
	
	T Update(T item);
	
	T Insert(T item);
	
}
