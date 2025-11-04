package org.javeriana.codequest.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private Integer xp;

    @Column(name = "max_xp", nullable = false)
    private Integer maxXp;

    @Column(nullable = false)
    private String rank;

    // Relación con UserCourses: CAMBIADO a FetchType.LAZY para mejor rendimiento
    @OneToMany(mappedBy = "userProfile", fetch = FetchType.LAZY)
    @JsonIgnore // Mantiene la solución al ciclo de serialización
    private List<UserCourse> userCourses;

    // Métodos helper para obtener cursos por estado (dependerán de que 'userCourses' esté inicializado)
    public List<UserCourse> getCoursesInProgress() {
        return userCourses == null ? List.of()
                : userCourses.stream()
                        .filter(uc -> uc.getStatus() == UserCourse.CourseStatus.IN_PROGRESS)
                        .toList();
    }

    public List<UserCourse> getCompletedCourses() {
        return userCourses == null ? List.of()
                : userCourses.stream()
                        .filter(uc -> uc.getStatus() == UserCourse.CourseStatus.COMPLETED)
                        .toList();
    }

    public List<UserCourse> getNotStartedCourses() {
        return userCourses == null ? List.of()
                : userCourses.stream()
                        .filter(uc -> uc.getStatus() == UserCourse.CourseStatus.NOT_STARTED)
                        .toList();
    }

    // Resto de las relaciones: CAMBIADO a FetchType.LAZY (por defecto) si no se especifica, pero se mantiene la estructura
    @OneToMany(mappedBy = "userProfile")
    @JsonIgnore
    private List<Project> projectsDone;

    @OneToMany(mappedBy = "userProfile")
    @JsonIgnore
    private List<Project> projectsInProgress;

    @OneToMany(mappedBy = "userProfile")
    @JsonIgnore
    private List<Review> reviews;

    @OneToMany(mappedBy = "userProfile")
    @JsonIgnore
    private List<CareerPath> carrerPathsDone;

    @OneToMany(mappedBy = "userProfile")
    @JsonIgnore
    private List<CareerPath> carrerPathsInProgress;

    @OneToMany(mappedBy = "userProfile")
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(mappedBy = "userProfile")
    @JsonIgnore
    private List<Badge> badges;

    @OneToMany(mappedBy = "userProfile")
    @JsonIgnore
    private List<Power> powers;
}
