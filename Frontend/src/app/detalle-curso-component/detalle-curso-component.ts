// detalle-curso-component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar-component/sidebar-component';

import { Router } from '@angular/router';


interface Instructor {
  name: string;
  avatar: string;
}

interface Lesson {
  title: string;
  duration: string;
  isPreview: boolean;
}

interface Topic {
  title: string;
  lessons: Lesson[];
}

interface Module {
  title: string;
  duration: string;
  points: number;
  topics: Topic[];
}

interface Review {
  userName: string;
  userAvatar: string;
  rating: number;
  date: string;
  comment: string;
  helpful: number;
}

interface RelatedCourse {
  id: number;
  title: string;
  image: string;
  rating: number;
  students: number;
  points: number;
}

interface Course {
  id: number;
  title: string;
  description: string;
  thumbnail: string;
  level: string;
  rating: number;
  reviews: number;
  students: number;
  duration: string;
  totalPoints: number;
  category: string;
  isNew: boolean;
  isTrending: boolean;
  instructor: Instructor;
  learningPoints: string[];
  modules: Module[];
  requirements: string[];
  reviewsList: Review[];
}

@Component({
  selector: 'app-detalle-curso',
  standalone: true,
  imports: [CommonModule, SidebarComponent],
  templateUrl: './detalle-curso-component.html',
  styleUrls: ['./detalle-curso-component.css'],
})
export class DetalleCursoComponent implements OnInit {
  course: Course = {
    id: 1,
    title: 'Angular Avanzado - Arquitectura y Mejores Prácticas',
    description:
      'Domina Angular con patrones avanzados, arquitectura escalable y las mejores prácticas de desarrollo. Aprende a construir aplicaciones empresariales robustas y mantenibles.',
    thumbnail: 'https://images.unsplash.com/photo-1555949963-aa79dcee981c?w=600&h=400&fit=crop',
    level: 'Avanzado',
    rating: 4.8,
    reviews: 3247,
    students: 15420,
    duration: '22 horas',
    totalPoints: 1500,
    category: 'Frontend',
    isNew: true,
    isTrending: true,
    instructor: {
      name: 'María González',
      avatar:
        'https://images.unsplash.com/photo-1494790108755-2616b612b786?w=100&h=100&fit=crop&crop=face',
    },
    learningPoints: [
      'Arquitectura de aplicaciones Angular escalables',
      'Patrones avanzados de RxJS y gestión de estado',
      'Optimización de rendimiento y lazy loading',
      'Testing integral con Jasmine y Cypress',
      'Deploy en producción y CI/CD',
      'Micro frontends con Angular',
      'Seguridad y mejores prácticas',
      'Integración con APIs REST y GraphQL',
    ],
    modules: [
      {
        title: 'Fundamentos Avanzados de Angular',
        duration: '4 horas',
        points: 200,
        topics: [
          {
            title: 'Arquitectura y Patrones',
            lessons: [
              { title: 'Introducción a la arquitectura MVVM', duration: '25 min', isPreview: true },
              { title: 'Patrón Container-Presenter', duration: '30 min', isPreview: false },
              { title: 'Smart vs Dumb Components', duration: '35 min', isPreview: false },
              { title: 'Arquitectura basada en módulos', duration: '40 min', isPreview: false },
            ],
          },
          {
            title: 'RxJS Avanzado',
            lessons: [
              { title: 'Operadores avanzados de RxJS', duration: '45 min', isPreview: false },
              { title: 'Gestión de estado con Subjects', duration: '35 min', isPreview: false },
              { title: 'Patrones de cancelación', duration: '30 min', isPreview: true },
            ],
          },
        ],
      },
      {
        title: 'Gestión de Estado Profesional',
        duration: '6 horas',
        points: 350,
        topics: [
          {
            title: 'NgRx Completo',
            lessons: [
              { title: 'Introducción a NgRx', duration: '40 min', isPreview: false },
              { title: 'Actions y Reducers', duration: '35 min', isPreview: false },
              { title: 'Selectors y Effects', duration: '45 min', isPreview: false },
              { title: 'Entity Adapter', duration: '50 min', isPreview: false },
            ],
          },
          {
            title: 'Alternativas de Estado',
            lessons: [
              { title: 'Gestión con Services', duration: '30 min', isPreview: false },
              { title: 'Akita vs NgRx', duration: '40 min', isPreview: true },
              { title: 'Estado local vs global', duration: '35 min', isPreview: false },
            ],
          },
        ],
      },
      {
        title: 'Rendimiento y Optimización',
        duration: '5 horas',
        points: 300,
        topics: [
          {
            title: 'Optimización Avanzada',
            lessons: [
              { title: 'Change Detection Strategy', duration: '35 min', isPreview: false },
              { title: 'Lazy Loading avanzado', duration: '40 min', isPreview: false },
              { title: 'Preloading strategies', duration: '30 min', isPreview: true },
            ],
          },
          {
            title: 'Bundle Analysis',
            lessons: [
              { title: 'Webpack Bundle Analyzer', duration: '45 min', isPreview: false },
              { title: 'Tree shaking y dead code', duration: '35 min', isPreview: false },
              { title: 'Optimización de imports', duration: '25 min', isPreview: false },
            ],
          },
        ],
      },
      {
        title: 'Testing Integral',
        duration: '4 horas',
        points: 250,
        topics: [
          {
            title: 'Unit Testing Avanzado',
            lessons: [
              { title: 'Testing de componentes', duration: '40 min', isPreview: false },
              { title: 'Testing de servicios', duration: '35 min', isPreview: false },
              { title: 'Testing asíncrono', duration: '30 min', isPreview: false },
            ],
          },
          {
            title: 'E2E Testing',
            lessons: [
              { title: 'Cypress básico', duration: '45 min', isPreview: true },
              { title: 'Testing de flujos completos', duration: '50 min', isPreview: false },
              { title: 'Best practices E2E', duration: '35 min', isPreview: false },
            ],
          },
        ],
      },
      {
        title: 'Deploy y Producción',
        duration: '3 horas',
        points: 200,
        topics: [
          {
            title: 'CI/CD Pipeline',
            lessons: [
              { title: 'Configuración de entornos', duration: '30 min', isPreview: false },
              { title: 'GitHub Actions', duration: '40 min', isPreview: false },
              { title: 'Dockerización', duration: '35 min', isPreview: true },
            ],
          },
          {
            title: 'Performance en Producción',
            lessons: [
              { title: 'Monitoring y logs', duration: '25 min', isPreview: false },
              { title: 'Error tracking', duration: '30 min', isPreview: false },
              { title: 'A/B testing', duration: '35 min', isPreview: false },
            ],
          },
        ],
      },
    ],
    requirements: [
      'Conocimientos sólidos de Angular y TypeScript',
      'Experiencia con HTML5, CSS3 y JavaScript ES6+',
      'Conocimientos básicos de RxJS',
      'Familiaridad con el ecosistema Node.js',
      'Experiencia previa con sistemas de control de versiones (Git)',
    ],
    reviewsList: [
      {
        userName: 'Carlos Rodríguez',
        userAvatar:
          'https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?w=100&h=100&fit=crop&crop=face',
        rating: 5,
        date: 'Hace 2 semanas',
        comment:
          'Excelente curso! La explicación sobre NgRx y la gestión de estado es la mejor que he visto. María explica conceptos complejos de manera muy clara.',
        helpful: 24,
      },
      {
        userName: 'Ana Martínez',
        userAvatar:
          'https://images.unsplash.com/photo-1438761681033-6461ffad8d80?w=100&h=100&fit=crop&crop=face',
        rating: 5,
        date: 'Hace 1 mes',
        comment:
          'Las secciones de optimización de rendimiento cambiaron completamente cómo desarrollo en Angular. Muy recomendado para desarrolladores con experiencia.',
        helpful: 18,
      },
      {
        userName: 'David Chen',
        userAvatar:
          'https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=100&h=100&fit=crop&crop=face',
        rating: 4,
        date: 'Hace 3 semanas',
        comment:
          'Buen contenido en general, aunque me hubiera gustado más profundidad en la parte de micro frontends. El instructor es muy conocedor del tema.',
        helpful: 12,
      },
    ],
  };

