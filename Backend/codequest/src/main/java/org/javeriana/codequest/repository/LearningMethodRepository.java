package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.LearningMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningMethodRepository extends JpaRepository<LearningMethod, Long> {

}
