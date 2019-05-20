package by.bsu.hachaton.services.worker;

import by.bsu.hachaton.DAO.CommonDAO;
import by.bsu.hachaton.DTO.Worker;
import by.bsu.hachaton.exceptions.NoWorkerWithSuchLoginException;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public class WorkerServiceImpl implements WorkerService {
    @Resource(name = "WorkerDAO")
    private CommonDAO commonDAO;

    @Override
    public Worker getWorkerByLogin(String login) throws NoWorkerWithSuchLoginException {
        Optional<Worker> optionalWorker = commonDAO.getById(login);
        if (optionalWorker.isPresent()) {
            return optionalWorker.get();
        } else {
            throw new NoWorkerWithSuchLoginException();
        }
    }

    @Override
    public List<Worker> getAllWorkers() {
        return commonDAO.getAll();
    }

    @Override
    public void createWorker(Worker worker) {
        commonDAO.create(worker);
    }

    @Override
    public void update(Worker worker) {
        commonDAO.update(worker);
    }
}
