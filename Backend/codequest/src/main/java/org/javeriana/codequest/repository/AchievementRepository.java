package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {

}
