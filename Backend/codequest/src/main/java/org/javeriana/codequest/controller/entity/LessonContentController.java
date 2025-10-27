package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Lesson;
import org.javeriana.codequest.entity.LessonContent;
import org.javeriana.codequest.service.entity.LessonContentService;
import org.javeriana.codequest.service.entity.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lessoncontent")
public class LessonContentController {

    @Autowired
    private LessonContentService lessonContentService;

    @Autowired
    private LessonService lessonService;

    @GetMapping("/all")
    public List<LessonContent> findAll() {
        return lessonContentService.findAll();
    }

    @GetMapping("/{id}")
    public LessonContent findById(@PathVariable Long id) {
        return lessonContentService.findById(id);
    }

    @PostMapping("/save/{idLesson}")
    public ResponseEntity<?> save(@RequestBody LessonContent lessonContent, @PathVariable Long idLesson) {
        try {
            Lesson lesson = lessonService.findById(idLesson);

            if (lesson == null) {
                return ResponseEntity.badRequest().body("Lesson not found with id: " + idLesson);
            }
            lesson.setContent(lessonContent);
            // Verificar si ya existe contenido para esta lección
            LessonContent existingContent = lessonContentService.findByLessonId(idLesson);
            if (existingContent != null) {
                // Actualizar el contenido existente
                lessonContent.setId(existingContent.getId());
                lessonContent.setLesson(lesson);
                lessonContentService.update(lessonContent);
                return ResponseEntity.ok("Lesson content updated successfully");
            } else {
                // Crear nuevo contenido
                lessonContent.setLesson(lesson);
                lessonContentService.save(lessonContent);

                return ResponseEntity.ok("Lesson content created successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving lesson content: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public void update(@RequestBody LessonContent lessonContent) {
        lessonContentService.update(lessonContent);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        lessonContentService.deleteById(id);
    }

    @GetMapping("/lesson/{id}")
    public LessonContent findByLessonId(@PathVariable Long id) {
        return lessonContentService.findByLessonId(id);
    }
}
