package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Lesson;
import org.javeriana.codequest.entity.Topic;
import org.javeriana.codequest.service.entity.LessonService;
import org.javeriana.codequest.service.entity.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private TopicService topicService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Lesson>> findAll() {
        try {
            List<Lesson> lessons = lessonService.findAll();
            return ResponseEntity.ok(lessons);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> findById(@PathVariable Long id) {
        try {
            Lesson lesson = lessonService.findById(id);
            if (lesson != null) {
                return ResponseEntity.ok(lesson);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/topic/{idTopic}")
    public ResponseEntity<List<Lesson>> findByTopicId(@PathVariable Long idTopic) {
        try {
            List<Lesson> lessons = lessonService.findByTopicId(idTopic);
            return ResponseEntity.ok(lessons);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/save/{idTopic}")
    public ResponseEntity<Lesson> save(@RequestBody Lesson lesson, @PathVariable Long idTopic) {
        Topic topic = topicService.findById(idTopic);
        lesson.setTopic(topic);
        try {
            lessonService.save(lesson);
            return ResponseEntity.status(HttpStatus.CREATED).body(lesson);
        } catch (Exception e) {
            e.printStackTrace(); // Para ver el error en consola
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Lesson> update(@PathVariable Long id, @RequestBody Lesson lesson) {
        try {
            lesson.setId(id);
            lessonService.update(lesson);
            return ResponseEntity.ok(lesson);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            lessonService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
