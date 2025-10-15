import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { SidebarComponent } from '../sidebar-component/sidebar-component';

interface Project {
  id: number;
  title: string;
  subtitle: string;
  description: string;
  type: 'guiado' | 'libre' | 'colaborativo' | 'desafio-ia';
  difficulty: 'principiante' | 'intermedio' | 'avanzado' | 'experto';
  duration: string;
  totalXP: number;
  baseXP: number;
  bonusXP: number;
  iaEvaluation: boolean;
  progress: number;
  status: 'no-iniciado' | 'en-progreso' | 'completado';
}

interface Technology {
  name: string;
  icon: string;
  category: string;
  required: boolean;
}

interface Requirement {
  id: number;
  description: string;
  type: 'conocimiento' | 'curso' | 'habilidad';
  status: 'completado' | 'pendiente' | 'en-progreso';
  courseId?: number;
}

interface RoadmapPhase {
  id: number;
  title: string;
  description: string;
  icon: string;
  status: 'completado' | 'activo' | 'pendiente';
  objectives: string[];
  xp: number;
  duration: string;
  resources: string[];
}

interface Skill {
  name: string;
  level: number;
  category: 'tecnica' | 'blanda';
}

interface ChatMessage {
  id: number;
  text: string;
  isUser: boolean;
  timestamp: Date;
  type: 'sugerencia' | 'feedback' | 'pista' | 'evaluacion';
}

interface TestCase {
  id: number;
  title: string;
  description: string;
  status: 'pasado' | 'fallado' | 'no-ejecutado';
  type: 'automatico' | 'personalizado';
}

interface Badge {
  id: number;
  name: string;
  description: string;
  icon: string;
  earned: boolean;
  xp: number;
}

interface Resource {
  id: number;
  title: string;
  description: string;
  icon: string;
  type: 'documento' | 'video' | 'repositorio' | 'articulo';
  url: string;
}

@Component({
  selector: 'app-detalle-proyecto',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarComponent],
  templateUrl: './detalle-proyecto-component.html',
  styleUrls: ['./detalle-proyecto-component.css'],
})
export class DetalleProyectoComponent implements OnInit {
  project: Project = {
    id: 1,
    title: 'Plataforma de Reservas de Hotel',
    subtitle: 'Sistema completo de gestión de reservas con panel administrativo',
    description:
      'Desarrolla una aplicación web completa que permita a los usuarios buscar, comparar y reservar habitaciones de hotel. Incluye panel administrativo para gestión de propiedades, precios y reservas.',
    type: 'guiado',
    difficulty: 'intermedio',
    duration: '6-8 semanas',
    totalXP: 2500,
    baseXP: 2000,
    bonusXP: 500,
    iaEvaluation: true,
    progress: 35,
    status: 'en-progreso',
  };

  technologies: Technology[] = [
    { name: 'React', icon: '⚛️', category: 'Frontend', required: true },
    { name: 'Node.js', icon: '🟢', category: 'Backend', required: true },
    { name: 'MongoDB', icon: '🍃', category: 'Base de Datos', required: true },
    { name: 'Express', icon: '🚂', category: 'Backend', required: true },
    { name: 'JWT', icon: '🔐', category: 'Autenticación', required: true },
    { name: 'CSS3', icon: '🎨', category: 'Frontend', required: true },
    { name: 'Git', icon: '📚', category: 'Control Versiones', required: true },
    { name: 'Docker', icon: '🐳', category: 'DevOps', required: false },
  ];

  requirements: Requirement[] = [
    {
      id: 1,
      description: 'Fundamentos de JavaScript ES6+',
      type: 'conocimiento',
      status: 'completado',
    },
    { id: 2, description: 'Curso: React desde Cero', type: 'curso', status: 'completado' },
    { id: 3, description: 'Curso: Node.js y Express', type: 'curso', status: 'en-progreso' },
    { id: 4, description: 'Manejo de APIs REST', type: 'habilidad', status: 'completado' },
    { id: 5, description: 'Bases de datos NoSQL', type: 'conocimiento', status: 'pendiente' },
  ];

