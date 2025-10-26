package org.javeriana.codequest.controller.entity;

import java.util.List;
import java.util.Map;

import org.javeriana.codequest.entity.Course;
import org.javeriana.codequest.service.entity.CourseService;
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

    @PostMapping("/save")
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @PutMapping("/update/{id}")
    public Course update(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
        Course existing = courseService.findById(id);
        if (existing == null) {
            throw new RuntimeException("Course not found with id " + id);
        }

        // Actualizar manualmente campos simples
        if (updates.containsKey("title")) {
            existing.setTitle((String) updates.get("title"));
        }
        if (updates.containsKey("description")) {
            existing.setDescription((String) updates.get("description"));
        }
        if (updates.containsKey("price")) {
            existing.setPrice((String) updates.get("price"));
        }
        if (updates.containsKey("originalPrice")) {
            existing.setOriginalPrice((String) updates.get("originalPrice"));
        }
        if (updates.containsKey("category")) {
            existing.setCategory((String) updates.get("category"));
        }
        if (updates.containsKey("level")) {
            existing.setLevel((String) updates.get("level"));
        }
        if (updates.containsKey("difficulty")) {
            existing.setDifficulty((String) updates.get("difficulty"));
        }
        if (updates.containsKey("totalPoints")) {
            existing.setTotalPoints((Integer) updates.get("totalPoints"));
        }

        courseService.save(existing);
        return existing;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        Course course = courseService.findById(id);
        courseService.delete(course);
    }
}
