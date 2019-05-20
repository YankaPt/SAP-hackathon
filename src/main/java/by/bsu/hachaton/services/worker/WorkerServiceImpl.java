package by.bsu.hachaton.services.worker;

import by.bsu.hachaton.DAO.CommonDAO;
import by.bsu.hachaton.DAO.WorkerDAO;
import by.bsu.hachaton.DTO.Worker;
import by.bsu.hachaton.exceptions.NoWorkerWithSuchLoginException;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class WorkerServiceImpl implements WorkerService {

    private final WorkerDAO commonDAO;

    @Autowired
    public WorkerServiceImpl(WorkerDAO commonDAO) {
        this.commonDAO = commonDAO;
    }

    @Override
    public Worker getWorkerByLogin(String login) throws NoWorkerWithSuchLoginException {
        return null;
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
