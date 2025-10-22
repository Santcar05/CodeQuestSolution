package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Trend;
import org.javeriana.codequest.service.entity.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trend")
@CrossOrigin(origins = "http://localhost:4200")
public class TrendController {

    @Autowired
    private TrendService trendService;

    public TrendController(TrendService trendService) {
        this.trendService = trendService;
    }

    @GetMapping("/all")
    public List<Trend> getAllTrends() {
        return trendService.findAll();
    }

    @GetMapping("/{id}")
    public Trend getTrendById(@PathVariable Long id) {
        return trendService.findById(id);
    }
}
