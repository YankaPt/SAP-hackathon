package by.bsu.hachaton.DAO;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CommonDAO<T> {

    Optional<T> getById(String id);

    List<T> getAll();

    void update(T model);
  
    void create(T model);
}
