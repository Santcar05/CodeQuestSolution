package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.QuestionForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionFormRepository extends JpaRepository<QuestionForm, Long> {

}
