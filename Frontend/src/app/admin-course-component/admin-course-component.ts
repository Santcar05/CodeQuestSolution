import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Course } from '../models/Course';
import { CourseService } from '../service/Course/course-service';

// Importar el servicio cuando esté disponible
// import { CourseService } from '../service/Course/course.service';

@Component({
  selector: 'app-admin-course',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './admin-course-component.html',
  styleUrls: ['./admin-course-component.css'],
})
export class AdminCourseComponent implements OnInit {
  courses: Course[] = [];
  filteredCourses: Course[] = [];
  selectedCourse: Course | null = null;
  isEditMode: boolean = false;
  isModalOpen: boolean = false;
  isDeleteModalOpen: boolean = false;
  isRelationsModalOpen: boolean = false;
  courseToDelete: Course | null = null;
  searchTerm: string = '';
  filterCategory: string = 'all';
  filterLevel: string = 'all';
  filterStatus: string = 'all';
  sortBy: string = 'title';
  isLoading: boolean = false;
  showSuccessMessage: boolean = false;
  successMessage: string = '';
  showErrorMessage: boolean = false;
  errorMessage: string = '';
  viewMode: 'grid' | 'list' = 'grid';

  newCourse: Course = {
    id: 0,
    title: '',
    description: '',
    category: '',
    level: 'beginner',
    rating: 0,
    duration: '',
    students: 0,
    lessons: 0,
    completedLessons: 0,
    nextLesson: '',
    thumbnail: '',
    image: '',
    price: '0',
    originalPrice: '0',
    xp: 0,
    isNew: false,
    isTrending: false,
    status: 'not-started',
    totalPoints: 0,
    difficulty: 'beginner',
    tags: [],
  };

  categories = [
    { value: 'desarrollo', label: 'Desarrollo', icon: '💻', color: '#ff5a00' },
    { value: 'diseno', label: 'Diseño', icon: '🎨', color: '#ec4899' },
    { value: 'datos', label: 'Datos', icon: '📊', color: '#3b82f6' },
    { value: 'negocios', label: 'Negocios', icon: '💼', color: '#10b981' },
    { value: 'marketing', label: 'Marketing', icon: '📢', color: '#f59e0b' },
    { value: 'tecnologia', label: 'Tecnología', icon: '⚙️', color: '#8b5cf6' },
  ];

  levels = [
    { value: 'beginner', label: 'Principiante', icon: '🌱', color: '#10b981' },
    { value: 'intermediate', label: 'Intermedio', icon: '📚', color: '#f59e0b' },
    { value: 'advanced', label: 'Avanzado', icon: '🚀', color: '#ef4444' },
    { value: 'expert', label: 'Experto', icon: '👑', color: '#8b5cf6' },
  ];

  statusOptions = [
    { value: 'not-started', label: 'No Iniciado', icon: '⭕', color: '#94a3b8' },
    { value: 'in-progress', label: 'En Progreso', icon: '🔄', color: '#f59e0b' },
    { value: 'completed', label: 'Completado', icon: '✅', color: '#10b981' },
  ];

