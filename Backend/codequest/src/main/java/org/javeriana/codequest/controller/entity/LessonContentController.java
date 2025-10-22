package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.LessonContent;
import org.javeriana.codequest.service.entity.LessonContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lessoncontent")
public class LessonContentController {

    @Autowired
    private LessonContentService lessonContentService;

    @GetMapping("/all")
    public List<LessonContent> findAll() {
        return lessonContentService.findAll();
    }

    @GetMapping("/{id}")
    public LessonContent findById(@PathVariable Long id) {
        return lessonContentService.findById(id);
    }
}
