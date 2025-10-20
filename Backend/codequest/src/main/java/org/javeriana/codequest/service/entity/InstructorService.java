package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Instructor;
import org.javeriana.codequest.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    public void delete(Instructor instructor) {
        instructorRepository.delete(instructor);
    }

    public Instructor findById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }
}
