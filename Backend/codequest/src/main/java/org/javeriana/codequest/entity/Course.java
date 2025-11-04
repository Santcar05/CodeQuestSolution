package org.javeriana.codequest.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType; // Se usa LAZY para colecciones
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 4000)
    private String description;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String level;

    private Double rating;

    private String duration;

    private Integer students;

    private Integer lessons;

    private String thumbnail;

    private String image;

    private String price;

    @Column(name = "original_price")
    private String originalPrice;

    private Integer xp;

    @Column(name = "is_new")
    private Boolean isNew;

    @Column(name = "is_trending")
    private Boolean isTrending;

    // ManyToOne con LAZY para optimización
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    @JsonIgnore
    private Instructor instructor;

    @ElementCollection
    @CollectionTable(name = "course_learning_points", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "learning_point")
    private List<String> learningPoints;

    @ElementCollection
    @CollectionTable(name = "course_requirements", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "requirement")
    private List<String> requirements;

    // Colecciones con FetchType.LAZY y @JsonIgnore para optimización y corte de ciclo
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ModuleModel> modules;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Review> reviewsList;

    @Column(name = "total_points", nullable = false)
    private Integer totalPoints;

    private String difficulty;

    // Colección con FetchType.LAZY (por defecto) y @JsonIgnore para corte de ciclo
    @ManyToMany
    @JoinTable(
            name = "course_prerequisites",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "prerequisite_id")
    )
    @JsonIgnore
    private List<Course> preRequisites;

    @ElementCollection
    @CollectionTable(name = "course_tags", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "tag")
    private List<String> tags;

    // Relación con UserCourses: Se mantiene FetchType.LAZY y @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserCourse> userCourses;
}
