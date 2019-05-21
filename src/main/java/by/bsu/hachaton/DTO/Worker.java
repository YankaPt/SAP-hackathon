package by.bsu.hachaton.DTO;

import org.springframework.stereotype.Component;

public class Worker extends User implements BasicEntity {

    public Worker() {
    }

    private String Status;

    public Worker(String login, String password, String role) {
        super(login, password, role);
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
