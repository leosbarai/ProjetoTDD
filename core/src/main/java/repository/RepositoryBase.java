package repository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryBase<T> {

    List<T> entities = new ArrayList<>();

    public T add(T entity) {
        entities.add(entity);
        return entity;
    }

    public void remove(T entity) {
        entities.remove(entity);
    }

    public List<T> findAll() {
        return entities;
    }

    public int size(){
        return entities.size();
    }

}
