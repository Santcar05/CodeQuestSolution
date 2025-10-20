package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.OptionForm;
import org.javeriana.codequest.repository.OptionFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionFormService {

    @Autowired
    private OptionFormRepository optionformRepository;

    public void save(OptionForm optionform) {
        optionformRepository.save(optionform);
    }

    public void delete(OptionForm optionform) {
        optionformRepository.delete(optionform);
    }

    public OptionForm findById(Long id) {
        return optionformRepository.findById(id).orElse(null);
    }

    public List<OptionForm> findByQuestionFormId(Long id) {
        return optionformRepository.findByQuestionForm_Id(id);
    }

    public List<OptionForm> findAll() {
        return optionformRepository.findAll();
    }
}
