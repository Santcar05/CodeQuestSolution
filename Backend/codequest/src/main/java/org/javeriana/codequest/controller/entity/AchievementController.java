package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Achievement;
import org.javeriana.codequest.service.entity.AchievementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/achievement")
public class AchievementController {

    private AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("/all")
    public List<Achievement> findAll() {
        return achievementService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Achievement achievement) {
        achievementService.save(achievement);
    }

    @DeleteMapping
    public void delete(@RequestBody Achievement achievement) {
        achievementService.delete(achievement);
    }

    @PutMapping
    public void update(@RequestBody Achievement achievement) {
        achievementService.update(achievement);
    }

}