  expandedModules: boolean[] = [];
  expandedTopics: boolean[][] = [];
  ratingDistribution = [
    { stars: 5, percentage: 72 },
    { stars: 4, percentage: 18 },
    { stars: 3, percentage: 6 },
    { stars: 2, percentage: 3 },
    { stars: 1, percentage: 1 },
  ];

  relatedCourses: RelatedCourse[] = [
    {
      id: 2,
      title: 'React Pro - Hooks y Patrones Avanzados',
      image: 'https://images.unsplash.com/photo-1633356122544-f134324a6cee?w=400&h=250&fit=crop',
      rating: 4.9,
      students: 23150,
      points: 1400,
    },
    {
      id: 3,
      title: 'TypeScript Masterclass - Tipos Avanzados',
      image: 'https://images.unsplash.com/photo-1619410283995-43d9134e7656?w=400&h=250&fit=crop',
      rating: 4.8,
      students: 18790,
      points: 1200,
    },
    {
      id: 4,
      title: 'Node.js Enterprise - Arquitectura Escalable',
      image: 'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=400&h=250&fit=crop',
      rating: 4.7,
      students: 15430,
      points: 1600,
    },
    {
      id: 5,
      title: 'Vue.js 3 - Composition API Pro',
      image: 'https://images.unsplash.com/photo-1593720213428-28a5b9e94613?w=400&h=250&fit=crop',
      rating: 4.6,
      students: 13240,
      points: 1100,
    },
  ];


  constructor(private router: Router) {}

  ngOnInit() {
    // Initialize expanded states
    this.expandedModules = new Array(this.course.modules.length).fill(false);
    this.expandedTopics = this.course.modules.map((module) =>
      new Array(module.topics.length).fill(false)
    );

    // Expand first module by default
    if (this.expandedModules.length > 0) {
      this.expandedModules[0] = true;
    }
  }

  toggleModule(index: number): void {
    this.expandedModules[index] = !this.expandedModules[index];
  }

  toggleTopic(moduleIndex: number, topicIndex: number): void {
    this.expandedTopics[moduleIndex][topicIndex] = !this.expandedTopics[moduleIndex][topicIndex];
  }

  getTotalLessons(): number {
    return this.course.modules.reduce((total, module) => {
      return (
        total +
        module.topics.reduce((topicTotal, topic) => {
          return topicTotal + topic.lessons.length;
        }, 0)
      );
    }, 0);
  }

  getTotalPoints(): number {
    return this.course.modules.reduce((total, module) => total + module.points, 0);
  }


  enrollInCourse(): void {
    // Lógica para inscribirse en el curso

    // Ingresar a la página de curso
    this.router.navigate(['/visualizar-tema', this.course.id]);
  }

}
