import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { PaymentComponent } from '../payment-component/payment-component';
import { HttpClientModule } from '@angular/common/http';

import { Course } from '../models/Course';
import { Achievement } from '../models/Achievement';
import { AchievementService } from '../service/achievement/achievement-service';

interface WishlistCourse {
  id: number;
  name: string;
  image: string;
  level: string;
  duration: string;
  students: number;
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
  ];

  // Achievements desde la base de datos
  recentAchievements: Achievement[] = [];
  upcomingAchievements: UpcomingAchievement[] = [];

  weeklyActivity: WeeklyActivity[] = [
    { day: 'L', value: 3 },
    { day: 'M', value: 5 },
    { day: 'X', value: 2 },
    { day: 'J', value: 4 },
    { day: 'V', value: 6 },
    { day: 'S', value: 1 },
    { day: 'D', value: 4 },
  ];

  constructor(private achievementService: AchievementService) {}

  ngOnInit() {
    // Cargar logros desde el backend
    this.achievementService.findAll().subscribe({
      next: (data) => {
        // Filtrar los desbloqueados y los bloqueados
        this.recentAchievements = data.filter((a) => a.unlocked);
        const lockedAchievements = data.filter((a) => !a.unlocked);

        // Mapear los bloqueados como próximos logros
        this.upcomingAchievements = lockedAchievements.map((a) => ({
          id: a.id,
          name: a.name,
          icon: a.image || '🏆',
          progress: Math.floor(Math.random() * 80), // simular progreso (puedes usar otro criterio)
          required: a.points || 100,
        }));
      },
      error: (err) => console.error('Error al cargar logros desde la BD', err),
    });

    // Animar estadísticas
    setTimeout(() => {
      this.animateStats = true;
    }, 100);
  }

  getCourseProgress(course: Course): number {
    if (!course.lessons || !course.completedLessons) return 0;
    return Math.round((course.completedLessons / course.lessons) * 100);
  }

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
}
