package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Requirement;
import org.javeriana.codequest.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequirementService {

    @Autowired
    private RequirementRepository requirementRepository;

    public void save(Requirement requirement) {
        requirementRepository.save(requirement);
    }

    public void delete(Requirement requirement) {
        requirementRepository.delete(requirement);
    }

    public void deleteById(Long id) {
        requirementRepository.deleteById(id);
    }

    public Requirement findById(Long id) {
        return requirementRepository.findById(id).orElse(null);
    }

    public List<Requirement> findAll() {
        return requirementRepository.findAll();
    }

}
