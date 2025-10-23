import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable, Subject } from 'rxjs';
import { tap, catchError, takeUntil } from 'rxjs/operators';
import { of } from 'rxjs';

import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { PaymentComponent } from '../payment-component/payment-component';
import { HttpClientModule } from '@angular/common/http';

import { Course } from '../models/Course';
import { Achievement } from '../models/Achievement';
import { AchievementService } from '../service/achievement/achievement-service';
import { CourseService } from '../service/Course/course-service';
import { Router } from '@angular/router';

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
export class DashboardComponent implements OnInit, OnDestroy {
  // 🪙 Datos generales
  streak = 15;
  coins = 2450;
  animateStats = false;

  // 📚 Observables para datos cargados desde el backend
  courses$: Observable<Course[]> = of([]);
  wishlistCourses$: Observable<Course[]> = of([]);
  recentAchievements$: Observable<Achievement[]> = of([]);
  upcomingAchievements$: Observable<UpcomingAchievement[]> = of([]);
  weeklyActivity$: Observable<WeeklyActivity[]> = of([]);

  // 🔔 Notificación flotante
  mensaje: string = '';
  mostrarNotificacion: boolean = false;
  tipoNotificacion: 'exito' | 'error' = 'exito';

  // 🛑 Subject para controlar desuscripciones
  private destroy$ = new Subject<void>();

  constructor(
    private achievementService: AchievementService,
    private courseService: CourseService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cargarCursos();
    this.cargarWishlist();
    this.cargarLogros();
    this.cargarActividadSemanal();
  }

  ngOnDestroy(): void {
    // 🛑 Desuscribirse de todos los observables
    this.destroy$.next();
    this.destroy$.complete();
  }

  // 📘 Cargar cursos del backend
  cargarCursos(): void {
    this.courses$ = this.courseService.findAll().pipe(
      tap((data) => {
        this.mostrarMensaje('Cursos cargados correctamente');
      }),
      catchError((err) => {
        console.error('Error al cargar cursos:', err);
        this.mostrarMensaje('Error al cargar cursos', 'error');
        return of([]);
      }),
      takeUntil(this.destroy$)
    );
  }

  // 🧡 Cargar wishlist (ejemplo: backend puede tener endpoint /wishlist)
  cargarWishlist(): void {
    this.wishlistCourses$ = this.courseService.findWishlist().pipe(
      catchError((err) => {
        console.error('Error al cargar wishlist:', err);
        this.mostrarMensaje('Error al cargar wishlist', 'error');
        return of([]);
      }),
      takeUntil(this.destroy$)
    );
  }

  // 🏆 Cargar logros desde el backend
  cargarLogros(): void {
    this.courseService
      .findAll()
      .pipe(
        tap((data) => {
          this.recentAchievements$ = this.achievementService.findAll().pipe(
            tap((achievements) => {
              // Filtrar logros desbloqueados
              const unlockedAchievements = achievements.filter((a) => a.unlocked);
              this.recentAchievements$ = of(unlockedAchievements);

              // Mapear logros bloqueados
              const locked = achievements.filter((a) => !a.unlocked);
              const upcoming = locked.map((a) => ({
                id: a.id,
                name: a.name,
                icon: a.image || '🏆',
                progress: Math.floor(Math.random() * 80),
                required: a.points || 100,
              }));
              this.upcomingAchievements$ = of(upcoming);
            }),
            catchError((err) => {
              console.error('Error al cargar logros:', err);
              this.mostrarMensaje('Error al cargar logros', 'error');
              return of([]);
            }),
            takeUntil(this.destroy$)
          );
        }),
        catchError((err) => {
          console.error('Error al cargar logros:', err);
          this.mostrarMensaje('Error al cargar logros', 'error');
          return of([]);
        })
      )
      .subscribe();
  }

  // 📈 Cargar actividad semanal
  cargarActividadSemanal(): void {
    this.weeklyActivity$ = this.courseService.findWeeklyActivity().pipe(
      catchError((err) => {
        console.error('Error al cargar actividad semanal:', err);
        return of([]);
      }),
      takeUntil(this.destroy$)
    );
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
      DevOps: '⚙',
    };
    return icons[course.category] || '📚';
  }

  openCourse(courseId: number): void {
    this.router.navigate(['/detalle-curso', courseId]);
  }
}