  roadmapPhases: RoadmapPhase[] = [
    {
      id: 1,
      title: 'Análisis y Diseño',
      description:
        'Define los requisitos del sistema, casos de uso y diseña la arquitectura de la aplicación.',
      icon: '🧩',
      status: 'completado',
      objectives: [
        'Definir modelos de datos principales',
        'Diseñar esquema de base de datos',
        'Planificar arquitectura frontend/backend',
        'Crear wireframes de interfaces',
      ],
      xp: 300,
      duration: '1 semana',
      resources: ['Plantilla de requisitos', 'Guía de arquitectura', 'Ejemplos de wireframes'],
    },
    {
      id: 2,
      title: 'Configuración del Entorno',
      description: 'Prepara el entorno de desarrollo y configura las herramientas necesarias.',
      icon: '⚙️',
      status: 'completado',
      objectives: [
        'Configurar proyecto React',
        'Inicializar servidor Express',
        'Conectar base de datos MongoDB',
        'Configurar herramientas de desarrollo',
      ],
      xp: 200,
      duration: '3 días',
      resources: ['Guía de configuración', 'Repositorio base', 'Configuración Docker'],
    },
    {
      id: 3,
      title: 'Implementación del Núcleo',
      description: 'Desarrolla las funcionalidades principales del sistema de reservas.',
      icon: '💻',
      status: 'activo',
      objectives: [
        'Implementar autenticación de usuarios',
        'Crear CRUD de hoteles y habitaciones',
        'Desarrollar sistema de búsqueda',
        'Implementar proceso de reserva',
      ],
      xp: 800,
      duration: '3 semanas',
      resources: ['Documentación API', 'Ejemplos de código', 'Guía de buenas prácticas'],
    },
    {
      id: 4,
      title: 'Integración y Optimización',
      description: 'Mejora la aplicación, maneja errores y optimiza el rendimiento.',
      icon: '🧠',
      status: 'pendiente',
      objectives: [
        'Implementar validaciones',
        'Optimizar consultas a BD',
        'Manejar errores y excepciones',
        'Mejorar experiencia de usuario',
      ],
      xp: 400,
      duration: '1 semana',
      resources: [
        'Guía de optimización',
        'Patrones de manejo de errores',
        'Herramientas de profiling',
      ],
    },
    {
      id: 5,
      title: 'Presentación Final',
      description: 'Prepara la entrega final, documenta el proyecto y realiza demostración.',
      icon: '🚀',
      status: 'pendiente',
      objectives: [
        'Documentar código y API',
        'Preparar presentación',
        'Realizar pruebas finales',
        'Desplegar aplicación',
      ],
      xp: 300,
      duration: '1 semana',
      resources: ['Plantilla de documentación', 'Guía de despliegue', 'Ejemplo de presentación'],
    },
  ];

  skills: Skill[] = [
    { name: 'Desarrollo Frontend', level: 75, category: 'tecnica' },
    { name: 'Desarrollo Backend', level: 60, category: 'tecnica' },
    { name: 'Bases de Datos', level: 50, category: 'tecnica' },
    { name: 'APIs REST', level: 70, category: 'tecnica' },
    { name: 'Autenticación', level: 65, category: 'tecnica' },
    { name: 'Resolución de Problemas', level: 80, category: 'blanda' },
    { name: 'Documentación', level: 70, category: 'blanda' },
    { name: 'Gestión de Tiempo', level: 75, category: 'blanda' },
  ];

  chatMessages: ChatMessage[] = [
    {
      id: 1,
      text: '¡Hola! Soy tu asistente IA para este proyecto. Veo que estás en la fase de implementación del núcleo. ¿En qué puedo ayudarte?',
      isUser: false,
      timestamp: new Date(),
      type: 'sugerencia',
    },
    {
      id: 2,
      text: 'Tengo dudas sobre cómo implementar la autenticación JWT en el backend.',
      isUser: true,
      timestamp: new Date(),
      type: 'pista',
    },
    {
      id: 3,
      text: 'Te recomiendo revisar la guía de autenticación en la sección de recursos. ¿Quieres que te muestre un ejemplo de implementación?',
      isUser: false,
      timestamp: new Date(),
      type: 'feedback',
    },
  ];

  testCases: TestCase[] = [
    {
      id: 1,
      title: 'Autenticación de Usuario',
      description: 'Usuario puede registrarse e iniciar sesión',
      status: 'pasado',
      type: 'automatico',
    },
    {
      id: 2,
      title: 'CRUD de Hoteles',
      description: 'Crear, leer, actualizar y eliminar hoteles',
      status: 'pasado',
      type: 'automatico',
    },
    {
      id: 3,
      title: 'Sistema de Búsqueda',
      description: 'Búsqueda con filtros por ubicación y fechas',
      status: 'fallado',
      type: 'automatico',
    },
    {
      id: 4,
      title: 'Proceso de Reserva',
      description: 'Reserva completa de principio a fin',
      status: 'no-ejecutado',
      type: 'automatico',
    },
    {
      id: 5,
      title: 'Pruebas de Carga',
      description: 'Rendimiento con múltiples usuarios',
      status: 'no-ejecutado',
      type: 'personalizado',
    },
  ];

