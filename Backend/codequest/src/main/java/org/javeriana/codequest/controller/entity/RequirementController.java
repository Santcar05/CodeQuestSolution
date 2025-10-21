package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Requirement;
import org.javeriana.codequest.service.entity.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requirement")
@CrossOrigin(origins = "http://localhost:4200")
public class RequirementController {

    @Autowired
    private RequirementService requirementService;

    public RequirementController(RequirementService requirementService) {
        this.requirementService = requirementService;
    }

    @GetMapping("/all")
    public List<Requirement> findAll() {
        return requirementService.findAll();
    }

    @GetMapping("/{id}")
    public Requirement findById(@PathVariable Long id) {
        return requirementService.findById(id);
    }

}
