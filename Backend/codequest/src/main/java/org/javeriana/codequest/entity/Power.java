package org.javeriana.codequest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "powers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private Integer uses;

    @Column(nullable = false)
    private Boolean owned;

    @Column(name = "is_featured", nullable = false)
    private Boolean isFeatured;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String icon;

    @Column(name = "icon_size", nullable = false)
    private Integer iconSize;
}
