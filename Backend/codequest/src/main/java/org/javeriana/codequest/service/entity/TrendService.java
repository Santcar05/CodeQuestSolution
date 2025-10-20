package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Trend;
import org.javeriana.codequest.repository.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrendService {

    private TrendRepository trendRepository;

    public void save(Trend trend) {
        trendRepository.save(trend);
    }

    public void delete(Trend trend) {
        trendRepository.delete(trend);
    }

    public List<Trend> findAll() {
        return trendRepository.findAll();
    }

    public Trend findById(Long id) {
        return trendRepository.findById(id).orElse(null);
    }
}
