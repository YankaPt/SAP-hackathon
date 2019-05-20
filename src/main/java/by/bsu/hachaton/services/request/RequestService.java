package by.bsu.hachaton.services.request;

import by.bsu.hachaton.DTO.Request;
import by.bsu.hachaton.exceptions.NoRequestWithSuchIdException;

import java.util.List;

public interface RequestService {
    Request getRequestByLogin(String login) throws NoRequestWithSuchIdException;
    List<Request> getAllRequests();
    void createRequest(Request Request);
    void update(Request Request);
}
