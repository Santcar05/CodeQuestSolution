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
@Table(name = "menu_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {

    @Id
    private String id;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private String icon;

    @Column(nullable = false)
    private String path;

    private Integer badge;

    @Column(name = "is_new")
    private Boolean isNew;
}
