package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Challenge;
import org.javeriana.codequest.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    public void save(Challenge challenge) {
        challengeRepository.save(challenge);
    }

    public void delete(Challenge challenge) {
        challengeRepository.delete(challenge);
    }

    public void deleteById(Long id) {
        challengeRepository.deleteById(id);
    }

    public Challenge findById(Long id) {
        return challengeRepository.findById(id).orElse(null);
    }

    public List<Challenge> findAll() {
        return challengeRepository.findAll();
    }
}
