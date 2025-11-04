package org.javeriana.codequest.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Se mantiene ManyToOne como EAGER por defecto o explícito si siempre se necesita
    // Se usa @JsonIgnoreProperties para cortar el ciclo de serialización
    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    @JsonBackReference("user-usercourse")
    private UserProfile userProfile;

    // Se usa @JsonIgnoreProperties para cortar el ciclo de serialización
    @ManyToOne(fetch = FetchType.EAGER) // Se mantiene EAGER, si se necesita el Course al cargar UserCourse
    @JoinColumn(name = "course_id")
    @JsonBackReference("course-usercourse")
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseStatus status;

    @Column(name = "completed_lessons")
    private Integer completedLessons;

    @Column(name = "next_lesson")
    private String nextLesson;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "last_accessed")
    private LocalDateTime lastAccessed;

    @Column(name = "progress_percentage")
    private Double progressPercentage;

    @Column(name = "current_module")
    private String currentModule;

    @Column(name = "current_lesson")
    private String currentLesson;

    private Integer rating;

    @Column(name = "is_favorite")
    private Boolean isFavorite;

    @Column(name = "notes", length = 2000)
    private String notes;

    public enum CourseStatus {
        COMPLETED, IN_PROGRESS, NOT_STARTED, PAUSED
    }
}
