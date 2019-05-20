package by.bsu.hachaton.services.user;

import by.bsu.hachaton.DTO.User;
import by.bsu.hachaton.exceptions.NoUserWithSuchLoginException;

import java.util.List;

public interface UserService {
    User getUserByLogin(String login) throws NoUserWithSuchLoginException;
    List<User> getAllUsers();
    void createUser(User user);
    void update(User user);
}
