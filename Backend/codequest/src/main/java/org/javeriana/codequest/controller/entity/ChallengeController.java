package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Challenge;
import org.javeriana.codequest.service.entity.ChallengeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/challenge")
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/all")
    public List<Challenge> findAll() {
        return challengeService.findAll();
    }

    @GetMapping("/{id}")
    public Challenge findById(@PathVariable Long id) {
        return challengeService.findById(id);
    }

}
