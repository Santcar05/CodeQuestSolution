package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.RoadmapItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadmapItemRepository extends JpaRepository<RoadmapItem, Long> {

}
