package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.LessonContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonContentRepository extends JpaRepository<LessonContent, Long> {

    public LessonContent findByLessonId(Long id);
}
