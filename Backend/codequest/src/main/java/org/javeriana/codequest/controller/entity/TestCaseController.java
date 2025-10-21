package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.TestCase;
import org.javeriana.codequest.service.entity.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testcase")
@CrossOrigin(origins = "http://localhost:4200")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping("/all")
    public List<TestCase> findAll() {
        return testCaseService.findAll();
    }

    @GetMapping("/{id}")
    public TestCase findById(@PathVariable Long id) {
        return testCaseService.findById(id);
    }
}
