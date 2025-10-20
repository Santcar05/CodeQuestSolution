package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Project;
import org.javeriana.codequest.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void save(Project project) {
        projectRepository.save(project);
    }

    public void delete(Project project) {
        projectRepository.delete(project);
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

}
