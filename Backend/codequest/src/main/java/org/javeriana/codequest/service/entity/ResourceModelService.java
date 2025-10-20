package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.ResourceModel;
import org.javeriana.codequest.repository.ResourceModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceModelService {

    @Autowired
    private ResourceModelRepository resourceModelRepository;

    public void save(ResourceModel resourceModel) {
        resourceModelRepository.save(resourceModel);
    }

    public void delete(ResourceModel resourceModel) {
        resourceModelRepository.delete(resourceModel);
    }

    public void deleteById(Long id) {
        resourceModelRepository.deleteById(id);
    }

    public ResourceModel findById(Long id) {
        return resourceModelRepository.findById(id).orElse(null);
    }

    public List<ResourceModel> findAll() {
        return resourceModelRepository.findAll();
    }
}
