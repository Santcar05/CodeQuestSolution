import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Router } from '@angular/router';
import { Course } from '../models/Course';
import { CourseService } from '../service/Course/course-service';

@Component({
  selector: 'app-ver-cursos',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarComponent],
  templateUrl: './ver-cursos-component.html',
  styleUrls: ['./ver-cursos-component.css'],
})
export class VerCursosComponent implements OnInit {
  constructor(private router: Router, private courseService: CourseService) {}

  searchTerm: string = '';

  showLevelFilter: boolean = false;
  showCategoryFilter: boolean = false;
  showDurationFilter: boolean = false;
  showSortFilter: boolean = false;

  levels: string[] = ['Principiante', 'Intermedio', 'Avanzado'];
  categories: string[] = [
    'Frontend',
    'Backend',
    'Full Stack',
    'Mobile',
    'Data Science',
    'DevOps',
    'IA & ML',
  ];
  durations: string[] = ['0-5 horas', '5-10 horas', '10-20 horas', '20+ horas'];
  sortOptions = [
    { label: 'Más populares', value: 'popular' },
    { label: 'Mejor valorados', value: 'rating' },
    { label: 'Más recientes', value: 'recent' },
    { label: 'Alfabético A-Z', value: 'az' },
  ];

  selectedLevels: string[] = [];
  selectedCategories: string[] = [];
  selectedDurations: string[] = [];
  selectedSort: string = 'popular';

  allCourses: Course[] = [];
  filteredCourses: Course[] = [];
  totalCourses: number = 0;
  totalStudents: string = '0';

  ngOnInit() {
    this.courseService.findAll().subscribe({
      next: (courses) => {
        this.allCourses = courses;
        this.filteredCourses = [...this.allCourses];
        this.calculateStats();
        this.sortCourses();
      },
      error: (err) => console.error('Error cargando cursos:', err),
    });
  }

  calculateStats() {
    this.totalCourses = this.filteredCourses.length; // Usar filteredCourses en lugar de allCourses
    const total = this.filteredCourses.reduce((sum, course) => sum + (course.students || 0), 0);
    this.totalStudents = this.formatNumber(total);
  }

  formatNumber(num: number): string {
    if (num >= 1000) {
      return (num / 1000).toFixed(1) + 'K';
    }
    return num.toString();
  }

  toggleFilter(filterType: string) {
    switch (filterType) {
      case 'level':
        this.showLevelFilter = !this.showLevelFilter;
        this.showCategoryFilter = false;
        this.showDurationFilter = false;
        this.showSortFilter = false;
        break;
      case 'category':
        this.showCategoryFilter = !this.showCategoryFilter;
        this.showLevelFilter = false;
        this.showDurationFilter = false;
        this.showSortFilter = false;
        break;
      case 'duration':
        this.showDurationFilter = !this.showDurationFilter;
        this.showLevelFilter = false;
        this.showCategoryFilter = false;
        this.showSortFilter = false;
        break;
      case 'sort':
        this.showSortFilter = !this.showSortFilter;
        this.showLevelFilter = false;
        this.showCategoryFilter = false;
        this.showDurationFilter = false;
        break;
    }
  }

  toggleLevel(level: string) {
    const index = this.selectedLevels.indexOf(level);
    if (index > -1) this.selectedLevels.splice(index, 1);
    else this.selectedLevels.push(level);
    this.filterCourses();
  }

  toggleCategory(category: string) {
    const index = this.selectedCategories.indexOf(category);
    if (index > -1) this.selectedCategories.splice(index, 1);
    else this.selectedCategories.push(category);
    this.filterCourses();
  }

  toggleDuration(duration: string) {
    const index = this.selectedDurations.indexOf(duration);
    if (index > -1) this.selectedDurations.splice(index, 1);
    else this.selectedDurations.push(duration);
    this.filterCourses();
  }

  selectSort(sortValue: string) {
    this.selectedSort = sortValue;
    this.showSortFilter = false;
    this.sortCourses();
  }

  filterCourses() {
    // Si no hay cursos, no hacer nada
    if (!this.allCourses || this.allCourses.length === 0) {
      this.filteredCourses = [];
      return;
    }

    this.filteredCourses = this.allCourses.filter((course) => {
      const matchesSearch =
        !this.searchTerm ||
        course.title.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        (course.tags &&
          course.tags.some((tag) => tag.toLowerCase().includes(this.searchTerm.toLowerCase())));

      const matchesLevel =
        this.selectedLevels.length === 0 ||
        (course.level && this.selectedLevels.includes(course.level));

      const matchesCategory =
        this.selectedCategories.length === 0 ||
        (course.category && this.selectedCategories.includes(course.category));

      const matchesDuration =
        this.selectedDurations.length === 0 ||
        (course.duration &&
          this.selectedDurations.some((duration) =>
            this.matchDuration(course.duration!, duration)
          ));

      return matchesSearch && matchesLevel && matchesCategory && matchesDuration;
    });

    this.sortCourses();
    this.calculateStats(); // Actualizar estadísticas después de filtrar
  }

  matchDuration(courseDuration: string, filterDuration: string): boolean {
    const hours = parseInt(courseDuration);
    switch (filterDuration) {
      case '0-5 horas':
        return hours <= 5;
      case '5-10 horas':
        return hours > 5 && hours <= 10;
      case '10-20 horas':
        return hours > 10 && hours <= 20;
      case '20+ horas':
        return hours > 20;
      default:
        return true;
    }
  }

  sortCourses() {
    switch (this.selectedSort) {
      case 'popular':
        this.filteredCourses.sort((a, b) => (b.students || 0) - (a.students || 0));
        break;
      case 'rating':
        this.filteredCourses.sort((a, b) => (b.rating || 0) - (a.rating || 0));
        break;
      case 'recent':
        this.filteredCourses.sort((a, b) => (b.isNew ? 1 : 0) - (a.isNew ? 1 : 0));
        break;
      case 'az':
        this.filteredCourses.sort((a, b) => a.title.localeCompare(b.title));
        break;
    }
  }

  clearSearch() {
    this.searchTerm = '';
    this.filterCourses();
  }

  clearAllFilters() {
    this.searchTerm = '';
    this.selectedLevels = [];
    this.selectedCategories = [];
    this.selectedDurations = [];
    this.selectedSort = 'popular';
    this.filterCourses();
  }

  hasActiveFilters(): boolean {
    return (
      this.searchTerm !== '' ||
      this.selectedLevels.length > 0 ||
      this.selectedCategories.length > 0 ||
      this.selectedDurations.length > 0
    );
  }

  goToCourse(courseId: number) {
    this.router.navigate(['/detalle-curso', courseId]);
  }
}
