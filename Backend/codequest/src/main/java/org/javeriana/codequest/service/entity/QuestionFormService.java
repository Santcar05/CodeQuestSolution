package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.QuestionForm;
import org.javeriana.codequest.repository.QuestionFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionFormService {

    @Autowired
    private QuestionFormRepository questionFormRepository;

    public QuestionForm save(QuestionForm questionForm) {
        return questionFormRepository.save(questionForm);
    }

    public void delete(QuestionForm questionForm) {
        questionFormRepository.delete(questionForm);
    }

    public void deleteById(Long id) {
        questionFormRepository.deleteById(id);
    }

    public QuestionForm findById(Long id) {
        return questionFormRepository.findById(id).orElse(null);
    }

    public List<QuestionForm> findAll() {
        return questionFormRepository.findAll();
    }

}
