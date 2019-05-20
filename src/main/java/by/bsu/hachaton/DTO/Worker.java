package by.bsu.hachaton.DTO;

public class Worker extends User {

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
