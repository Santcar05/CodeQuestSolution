package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.UserProfile;
import org.javeriana.codequest.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile save(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public void delete(UserProfile userProfile) {
        userProfileRepository.delete(userProfile);
    }

    public UserProfile findById(Long id) {
        return userProfileRepository.findById(id).orElse(null);
    }

    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }
}
