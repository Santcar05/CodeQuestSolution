package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Course;
import org.javeriana.codequest.entity.ModuleModel;
import org.javeriana.codequest.repository.ModuleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleModelService {

    @Autowired
    private ModuleModelRepository moduleModelRepository;

    @Autowired
    private CourseService courseService;

    public void save(ModuleModel moduleModel, Long id) {
        Course course = courseService.findById(id);
        moduleModel.setCourse(course);
        moduleModel.setId(null);
        moduleModelRepository.save(moduleModel);
    }

    public void save(ModuleModel moduleModel) {
        moduleModel.setId(null);
        moduleModelRepository.save(moduleModel);
    }

    public void deleteById(Long id) {
        moduleModelRepository.deleteById(id);
    }

    public void delete(ModuleModel moduleModel) {
        moduleModelRepository.delete(moduleModel);
    }

    public ModuleModel findById(Long id) {
        return moduleModelRepository.findById(id).orElse(null);
    }

    public List<ModuleModel> findAll() {
        return moduleModelRepository.findAll();
    }

    public void update(ModuleModel moduleModel) {
        moduleModelRepository.save(moduleModel);
    }

    public List<ModuleModel> findByIdCourse(Long id) {
        return moduleModelRepository.findByCourse_Id(id);
    }

}
