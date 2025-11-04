package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.UserCourse;
import org.javeriana.codequest.service.entity.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping("/api/usercourse")
@CrossOrigin(origins = "http://localhost:4200")
public class UserCourseController {

    @Autowired
    private UserCourseService userCourseService;

    @GetMapping("/all")
    public List<UserCourse> getAllUserCourses() {
        return userCourseService.findAll();
    }

    @GetMapping("/{id}")
    public UserCourse getUserCourseById(@PathVariable Long id) {
        return userCourseService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserCourse> getUserCoursesByUserId(@PathVariable Long userId) {
        return userCourseService.findByUserId(userId);
    }

    @GetMapping("/course/{courseId}")
    public List<UserCourse> getUserCoursesByCourseId(@PathVariable Long courseId) {
        return userCourseService.findByCourseId(courseId);
    }

    //POST con JSON correctamente definido
    @PostMapping("/save")
    public UserCourse saveUserCourse(@RequestBody UserCourse userCourse) {
        System.out.println("📥 Recibiendo UserCourse: " + userCourse);
        return userCourseService.save(userCourse);
    }

    @PutMapping(
            value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserCourse updateUserCourse(@RequestBody UserCourse userCourse) {
        return userCourseService.save(userCourse);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserCourse(@PathVariable Long id) {
        UserCourse userCourse = userCourseService.findById(id);
        if (userCourse != null) {
            userCourseService.delete(userCourse);
        }
    }
}
