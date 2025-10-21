package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.UserProfile;
import org.javeriana.codequest.service.entity.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/userProfile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/all")
    public List<UserProfile> findAll() {
        return userProfileService.findAll();
    }

    @GetMapping("/{id}")
    public UserProfile findById(@PathVariable Long id) {
        return userProfileService.findById(id);
    }
}
