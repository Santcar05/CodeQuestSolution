import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { PaymentComponent } from '../payment-component/payment-component';
import { HttpClientModule } from '@angular/common/http';

import { Course } from '../models/Course';
import { Achievement } from '../models/Achievement';
import { AchievementService } from '../service/achievement/achievement-service';
import { CourseService } from '../service/Course/course-service';

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
  // 🪙 Datos generales
  streak = 15;
  coins = 2450;
  animateStats = false;

  // 📚 Datos cargados desde el backend
  courses: Course[] = [];
  wishlistCourses: Course[] = [];
  recentAchievements: Achievement[] = [];
  upcomingAchievements: UpcomingAchievement[] = [];

  // 📈 Actividad semanal (puede venir del backend si lo deseas)
  weeklyActivity: WeeklyActivity[] = [];

  // 🔔 Notificación flotante
  mensaje: string = '';
  mostrarNotificacion: boolean = false;
  tipoNotificacion: 'exito' | 'error' = 'exito';

  constructor(
    private achievementService: AchievementService,
    private courseService: CourseService
  ) {}

  ngOnInit(): void {
    this.cargarCursos();
    this.cargarWishlist();
    this.cargarLogros();
    this.cargarActividadSemanal();

    // Animación inicial de estadísticas
    setTimeout(() => {
      this.animateStats = true;
    }, 100);
  }

  // 📘 Cargar cursos del backend
  cargarCursos(): void {
    this.courseService.findAll().subscribe({
      next: (data) => {
        this.courses = data;
        this.mostrarMensaje('Cursos cargados correctamente');
      },
      error: (err) => {
        console.error('Error al cargar cursos:', err);
        this.mostrarMensaje('Error al cargar cursos', 'error');
      },
    });
  }

  // 🧡 Cargar wishlist (ejemplo: backend puede tener endpoint /wishlist)
  cargarWishlist(): void {
    this.courseService.findWishlist().subscribe({
      next: (data) => {
        this.wishlistCourses = data;
      },
      error: () => this.mostrarMensaje('Error al cargar wishlist', 'error'),
    });
  }

  // 🏆 Cargar logros desde el backend
  cargarLogros(): void {
    this.achievementService.findAll().subscribe({
      next: (data) => {
        this.recentAchievements = data.filter((a) => a.unlocked);
        const locked = data.filter((a) => !a.unlocked);

        this.upcomingAchievements = locked.map((a) => ({
          id: a.id,
          name: a.name,
          icon: a.image || '🏆',
          progress: Math.floor(Math.random() * 80),
          required: a.points || 100,
        }));
      },
      error: () => this.mostrarMensaje('Error al cargar logros', 'error'),
    });
  }

  // 📈 Cargar actividad semanal
  cargarActividadSemanal(): void {
    this.courseService.findWeeklyActivity().subscribe({
      next: (data) => (this.weeklyActivity = data),
      error: () => (this.weeklyActivity = []),
    });
  }

  // 🔔 Mostrar notificaciones flotantes
  mostrarMensaje(texto: string, tipo: 'exito' | 'error' = 'exito'): void {
    this.mensaje = texto;
    this.tipoNotificacion = tipo;
    this.mostrarNotificacion = true;
    setTimeout(() => (this.mostrarNotificacion = false), 2500);
  }

  // 📊 Progreso de curso
  getCourseProgress(course: Course): number {
    if (!course.lessons || !course.completedLessons) return 0;
    return Math.round((course.completedLessons / course.lessons) * 100);
  }

  // 📚 Icono de curso según categoría
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
