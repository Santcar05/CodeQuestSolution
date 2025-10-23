package org.javeriana.codequest.controller.entity;

import java.util.List;
import java.util.Map;

import org.javeriana.codequest.entity.Course;
import org.javeriana.codequest.service.entity.CourseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    //Cursos en la Wishlist
    @GetMapping("/wishlist")
    public List<Course> findWishlist() {
        //devolver los 3 primeros cursos (utilizar otra lógica para crear la wishlist)
        List<Course> all = courseService.findAll();
        return all.stream().limit(3).toList();
    }

    //Actividad semanal (mock de progreso)
    @GetMapping("/weekly-activity")
    public List<Map<String, Object>> findWeeklyActivity() {
        return List.of(
                Map.of("day", "L", "value", 3),
                Map.of("day", "M", "value", 5),
                Map.of("day", "X", "value", 2),
                Map.of("day", "J", "value", 4),
                Map.of("day", "V", "value", 6),
                Map.of("day", "S", "value", 1),
                Map.of("day", "D", "value", 4)
        );
    }

}
