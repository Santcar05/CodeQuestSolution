package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.ExamResults;
import org.javeriana.codequest.repository.ExamResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamResultsService {

    @Autowired
    private ExamResultsRepository examResultsRepository;

    public void save(ExamResults examResults) {
        examResultsRepository.save(examResults);
    }

    public void delete(ExamResults examResults) {
        examResultsRepository.delete(examResults);
    }

    public void deleteById(Long id) {
        examResultsRepository.deleteById(id);
    }

    public ExamResults findById(Long id) {
        return examResultsRepository.findById(id).orElse(null);
    }

    public List<ExamResults> findAll() {
        return examResultsRepository.findAll();
    }
}
