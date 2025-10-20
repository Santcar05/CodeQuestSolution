package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.RoadmapPhase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadmapPhaseRepository extends JpaRepository<RoadmapPhase, Long> {

}
