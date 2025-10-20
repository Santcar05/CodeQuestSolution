package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.Power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerRepository extends JpaRepository<Power, Long> {

}
