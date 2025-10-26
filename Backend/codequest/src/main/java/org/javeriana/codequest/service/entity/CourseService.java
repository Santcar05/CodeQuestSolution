package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Course;
import org.javeriana.codequest.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public void delete(Course course) {
        courseRepository.delete(course);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

}
