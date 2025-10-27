package org.javeriana.codequest.repository;

import java.util.List;

import org.javeriana.codequest.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    public List<Topic> findByModuleId(Long idModule);
}
