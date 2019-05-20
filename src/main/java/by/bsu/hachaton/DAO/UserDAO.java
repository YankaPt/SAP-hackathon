package by.bsu.hachaton.DAO;

import by.bsu.hachaton.DTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO implements CommonDAO<User> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> getById(String id) {
        return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM \"user\" WHERE login = ?",
                new BeanPropertyRowMapper<>(User.class), id));
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM \"user\"",
                new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void update(User model) {
        Object[] params = {model.getLogin(), model.getPassword(), model.getRole()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.
                update("UPDATE \"user\" SET  role = ?, password = ? WHERE login = ?", params, types);
    }

    @Override
    public void create(User model) {
        Object[] params = {model.getLogin(), model.getPassword(), model.getRole()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update("INSERT INTO \"user\" (login, password, role) VALUES (?, ?, ?)", params, types);
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
