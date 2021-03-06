package by.bsu.hachaton.services.worker;

import by.bsu.hachaton.DTO.Worker;
import by.bsu.hachaton.exceptions.NoWorkerWithSuchLoginException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WorkerService {
    Worker getWorkerByLogin(String login) throws NoWorkerWithSuchLoginException;
    List<Worker> getAllWorkers();
    void createWorker(Worker worker);
    void update(Worker worker);
}
