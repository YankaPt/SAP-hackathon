package by.bsu.hachaton.DAO;

import by.bsu.hachaton.DTO.User;
import by.bsu.hachaton.DTO.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Repository
public class WorkerDAO implements CommonDAO<Worker> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Worker> getById(String id) {
        return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM \"worker\" WHERE login = ?",
                new BeanPropertyRowMapper<>(Worker.class), id));
    }

    @Override
    public List<Worker> getAll() {
        return jdbcTemplate.query("SELECT * FROM \"worker\"",
                new BeanPropertyRowMapper<>(Worker.class));
    }

    @Override
    public void update(Worker model) {
        Object[] params = {model.getLogin(), model.getPassword(), model.getRole(), model.getStatus()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.
                update("UPDATE \"worker\" SET  role = ?, password = ?, status = ? WHERE login = ?", params, types);
    }

    @Override
    public void create(Worker model) {
        Object[] params = {model.getLogin(), model.getPassword(), model.getRole(), model.getStatus()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        jdbcTemplate.update("INSERT INTO \"worker\" (login, password, role, status) VALUES (?, ?, ?, ?)", params, types);
    }
}
