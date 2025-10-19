// detalle-curso-component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Router } from '@angular/router';
import { Course } from '../models/Course';

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
              {
                title: 'Introducción a la arquitectura MVVM',
                duration: '25 min',
                isPreview: true,
                id: 0,
              },
              {
                title: 'Patrón Container-Presenter',
                duration: '30 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Smart vs Dumb Components',
                duration: '35 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Arquitectura basada en módulos',
                duration: '40 min',
                isPreview: false,
                id: 0,
              },
            ],
            id: 0,
          },
          {
            title: 'RxJS Avanzado',
            lessons: [
              {
                title: 'Operadores avanzados de RxJS',
                duration: '45 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Gestión de estado con Subjects',
                duration: '35 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Patrones de cancelación',
                duration: '30 min',
                isPreview: true,
                id: 0,
              },
            ],
            id: 0,
          },
        ],
        id: 0,
      },
      {
        title: 'Gestión de Estado Profesional',
        duration: '6 horas',
        points: 350,
        topics: [
          {
            title: 'NgRx Completo',
            lessons: [
              {
                title: 'Introducción a NgRx',
                duration: '40 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Actions y Reducers',
                duration: '35 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Selectors y Effects',
                duration: '45 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Entity Adapter',
                duration: '50 min',
                isPreview: false,
                id: 0,
              },
            ],
            id: 0,
          },
          {
            title: 'Alternativas de Estado',
            lessons: [
              {
                title: 'Gestión con Services',
                duration: '30 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Akita vs NgRx',
                duration: '40 min',
                isPreview: true,
                id: 0,
              },
              {
                title: 'Estado local vs global',
                duration: '35 min',
                isPreview: false,
                id: 0,
              },
            ],
            id: 0,
          },
        ],
        id: 0,
      },
      {
        title: 'Rendimiento y Optimización',
        duration: '5 horas',
        points: 300,
        topics: [
          {
            title: 'Optimización Avanzada',
            lessons: [
              {
                title: 'Change Detection Strategy',
                duration: '35 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Lazy Loading avanzado',
                duration: '40 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Preloading strategies',
                duration: '30 min',
                isPreview: true,
                id: 0,
              },
            ],
            id: 0,
          },
          {
            title: 'Bundle Analysis',
            lessons: [
              {
                title: 'Webpack Bundle Analyzer',
                duration: '45 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Tree shaking y dead code',
                duration: '35 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Optimización de imports',
                duration: '25 min',
                isPreview: false,
                id: 0,
              },
            ],
            id: 0,
          },
        ],
        id: 0,
      },
      {
        title: 'Testing Integral',
        duration: '4 horas',
        points: 250,
        topics: [
          {
            title: 'Unit Testing Avanzado',
            lessons: [
              {
                title: 'Testing de componentes',
                duration: '40 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Testing de servicios',
                duration: '35 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Testing asíncrono',
                duration: '30 min',
                isPreview: false,
                id: 0,
              },
            ],
            id: 0,
          },
          {
            title: 'E2E Testing',
            lessons: [
              {
                title: 'Cypress básico',
                duration: '45 min',
                isPreview: true,
                id: 0,
              },
              {
                title: 'Testing de flujos completos',
                duration: '50 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Best practices E2E',
                duration: '35 min',
                isPreview: false,
                id: 0,
              },
            ],
            id: 0,
          },
        ],
        id: 0,
      },
      {
        title: 'Deploy y Producción',
        duration: '3 horas',
        points: 200,
        topics: [
          {
            title: 'CI/CD Pipeline',
            lessons: [
              {
                title: 'Configuración de entornos',
                duration: '30 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'GitHub Actions',
                duration: '40 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Dockerización',
                duration: '35 min',
                isPreview: true,
                id: 0,
              },
            ],
            id: 0,
          },
          {
            title: 'Performance en Producción',
            lessons: [
              {
                title: 'Monitoring y logs',
                duration: '25 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'Error tracking',
                duration: '30 min',
                isPreview: false,
                id: 0,
              },
              {
                title: 'A/B testing',
                duration: '35 min',
                isPreview: false,
                id: 0,
              },
            ],
            id: 0,
          },
        ],
        id: 0,
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

  relatedCourses: Course[] = [
    {
      id: 2,
      title: 'React Pro - Hooks y Patrones Avanzados',
      image: 'https://images.unsplash.com/photo-1633356122544-f134324a6cee?w=400&h=250&fit=crop',
      rating: 4.9,
      students: 23150,
      totalPoints: 1400,
      description:
        'Aprende React de cero a experto con Hooks y patrones avanzados. Desarrolla aplicaciones modernas y escalables.',
      category: 'Desarrollo Web',
      level: 'Avanzado',
    },
    {
      id: 3,
      title: 'TypeScript Masterclass - Tipos Avanzados',
      image: 'https://images.unsplash.com/photo-1619410283995-43d9134e7656?w=400&h=250&fit=crop',
      rating: 4.8,
      students: 18790,
      totalPoints: 1200,
      description:
        'Aprende TypeScript desde cero y domina los tipos avanzados. Desarrolla aplicaciones robustas y escalables con TypeScript.',
      category: 'Desarrollo Web',
      level: 'Avanzado',
    },
    {
      id: 4,
      title: 'Node.js Enterprise - Arquitectura Escalable',
      image: 'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=400&h=250&fit=crop',
      rating: 4.7,
      students: 15430,
      totalPoints: 1300,
      description:
        'Aprende Node.js desde cero y domina la arquitectura escalable. Desarrolla aplicaciones robustas y escalables con Node.js.',
      category: 'Desarrollo Web',
      level: 'Avanzado',
    },
    {
      id: 5,
      title: 'Vue.js 3 - Composition API Pro',
      image: 'https://images.unsplash.com/photo-1593720213428-28a5b9e94613?w=400&h=250&fit=crop',
      rating: 4.6,
      students: 13240,
      totalPoints: 1100,
      description:
        'Aprende Vue.js desde cero y domina la Composition API. Desarrolla aplicaciones modernas y escalables con Vue.js.',
      category: 'Desarrollo Web',
      level: 'Avanzado',
    },
  ];

  constructor(private router: Router) {}
  ngOnInit() {
    // Initialize expanded states
    this.expandedModules = new Array(this.course.modules?.length).fill(false);
    this.expandedTopics = this.course.modules!.map((module) =>
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
    return this.course.modules!.reduce((total, module) => {
      return (
        total +
        module.topics.reduce((topicTotal, topic) => {
          return topicTotal + topic.lessons.length;
        }, 0)
      );
    }, 0);
  }

  getTotalPoints(): number {
    return this.course.modules!.reduce((total, module) => total + module.points!, 0);
  }

  enrollInCourse(): void {
    // Lógica para inscribirse en el curso

    // Ingresar a la página de curso
    this.router.navigate(['/visualizar-tema', this.course.id]);
  }
}
