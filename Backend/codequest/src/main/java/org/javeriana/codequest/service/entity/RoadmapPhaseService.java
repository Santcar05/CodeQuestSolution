package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.RoadmapPhase;
import org.javeriana.codequest.repository.RoadmapPhaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoadmapPhaseService {

    @Autowired
    private RoadmapPhaseRepository roadmapPhaseRepository;

    public void save(RoadmapPhase roadmapPhase) {
        roadmapPhaseRepository.save(roadmapPhase);
    }

    public void delete(RoadmapPhase roadmapPhase) {
        roadmapPhaseRepository.delete(roadmapPhase);
    }

    public void deleteById(Long id) {
        roadmapPhaseRepository.deleteById(id);
    }

    public RoadmapPhase findById(Long id) {
        return roadmapPhaseRepository.findById(id).orElse(null);
    }

    public List<RoadmapPhase> findAll() {
        return roadmapPhaseRepository.findAll();
    }
}
