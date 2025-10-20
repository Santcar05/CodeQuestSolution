package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Question;
import org.javeriana.codequest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void save(Question question) {
        questionRepository.save(question);
    }

    public void delete(Question question) {
        questionRepository.delete(question);
    }

    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    public Question findById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
