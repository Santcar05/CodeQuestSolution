package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.PremiumPlan;
import org.javeriana.codequest.repository.PremiumPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumPlanService {

    @Autowired
    private PremiumPlanRepository premiumPlanRepository;

    public void save(PremiumPlan premiumPlan) {
        premiumPlanRepository.save(premiumPlan);
    }

    public void delete(PremiumPlan premiumPlan) {
        premiumPlanRepository.delete(premiumPlan);
    }

    public void deleteById(Long id) {
        premiumPlanRepository.deleteById(id);
    }

    public PremiumPlan findById(Long id) {
        return premiumPlanRepository.findById(id).orElse(null);
    }

    public List<PremiumPlan> findAll() {
        return premiumPlanRepository.findAll();
    }

}
