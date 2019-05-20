package by.bsu.hachaton.DAO;

import java.util.List;

public interface CommonDAO<T> {

    T getById(String id);

    List<T> getAll();

    void update(T model);

    void create(T model);
}
