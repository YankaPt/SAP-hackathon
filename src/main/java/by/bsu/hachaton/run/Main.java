package by.bsu.hachaton.run;

import by.bsu.hachaton.DAO.CommonDAO;
import by.bsu.hachaton.DAO.UserDAO;
import by.bsu.hachaton.DTO.User;
import by.bsu.hachaton.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);

        CommonDAO storage = applicationContext.getBean(UserDAO.class);

        List<User> users = storage.getAll();

        System.out.println(users.size());
    }
}
