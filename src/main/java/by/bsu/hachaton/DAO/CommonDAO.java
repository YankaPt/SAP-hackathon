package by.bsu.hachaton.DAO;

import java.util.List;
import java.util.Optional;

public interface CommonDAO<T> {

    Optional<T> getById(String id);

    List<T> getAll();

    void update(T model);
  
    void create(T model);
}
