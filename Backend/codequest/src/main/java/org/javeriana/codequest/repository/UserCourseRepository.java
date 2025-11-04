package org.javeriana.codequest.repository;

import java.util.List;

import org.javeriana.codequest.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {

    public List<UserCourse> findByUserProfileId(Long userId);

    public List<UserCourse> findByCourseId(Long courseId);

}
