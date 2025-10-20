package org.javeriana.codequest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "requirements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequirementType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequirementStatus status;

    @Column(name = "course_id")
    private Long courseId;

    public enum RequirementType {
        CONOCIMIENTO, CURSO, HABILIDAD
    }

    public enum RequirementStatus {
        COMPLETADO, PENDIENTE, EN_PROGRESO
    }
}
