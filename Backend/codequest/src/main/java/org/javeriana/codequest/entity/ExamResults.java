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
@Table(name = "exam_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double score;

    @Column(name = "total_questions", nullable = false)
    private Integer totalQuestions;

    @Column(name = "correct_answers", nullable = false)
    private Integer correctAnswers;

    @Column(name = "time_spent", nullable = false)
    private String timeSpent;

    @Column(nullable = false)
    private Boolean passed;
    /* 
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_results_id")
    private List<ExamDetail> details;
     */
}
