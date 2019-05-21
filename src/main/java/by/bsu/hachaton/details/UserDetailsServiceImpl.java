package by.bsu.hachaton.details;

import by.bsu.hachaton.DAO.UserDAO;
import by.bsu.hachaton.DTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO repository;

    @Autowired
    public UserDetailsServiceImpl(UserDAO repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repository.getById(login).get();
        user.setPassword("{noop}" + user.getPassword());
        return new UserDetailsImpl(user);
    }
}
