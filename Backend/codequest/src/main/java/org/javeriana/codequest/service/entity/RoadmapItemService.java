package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.RoadmapItem;
import org.javeriana.codequest.repository.RoadmapItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoadmapItemService {

    @Autowired
    private RoadmapItemRepository roadmapItemRepository;

    public void save(RoadmapItem roadmapItem) {
        roadmapItemRepository.save(roadmapItem);
    }

    public void delete(RoadmapItem roadmapItem) {
        roadmapItemRepository.delete(roadmapItem);
    }

    public void deleteById(Long id) {
        roadmapItemRepository.deleteById(id);
    }

    public RoadmapItem findById(Long id) {
        return roadmapItemRepository.findById(id).orElse(null);
    }

    public List<RoadmapItem> findAll() {
        return roadmapItemRepository.findAll();
    }
}
