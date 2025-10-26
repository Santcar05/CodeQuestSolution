package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.ModuleModel;
import org.javeriana.codequest.service.entity.ModuleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/modulemodel")
public class ModuleModelController {

    @Autowired
    private ModuleModelService moduleModelService;

    public ModuleModelController(ModuleModelService moduleModelService) {
        this.moduleModelService = moduleModelService;
    }

    @GetMapping("/all")
    public List<ModuleModel> findAll() {
        return moduleModelService.findAll();
    }

    @GetMapping("/{id}")
    public ModuleModel findById(Long id) {
        return moduleModelService.findById(id);
    }

    @PostMapping("/save/{idCurso}")
    public void save(@RequestBody ModuleModel moduleModel, @PathVariable Long idCurso) {
        moduleModelService.save(moduleModel, idCurso);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody ModuleModel moduleModel, @PathVariable Long id) {
        moduleModel.setId(id);
        moduleModelService.update(moduleModel);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        ModuleModel moduleModel = moduleModelService.findById(id);
        moduleModelService.delete(moduleModel);
    }

    @GetMapping("/course/{id}")
    public List<ModuleModel> findByCourseId(@PathVariable Long id) {
        return moduleModelService.findByIdCourse(id);
    }

}
