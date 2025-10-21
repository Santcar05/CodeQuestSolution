package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.CodeExplanation;
import org.javeriana.codequest.service.entity.CodeExplanationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/codeExplanation")
public class CodeExplanationController {

    private CodeExplanationService codeExplanationService;

    public CodeExplanationController(CodeExplanationService codeExplanationService) {
        this.codeExplanationService = codeExplanationService;
    }

    @GetMapping("/all")
    public List<CodeExplanation> findAll() {
        return codeExplanationService.findAll();
    }

    @GetMapping("/{id}")
    public CodeExplanation findById(@PathVariable Long id) {
        return codeExplanationService.findById(id);
    }

}
