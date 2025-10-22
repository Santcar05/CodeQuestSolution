package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.CareerPath;
import org.javeriana.codequest.service.entity.CareerPathService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/careerpath")
public class CareerPathController {

    private CareerPathService careerPathService;

    public CareerPathController(CareerPathService careerPathService) {
        this.careerPathService = careerPathService;
    }

    @GetMapping("/all")
    public List<CareerPath> findAll() {
        return careerPathService.findAll();
    }

    @GetMapping("/{id}")
    public CareerPath findById(@PathVariable Long id) {
        return careerPathService.findById(id);
    }

    @PostMapping
    public void save(CareerPath careerPath) {
        careerPathService.save(careerPath);
    }
}
