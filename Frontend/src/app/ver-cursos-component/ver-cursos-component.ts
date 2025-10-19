// ver-cursos-component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Router } from '@angular/router';
import { Course } from '../models/Course';

@Component({
  selector: 'app-ver-cursos',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarComponent],
  templateUrl: './ver-cursos-component.html',
  styleUrls: ['./ver-cursos-component.css'],
})
export class VerCursosComponent implements OnInit {
  constructor(private router: Router) {}
  // Search
  searchTerm: string = '';

  // Filter states
  showLevelFilter: boolean = false;
  showCategoryFilter: boolean = false;
  showDurationFilter: boolean = false;
  showSortFilter: boolean = false;

  // Filter options
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

  // Selected filters
  selectedLevels: string[] = [];
  selectedCategories: string[] = [];
  selectedDurations: string[] = [];
  selectedSort: string = 'popular';

  // Courses data
  allCourses: Course[] = [
    {
      id: 1,
      title: 'JavaScript Moderno - De Cero a Experto',
      image: 'https://images.unsplash.com/photo-1579468118864-1b9ea3c0db4a?w=400&h=300&fit=crop',
      level: 'Intermedio',
      rating: 4.8,
      tags: ['JavaScript', 'ES6+', 'Async'],
      duration: '12h',
      students: 15420,
      category: 'Frontend',
      isNew: false,
      description: '',
      totalPoints: 0,
    },
    {
      id: 2,
      title: 'React Pro - Hooks y Context',
      image: 'https://images.unsplash.com/photo-1633356122544-f134324a6cee?w=400&h=300&fit=crop',
      level: 'Avanzado',
      rating: 4.9,
      tags: ['React', 'Hooks', 'Context'],
      duration: '18h',
      students: 23150,
      category: 'Frontend',
      isNew: true,
      description: '',
      totalPoints: 0,
    },
    {
      id: 3,
      title: 'Node.js y Express - Backend Completo',
      image: 'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=400&h=300&fit=crop',
      level: 'Intermedio',
      rating: 4.7,
      tags: ['Node.js', 'Express', 'MongoDB'],
      duration: '15h',
      students: 18790,
      category: 'Backend',
      isNew: false,
      description: '',
      totalPoints: 0,
    },
    {
      id: 4,
      title: 'Python para Data Science',
      image: 'https://images.unsplash.com/photo-1526374965328-7f61d4dc18c5?w=400&h=300&fit=crop',
      level: 'Principiante',
      rating: 4.6,
      tags: ['Python', 'Pandas', 'NumPy'],
      duration: '20h',
      students: 32450,
      category: 'Data Science',
      isNew: false,
      description: '',
      totalPoints: 0,
    },
    {
      id: 5,
      title: 'TypeScript Masterclass',
      image: 'https://images.unsplash.com/photo-1619410283995-43d9134e7656?w=400&h=300&fit=crop',
      level: 'Avanzado',
      rating: 4.9,
      tags: ['TypeScript', 'Types', 'Generics'],
      duration: '14h',
      students: 12890,
      category: 'Frontend',
      isNew: true,
      description: '',
      totalPoints: 0,
    },
    {
      id: 6,
      title: 'Angular Avanzado - Arquitectura',
      image: 'https://images.unsplash.com/photo-1555949963-aa79dcee981c?w=400&h=300&fit=crop',
      level: 'Avanzado',
      rating: 4.8,
      tags: ['Angular', 'RxJS', 'NgRx'],
      duration: '22h',
      students: 9870,
      category: 'Frontend',
      isNew: false,
      description: '',
      totalPoints: 0,
    },
    {
      id: 7,
      title: 'Docker y Kubernetes desde Cero',
      image: 'https://images.unsplash.com/photo-1605745341112-85968b19335b?w=400&h=300&fit=crop',
      level: 'Intermedio',
      rating: 4.7,
      tags: ['Docker', 'Kubernetes', 'DevOps'],
      duration: '16h',
      students: 14560,
      category: 'DevOps',
      isNew: true,
      description: '',
      totalPoints: 0,
    },
    {
      id: 8,
      title: 'Machine Learning con Python',
      image: 'https://images.unsplash.com/photo-1555949963-ff9fe0c870eb?w=400&h=300&fit=crop',
      level: 'Avanzado',
      rating: 4.9,
      tags: ['ML', 'Scikit-learn', 'TensorFlow'],
      duration: '25h',
      students: 11230,
      category: 'IA & ML',
      isNew: true,
      description: '',
      totalPoints: 0,
    },
    {
      id: 9,
      title: 'Flutter - Apps Nativas Multiplataforma',
      image: 'https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c?w=400&h=300&fit=crop',
      level: 'Intermedio',
      rating: 4.6,
      tags: ['Flutter', 'Dart', 'Mobile'],
      duration: '18h',
      students: 16780,
      category: 'Mobile',
      isNew: false,
      description: '',
      totalPoints: 0,
    },
    {
      id: 10,
      title: 'Full Stack MERN - Proyecto Real',
      image: 'https://images.unsplash.com/photo-1581291518857-4e27b48ff24e?w=400&h=300&fit=crop',
      level: 'Avanzado',
      rating: 4.8,
      tags: ['MongoDB', 'Express', 'React', 'Node'],
      duration: '30h',
      students: 19450,
      category: 'Full Stack',
      isNew: true,
      description: '',
      totalPoints: 0,
    },
    {
      id: 11,
      title: 'Vue.js 3 - Composition API',
      image: 'https://images.unsplash.com/photo-1593720213428-28a5b9e94613?w=400&h=300&fit=crop',
      level: 'Intermedio',
      rating: 4.7,
      tags: ['Vue.js', 'Composition', 'Pinia'],
      duration: '13h',
      students: 13240,
      category: 'Frontend',
      isNew: false,
      description: '',
      totalPoints: 0,
    },
    {
      id: 12,
      title: 'AWS Cloud - Arquitectura y Deploy',
      image: 'https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=400&h=300&fit=crop',
      level: 'Avanzado',
      rating: 4.9,
      tags: ['AWS', 'Cloud', 'S3', 'EC2'],
      duration: '20h',
      students: 10890,
      category: 'DevOps',
      isNew: true,
      description: '',
      totalPoints: 0,
    },
  ];

