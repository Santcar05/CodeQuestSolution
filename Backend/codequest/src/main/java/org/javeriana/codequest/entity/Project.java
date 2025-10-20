package org.javeriana.codequest.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String subtitle;

    @Column(nullable = false, length = 4000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    @Column(nullable = false)
    private String duration;

    @Column(name = "total_xp", nullable = false)
    private Integer totalXP;

    @Column(name = "base_xp", nullable = false)
    private Integer baseXP;

    @Column(name = "bonus_xp", nullable = false)
    private Integer bonusXP;

    @Column(name = "ia_evaluation", nullable = false)
    private Boolean iaEvaluation;

    @Column(nullable = false)
    private Integer progress;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectStatus status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private List<Technology> technologies;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private List<RoadmapPhase> roadmap;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private List<Requirement> requirements;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private List<TestCase> testCases;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private List<Badge> badges;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private List<ResourceModel> resources;

    public enum ProjectType {
        GUIADO, LIBRE, COLABORATIVO, DESAFIO_IA, GUIDED, FREE, COLLABORATIVE
    }

    public enum Difficulty {
        PRINCIPIANTE, INTERMEDIO, AVANZADO, EXPERTO
    }

    public enum ProjectStatus {
        NO_INICIADO, EN_PROGRESO, COMPLETADO, COMPLETED, PLANNED
    }
}
