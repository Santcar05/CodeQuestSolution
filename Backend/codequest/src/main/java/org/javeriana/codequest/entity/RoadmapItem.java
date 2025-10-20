package org.javeriana.codequest.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "roadmap_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoadmapItem {

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
    private RoadmapItemStatus status;

    private Integer courses;

    private Integer xp;

    private String duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "career_path_id")
    private CareerPath careerPath;

    public enum RoadmapItemStatus {
        COMPLETED, CURRENT, UPCOMING
    }
}
