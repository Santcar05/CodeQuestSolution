package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.CareerPath;
import org.javeriana.codequest.repository.CareerPathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareerPathService {

    @Autowired
    private CareerPathRepository careerPathRepository;

    public void save(CareerPath careerPath) {
        careerPathRepository.save(careerPath);
    }

    public void deleteById(Long id) {
        careerPathRepository.deleteById(id);
    }

    public CareerPath findById(Long id) {
        return careerPathRepository.findById(id).orElse(null);
    }

    public List<CareerPath> findAll() {
        return careerPathRepository.findAll();
    }
}