  filteredCourses: Course[] = [];
  totalCourses: number = 0;
  totalStudents: string = '0';

  ngOnInit() {
    this.filteredCourses = [...this.allCourses];
    this.calculateStats();
    this.sortCourses();
  }

  calculateStats() {
    this.totalCourses = this.allCourses.length;
    const total = this.allCourses.reduce((sum, course) => sum + course.students!, 0);
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
    if (index > -1) {
      this.selectedLevels.splice(index, 1);
    } else {
      this.selectedLevels.push(level);
    }
    this.filterCourses();
  }

  toggleCategory(category: string) {
    const index = this.selectedCategories.indexOf(category);
    if (index > -1) {
      this.selectedCategories.splice(index, 1);
    } else {
      this.selectedCategories.push(category);
    }
    this.filterCourses();
  }

  toggleDuration(duration: string) {
    const index = this.selectedDurations.indexOf(duration);
    if (index > -1) {
      this.selectedDurations.splice(index, 1);
    } else {
      this.selectedDurations.push(duration);
    }
    this.filterCourses();
  }

  selectSort(sortValue: string) {
    this.selectedSort = sortValue;
    this.showSortFilter = false;
    this.sortCourses();
  }

  filterCourses() {
    this.filteredCourses = this.allCourses.filter((course) => {
      // Search filter
      const matchesSearch =
        !this.searchTerm ||
        course.title.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        course.tags!.some((tag) => tag.toLowerCase().includes(this.searchTerm.toLowerCase()));

      // Level filter
      const matchesLevel =
        this.selectedLevels.length === 0 || this.selectedLevels.includes(course.level);

      // Category filter
      const matchesCategory =
        this.selectedCategories.length === 0 || this.selectedCategories.includes(course.category);

      // Duration filter
      const matchesDuration =
        this.selectedDurations.length === 0 ||
        this.selectedDurations.some((duration) => this.matchDuration(course.duration!, duration));

      return matchesSearch && matchesLevel && matchesCategory && matchesDuration;
    });

    this.sortCourses();
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
        this.filteredCourses.sort((a, b) => b.students! - a.students!);
        break;
      case 'rating':
        this.filteredCourses.sort((a, b) => b.rating! - a.rating!);
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
