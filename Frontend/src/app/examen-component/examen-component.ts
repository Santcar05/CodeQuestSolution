import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Question } from '../models/Question';
import { ExamResults } from '../models/ExamResults';

@Component({
  selector: 'app-examen',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarComponent],
  templateUrl: './examen-component.html',
  styleUrls: ['./examen-component.css'],
})
export class ExamenComponent implements OnInit {
  // Exam State
  currentQuestionIndex: number = 0;
  examStarted: boolean = false;
  examFinished: boolean = false;
  timeRemaining: number = 1800; // 30 minutes in seconds
  timerInterval: any;

  // Questions Data
  questions: Question[] = [
    {
      id: 1,
      type: 'teorica',
      text: '¿Cuál es la diferencia principal entre "let" y "var" en JavaScript?',
      options: [
        'let tiene scope de bloque, var tiene scope de función',
        'let es más rápido que var',
        'var es más moderno que let',
        'No hay diferencia, son sinónimos',
      ],
      correctAnswer: 0,
      flagged: false,
      explanation:
        'let tiene scope de bloque, lo que significa que solo está disponible dentro del bloque donde se declara, mientras que var tiene scope de función.',
    },
    {
      id: 2,
      type: 'teorica',
      text: '¿Qué método se utiliza para agregar un elemento al final de un array en JavaScript?',
      options: ['array.push()', 'array.pop()', 'array.shift()', 'array.unshift()'],
      correctAnswer: 0,
      flagged: false,
      explanation:
        'El método push() agrega uno o más elementos al final de un array y devuelve la nueva longitud del array.',
    },
    {
      id: 3,
      type: 'teorica',
      text: 'En React, ¿qué hook se utiliza para manejar el estado en componentes funcionales?',
      options: ['useState', 'useEffect', 'useContext', 'useReducer'],
      correctAnswer: 0,
      flagged: false,
      explanation:
        'El hook useState permite agregar estado local a componentes funcionales en React.',
    },
    {
      id: 4,
      type: 'teorica',
      text: '¿Cuál es el propósito principal de las Promises en JavaScript?',
      options: [
        'Manejar operaciones asíncronas',
        'Declarar variables constantes',
        'Crear bucles infinitos',
        'Optimizar el rendimiento',
      ],
      correctAnswer: 0,
      flagged: false,
      explanation:
        'Las Promises se utilizan para manejar operaciones asíncronas, permitiendo un código más limpio y manejable que los callbacks anidados.',
    },
    {
      id: 5,
      type: 'teorica',
      text: '¿Qué significa CSS?',
      options: [
        'Cascading Style Sheets',
        'Computer Style Sheets',
        'Creative Style System',
        'Coded Style Syntax',
      ],
      correctAnswer: 0,
      flagged: false,
      explanation: 'CSS significa Cascading Style Sheets (Hojas de Estilo en Cascada).',
    },
    {
      id: 6,
      type: 'teorica',
      text: 'En Angular, ¿qué decorador se utiliza para definir un componente?',
      options: ['@Component', '@NgModule', '@Injectable', '@Directive'],
      correctAnswer: 0,
      flagged: false,
      explanation:
        'El decorador @Component se utiliza para definir una clase como componente Angular y proporcionar metadatos de configuración.',
    },
    {
      id: 7,
      type: 'teorica',
      text: '¿Qué es el Virtual DOM en React?',
      options: [
        'Una representación en memoria del DOM real',
        'Un DOM más rápido y optimizado',
        'Una extensión del navegador',
        'Un tipo de base de datos',
      ],
      correctAnswer: 0,
      flagged: false,
      explanation:
        'El Virtual DOM es una representación ligera en memoria del DOM real que React utiliza para optimizar las actualizaciones.',
    },
    {
      id: 8,
      type: 'teorica',
      text: '¿Cuál es la diferencia entre == y === en JavaScript?',
      options: [
        '== compara valor, === compara valor y tipo',
        '== compara tipo, === compara valor',
        '== es más estricto que ===',
        'No hay diferencia',
      ],
      correctAnswer: 0,
      flagged: false,
      explanation:
        '== realiza conversión de tipo antes de la comparación (coerción), mientras que === compara tanto el valor como el tipo sin conversión.',
    },
    {
      id: 9,
      type: 'practica',
      text: 'Escribe una función en JavaScript que reciba un array de números y devuelva la suma de todos los números pares.',
      correctAnswer:
        'function sumarPares(numeros) {\n  return numeros.filter(n => n % 2 === 0).reduce((sum, num) => sum + num, 0);\n}',
      codeTemplate: 'function sumarPares(numeros) {\n  // Tu código aquí\n}',
      flagged: false,
      explanation:
        'La función filtra los números pares y luego usa reduce para sumarlos. El valor inicial 0 asegura que funcione con arrays vacíos.',
    },
  ];

  userCode: string = '';
  examResults?: ExamResults;

