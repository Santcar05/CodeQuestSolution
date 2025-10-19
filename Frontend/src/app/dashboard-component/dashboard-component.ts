import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { PaymentComponent } from '../payment-component/payment-component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Course } from '../models/Course';
import { Instructor } from '../models/Instructor';
import { Review } from '../models/Review';

interface WishlistCourse {
  id: number;
  name: string;
  image: string;
  level: string;
  duration: string;
  students: number;
}

interface Achievement {
  id: number;
  name: string;
  icon: string;
  date: string;
  rarity: string;
}

interface UpcomingAchievement {
  id: number;
  name: string;
  icon: string;
  progress: number;
  required: number;
}

interface WeeklyActivity {
  day: string;
  value: number;
}

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, SidebarComponent, PaymentComponent, HttpClientModule],
  templateUrl: './dashboard-component.html',
  styleUrls: ['./dashboard-component.css'],
})
export class DashboardComponent implements OnInit {
  streak = 15;
  coins = 2450;
  animateStats = false;

  // Cursos quemados que cumplen con la interfaz Course
  courses: Course[] = [
    {
      id: 1,
      title: 'JavaScript Avanzado',
      description: 'Domina JavaScript moderno con ES6+, patrones de diseño y mejores prácticas',
      category: 'Frontend',
      level: 'Avanzado',
      rating: 4.8,
      duration: '15h 30m',
      students: 15420,
      lessons: 45,
      completedLessons: 31,
      nextLesson: 'Promesas y Async/Await',
      thumbnail:
        'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=400&h=300&fit=crop',
      image: 'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=800&h=600&fit=crop',
      price: '$29.99',
      originalPrice: '$49.99',
      xp: 1500,
      isNew: true,
      isTrending: true,
      status: 'in-progress',
      instructor: {
        id: 1,
        name: 'María González',
        avatar:
          'https://images.unsplash.com/photo-1494790108755-2616b612b786?w=100&h=100&fit=crop&crop=face',
      },
      learningPoints: [
        'ES6+ Features',
        'Async/Await Patterns',
        'Functional Programming',
        'Performance Optimization',
      ],
      requirements: [
        'Conocimientos básicos de JavaScript',
        'HTML y CSS básico',
        'Editor de código instalado',
      ],
      modules: [],
      reviewsList: [],
      totalPoints: 15000,
    },
    {
      id: 2,
      title: 'React Pro',
      description: 'Conviértete en experto en React con Hooks, Context API y patrones avanzados',
      category: 'Frontend',
      level: 'Intermedio',
      rating: 4.7,
      duration: '18h 15m',
      students: 23150,
      lessons: 60,
      completedLessons: 25,
      nextLesson: 'Context API',
      thumbnail:
        'https://images.unsplash.com/photo-1633356122544-f134324a6cee?w=400&h=300&fit=crop',
      image: 'https://images.unsplash.com/photo-1633356122544-f134324a6cee?w=800&h=600&fit=crop',
      price: '$34.99',
      originalPrice: '$59.99',
      xp: 1800,
      isNew: false,
      isTrending: true,
      status: 'in-progress',
      instructor: {
        id: 2,
        name: 'Carlos Rodríguez',
        avatar:
          'https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?w=100&h=100&fit=crop&crop=face',
      },
      learningPoints: [
        'React Hooks avanzados',
        'State Management',
        'Performance Optimization',
        'Testing con Jest',
      ],
      requirements: [
        'JavaScript intermedio',
        'Conocimientos básicos de React',
        'Node.js instalado',
      ],
      modules: [],
      reviewsList: [],
      totalPoints: 15000,
    },
    {
      id: 3,
      title: 'Node.js Backend',
      description: 'Construye APIs RESTful escalables con Node.js, Express y MongoDB',
      category: 'Backend',
      level: 'Intermedio',
      rating: 4.6,
      duration: '20h 45m',
      students: 18790,
      lessons: 52,
      completedLessons: 13,
      nextLesson: 'Express Routing',
      thumbnail:
        'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=400&h=300&fit=crop',
      image: 'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=800&h=600&fit=crop',
      price: '$39.99',
      originalPrice: '$69.99',
      xp: 2000,
      isNew: true,
      isTrending: false,
      status: 'not-started',
      instructor: {
        id: 3,
        name: 'Ana Martínez',
        avatar:
          'https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?w=100&h=100&fit=crop&crop=face',
      },
      learningPoints: [
        'Express.js Framework',
        'MongoDB Integration',
        'JWT Authentication',
        'API Security',
      ],
      requirements: ['JavaScript básico', 'Conocimientos de HTTP', 'MongoDB instalado'],
      modules: [],
      reviewsList: [],
      totalPoints: 10000,
    },
  ];

