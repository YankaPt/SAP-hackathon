package by.bsu.hachaton.DAO;

import by.bsu.hachaton.DTO.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Component
public class RequestDAO implements CommonDAO<Request> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RequestDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Request> getById(String id) {
        return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM \"request\" WHERE login = ?",
                new BeanPropertyRowMapper<>(Request.class), id));
    }

    @Override
    public List<Request> getAll() {
        return jdbcTemplate.query("SELECT * FROM \"request\"",
                new BeanPropertyRowMapper<>(Request.class));
    }

    @Override
    public void update(Request model) {
        Object[] params = {model.getDescription(), model.getId(), model.getLatitude(), model.getLongitude(),
                model.getPhoto(), model.getRank(), model.getStatus()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.DOUBLE, Types.VARCHAR, Types.DOUBLE, Types.VARCHAR};
        jdbcTemplate.
                update("UPDATE \"request\" SET  description = ?, id = ?, latitude = ?, longitude = ?, photo = ?, rank = ?, status = ? WHERE id = ?", params, types);
    }

    @Override
    public void create(Request model) {
        Object[] params = {model.getDescription(), model.getLatitude(), model.getLongitude(),
                model.getPhoto(), model.getRank(), model.getStatus()};
        int[] types = {Types.VARCHAR, Types.DOUBLE, Types.DOUBLE, Types.VARCHAR, Types.DOUBLE, Types.VARCHAR};
        jdbcTemplate.update("INSERT INTO \"request\" (description, latitude, longitude, photo, rank, status) VALUES (?, ?, ?, ?, ?, ?)", params, types);
    }
}
