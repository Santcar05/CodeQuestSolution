package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.Technology;
import org.javeriana.codequest.service.entity.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/techonology")
@CrossOrigin(origins = "http://localhost:4200")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    public TechnologyController(TechnologyService techonologyService) {
        this.technologyService = techonologyService;
    }

    @GetMapping
    public List<Technology> getAllTechnologies() {
        return technologyService.findAll();
    }

    @GetMapping("/{id}")
    public Technology getTechnologyById(@PathVariable Long id) {
        return technologyService.findById(id);
    }

}
