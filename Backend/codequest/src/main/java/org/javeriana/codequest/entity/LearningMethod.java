package org.javeriana.codequest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "learning_methods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LearningMethod {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String icon;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false, length = 1000)
    private String description;
}
