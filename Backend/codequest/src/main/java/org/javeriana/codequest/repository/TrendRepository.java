package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.Trend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendRepository extends JpaRepository<Trend, Long> {

}
