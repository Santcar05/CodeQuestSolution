package org.javeriana.codequest.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "challenges")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(nullable = false)
    private String icon;

    @Column(nullable = false)
    private Integer xp;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Boolean completed = false;

    // Constructors
    public Challenge() {
    }

    public Challenge(String title, String description, String icon, Integer xp, String type, Boolean completed) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.xp = xp;
        this.type = type;
        this.completed = completed;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Challenge)) {
            return false;
        }
        Challenge challenge = (Challenge) o;
        return Objects.equals(id, challenge.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
