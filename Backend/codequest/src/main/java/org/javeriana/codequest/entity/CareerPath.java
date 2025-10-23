package org.javeriana.codequest.entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "career_paths")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CareerPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String subtitle;

    @Column(nullable = false, length = 2000)
    private String description;

    private String icon;

    private String role;

    private String level;

    @Column(name = "total_xp")
    private Integer totalXP;

    @Column(name = "current_xp")
    private Integer currentXP;

    @Column(name = "required_xp")
    private Integer requiredXP;

    @Column(name = "salary_range")
    private String salaryRange;

    private Boolean selected = false;

    @ElementCollection
    @CollectionTable(name = "career_path_opportunities", joinColumns = @JoinColumn(name = "career_path_id"))
    @Column(name = "opportunity")
    private List<String> opportunities;

    @ElementCollection
    @CollectionTable(name = "career_path_technologies", joinColumns = @JoinColumn(name = "career_path_id"))
    @Column(name = "technology")
    private List<String> technologies;

    @OneToMany(mappedBy = "careerPath", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RoadmapItem> roadmap;

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;

    // Constructors
    public CareerPath() {
    }

    public CareerPath(String title, String description) {
        this.title = title;
        this.description = description;
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getTotalXP() {
        return totalXP;
    }

    public void setTotalXP(Integer totalXP) {
        this.totalXP = totalXP;
    }

    public Integer getCurrentXP() {
        return currentXP;
    }

    public void setCurrentXP(Integer currentXP) {
        this.currentXP = currentXP;
    }

    public Integer getRequiredXP() {
        return requiredXP;
    }

    public void setRequiredXP(Integer requiredXP) {
        this.requiredXP = requiredXP;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public List<String> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<String> opportunities) {
        this.opportunities = opportunities;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public List<RoadmapItem> getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(List<RoadmapItem> roadmap) {
        this.roadmap = roadmap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CareerPath)) {
            return false;
        }
        CareerPath that = (CareerPath) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
