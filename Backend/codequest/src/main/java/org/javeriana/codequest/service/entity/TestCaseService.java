package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.TestCase;
import org.javeriana.codequest.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    public void save(TestCase testCase) {
        testCaseRepository.save(testCase);
    }

    public void delete(TestCase testCase) {
        testCaseRepository.delete(testCase);
    }

    public List<TestCase> findAll() {
        return testCaseRepository.findAll();
    }

    public TestCase findById(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }
}
