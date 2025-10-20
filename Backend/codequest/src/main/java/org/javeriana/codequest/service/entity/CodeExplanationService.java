package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.CodeExplanation;
import org.javeriana.codequest.repository.CodeExplanationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeExplanationService {

    @Autowired
    private CodeExplanationRepository codeExplanationRepository;

    public void save(CodeExplanation codeExplanation) {
        codeExplanationRepository.save(codeExplanation);
    }

    public void delete(CodeExplanation codeExplanation) {
        codeExplanationRepository.delete(codeExplanation);
    }

    public void deleteById(Long id) {
        codeExplanationRepository.deleteById(id);
    }

    public CodeExplanation findById(Long id) {
        return codeExplanationRepository.findById(id).orElse(null);
    }

    public List<CodeExplanation> findAll() {
        return codeExplanationRepository.findAll();
    }
}