  badges: Badge[] = [
    {
      id: 1,
      name: 'Arquitecto Frontend',
      description: 'Diseña una interfaz excepcional',
      icon: '🎨',
      earned: true,
      xp: 100,
    },
    {
      id: 2,
      name: 'Maestro del Backend',
      description: 'Backend robusto y escalable',
      icon: '⚙️',
      earned: false,
      xp: 150,
    },
    {
      id: 3,
      name: 'Rey de las APIs',
      description: 'API bien documentada y eficiente',
      icon: '🔗',
      earned: false,
      xp: 125,
    },
    {
      id: 4,
      name: 'Documentador Pro',
      description: 'Documentación completa y clara',
      icon: '📚',
      earned: false,
      xp: 75,
    },
    {
      id: 5,
      name: 'Optimizador',
      description: 'Aplicación de alto rendimiento',
      icon: '⚡',
      earned: false,
      xp: 100,
    },
  ];

  resources: Resource[] = [
    {
      id: 1,
      title: 'Guía de Arquitectura',
      description: 'Documento completo de diseño del sistema',
      icon: '📘',
      type: 'documento',
      url: '#',
    },
    {
      id: 2,
      title: 'Repositorio Base',
      description: 'Código inicial con configuración',
      icon: '💻',
      type: 'repositorio',
      url: '#',
    },
    {
      id: 3,
      title: 'Video: Autenticación JWT',
      description: 'Tutorial paso a paso',
      icon: '🎥',
      type: 'video',
      url: '#',
    },
    {
      id: 4,
      title: 'API Documentation',
      description: 'Especificación completa de endpoints',
      icon: '🔗',
      type: 'documento',
      url: '#',
    },
    {
      id: 5,
      title: 'Best Practices',
      description: 'Guía de mejores prácticas React/Node',
      icon: '⭐',
      type: 'articulo',
      url: '#',
    },
  ];

  newMessage: string = '';
  activePhase: number = 3;

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      const projectId = params.get('id');
      this.loadProject(parseInt(projectId || '1'));
    });
  }

  loadProject(projectId: number) {
    // En una aplicación real, cargarías los datos del proyecto desde una API
    console.log('Cargando proyecto:', projectId);
  }

  getRingRotation(): number {
    return (this.project.progress / 100) * 360 - 45;
  }

  getTechnicalSkills(): Skill[] {
    return this.skills.filter((skill) => skill.category === 'tecnica');
  }

  getSoftSkills(): Skill[] {
    return this.skills.filter((skill) => skill.category === 'blanda');
  }

  getEarnedBadges(): Badge[] {
    return this.badges.filter((badge) => badge.earned);
  }

  getLockedBadges(): Badge[] {
    return this.badges.filter((badge) => !badge.earned);
  }

  getPassedTests(): TestCase[] {
    return this.testCases.filter((test) => test.status === 'pasado');
  }

  getFailedTests(): TestCase[] {
    return this.testCases.filter((test) => test.status === 'fallado');
  }

  getPendingTests(): TestCase[] {
    return this.testCases.filter((test) => test.status === 'no-ejecutado');
  }

  sendMessage() {
    if (this.newMessage.trim()) {
      this.chatMessages.push({
        id: this.chatMessages.length + 1,
        text: this.newMessage,
        isUser: true,
        timestamp: new Date(),
        type: 'pista',
      });

      // Simular respuesta de IA
      setTimeout(() => {
        this.chatMessages.push({
          id: this.chatMessages.length + 1,
          text: this.generateAIResponse(this.newMessage),
          isUser: false,
          timestamp: new Date(),
          type: 'feedback',
        });
      }, 1000);

      this.newMessage = '';
    }
  }

  generateAIResponse(userMessage: string): string {
    const responses = [
      'Interesante pregunta. Te recomiendo revisar la documentación de la fase actual.',
      'Basado en tu progreso, sugiero enfocarte en completar los tests fallidos primero.',
      '¡Excelente avance! Tu comprensión de los conceptos está mejorando notablemente.',
      'Detecté que podrías optimizar esa implementación. ¿Quieres que te muestre algunas mejoras?',
      'Tu código está bien estructurado. Considera añadir más comentarios para mejor documentación.',
    ];

    return responses[Math.floor(Math.random() * responses.length)];
  }

  startProject() {
    this.project.status = 'en-progreso';
    console.log('Iniciando proyecto...');
  }

  submitForEvaluation() {
    console.log('Enviando proyecto para evaluación IA...');
    // Lógica de evaluación
  }

  downloadCertificate() {
    console.log('Descargando certificado...');
  }

  shareProject() {
    console.log('Compartiendo proyecto con la comunidad...');
  }

  runTests() {
    console.log('Ejecutando pruebas automáticas...');
    // Lógica para ejecutar tests
  }

  setActivePhase(phaseId: number) {
    this.activePhase = phaseId;
  }

  getActivePhase(): RoadmapPhase {
    return (
      this.roadmapPhases.find((phase) => phase.id === this.activePhase) || this.roadmapPhases[0]
    );
  }
}
