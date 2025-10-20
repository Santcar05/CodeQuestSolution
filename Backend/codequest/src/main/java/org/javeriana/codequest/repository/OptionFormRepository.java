package org.javeriana.codequest.repository;

import java.util.List;

import org.javeriana.codequest.entity.OptionForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionFormRepository extends JpaRepository<org.javeriana.codequest.entity.OptionForm, Long> {

    List<OptionForm> findByQuestionForm_Id(Long id);

}
