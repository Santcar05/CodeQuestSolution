import { Component, OnInit } from '@angular/core';
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
  course?: Course;
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
    private router: Router
  ) {}

  ngOnInit(): void {
    const courseId = Number(this.route.snapshot.paramMap.get('id'));
    if (!courseId) {
      this.hasError = true;
      this.isLoading = false;
      return;
    }

    this.loadCourseData(courseId);
  }

  private loadCourseData(courseId: number): void {
    this.courseService.findById(courseId).subscribe({
      next: (data) => {
        this.course = data;

        // Inicializar estados de expansión
        this.expandedModules = new Array(this.course.modules?.length || 0).fill(false);
        this.expandedTopics =
          this.course.modules?.map((module) => new Array(module.topics?.length || 0).fill(false)) ||
          [];

        if (this.expandedModules.length > 0) this.expandedModules[0] = true;

        // Cargar cursos relacionados
        //(TODO: Cambiar el findAll por la lógica de obtener cursos relacionados)
        this.courseService.findAll().subscribe({
          next: (related) => (this.relatedCourses = related),
          error: (err) => console.error('Error cargando cursos relacionados', err),
        });

        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error al cargar el curso', err);
        this.hasError = true;
        this.isLoading = false;
      },
    });
  }

  toggleModule(index: number): void {
    this.expandedModules[index] = !this.expandedModules[index];
  }

  toggleTopic(moduleIndex: number, topicIndex: number): void {
    this.expandedTopics[moduleIndex][topicIndex] = !this.expandedTopics[moduleIndex][topicIndex];
  }

  getTotalLessons(): number {
    if (!this.course) return 0;
    return (
      this.course.modules?.reduce(
        (total, module) =>
          total + module.topics.reduce((topicTotal, topic) => topicTotal + topic.lessons.length, 0),
        0
      ) ?? 0
    );
  }

  getTotalPoints(): number {
    if (!this.course) return 0;
    return this.course.modules?.reduce((total, module) => total + (module.points || 0), 0) ?? 0;
  }

  enrollInCourse(): void {
    if (!this.course) return;
    this.router.navigate(['/visualizar-tema', this.course.id]);
  }
}
