import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable, Subject } from 'rxjs';
import { tap, catchError, takeUntil } from 'rxjs/operators';
import { of } from 'rxjs';

import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { PaymentComponent } from '../payment-component/payment-component';
import { HttpClientModule } from '@angular/common/http';

import { Course } from '../models/Course';
import { UserCourse } from '../models/UserCourse';
import { Achievement } from '../models/Achievement';
import { AchievementService } from '../service/achievement/achievement-service';
import { CourseService } from '../service/Course/course-service';
import { UserCourseService } from '../service/UserCourse/user-course-service';
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
  userCourses$: Observable<UserCourse[]> = of([]);
  wishlistCourses$: Observable<Course[]> = of([]);
  recentAchievements$: Observable<Achievement[]> = of([]);
  upcomingAchievements$: Observable<UpcomingAchievement[]> = of([]);
  weeklyActivity$: Observable<WeeklyActivity[]> = of([]);

  //Notificación flotante
  mensaje: string = '';
  mostrarNotificacion: boolean = false;
  tipoNotificacion: 'exito' | 'error' = 'exito';

  // Propiedades para paginación
  currentPage = 0;
  pageSize = 3;
  totalCourses = 0;

  // Subject para controlar desuscripciones
  private destroy$ = new Subject<void>();

  // ID del usuario actual (deberías obtenerlo del servicio de autenticación)
  private currentUserProfileId = 1; // TODO: Obtener del servicio de autenticación

  constructor(
    private achievementService: AchievementService,
    private courseService: CourseService,
    private userCourseService: UserCourseService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cargarCursosUsuario();
    this.cargarWishlist();
    this.cargarLogros();
    this.cargarActividadSemanal();
  }

  ngOnDestroy(): void {
    // Desuscribirse de todos los observables
    this.destroy$.next();
    this.destroy$.complete();
  }

  // Cargar cursos del usuario actual desde el backend
  cargarCursosUsuario(): void {
    this.userCourses$ = this.userCourseService.findByUserProfileId(this.currentUserProfileId).pipe(
      tap((data) => {
        console.log('Cursos cargados:', data);
        this.mostrarMensaje('Cursos cargados correctamente');
      }),
      catchError((err) => {
        console.error('Error al cargar cursos del usuario:', err);
        this.mostrarMensaje('Error al cargar cursos', 'error');
        return of([]);
      }),
      takeUntil(this.destroy$)
    );
  }

  // Cargar wishlist (ejemplo: backend puede tener endpoint /wishlist)
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

  // Cargar logros desde el backend
  cargarLogros(): void {
    this.achievementService
      .findAll()
      .pipe(
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
      )
      .subscribe();
  }

  // Método para obtener cursos paginados
  getPaginatedCourses(userCourses: UserCourse[] | null): UserCourse[] {
    if (!userCourses) return [];
    this.totalCourses = userCourses.length;
    const startIndex = this.currentPage * this.pageSize;
    return userCourses.slice(startIndex, startIndex + this.pageSize);
  }

  // Getter para pageNumbers
  get pageNumbers(): number[] {
    if (this.totalCourses === 0) return [];
    return Array.from({ length: this.totalPages }, (_, i) => i);
  }

  // Métodos para navegación de paginación
  nextPage(): void {
    const totalPages = Math.ceil(this.totalCourses / this.pageSize);
    if (this.currentPage < totalPages - 1) {
      this.currentPage++;
    }
  }

  previousPage(): void {
    if (this.currentPage > 0) {
      this.currentPage--;
    }
  }

  // Método para ir a una página específica
  goToPage(page: number): void {
    const totalPages = Math.ceil(this.totalCourses / this.pageSize);
    if (page >= 0 && page < totalPages) {
      this.currentPage = page;
    }
  }

  // Getter para obtener el número total de páginas
  get totalPages(): number {
    return Math.ceil(this.totalCourses / this.pageSize);
  }

  // Cargar actividad semanal
  cargarActividadSemanal(): void {
    this.weeklyActivity$ = this.courseService.findWeeklyActivity().pipe(
      catchError((err) => {
        console.error('Error al cargar actividad semanal:', err);
        return of([]);
      }),
      takeUntil(this.destroy$)
    );
  }

  // Mostrar notificaciones flotantes
  mostrarMensaje(texto: string, tipo: 'exito' | 'error' = 'exito'): void {
    this.mensaje = texto;
    this.tipoNotificacion = tipo;
    this.mostrarNotificacion = true;
    setTimeout(() => (this.mostrarNotificacion = false), 2500);
  }

  /**
   * Calcula el progreso del curso basado en UserCourse
   * Prioriza progressPercentage si está disponible,
   * de lo contrario calcula basado en lecciones completadas del Course
   */
  getCourseProgress(userCourse: UserCourse): number {
    // Si tiene progressPercentage en UserCourse, úsalo directamente
    if (userCourse.progressPercentage !== undefined && userCourse.progressPercentage !== null) {
      return Math.round(userCourse.progressPercentage);
    }

    // Si no, calcula basado en lecciones completadas de UserCourse y total de lecciones del Course
    if (userCourse.completedLessons && userCourse.course.lessons) {
      return Math.round((userCourse.completedLessons / userCourse.course.lessons) * 100);
    }

    return 0;
  }

  /**
   * Obtiene el icono del curso según su categoría (desde Course)
   */
  getCourseIcon(userCourse: UserCourse): string {
    const icons: { [key: string]: string } = {
      Frontend: '🚀',
      Backend: '🟢',
      'Data Science': '📊',
      Mobile: '📱',
      DevOps: '⚙',
      Database: '🗄️',
      'Machine Learning': '🤖',
      'Cloud Computing': '☁️',
      Security: '🔒',
      Testing: '🧪',
    };
    return icons[userCourse.course.category] || '📚';
  }

  /**
   * Navega al detalle del curso usando el ID del Course
   */
  openCourse(courseId: number): void {
    this.router.navigate(['/detalle-curso', courseId]);
  }

  /**
   * Convierte el estado de UserCourse a una etiqueta legible
   */
  getStatusLabel(status: string): string {
    const labels: { [key: string]: string } = {
      COMPLETED: 'Completado',
      IN_PROGRESS: 'En progreso',
      NOT_STARTED: 'No iniciado',
      PAUSED: 'Pausado',
    };
    return labels[status] || status;
  }

  /**
   * Formatea la fecha de último acceso de UserCourse
   */
  formatDate(dateString: string): string {
    if (!dateString) return 'Nunca';

    const date = new Date(dateString);
    const now = new Date();
    const diffMs = now.getTime() - date.getTime();
    const diffDays = Math.floor(diffMs / (1000 * 60 * 60 * 24));

    if (diffDays === 0) return 'Hoy';
    if (diffDays === 1) return 'Ayer';
    if (diffDays < 7) return `Hace ${diffDays} días`;
    if (diffDays < 30) return `Hace ${Math.floor(diffDays / 7)} semanas`;
    if (diffDays < 365) return `Hace ${Math.floor(diffDays / 30)} meses`;

    return date.toLocaleDateString('es-ES', {
      year: 'numeric',
      month: 'long',
      day: 'numeric',
    });
  }

  /**
   * Obtiene el color del badge según el nivel del curso (desde Course)
   */
  getLevelColor(level: string): string {
    const colors: { [key: string]: string } = {
      Principiante: '#10b981',
      Intermedio: '#f59e0b',
      Avanzado: '#ef4444',
      Experto: '#8b5cf6',
    };
    return colors[level] || '#6b7280';
  }

  /**
   * Calcula el tiempo estimado restante basado en el progreso de UserCourse
   * y la duración total del Course
   */
  getEstimatedTimeRemaining(userCourse: UserCourse): string {
    if (!userCourse.course.duration) return 'No disponible';

    const progress = this.getCourseProgress(userCourse);
    if (progress === 100) return 'Completado';
    if (progress === 0) return userCourse.course.duration;

    // Extrae las horas de la duración (asume formato "X horas")
    const durationMatch = userCourse.course.duration.match(/(\d+)/);
    if (!durationMatch) return 'No disponible';

    const totalHours = parseInt(durationMatch[1]);
    const remainingHours = Math.ceil((totalHours * (100 - progress)) / 100);

    return `${remainingHours} hora${remainingHours !== 1 ? 's' : ''} restante${
      remainingHours !== 1 ? 's' : ''
    }`;
  }
}
