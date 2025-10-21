package org.javeriana.codequest.controller.entity;

import org.javeriana.codequest.entity.RoadmapItem;
import org.javeriana.codequest.service.entity.RoadmapItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roadmapitem")
@CrossOrigin(origins = "http://localhost:4200")
public class RoadmapItemController {

    @Autowired
    private RoadmapItemService roadmapItemService;

    public RoadmapItemController(RoadmapItemService roadmapItemService) {
        this.roadmapItemService = roadmapItemService;
    }

    @GetMapping("/all")
    public Iterable<RoadmapItem> findAll() {
        return roadmapItemService.findAll();
    }

    @GetMapping("/{id}")
    public RoadmapItem findById(@PathVariable Long id) {
        return roadmapItemService.findById(id);
    }

}
