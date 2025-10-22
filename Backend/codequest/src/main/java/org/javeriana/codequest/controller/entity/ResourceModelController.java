package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.ResourceModel;
import org.javeriana.codequest.service.entity.ResourceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resourceModel")
@CrossOrigin(origins = "http://localhost:4200")
public class ResourceModelController {

    @Autowired
    private ResourceModelService resourceModelService;

    public ResourceModelController(ResourceModelService resourceModelService) {
        this.resourceModelService = resourceModelService;
    }

    @GetMapping("/all")
    public List<ResourceModel> findAll() {
        return resourceModelService.findAll();
    }

    @GetMapping("/{id}")
    public ResourceModel findById(@PathVariable Long id) {
        return resourceModelService.findById(id);
    }
}
