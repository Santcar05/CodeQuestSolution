package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.LearningMethod;
import org.javeriana.codequest.repository.LearningMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningMethodService {

    @Autowired
    private LearningMethodRepository learningMethodRepository;

    public void save(LearningMethod learningMethod) {
        learningMethodRepository.save(learningMethod);
    }

    public void delete(LearningMethod learningMethod) {
        learningMethodRepository.delete(learningMethod);
    }

    public void deleteById(Long id) {
        learningMethodRepository.deleteById(id);
    }

    public LearningMethod findById(Long id) {
        return learningMethodRepository.findById(id).orElse(null);
    }

    public List<LearningMethod> findAll() {
        return learningMethodRepository.findAll();
    }
}
