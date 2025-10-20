package org.javeriana.codequest.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "modules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    private String duration;

    private Integer points;

    private Integer progress;

    private Boolean completed;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private List<Topic> topics;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}
