package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Badge;
import org.javeriana.codequest.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BadgeService {

    @Autowired
    BadgeRepository badgeRepository;

    public void save(Badge badge) {
        badgeRepository.save(badge);
    }

    public void delete(Badge badge) {
        badgeRepository.delete(badge);
    }

    public void deleteById(Long id) {
        badgeRepository.deleteById(id);
    }

    public Badge findById(Long id) {
        return badgeRepository.findById(id).orElse(null);
    }

    public List<Badge> findAll() {
        return badgeRepository.findAll();
    }
}
