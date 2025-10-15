import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { SidebarComponent } from '../sidebar-component/sidebar-component';

interface Question {
  id: number;
  title: string;
  options: Option[];
  selectedOption: number | null;
}

interface Option {
  id: number;
  title: string;
  description: string;
  icon: string;
  learningStyle: string;
}

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
  questions: Question[] = [];
  isCompleted: boolean = false;
  userLearningStyle: LearningStyle | null = null;

  constructor(private router: Router) {}

  ngOnInit() {
    this.initializeQuestions();
  }

  initializeQuestions() {
    this.questions = [
      {
        id: 1,
        title: 'Cuando aprendes algo nuevo, ¿qué método prefieres?',
        options: [
          {
            id: 1,
            title: 'Ver demostraciones',
            description: 'Prefiero ver cómo se hace antes de intentarlo yo mismo',
            icon: '👀',
            learningStyle: 'Visual',
          },
          {
            id: 2,
            title: 'Leer instrucciones',
            description: 'Me gusta leer y entender la teoría primero',
            icon: '📖',
            learningStyle: 'Lectura',
          },
          {
            id: 3,
            title: 'Practicar directamente',
            description: 'Aprendo mejor haciendo y experimentando',
            icon: '🔧',
            learningStyle: 'Kinestésico',
          },
          {
            id: 4,
            title: 'Escuchar explicaciones',
            description: 'Prefiero que me expliquen verbalmente',
            icon: '🎧',
            learningStyle: 'Auditivo',
          },
        ],
        selectedOption: null,
      },
      {
        id: 2,
        title: '¿Cómo organizas tu tiempo de estudio?',
        options: [
          {
            id: 1,
            title: 'Horarios fijos',
            description: 'Prefiero estudiar a la misma hora todos los días',
            icon: '⏰',
            learningStyle: 'Estructurado',
          },
          {
            id: 2,
            title: 'Cuando tengo inspiración',
            description: 'Estudio cuando me siento motivado y concentrado',
            icon: '💡',
            learningStyle: 'Flexible',
          },
          {
            id: 3,
            title: 'Por objetivos',
            description: 'Planifico en base a metas específicas a alcanzar',
            icon: '🎯',
            learningStyle: 'Orientado a metas',
          },
          {
            id: 4,
            title: 'Intensivo',
            description: 'Prefiero sesiones largas y profundas',
            icon: '⚡',
            learningStyle: 'Inmersivo',
          },
        ],
        selectedOption: null,
      },
      {
        id: 3,
        title: '¿Qué tipo de material te resulta más útil?',
        options: [
          {
            id: 1,
            title: 'Diagramas y mapas mentales',
            description: 'Me ayudan a ver las conexiones entre conceptos',
            icon: '🗺️',
            learningStyle: 'Visual',
          },
          {
            id: 2,
            title: 'Textos y apuntes',
            description: 'Prefiero material escrito detallado',
            icon: '📝',
            learningStyle: 'Lectura',
          },
          {
            id: 3,
            title: 'Ejercicios prácticos',
            description: 'Aprendo resolviendo problemas reales',
            icon: '🧩',
            learningStyle: 'Kinestésico',
          },
          {
            id: 4,
            title: 'Podcasts y audios',
            description: 'Puedo aprender mientras hago otras actividades',
            icon: '🎙️',
            learningStyle: 'Auditivo',
          },
        ],
        selectedOption: null,
      },
      {
        id: 4,
        title: '¿Cómo prefieres recibir feedback?',
        options: [
          {
            id: 1,
            title: 'Ver ejemplos corregidos',
            description: 'Comparar mi trabajo con soluciones modelo',
            icon: '👁️',
            learningStyle: 'Visual',
          },
          {
            id: 2,
            title: 'Comentarios escritos',
            description: 'Prefiero feedback detallado por escrito',
            icon: '✍️',
            learningStyle: 'Lectura',
          },
          {
            id: 3,
            title: 'Práctica guiada',
            description: 'Que me muestren cómo mejorar en el momento',
            icon: '🤝',
            learningStyle: 'Kinestésico',
          },
          {
            id: 4,
            title: 'Conversaciones',
            description: 'Discutir mis progresos verbalmente',
            icon: '💬',
            learningStyle: 'Auditivo',
          },
        ],
        selectedOption: null,
      },
      {
        id: 5,
        title: '¿Qué ambiente te ayuda más a concentrarte?',
        options: [
          {
            id: 1,
            title: 'Espacio ordenado y visual',
            description: 'Me concentro mejor en ambientes organizados',
            icon: '🧹',
            learningStyle: 'Visual',
          },
          {
            id: 2,
            title: 'Silencio absoluto',
            description: 'Necesito eliminar distracciones auditivas',
            icon: '🤫',
            learningStyle: 'Lectura',
          },
          {
            id: 3,
            title: 'Poder moverme',
            description: 'Me ayuda cambiar de postura o lugar',
            icon: '🚶',
            learningStyle: 'Kinestésico',
          },
          {
            id: 4,
            title: 'Música de fondo',
            description: 'El sonido ambiental me ayuda a concentrarme',
            icon: '🎵',
            learningStyle: 'Auditivo',
          },
        ],
        selectedOption: null,
      },
      {
        id: 6,
        title: '¿Cómo abordas un tema complejo?',
        options: [
          {
            id: 1,
            title: 'Dividiendo en partes',
            description: 'Desgloso el problema en componentes más pequeños',
            icon: '🧩',
            learningStyle: 'Analítico',
          },
          {
            id: 2,
            title: 'Buscando el panorama general',
            description: 'Primero entiendo el concepto global',
            icon: '🌅',
            learningStyle: 'Global',
          },
          {
            id: 3,
            title: 'Probando con ejemplos',
            description: 'Experimentando con casos prácticos',
            icon: '🔍',
            learningStyle: 'Experimental',
          },
          {
            id: 4,
            title: 'Preguntando a otros',
            description: 'Discutiendo el tema con compañeros',
            icon: '👥',
            learningStyle: 'Social',
          },
        ],
        selectedOption: null,
      },
      {
        id: 7,
        title: '¿Qué tipo de proyectos disfrutas más?',
        options: [
          {
            id: 1,
            title: 'Diseño visual',
            description: 'Crear interfaces y experiencias visuales',
            icon: '🎨',
            learningStyle: 'Visual',
          },
          {
            id: 2,
            title: 'Investigación teórica',
            description: 'Profundizar en conceptos y teorías',
            icon: '🔬',
            learningStyle: 'Lectura',
          },
          {
            id: 3,
            title: 'Construcción manual',
            description: 'Armar cosas con las manos o código',
            icon: '🛠️',
            learningStyle: 'Kinestésico',
          },
          {
            id: 4,
            title: 'Presentaciones orales',
            description: 'Explicar ideas verbalmente',
            icon: '🎤',
            learningStyle: 'Auditivo',
          },
        ],
        selectedOption: null,
      },
      {
        id: 8,
        title: '¿Cómo tomas apuntes?',
        options: [
          {
            id: 1,
            title: 'Con colores y dibujos',
            description: 'Uso elementos visuales para organizar ideas',
            icon: '🖍️',
            learningStyle: 'Visual',
          },
          {
            id: 2,
            title: 'Texto estructurado',
            description: 'Listas y párrafos organizados',
            icon: '📑',
            learningStyle: 'Lectura',
          },
          {
            id: 3,
            title: 'Notas breves',
            description: 'Apunto solo lo esencial y práctico',
            icon: '📌',
            learningStyle: 'Kinestésico',
          },
          {
            id: 4,
            title: 'Grabaciones',
            description: 'Prefiero grabar y escuchar después',
            icon: '🎙️',
            learningStyle: 'Auditivo',
          },
        ],
        selectedOption: null,
      },
      {
        id: 9,
        title: '¿Cómo manejas los errores al aprender?',
        options: [
          {
            id: 1,
            title: 'Analizando visualmente',
            description: 'Reviso dónde me equivoqué paso a paso',
            icon: '🔎',
            learningStyle: 'Visual',
          },
          {
            id: 2,
            title: 'Buscando en documentación',
            description: 'Consulto fuentes escritas para entender',
            icon: '📚',
            learningStyle: 'Lectura',
          },
          {
            id: 3,
            title: 'Intentando de nuevo',
            description: 'Práctico hasta que sale bien',
            icon: '🔄',
            learningStyle: 'Kinestésico',
          },
          {
            id: 4,
            title: 'Pidiendo explicación',
            description: 'Pregunto a alguien que me lo explique',
            icon: '❓',
            learningStyle: 'Auditivo',
          },
        ],
        selectedOption: null,
      },
      {
        id: 10,
        title: '¿Qué te motiva a seguir aprendiendo?',
        options: [
          {
            id: 1,
            title: 'Ver progreso visual',
            description: 'Gráficos y métricas de mi avance',
            icon: '📊',
            learningStyle: 'Visual',
          },
          {
            id: 2,
            title: 'Lograr certificaciones',
            description: 'Obtener reconocimientos formales',
            icon: '🏆',
            learningStyle: 'Lectura',
          },
          {
            id: 3,
            title: 'Resolver problemas reales',
            description: 'Aplicar lo aprendido en proyectos',
            icon: '💼',
            learningStyle: 'Kinestésico',
          },
          {
            id: 4,
            title: 'Compartir conocimiento',
            description: 'Enseñar a otros lo que he aprendido',
            icon: '🗣️',
            learningStyle: 'Auditivo',
          },
        ],
        selectedOption: null,
      },
    ];
  }

  get currentQuestion(): Question {
    return this.questions[this.currentQuestionIndex];
  }

  get progress(): number {
    return ((this.currentQuestionIndex + 1) / this.questions.length) * 100;
  }

  get progressText(): string {
    return `${this.currentQuestionIndex + 1} de ${this.questions.length}`;
  }

  selectOption(questionIndex: number, optionId: number) {
    this.questions[questionIndex].selectedOption = optionId;
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
    return this.currentQuestion.selectedOption !== null;
  }

  isLastQuestion(): boolean {
    return this.currentQuestionIndex === this.questions.length - 1;
  }

  submitForm() {
    if (this.allQuestionsAnswered()) {
      this.calculateLearningStyle();
      this.isCompleted = true;
      // Guardar en localStorage que el usuario ya completó el formulario
      localStorage.setItem('firstTimeUser', 'false');
      localStorage.setItem('userLearningStyle', JSON.stringify(this.userLearningStyle));
    }
  }

  allQuestionsAnswered(): boolean {
    return this.questions.every((question) => question.selectedOption !== null);
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
        description:
          'Aprendes mejor a través de imágenes, diagramas y representaciones visuales. Prefieres ver demostraciones y utilizar colores, mapas mentales y elementos gráficos para organizar la información.',
        characteristics: [
          'Prefieres ver información en gráficos y diagramas',
          'Recuerdas mejor lo que ves que lo que escuchas',
          'Te beneficias de videos y demostraciones',
          'Organizas ideas con colores y elementos visuales',
        ],
      },
      Auditivo: {
        name: 'Aprendiz Auditivo',
        description:
          'Aprendes mejor a través del sonido y la discusión verbal. Prefieres explicaciones habladas, discusiones en grupo y materiales auditivos como podcasts.',
        characteristics: [
          'Aprendes mejor mediante explicaciones verbales',
          'Prefieres discutir ideas con otros',
          'Recuerdas información a través de rimas o canciones',
          'Te beneficias de grabaciones y podcasts',
        ],
      },
      Kinestésico: {
        name: 'Aprendiz Kinestésico',
        description:
          'Aprendes mejor haciendo y experimentando. Prefieres la práctica directa, los proyectos hands-on y aprender mediante la experiencia tangible.',
        characteristics: [
          'Aprendes mejor mediante la práctica directa',
          'Prefieres aprender haciendo en lugar de observar',
          'Te beneficias de ejercicios prácticos y proyectos',
          'Recuerdas mejor lo que haces que lo que lees o escuchas',
        ],
      },
      Lectura: {
        name: 'Aprendiz de Lectura/Escritura',
        description:
          'Aprendes mejor a través de textos escritos. Prefieres leer instrucciones, tomar apuntes detallados y aprender mediante materiales escritos.',
        characteristics: [
          'Prefieres aprender mediante lectura',
          'Tomas apuntes detallados y organizados',
          'Te beneficias de manuales y documentación',
          'Expresas mejor tus ideas por escrito',
        ],
      },
    };

    return styles[style] || styles['Visual'];
  }

  goToCourses() {
    this.router.navigate(['/inicio']);
  }
}
