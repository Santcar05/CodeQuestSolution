package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Skill;
import org.javeriana.codequest.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public void save(Skill skill) {
        skillRepository.save(skill);
    }

    public void delete(Skill skill) {
        skillRepository.delete(skill);
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Skill findById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }
}
