package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Technology;
import org.javeriana.codequest.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyService {

    @Autowired
    TechnologyRepository technologyRepository;

    public void save(Technology technology) {
        technologyRepository.save(technology);
    }

    public void delete(Technology technology) {
        technologyRepository.delete(technology);
    }

    public List<Technology> findAll() {
        return technologyRepository.findAll();
    }

    public Technology findById(Long id) {
        return technologyRepository.findById(id).orElse(null);
    }
}