  constructor(
    private router: Router,
    private courseService: CourseService,
    private cdRef: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses(): void {
    this.isLoading = true;

    this.courseService.findAll().subscribe({
      next: (courses) => {
        this.courses = courses;
        this.applyFilters();
        this.isLoading = false;
        this.cdRef.detectChanges();
      },
      error: (err) => {
        console.error('Error loading courses:', err);
        this.showError('Error al cargar los cursos');
        this.isLoading = false;
      },
    });
  }

  applyFilters(): void {
    let result = [...this.courses];

    if (this.searchTerm.trim()) {
      result = result.filter(
        (course) =>
          course.title.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
          course.description.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    }

    if (this.filterCategory !== 'all') {
      result = result.filter((course) => course.category === this.filterCategory);
    }

    if (this.filterLevel !== 'all') {
      result = result.filter((course) => course.level === this.filterLevel);
    }

    if (this.filterStatus !== 'all') {
      result = result.filter((course) => course.status === this.filterStatus);
    }

    result.sort((a, b) => {
      switch (this.sortBy) {
        case 'title':
          return a.title.localeCompare(b.title);
        case 'rating':
          return (b.rating || 0) - (a.rating || 0);
        case 'students':
          return (b.students || 0) - (a.students || 0);
        case 'xp':
          return (b.xp || 0) - (a.xp || 0);
        default:
          return 0;
      }
    });

    this.filteredCourses = result;
  }

  onSearchChange(): void {
    this.applyFilters();
  }

  onFilterChange(): void {
    this.applyFilters();
  }

  onSortChange(): void {
    this.applyFilters();
  }

  toggleViewMode(): void {
    this.viewMode = this.viewMode === 'grid' ? 'list' : 'grid';
  }

  openCreateModal(): void {
    this.isEditMode = false;
    this.newCourse = {
      id: 0,
      title: '',
      description: '',
      category: 'desarrollo',
      level: 'beginner',
      rating: 0,
      duration: '',
      students: 0,
      lessons: 0,
      completedLessons: 0,
      nextLesson: '',
      thumbnail: '',
      image: '',
      price: '0',
      originalPrice: '0',
      xp: 0,
      isNew: false,
      isTrending: false,
      status: 'not-started',
      totalPoints: 0,
      difficulty: 'beginner',
      tags: [],
    };
    this.isModalOpen = true;
  }

  openEditModal(course: Course): void {
    this.isEditMode = true;
    this.newCourse = { ...course };
    this.isModalOpen = true;
  }

  closeModal(): void {
    this.isModalOpen = false;
  }

  saveCourse(): void {
    if (!this.validateCourse()) {
      return;
    }

    this.isLoading = true;

    if (this.isEditMode) {
      //Actualizar curso existente
      this.courseService.update(this.newCourse).subscribe({
        next: (updatedCourse) => {
          const index = this.courses.findIndex((c) => c.id === updatedCourse.id);
          if (index !== -1) {
            this.courses[index] = updatedCourse;
          }
          this.applyFilters();
          this.showSuccess('Curso actualizado correctamente');
          this.isModalOpen = false;
          this.isLoading = false; // Finaliza carga
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error al actualizar curso:', err);
          this.showError('Error al actualizar el curso');
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
        complete: () => {
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
      });
    } else {
      // Crear nuevo curso
      this.courseService.save(this.newCourse).subscribe({
        next: (createdCourse) => {
          this.courses.push(createdCourse);
          this.applyFilters();
          this.showSuccess('Curso creado correctamente');
          this.isModalOpen = false;
          this.isLoading = false; //Finaliza carga
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error al crear curso:', err);
          this.showError('Error al crear el curso');
          this.isLoading = false; //Finaliza carga
          this.cdRef.detectChanges();
        },
        complete: () => {
          this.isLoading = false; // Finaliza carga
          this.cdRef.detectChanges();
        },
      });
    }
  }

  validateCourse(): boolean {
    if (!this.newCourse.title.trim()) {
      this.showError('El título del curso es requerido');
      return false;
    }
    if (!this.newCourse.description.trim()) {
      this.showError('La descripción es requerida');
      return false;
    }
    if (this.newCourse.totalPoints < 0) {
      this.showError('Los puntos totales deben ser positivos');
      return false;
    }
    return true;
  }

  openDeleteModal(course: Course): void {
    this.courseToDelete = course;
    this.isDeleteModalOpen = true;
  }

  closeDeleteModal(): void {
    this.isDeleteModalOpen = false;
    this.courseToDelete = null;
  }

  confirmDelete(): void {
    if (this.courseToDelete) {
      this.isLoading = true;

      this.courseService.delete(this.courseToDelete.id).subscribe({
        next: () => {
          this.courses = this.courses.filter((c) => c.id !== this.courseToDelete!.id);
          this.applyFilters();
          this.showSuccess('Curso eliminado exitosamente');
          this.closeDeleteModal();
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error deleting course:', err);
          this.showError('Error al eliminar el curso');
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
      });
    }
  }

  openRelationsModal(course: Course): void {
    this.selectedCourse = course;
    this.isRelationsModalOpen = true;
  }

  closeRelationsModal(): void {
    this.isRelationsModalOpen = false;
    this.selectedCourse = null;
  }

  manageInstructor(course: Course): void {
    this.router.navigate(['/admin/course', course.id, 'instructor']);
  }

  manageModules(course: Course): void {
    this.router.navigate(['/admin/course', course.id, 'modules']);
  }

  manageReviews(course: Course): void {
    this.router.navigate(['/admin/course', course.id, 'reviews']);
  }

  manageLearningPoints(course: Course): void {
    this.router.navigate(['/admin/course', course.id, 'learning-points']);
  }

  manageRequirements(course: Course): void {
    this.router.navigate(['/admin/course', course.id, 'requirements']);
  }

  managePrerequisites(course: Course): void {
    this.router.navigate(['/admin/course', course.id, 'prerequisites']);
  }

  manageTags(course: Course): void {
    this.router.navigate(['/admin/course', course.id, 'tags']);
  }

  showSuccess(message: string): void {
    this.successMessage = message;
    this.showSuccessMessage = true;
    setTimeout(() => {
      this.showSuccessMessage = false;
    }, 3000);
  }

  showError(message: string): void {
    this.errorMessage = message;
    this.showErrorMessage = true;
    setTimeout(() => {
      this.showErrorMessage = false;
    }, 3000);
  }

  getCategoryInfo(category: string) {
    return this.categories.find((c) => c.value === category) || this.categories[0];
  }

  getLevelInfo(level: string) {
    return this.levels.find((l) => l.value === level) || this.levels[0];
  }

  getStatusInfo(status: string | undefined) {
    return this.statusOptions.find((s) => s.value === status) || this.statusOptions[0];
  }

  getCoursesByCategory(category: string): number {
    return this.courses.filter((c) => c.category === category).length;
  }

  getTotalStudents(): number {
    return this.courses.reduce((sum, course) => sum + (course.students || 0), 0);
  }

  getAverageRating(): number {
    const coursesWithRating = this.courses.filter((c) => c.rating && c.rating > 0);
    if (coursesWithRating.length === 0) return 0;
    const sum = coursesWithRating.reduce((acc, course) => acc + (course.rating || 0), 0);
    return Math.round((sum / coursesWithRating.length) * 10) / 10;
  }

  getTotalXP(): number {
    return this.courses.reduce((sum, course) => sum + (course.xp || 0), 0);
  }

  getProgressPercentage(course: Course): number {
    if (!course.lessons || course.lessons === 0) return 0;
    return Math.round(((course.completedLessons || 0) / course.lessons) * 100);
  }

  getDiscountPercentage(course: Course): number {
    if (!course.originalPrice || !course.price) return 0;
    const original = parseFloat(course.originalPrice.replace('$', ''));
    const current = parseFloat(course.price.replace('$', ''));
    if (original === 0) return 0;
    return Math.round(((original - current) / original) * 100);
  }
}