  wishlistCourses: WishlistCourse[] = [
    {
      id: 1,
      name: 'TypeScript Master',
      image: 'https://images.unsplash.com/photo-1619410283995-43d9134e7656?w=400&h=300&fit=crop',
      level: 'Avanzado',
      duration: '12h',
      students: 15420,
    },
    {
      id: 2,
      name: 'Python para Data Science',
      image: 'https://images.unsplash.com/photo-1526374965328-7f61d4dc18c5?w=400&h=300&fit=crop',
      level: 'Intermedio',
      duration: '15h',
      students: 23150,
    },
    {
      id: 3,
      name: 'Docker & Kubernetes',
      image: 'https://images.unsplash.com/photo-1605745341112-85968b19335b?w=400&h=300&fit=crop',
      level: 'Avanzado',
      duration: '18h',
      students: 18790,
    },
    {
      id: 4,
      name: 'React Native para Android',
      image: 'https://images.unsplash.com/photo-1605745341112-85968b19335b?w=400&h=300&fit=crop',
      level: 'Intermedio',
      duration: '14h',
      students: 15420,
    },
    {
      id: 5,
      name: 'React Native para iOS',
      image: 'https://images.unsplash.com/photo-1605745341112-85968b19335b?w=400&h=300&fit=crop',
      level: 'Intermedio',
      duration: '14h',
      students: 15420,
    },
    {
      id: 6,
      name: 'React Native para Web',
      image: 'https://images.unsplash.com/photo-1605745341112-85968b19335b?w=400&h=300&fit=crop',
      level: 'Intermedio',
      duration: '14h',
      students: 15420,
    },
  ];

  recentAchievements: Achievement[] = [
    { id: 1, name: 'Racha de 15 días', icon: '🔥', date: 'Hoy', rarity: 'rare' },
    { id: 2, name: 'Primer Proyecto', icon: '🎯', date: 'Hace 2 días', rarity: 'common' },
    { id: 3, name: 'Code Master', icon: '👑', date: 'Hace 5 días', rarity: 'epic' },
  ];

  upcomingAchievements: UpcomingAchievement[] = [
    { id: 1, name: 'Racha de 30 días', icon: '🔥', progress: 50, required: 30 },
    { id: 2, name: 'Completar 5 cursos', icon: '📚', progress: 60, required: 5 },
    { id: 3, name: '100 Desafíos', icon: '⚡', progress: 75, required: 100 },
  ];

  weeklyActivity: WeeklyActivity[] = [
    { day: 'L', value: 3 },
    { day: 'M', value: 5 },
    { day: 'X', value: 2 },
    { day: 'J', value: 4 },
    { day: 'V', value: 6 },
    { day: 'S', value: 1 },
    { day: 'D', value: 4 },
  ];

  // Función para calcular el progreso basado en lecciones completadas
  getCourseProgress(course: Course): number {
    if (!course.lessons || !course.completedLessons) return 0;
    return Math.round((course.completedLessons / course.lessons) * 100);
  }

  // Función para obtener icono basado en categoría
  getCourseIcon(course: Course): string {
    const icons: { [key: string]: string } = {
      Frontend: '🚀',
      Backend: '🟢',
      'Data Science': '📊',
      Mobile: '📱',
      DevOps: '⚙️',
    };
    return icons[course.category] || '📚';
  }

  ngOnInit() {
    setTimeout(() => {
      this.animateStats = true;
    }, 100);
  }
}
