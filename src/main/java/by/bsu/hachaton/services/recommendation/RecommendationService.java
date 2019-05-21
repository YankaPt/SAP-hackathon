package by.bsu.hachaton.services.recommendation;

import by.bsu.hachaton.DAO.RequestDAO;
import by.bsu.hachaton.DAO.WorkerDAO;
import by.bsu.hachaton.DTO.Request;
import by.bsu.hachaton.DTO.Worker;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendationService {
    private static final Double NEARBY_RADIUS = 100.0;

    @Resource
    RequestDAO requestDAO;
    @Resource
    WorkerDAO workerDAO;

    public Request chooseMostRankedRequest() {
        List<Request> freeRequests = requestDAO.getAll()
                .stream()
                .filter(request -> "Free".equals(request.getStatus()))
                .collect(Collectors.toList());
        Request resultRequest = freeRequests
                .stream()
                .max(Comparator.comparingDouble(Request::getRank))
                .get();
        return resultRequest;
    }

    public Worker findWorkerForPerformRequest(Request request) {
        List<Worker> freeWorkers = workerDAO.getAll()
                .stream()
                .filter(worker -> "FREE".equals(worker.getStatus()))
                .collect(Collectors.toList());
        List<Request> nearbyHoles = requestDAO.getAll()
                .stream()
                .filter(r -> isNearbyHole(request, r))
                .collect(Collectors.toList());
        if (nearbyHoles.stream().anyMatch(r -> r.getStatus().equals("UNDER_WORK"))) {
            return null;
        } else {
            Worker resultWorker = freeWorkers.get(0);
            resultWorker.setStatus("BUSY");
            request.setStatus("UNDER_WORK");
            workerDAO.update(resultWorker);
            requestDAO.update(request);
            return resultWorker;
        }
    }

    private boolean isNearbyHole(Request initial, Request anotherRequest) {
        return Math.abs(initial.getLatitude() - anotherRequest.getLatitude()) <= NEARBY_RADIUS && Math.abs(initial.getLongitude() - anotherRequest.getLongitude()) <= NEARBY_RADIUS;
    }
}
