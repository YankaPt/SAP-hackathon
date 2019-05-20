package by.bsu.hachaton.DAO;

import by.bsu.hachaton.DTO.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO implements CommonDAO<User> {



    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void create(User model) {

    }

}
