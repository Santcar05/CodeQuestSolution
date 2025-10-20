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
@Table(name = "code_explanations")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodeExplanation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "line_number", nullable = false)
    private Integer line;

    @Column(nullable = false, length = 1000)
    private String code;

    @Column(nullable = false, length = 2000)
    private String explanation;

    // Constructors
    public CodeExplanation() {
    }

    public CodeExplanation(Integer line, String code, String explanation) {
        this.line = line;
        this.code = code;
        this.explanation = explanation;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodeExplanation)) {
            return false;
        }
        CodeExplanation that = (CodeExplanation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
