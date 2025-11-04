import { Component, OnInit, ChangeDetectorRef, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../models/Course';
import { CourseService } from '../service/Course/course-service';
import { UserCourse } from '../models/UserCourse';
import { UserCourseService } from '../service/UserCourse/user-course-service';
import { UserProfileService } from '../service/UserProfile/user-profile-service';
import { Subject, takeUntil } from 'rxjs';

@Component({
  selector: 'app-detalle-curso',
  standalone: true,
  imports: [CommonModule, SidebarComponent],
  templateUrl: './detalle-curso-component.html',
  styleUrls: ['./detalle-curso-component.css'],
})
export class DetalleCursoComponent implements OnInit, OnDestroy {
  course: Course | null = null;
  relatedCourses: Course[] = [];

  expandedModules: boolean[] = [];
  expandedTopics: boolean[][] = [];

  ratingDistribution = [
    { stars: 5, percentage: 72 },
    { stars: 4, percentage: 18 },
    { stars: 3, percentage: 6 },
    { stars: 2, percentage: 3 },
    { stars: 1, percentage: 1 },
  ];

  isLoading = true;
  hasError = false;

  private destroy$ = new Subject<void>();

  constructor(
    private courseService: CourseService,
    private route: ActivatedRoute,
    private router: Router,
    private cdRef: ChangeDetectorRef,
    private userCourseService: UserCourseService,
    private userProfileService: UserProfileService
  ) {}

  ngOnInit(): void {
    // Suscribirse a cambios en los parámetros de la ruta
    this.route.paramMap.pipe(takeUntil(this.destroy$)).subscribe((params) => {
      const courseId = Number(params.get('id'));
      if (!courseId || isNaN(courseId)) {
        this.hasError = true;
        this.isLoading = false;
        this.cdRef.detectChanges();
        return;
      }

      this.loadCourseData(courseId);
    });
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  loadCourseDataFromRoute() {
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      const courseId = Number(idParam); // Conversión aquí
      this.loadCourseData(courseId);
    }
  }

  loadCourseData(courseId: number): void {
    // Resetear estado antes de cargar nuevo curso
    this.resetComponentState();

    this.isLoading = true;
    this.hasError = false;

    this.courseService
      .findById(courseId)
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (data) => {
          this.course = data;

          // Inicializar estados de expansión de forma segura
          this.initializeExpansionStates();

          if (this.expandedModules.length > 0) {
            this.expandedModules[0] = true;
          }

          // Cargar cursos relacionados
          this.loadRelatedCourses();

          this.isLoading = false;
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error al cargar el curso', err);
          this.hasError = true;
          this.isLoading = false;
          this.course = null;
          this.cdRef.detectChanges();
        },
      });
  }

  private resetComponentState(): void {
    this.course = null;
    this.relatedCourses = [];
    this.expandedModules = [];
    this.expandedTopics = [];
    this.isLoading = true;
    this.hasError = false;
  }

  private initializeExpansionStates(): void {
    // Inicializar arrays de expansión de forma segura
    const modulesCount = this.course?.modules?.length || 0;
    this.expandedModules = new Array(modulesCount).fill(false);

    this.expandedTopics = [];
    if (this.course?.modules) {
      for (let i = 0; i < modulesCount; i++) {
        const topicsCount = this.course.modules[i]?.topics?.length || 0;
        this.expandedTopics.push(new Array(topicsCount).fill(false));
      }
    }
  }

  private loadRelatedCourses(): void {
    this.courseService
      .findAll()
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (related) => {
          this.relatedCourses = related;
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error cargando cursos relacionados', err);
          this.relatedCourses = [];
        },
      });
  }

  toggleModule(index: number): void {
    if (index >= 0 && index < this.expandedModules.length) {
      this.expandedModules[index] = !this.expandedModules[index];
    }
  }

  toggleTopic(moduleIndex: number, topicIndex: number): void {
    if (
      moduleIndex >= 0 &&
      moduleIndex < this.expandedTopics.length &&
      topicIndex >= 0 &&
      topicIndex < this.expandedTopics[moduleIndex]?.length
    ) {
      this.expandedTopics[moduleIndex][topicIndex] = !this.expandedTopics[moduleIndex][topicIndex];
    }
  }

  getTotalLessons(): number {
    if (!this.course?.modules) return 0;

    return this.course.modules.reduce((total, module) => {
      const moduleLessons =
        module.topics?.reduce((topicTotal, topic) => {
          return topicTotal + (topic.lessons?.length || 0);
        }, 0) || 0;
      return total + moduleLessons;
    }, 0);
  }

  getTotalPoints(): number {
    if (!this.course?.modules) return 0;
    return this.course.modules.reduce((total, module) => total + (module.points || 0), 0);
  }

  enrollInCourse(): void {
    if (!this.course?.id) return;

    this.userProfileService
      .findById(1)
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (userProfile) => {
          const now = new Date().toISOString();

          const userCourse: UserCourse = {
            userProfile: { id: userProfile.id } as any,
            course: { id: this.course!.id } as any,
            status: 'IN_PROGRESS',
            completedLessons: 0,
            nextLesson: '',
            startedAt: now,
            completedAt: null,
            lastAccessed: now,
            progressPercentage: 0,
            currentModule: '',
            currentLesson: '',
            rating: 0,
            isFavorite: false,
            notes: '',
          };

          console.log('📤 Enviando JSON:', JSON.stringify(userCourse, null, 2));

          //TODO:Revisar si el usuario ya estaba inscrito antes de crear uno nuevo

          this.userCourseService
            .save(userCourse)
            .pipe(takeUntil(this.destroy$))
            .subscribe({
              next: (data) => {
                console.log('✅ Inscripción exitosa', data);
                this.router.navigate(['/visualizar-tema', this.course!.id]);
              },
              error: (err) => {
                console.error('❌ Error al inscribir en el curso', err);
                console.error('Detalles del error:', err.error);
                console.error('Status:', err.status);
              },
            });
        },
        error: (err) => {
          console.error('❌ Error al obtener el perfil del usuario', err);
        },
      });
  }

  openCourse(courseId: number): void {
    // Navegar directamente sin recargar la página
    this.router.navigate(['/detalle-curso', courseId]);
  }
}
