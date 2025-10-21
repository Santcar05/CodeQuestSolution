package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Lesson;
import org.javeriana.codequest.service.entity.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/all")
    public List<Lesson> findAll() {
        return lessonService.findAll();
    }

    @GetMapping("/{id}")
    public Lesson findById(@PathVariable Long id) {
        return lessonService.findById(id);
    }

}
