package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Lesson;
import org.javeriana.codequest.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public void save(Lesson lesson) {
        lesson.setId(null);
        lessonRepository.save(lesson);
    }

    public void delete(Long idLesson) {
        Lesson lesson = lessonRepository.findById(idLesson).orElse(null);
        lessonRepository.delete(lesson);
    }

    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }

    public Lesson findById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public List<Lesson> findByTopicId(Long idTopic) {
        return lessonRepository.findByTopicId(idTopic);
    }

    public void update(Lesson lesson) {
        lessonRepository.save(lesson);
    }
}
