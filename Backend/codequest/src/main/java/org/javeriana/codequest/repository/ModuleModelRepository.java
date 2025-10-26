package org.javeriana.codequest.repository;

import java.util.List;

import org.javeriana.codequest.entity.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleModelRepository extends JpaRepository<ModuleModel, Long> {

    List<ModuleModel> findByCourse_Id(Long courseId);

}
