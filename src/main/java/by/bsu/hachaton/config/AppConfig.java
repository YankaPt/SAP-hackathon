package by.bsu.hachaton.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"by.bsu.hachaton"}, excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
@EnableTransactionManagement
public class AppConfig {

    @Bean
    @FlywayDataSource
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("1234qwer");
        hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hakaton");
        return hikariDataSource;
    }

    @Bean
    @DependsOn("dataSource")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}


