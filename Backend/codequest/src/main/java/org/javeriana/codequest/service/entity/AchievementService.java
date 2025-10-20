package org.javeriana.codequest.service.entity;

import org.javeriana.codequest.entity.Achievement;
import org.javeriana.codequest.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public void save(Achievement achievement) {
        achievementRepository.save(achievement);
    }

    public void delete(Achievement achievement) {
        achievementRepository.delete(achievement);
    }

    public void deleteById(Long id) {
        achievementRepository.deleteById(id);
    }

    public Achievement findById(Long id) {
        return achievementRepository.findById(id).orElse(null);
    }

}
