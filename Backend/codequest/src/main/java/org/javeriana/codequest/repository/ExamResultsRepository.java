package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.ExamResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamResultsRepository extends JpaRepository<ExamResults, Integer> {

}
