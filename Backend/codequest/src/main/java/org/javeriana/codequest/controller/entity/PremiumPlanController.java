package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.PremiumPlan;
import org.javeriana.codequest.service.entity.PremiumPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/premiumPlan")
public class PremiumPlanController {

    @Autowired
    private PremiumPlanService premiumPlanService;

    public PremiumPlanController(PremiumPlanService premiumPlanService) {
        this.premiumPlanService = premiumPlanService;
    }

    @GetMapping("/all")
    public List<PremiumPlan> findAll() {
        return premiumPlanService.findAll();
    }

    @GetMapping("/{id}")
    public PremiumPlan findById(@PathVariable Long id) {
        return premiumPlanService.findById(id);
    }
}
