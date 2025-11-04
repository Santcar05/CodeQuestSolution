package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Course;
import org.javeriana.codequest.entity.UserCourse;
import org.javeriana.codequest.entity.UserProfile;
import org.javeriana.codequest.repository.CourseRepository;
import org.javeriana.codequest.repository.UserCourseRepository;
import org.javeriana.codequest.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<UserCourse> findAll() {
        return userCourseRepository.findAll();
    }

    public UserCourse findById(Long id) {
        return userCourseRepository.findById(id).orElse(null);
    }

    public List<UserCourse> findByUserId(Long userId) {
        return userCourseRepository.findByUserProfileId(userId);
    }

    public List<UserCourse> findByCourseId(Long courseId) {
        return userCourseRepository.findByCourseId(courseId);
    }

    public UserCourse save(UserCourse userCourse) {

        // 1. Manejo de Course: Prevenir NPE y cargar referencia.
        if (userCourse.getCourse() == null || userCourse.getCourse().getId() == null) {
            // Si el cliente no envió la referencia necesaria
            throw new IllegalArgumentException("Course ID must be provided to save UserCourse.");
        }

        // Usar getReferenceById es el patrón más eficiente para establecer una FK 
        // cuando solo se tiene el ID de una entidad existente.
        Long courseId = userCourse.getCourse().getId();
        Course courseReference = courseRepository.getReferenceById(courseId);

        // Se inyecta la referencia gestionada por Hibernate
        userCourse.setCourse(courseReference);

        // 2. Manejo de UserProfile: Prevenir NPE y cargar referencia.
        if (userCourse.getUserProfile() == null || userCourse.getUserProfile().getId() == null) {
            throw new IllegalArgumentException("UserProfile ID must be provided to save UserCourse.");
        }

        Long profileId = userCourse.getUserProfile().getId();
        UserProfile userProfileReference = userProfileRepository.getReferenceById(profileId);

        // Se inyecta la referencia gestionada por Hibernate
        userCourse.setUserProfile(userProfileReference);

        // 3. Persistir UserCourse
        return userCourseRepository.save(userCourse);
    }

    public void delete(UserCourse userCourse) {
        userCourseRepository.delete(userCourse);
    }
}
