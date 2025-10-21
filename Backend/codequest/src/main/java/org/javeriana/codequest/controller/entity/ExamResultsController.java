package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.ExamResults;
import org.javeriana.codequest.service.entity.ExamResultsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/examResults")
public class ExamResultsController {

    private ExamResultsService examResultService;

    public ExamResultsController(ExamResultsService examResultService) {
        this.examResultService = examResultService;
    }

    @GetMapping("/all")
    public List<ExamResults> findAll() {
        return examResultService.findAll();
    }

    @GetMapping("/{id}")
    public ExamResults findById(@PathVariable Long id) {
        return examResultService.findById(id);
    }
}
