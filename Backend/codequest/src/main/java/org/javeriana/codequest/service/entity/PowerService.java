package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Power;
import org.javeriana.codequest.repository.PowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerService {

    @Autowired
    private PowerRepository powerRepository;

    public void save(Power power) {
        powerRepository.save(power);
    }

    public void delete(Power power) {
        powerRepository.delete(power);
    }

    public Power findById(Long id) {
        return powerRepository.findById(id).orElse(null);
    }

    public List<Power> findAll() {
        return powerRepository.findAll();
    }
}
