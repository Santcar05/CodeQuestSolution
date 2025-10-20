package org.javeriana.codequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<org.javeriana.codequest.entity.Lesson, Long> {

}
