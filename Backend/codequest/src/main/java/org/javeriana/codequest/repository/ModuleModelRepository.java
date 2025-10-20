package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleModelRepository extends JpaRepository<ModuleModel, Long> {

}
