package org.javeriana.codequest.controller.entity;

import org.javeriana.codequest.entity.RoadmapPhase;
import org.javeriana.codequest.service.entity.RoadmapPhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roadmapPhase")
@CrossOrigin(origins = "http://localhost:4200")
public class RoadmapPhaseContoller {

    @Autowired
    private RoadmapPhaseService roadmapPhaseService;

    public RoadmapPhaseContoller(RoadmapPhaseService roadmapPhaseService) {
        this.roadmapPhaseService = roadmapPhaseService;
    }

    @GetMapping("/all")
    public Iterable<RoadmapPhase> findAll() {
        return roadmapPhaseService.findAll();
    }

    @GetMapping("/{id}")
    public RoadmapPhase getById(@PathVariable Long id) {
        return roadmapPhaseService.findById(id);
    }
}
