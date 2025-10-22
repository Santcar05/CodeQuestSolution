import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { QuestionForm } from '../models/QuestionForm';
import { OptionFormService } from '../service/OptionForm/option-form-service';
import { QuestionFormService } from '../service/QuestionForm/question-form-service';

interface LearningStyle {
  name: string;
  description: string;
  characteristics: string[];
}

@Component({
  selector: 'app-formulario-inicial',
  standalone: true,
  imports: [CommonModule, SidebarComponent],
  templateUrl: './formulario-inicial-component.html',
  styleUrls: ['./formulario-inicial-component.css'],
})
export class FormularioInicialComponent implements OnInit {
  currentQuestionIndex: number = 0;
  questions: QuestionForm[] = [];
  isCompleted: boolean = false;
  userLearningStyle: LearningStyle | null = null;
  loading: boolean = true;

  constructor(private router: Router, private questionFormService: QuestionFormService) {}

  ngOnInit() {
    this.loadQuestions();
  }

  loadQuestions() {
    this.questionFormService.findAll().subscribe({
      next: (data) => {
        this.questions = data.map((q) => ({
          ...q,
          answer: '',
          selectedOption: null,
        }));
        this.loading = false;
      },
      error: (err) => {
        console.error('Error cargando preguntas:', err);
        this.loading = false;
      },
    });
  }

  get currentQuestion(): QuestionForm {
    return this.questions[this.currentQuestionIndex];
  }

  get progress(): number {
    if (!this.questions || this.questions.length === 0) return 0;
    return ((this.currentQuestionIndex + 1) / this.questions.length) * 100;
  }

  get progressText(): string {
    return `${this.currentQuestionIndex + 1} de ${this.questions.length}`;
  }

  selectOption(questionIndex: number, optionId: number) {
    const question = this.questions[questionIndex];
    question.selectedOption = optionId;

    const selectedOption = question.options.find((opt) => opt.id === optionId);
    if (selectedOption) {
      question.answer = selectedOption.title;
    }
  }

  nextQuestion() {
    if (this.currentQuestionIndex < this.questions.length - 1) {
      this.currentQuestionIndex++;
    }
  }

  previousQuestion() {
    if (this.currentQuestionIndex > 0) {
      this.currentQuestionIndex--;
    }
  }

  canProceed(): boolean {
    return this.currentQuestion?.selectedOption !== null;
  }

  isLastQuestion(): boolean {
    return this.currentQuestionIndex === this.questions.length - 1;
  }

  submitForm() {
    if (this.allQuestionsAnswered()) {
      this.calculateLearningStyle();
      this.isCompleted = true;
      localStorage.setItem('firstTimeUser', 'false');
      localStorage.setItem('userLearningStyle', JSON.stringify(this.userLearningStyle));
    }
  }

  allQuestionsAnswered(): boolean {
    return this.questions.every((q) => q.selectedOption !== null);
  }

  calculateLearningStyle() {
    const styleCount: { [key: string]: number } = {};

    this.questions.forEach((question) => {
      const selectedOption = question.options.find((opt) => opt.id === question.selectedOption);
      if (selectedOption) {
        styleCount[selectedOption.learningStyle] =
          (styleCount[selectedOption.learningStyle] || 0) + 1;
      }
    });

    const dominantStyle = Object.keys(styleCount).reduce((a, b) =>
      styleCount[a] > styleCount[b] ? a : b
    );

    this.userLearningStyle = this.getLearningStyleDetails(dominantStyle);
  }

  getLearningStyleDetails(style: string): LearningStyle {
    const styles: { [key: string]: LearningStyle } = {
      Visual: {
        name: 'Aprendiz Visual',
        description: 'Aprendes mejor a través de imágenes, diagramas y representaciones visuales.',
        characteristics: ['Usas colores', 'Prefieres mapas mentales', 'Recuerdas lo que ves'],
      },
      Auditivo: {
        name: 'Aprendiz Auditivo',
        description: 'Aprendes mejor mediante el sonido y las explicaciones verbales.',
        characteristics: ['Prefieres hablar o escuchar', 'Aprendes con podcasts o clases'],
      },
      Kinestésico: {
        name: 'Aprendiz Kinestésico',
        description: 'Aprendes mejor haciendo y experimentando.',
        characteristics: ['Aprendes practicando', 'Prefieres moverte o usar las manos'],
      },
      Lectura: {
        name: 'Aprendiz de Lectura/Escritura',
        description: 'Aprendes mejor leyendo o escribiendo.',
        characteristics: ['Prefieres apuntes', 'Aprendes con texto estructurado'],
      },
    };

    return (
      styles[style] || {
        name: 'Aprendiz Multimodal',
        description: 'Tienes varios estilos de aprendizaje.',
        characteristics: ['Aprendes con varios métodos', 'Eres adaptable'],
      }
    );
  }

  goToCourses() {
    this.router.navigate(['/inicio']);
  }
}
