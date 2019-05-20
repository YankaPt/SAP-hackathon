package by.bsu.hachaton.services.worker;

import by.bsu.hachaton.DAO.CommonDAO;
import by.bsu.hachaton.exceptions.NoWorkerWithSuchLoginException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class WorkerServiceImpl implements WorkerService {
    @Resource(name = "WorkerDao")
    private CommonDAO commonDAO;

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