  constructor(private router: Router) {}

  ngOnInit() {
    this.initializeExam();
  }

  initializeExam() {
    this.currentQuestionIndex = 0;
    this.examStarted = false;
    this.examFinished = false;
    this.timeRemaining = 1800;
    this.userCode = this.questions[8].codeTemplate || '';
  }

  startExam() {
    this.examStarted = true;
    this.startTimer();
  }

  startTimer() {
    this.timerInterval = setInterval(() => {
      this.timeRemaining--;

      if (this.timeRemaining <= 0) {
        this.finishExam();
      }
    }, 1000);
  }

  get currentQuestion(): Question {
    return this.questions[this.currentQuestionIndex];
  }

  get progressPercentage(): number {
    return ((this.currentQuestionIndex + 1) / this.questions.length) * 100;
  }

  get answeredQuestions(): number {
    return this.questions.filter((q) => q.userAnswer !== undefined).length;
  }

  get formattedTime(): string {
    const minutes = Math.floor(this.timeRemaining / 60);
    const seconds = this.timeRemaining % 60;
    return `${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
  }

  get isTimeWarning(): boolean {
    return this.timeRemaining < 300; // 5 minutes
  }

  selectAnswer(questionIndex: number, answerIndex: number) {
    this.questions[questionIndex].userAnswer = answerIndex;
  }

  toggleFlag() {
    this.questions[this.currentQuestionIndex].flagged =
      !this.questions[this.currentQuestionIndex].flagged;
  }

  nextQuestion() {
    if (this.currentQuestionIndex < this.questions.length - 1) {
      this.currentQuestionIndex++;
      if (this.currentQuestion.type === 'practica') {
        this.userCode = this.currentQuestion.codeTemplate || '';
      }
    }
  }

  previousQuestion() {
    if (this.currentQuestionIndex > 0) {
      this.currentQuestionIndex--;
      if (this.currentQuestion.type === 'practica') {
        this.userCode = this.currentQuestion.codeTemplate || '';
      }
    }
  }

  goToQuestion(index: number) {
    this.currentQuestionIndex = index;
    if (this.currentQuestion.type === 'practica') {
      this.userCode = this.currentQuestion.codeTemplate || '';
    }
  }

  runCode() {
    // En un entorno real, aquí se ejecutaría el código del usuario
    console.log('Ejecutando código:', this.userCode);

    // Simulación de ejecución
    try {
      // Evaluar el código (en producción usaría un sandbox seguro)
      const result = 'Código ejecutado correctamente';
      alert('✅ ' + result);
    } catch (error) {
      alert('❌ Error en la ejecución: ' + error);
    }
  }

  resetCode() {
    this.userCode = this.currentQuestion.codeTemplate || '';
  }

  finishExam() {
    clearInterval(this.timerInterval);
    this.calculateResults();
    this.examFinished = true;
  }

  calculateResults() {
    const details = this.questions.map((question) => {
      let userAnswer = '';
      let correctAnswer = '';
      let correct = false;

      if (question.type === 'teorica') {
        userAnswer = question.options?.[question.userAnswer as number] || 'Sin responder';
        correctAnswer = question.options?.[question.correctAnswer as number] || '';
        correct = question.userAnswer === question.correctAnswer;
      } else {
        userAnswer = this.userCode;
        correctAnswer = question.correctAnswer as string;
        // En un entorno real, aquí se compararía la funcionalidad del código
        correct = this.userCode.includes('filter') && this.userCode.includes('reduce');
      }

      return {
        questionId: question.id,
        correct,
        userAnswer,
        correctAnswer,
        explanation: question.explanation || '',
      };
    });

    const correctAnswers = details.filter((d) => d.correct).length;
    const score = Math.round((correctAnswers / this.questions.length) * 100);

    this.examResults = {
      score,
      totalQuestions: this.questions.length,
      correctAnswers,
      timeSpent: this.formatTimeSpent(1800 - this.timeRemaining),
      passed: score >= 70,
      details,
    };
  }

  formatTimeSpent(seconds: number): string {
    const minutes = Math.floor(seconds / 60);
    const remainingSeconds = seconds % 60;
    return `${minutes}m ${remainingSeconds}s`;
  }

  restartExam() {
    this.initializeExam();
    this.questions.forEach((q) => {
      q.userAnswer = undefined;
      q.flagged = false;
    });
  }

  getQuestionStatus(index: number): string {
    const question = this.questions[index];
    if (index === this.currentQuestionIndex) return 'current';
    if (question.userAnswer !== undefined) return 'answered';
    if (question.flagged) return 'flagged';
    return '';
  }

  getRingRotation(): number {
    return (this.progressPercentage / 100) * 360 - 45;
  }

  ngOnDestroy() {
    if (this.timerInterval) {
      clearInterval(this.timerInterval);
    }
  }

  getBackCourses() {
    this.router.navigate(['/catalogo-cursos']);
  }
}
