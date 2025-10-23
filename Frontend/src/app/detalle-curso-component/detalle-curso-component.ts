import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../models/Course';
import { CourseService } from '../service/Course/course-service';

@Component({
  selector: 'app-detalle-curso',
  standalone: true,
  imports: [CommonModule, SidebarComponent],
  templateUrl: './detalle-curso-component.html',
  styleUrls: ['./detalle-curso-component.css'],
})
export class DetalleCursoComponent implements OnInit {
  course: Course | null = null; // Inicializar como null
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

  constructor(
    private courseService: CourseService,
    private route: ActivatedRoute,
    private router: Router,
    private cdRef: ChangeDetectorRef // Agregar ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    const courseId = Number(this.route.snapshot.paramMap.get('id'));
    if (!courseId || isNaN(courseId)) {
      this.hasError = true;
      this.isLoading = false;
      this.cdRef.detectChanges(); // Forzar detección de cambios
      return;
    }

    this.loadCourseData(courseId);
  }

  private loadCourseData(courseId: number): void {
    this.isLoading = true;
    this.hasError = false;

    this.courseService.findById(courseId).subscribe({
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
        this.cdRef.detectChanges(); // Forzar detección de cambios después de cargar
      },
      error: (err) => {
        console.error('Error al cargar el curso', err);
        this.hasError = true;
        this.isLoading = false;
        this.course = null;
        this.cdRef.detectChanges(); // Forzar detección de cambios en error
      },
    });
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
    this.courseService.findAll().subscribe({
      next: (related) => {
        this.relatedCourses = related;
        this.cdRef.detectChanges(); // Forzar detección de cambios
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
    this.router.navigate(['/visualizar-tema', this.course.id]);
  }
}
