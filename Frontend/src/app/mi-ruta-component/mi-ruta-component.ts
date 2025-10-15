import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Router } from '@angular/router';

interface Skill {
  name: string;
  level: number;
  target: number;
}

interface RoadmapItem {
  id: number;
  title: string;
  description: string;
  status: 'completed' | 'current' | 'upcoming';
  icon: string;
}

interface CareerPath {
  id: number;
  title: string;
  description: string;
  icon: string;
  selected: boolean;
}

interface Badge {
  id: number;
  name: string;
  icon: string;
  earned: boolean;
  description: string;
}

interface ChatMessage {
  id: number;
  text: string;
  isUser: boolean;
  timestamp: Date;
}

@Component({
  selector: 'app-mi-ruta',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarComponent],
  templateUrl: './mi-ruta-component.html',
  styleUrls: ['./mi-ruta-component.css'],
})
export class MiRutaComponent implements OnInit {
  // User Progress Data
  userLevel: number = 12;
  userXP: number = 3450;
  nextLevelXP: number = 4000;
  totalCourses: number = 8;
  completedCourses: number = 5;
  currentStreak: number = 7;

  // Skills Data
  skills: Skill[] = [
    { name: 'Fundamentos', level: 85, target: 100 },
    { name: 'Algoritmos', level: 65, target: 100 },
    { name: 'Estructuras', level: 45, target: 100 },
    { name: 'Desarrollo Web', level: 75, target: 100 },
    { name: 'Bases de Datos', level: 55, target: 100 },
    { name: 'DevOps', level: 25, target: 100 },
  ];

  // Roadmap Data
  roadmapItems: RoadmapItem[] = [
    {
      id: 1,
      title: 'Fundamentos de Programación',
      description: 'Variables, condicionales, bucles y funciones',
      status: 'completed',
      icon: '📚',
    },
    {
      id: 2,
      title: 'Estructuras de Datos Básicas',
      description: 'Arrays, listas, pilas y colas',
      status: 'completed',
      icon: '🧩',
    },
    {
      id: 3,
      title: 'Algoritmos y Complejidad',
      description: 'Análisis de algoritmos y notación Big O',
      status: 'current',
      icon: '⚡',
    },
    {
      id: 4,
      title: 'Desarrollo Web Frontend',
      description: 'HTML, CSS, JavaScript y frameworks modernos',
      status: 'upcoming',
      icon: '🎨',
    },
    {
      id: 5,
      title: 'Backend y APIs',
      description: 'Servidores, bases de datos y REST APIs',
      status: 'upcoming',
      icon: '🔧',
    },
  ];

  // Career Paths
  careerPaths: CareerPath[] = [
    {
      id: 1,
      title: 'Desarrollador Web',
      description: 'Full Stack Developer',
      icon: '🕸️',
      selected: true,
    },
    {
      id: 2,
      title: 'Ingeniero de IA',
      description: 'Data Scientist & ML',
      icon: '🤖',
      selected: false,
    },
    {
      id: 3,
      title: 'DevOps Engineer',
      description: 'Cloud & Infrastructure',
      icon: '🧱',
      selected: false,
    },
    {
      id: 4,
      title: 'Mobile Developer',
      description: 'iOS & Android Apps',
      icon: '📱',
      selected: false,
    },
  ];

  // Badges and Achievements
  badges: Badge[] = [
    {
      id: 1,
      name: 'Primer Programa',
      icon: '🚀',
      earned: true,
      description: 'Completaste tu primer programa',
    },
    {
      id: 2,
      name: 'Estrella en Ascenso',
      icon: '⭐',
      earned: true,
      description: 'Alcanzaste nivel 10',
    },
    {
      id: 3,
      name: 'Racha de 7 Días',
      icon: '🔥',
      earned: true,
      description: '7 días consecutivos aprendiendo',
    },
    {
      id: 4,
      name: 'Algoritmos Maestro',
      icon: '🧠',
      earned: false,
      description: 'Domina 50 algoritmos',
    },
    {
      id: 5,
      name: 'Proyecto Completo',
      icon: '🏆',
      earned: false,
      description: 'Termina tu primer proyecto',
    },
    {
      id: 6,
      name: 'Comunidad Activa',
      icon: '👥',
      earned: false,
      description: 'Ayuda a 10 compañeros',
    },
  ];

