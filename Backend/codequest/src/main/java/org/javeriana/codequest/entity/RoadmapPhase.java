package org.javeriana.codequest.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "roadmap_phases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoadmapPhase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String icon;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoadmapPhaseStatus status;

    @ElementCollection
    @CollectionTable(name = "roadmap_phase_objectives", joinColumns = @JoinColumn(name = "roadmap_phase_id"))
    @Column(name = "objective")
    private List<String> objectives;

    @Column(nullable = false)
    private Integer xp;

    @Column(nullable = false)
    private String duration;

    @ElementCollection
    @CollectionTable(name = "roadmap_phase_resources", joinColumns = @JoinColumn(name = "roadmap_phase_id"))
    @Column(name = "resource")
    private List<String> resources;

    public enum RoadmapPhaseStatus {
        COMPLETADO, ACTIVO, PENDIENTE
    }
}
