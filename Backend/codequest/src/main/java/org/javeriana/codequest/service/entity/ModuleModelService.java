package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.ModuleModel;
import org.javeriana.codequest.repository.ModuleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleModelService {

    @Autowired
    private ModuleModelRepository moduleModelRepository;

    public void save(ModuleModel moduleModel) {
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
}
