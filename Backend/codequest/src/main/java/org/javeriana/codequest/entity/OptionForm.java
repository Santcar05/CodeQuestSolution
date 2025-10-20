package org.javeriana.codequest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "option_forms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String icon;

    @Column(name = "learning_style", nullable = false)
    private String learningStyle;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "question_form_id", nullable = false)
    private QuestionForm questionForm;

}
