package by.bsu.hachaton.services.recommendation;

import by.bsu.hachaton.DAO.RequestDAO;
import by.bsu.hachaton.DAO.WorkerDAO;
import by.bsu.hachaton.DTO.Request;
import by.bsu.hachaton.DTO.Worker;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendationService {
    private static final Double NEARBY_RADIUS = 100.0;

    @Resource
    RequestDAO requestDAO;
    @Resource
    WorkerDAO workerDAO;

    public Worker findWorkerForPerformRequest(Request request) {
        List<Worker> freeWorkers = workerDAO.getAll().stream().filter(worker -> "Free".equals(worker.getStatus())).collect(Collectors.toList());
        List<Request> nearbyHoles = requestDAO.getAll().stream().filter(r -> isNearbyHole(request, r)).collect(Collectors.toList());
        if (nearbyHoles.stream().anyMatch(r -> r.getStatus().equals("UnderWork"))) {
            return null;
        } else {
            return freeWorkers.get(0);
        }
    }

    private boolean isNearbyHole(Request initial, Request anotherRequest) {
        return Math.abs(initial.getLatitude()-anotherRequest.getLatitude())<=NEARBY_RADIUS && Math.abs(initial.getLongitude()-anotherRequest.getLongitude())<=NEARBY_RADIUS;
    }
}
