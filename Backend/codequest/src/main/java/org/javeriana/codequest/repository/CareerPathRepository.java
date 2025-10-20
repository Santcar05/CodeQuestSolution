package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.CareerPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerPathRepository extends JpaRepository<CareerPath, Long> {

}
