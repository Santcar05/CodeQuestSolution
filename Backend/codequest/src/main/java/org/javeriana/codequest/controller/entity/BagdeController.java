package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Badge;
import org.javeriana.codequest.service.entity.BadgeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/badge")
public class BagdeController {

    private BadgeService badgeService;

    public BagdeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @GetMapping("/all")
    public List<Badge> findAll() {
        return badgeService.findAll();
    }

    @GetMapping("/{id}")
    public Badge findById(@PathVariable Long id) {
        return badgeService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Badge badge) {
        badgeService.save(badge);
    }

}
