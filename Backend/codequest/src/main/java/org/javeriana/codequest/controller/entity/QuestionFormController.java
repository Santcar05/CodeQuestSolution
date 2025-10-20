package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.QuestionForm;
import org.javeriana.codequest.service.entity.QuestionFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questionform")
@CrossOrigin(origins = "http://localhost:4200") // Permitir Angular local
public class QuestionFormController {

    @Autowired
    private QuestionFormService questionFormService;

    @GetMapping
    public List<QuestionForm> findAll() {
        return questionFormService.findAll();
    }

    @GetMapping("/{id}")
    public QuestionForm findById(@PathVariable Long id) {
        return questionFormService.findById(id);
    }
}
