package by.bsu.hachaton.DAO;

import by.bsu.hachaton.DTO.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO implements CommonDAO {

    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public Optional getById(String id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void update(Object model) {

    }

    @Override
    public void create(Object model) {

    }
}
