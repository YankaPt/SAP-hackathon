package by.bsu.hachaton.services.request;

import by.bsu.hachaton.DAO.CommonDAO;
import by.bsu.hachaton.DTO.Request;
import by.bsu.hachaton.exceptions.NoRequestWithSuchIdException;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public class RequestServiceImpl implements RequestService {
    @Resource(name = "RequestDAO")
    private CommonDAO commonDAO;

    @Override
    public Request getRequestByLogin(String login) throws NoRequestWithSuchIdException {
        Optional<Request> optionalRequest = commonDAO.getById(login);
        if (optionalRequest.isPresent()) {
            return optionalRequest.get();
        } else {
            throw new NoRequestWithSuchIdException();
        }
    }

    @Override
    public List<Request> getAllRequests() {
        return commonDAO.getAll();
    }

    @Override
    public void createRequest(Request Request) {
        commonDAO.create(Request);
    }

    @Override
    public void update(Request Request) {
        commonDAO.update(Request);
    }
}
