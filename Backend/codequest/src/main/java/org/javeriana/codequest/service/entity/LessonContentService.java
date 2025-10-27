package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.LessonContent;
import org.javeriana.codequest.repository.LessonContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonContentService {

    @Autowired
    private LessonContentRepository lessonContentRepository;

    public LessonContent save(LessonContent lessonContent) {
        // Para crear nuevo, asegurar que el ID sea null
        if (lessonContent.getId() != null) {
            // Si tiene ID, es una actualización
            return lessonContentRepository.save(lessonContent);
        } else {
            // Para creación nueva, verificar si ya existe
            if (lessonContent.getLesson() != null && lessonContent.getLesson().getId() != null) {
                LessonContent existing = findByLessonId(lessonContent.getLesson().getId());
                if (existing != null) {
                    // Actualizar el existente
                    lessonContent.setId(existing.getId());
                    return lessonContentRepository.save(lessonContent);
                }
            }
            // Crear nuevo
            lessonContent.setId(null);
            return lessonContentRepository.save(lessonContent);
        }
    }

    public void delete(LessonContent lessonContent) {
        lessonContentRepository.delete(lessonContent);
    }

    public void deleteById(Long id) {
        lessonContentRepository.deleteById(id);
    }

    public LessonContent findById(Long id) {
        return lessonContentRepository.findById(id).orElse(null);
    }

    public List<LessonContent> findAll() {
        return lessonContentRepository.findAll();
    }

    public void update(LessonContent lessonContent) {
        lessonContentRepository.save(lessonContent);
    }

    public LessonContent findByLessonId(Long id) {
        return lessonContentRepository.findByLessonId(id);
    }
}
