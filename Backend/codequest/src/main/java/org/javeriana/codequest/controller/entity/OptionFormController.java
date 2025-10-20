package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.OptionForm;
import org.javeriana.codequest.service.entity.OptionFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/optionForm")
public class OptionFormController {

    @Autowired
    private OptionFormService optionFormService;

    @GetMapping("/all")
    public List<OptionForm> findAll() {
        return optionFormService.findAll();
    }

    @GetMapping("question/{id}")
    public List<OptionForm> findById(@PathVariable Long id) {
        return optionFormService.findByQuestionFormId(id);
    }
}