  // AI Mentor Chat
  chatMessages: ChatMessage[] = [
    {
      id: 1,
      text: '¡Hola! Soy tu mentor de IA. Veo que estás progresando muy bien con los algoritmos. ¿En qué puedo ayudarte hoy?',
      isUser: false,
      timestamp: new Date(),
    },
    {
      id: 2,
      text: 'Hola, tengo dudas sobre complejidad temporal en algoritmos de ordenamiento.',
      isUser: true,
      timestamp: new Date(),
    },
    {
      id: 3,
      text: 'Excelente pregunta. Te recomiendo practicar con ejercicios de Bubble Sort vs Quick Sort. ¿Quieres que genere algunos ejercicios para ti?',
      isUser: false,
      timestamp: new Date(),
    },
  ];

  newMessage: string = '';

  // Practice Options
  practiceOptions = [
    { icon: '💬', title: 'Playground', description: 'Practica cualquier lenguaje' },
    { icon: '🧠', title: 'Ejercicios IA', description: 'Generados para tu nivel' },
    { icon: '⚡', title: 'Modo Desafío', description: 'Problemas con tiempo' },
    { icon: '🎯', title: 'Entrevistas', description: 'Simulador técnico' },
  ];

  constructor(private router: Router) {}

  ngOnInit() {
    this.loadUserProgress();
  }

  loadUserProgress() {
    // Simular carga de datos del usuario
    setTimeout(() => {
      // Datos ya inicializados en las propiedades
    }, 1000);
  }

  get progressPercentage(): number {
    return (this.userXP / this.nextLevelXP) * 100;
  }

  get currentCareerPath(): CareerPath {
    return this.careerPaths.find((path) => path.selected) || this.careerPaths[0];
  }

  selectCareerPath(pathId: number) {
    this.careerPaths.forEach((path) => {
      path.selected = path.id === pathId;
      //Ir a la sección de la ruta profesional de la carrera seleccionada
      this.loadCareerPath(path.id);
    });
  }

  loadCareerPath(pathId: number) {
    //Ir a la pantalla de la ruta profesional
    this.router.navigate(['/ruta-profesional', pathId]);
  }

  sendMessage() {
    if (this.newMessage.trim()) {
      // Agregar mensaje del usuario
      this.chatMessages.push({
        id: this.chatMessages.length + 1,
        text: this.newMessage,
        isUser: true,
        timestamp: new Date(),
      });

      // Simular respuesta de la IA
      setTimeout(() => {
        this.chatMessages.push({
          id: this.chatMessages.length + 1,
          text: this.generateAIResponse(this.newMessage),
          isUser: false,
          timestamp: new Date(),
        });

        // Scroll to bottom would be implemented in a real scenario
      }, 1000);

      this.newMessage = '';
    }
  }

  generateAIResponse(userMessage: string): string {
    const responses = [
      'Interesante pregunta. Te recomiendo revisar los ejercicios prácticos de esa sección.',
      'Basado en tu progreso, sugiero enfocarte en los conceptos fundamentales primero.',
      '¡Excelente avance! Tu comprensión de los temas está mejorando notablemente.',
      'Detecté que podrías practicar más ese tema. ¿Quieres que genere ejercicios específicos?',
      'Tu ruta de aprendizaje se está adaptando a tu ritmo. ¡Sigue así!',
    ];

    return responses[Math.floor(Math.random() * responses.length)];
  }

  startPractice(type: string) {
    // Navegar a la sección de práctica correspondiente
    console.log(`Iniciando práctica: ${type}`);
    // this.router.navigate(['/practice', type]);
  }

  generateNewExercises() {
    // Lógica para generar nuevos ejercicios
    console.log('Generando nuevos ejercicios personalizados...');
  }

  adjustLearningPath() {
    // Lógica para ajustar la ruta de aprendizaje
    console.log('Ajustando ruta de aprendizaje...');
  }

  exportProgress() {
    // Lógica para exportar progreso
    console.log('Exportando progreso y CV técnico...');
  }
}
