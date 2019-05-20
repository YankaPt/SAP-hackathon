package by.bsu.hachaton.services.user;

import by.bsu.hachaton.DAO.CommonDAO;
import by.bsu.hachaton.DTO.User;
import by.bsu.hachaton.exceptions.NoUserWithSuchLoginException;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Resource(name = "UserDao")
    private CommonDAO commonDAO;

    @Override
    public User getUserByLogin(String login) {
        Optional<User> optionalUser = commonDAO.getById(login);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new NoUserWithSuchLoginException();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return commonDAO.getAll();
    }

    @Override
    public void createUser(User user) {
        commonDAO.create(user);
    }

    @Override
    public void update(User user) {
        commonDAO.update(user);
    }
}
