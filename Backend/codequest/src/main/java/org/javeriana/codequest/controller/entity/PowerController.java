package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Power;
import org.javeriana.codequest.service.entity.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/power")
public class PowerController {

    @Autowired
    private PowerService powerService;

    public PowerController(PowerService powerService) {
        this.powerService = powerService;
    }

    @GetMapping("/all")
    public List<Power> findAll() {
        return powerService.findAll();
    }

    @GetMapping("/{id}")
    public Power findById(@PathVariable Long id) {
        return powerService.findById(id);
    }

}
