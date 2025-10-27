package org.javeriana.codequest.repository;

import java.util.List;

import org.javeriana.codequest.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<org.javeriana.codequest.entity.Lesson, Long> {

    public List<Lesson> findByTopicId(Long idTopic);
}
