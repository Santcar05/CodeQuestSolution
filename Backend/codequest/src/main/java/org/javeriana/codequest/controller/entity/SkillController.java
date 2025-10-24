package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Skill;
import org.javeriana.codequest.service.entity.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/all")
    public List<Skill> getAllSkills() {
        return skillService.findAll();
    }

    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return skillService.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Skill skill) {
        skillService.save(skill);
    }

    @PutMapping("/update")
    public void update(@RequestBody Skill skill) {
        skillService.save(skill);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        Skill skill = skillService.findById(id);
        skillService.delete(skill);
    }

}
