package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.FeaturedUser;
import org.javeriana.codequest.service.entity.FeaturedUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/featuredUser")
public class FeaturedUserController {

    private FeaturedUserService featuredUserService;

    public FeaturedUserController(FeaturedUserService featuredUserService) {
        this.featuredUserService = featuredUserService;
    }

    @GetMapping("/all")
    public List<FeaturedUser> findAll() {
        return featuredUserService.findAll();
    }

    @GetMapping("/{id}")
    public FeaturedUser findById(@PathVariable Long id) {
        return featuredUserService.findById(id);
    }
}
