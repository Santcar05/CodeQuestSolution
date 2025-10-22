package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.LearningMethod;
import org.javeriana.codequest.service.entity.LearningMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "localhost:4200")
@RequestMapping("/api/learningMethod")
public class LearningMethodController {

    @Autowired
    private LearningMethodService learningMethodService;

    public LearningMethodController(LearningMethodService learningMethodService) {
        this.learningMethodService = learningMethodService;
    }

    @GetMapping("/all")
    public List<LearningMethod> findAll() {
        return learningMethodService.findAll();
    }

    @GetMapping("/{id}")
    public LearningMethod findById(@PathVariable Long id) {
        return learningMethodService.findById(id);
    }

}
