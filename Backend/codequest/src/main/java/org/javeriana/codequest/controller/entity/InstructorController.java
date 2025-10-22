package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Instructor;
import org.javeriana.codequest.service.entity.InstructorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/instructor")
public class InstructorController {

    private InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/all")
    public List<Instructor> findAll() {
        return instructorService.findAll();
    }

    @GetMapping("/{id}")
    public Instructor findById(Long id) {
        return instructorService.findById(id);
    }
}
