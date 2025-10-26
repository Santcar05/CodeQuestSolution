import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { Course } from '../models/Course';
import { ModuleModel } from '../models/ModuleModel';
import { Topic } from '../models/Topic';
import { Lesson } from '../models/Lesson';
import { LessonContent } from '../models/LessonContent';
import { CourseService } from '../service/Course/course-service';
import { ModuleModelService } from '../service/ModuleModel/module-model-service';
import { TopicService } from '../service/Topic/topic-service';
import { LessonService } from '../service/Lesson/lesson-service';
import { LessonContentService } from '../service/LessonContent/lesson-content-service';

@Component({
  selector: 'app-admin-module-component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './admin-module-component.html',
  styleUrls: ['./admin-module-component.css'],
})
export class AdminModuleComponentComponent implements OnInit {
  course: Course | null = null;
  modules: ModuleModel[] = [];
  filteredModules: ModuleModel[] = [];
  selectedModule: ModuleModel | null = null;
  selectedTopic: Topic | null = null;
  selectedLesson: Lesson | null = null;

  isModuleModalOpen: boolean = false;
  isTopicModalOpen: boolean = false;
  isLessonModalOpen: boolean = false;
  isContentModalOpen: boolean = false;
  isDeleteModalOpen: boolean = false;

  isEditMode: boolean = false;
  deleteType: 'module' | 'topic' | 'lesson' | 'content' = 'module';
  itemToDelete: any = null;

  searchTerm: string = '';
  isLoading: boolean = false;
  showSuccessMessage: boolean = false;
  successMessage: string = '';
  showErrorMessage: boolean = false;
  errorMessage: string = '';

  expandedModules: Set<number> = new Set();
  expandedTopics: Set<number> = new Set();
  activeContentTab: string = 'video';

  newModule: ModuleModel = {
    id: 0,
    title: '',
    description: '',
    duration: '',
    points: 0,
    progress: 0,
    completed: false,
    topics: [],
  };

  newTopic: Topic = {
    id: 0,
    title: '',
    description: '',
    completed: false,
    lessons: [],
  };

  newLesson: Lesson = {
    id: 0,
    title: '',
    duration: '',
    completed: false,
    isPreview: false,
  };

  newLessonContent: LessonContent = {
    video: '',
    audio: '',
    document: '',
    code: '',
    mindmap: '',
    interactive: '',
    codeExplanations: [],
  };

  contentTypes = [
    { value: 'video', label: 'Video', icon: '🎥', color: '#3B82F6' },
    { value: 'audio', label: 'Audio', icon: '🎧', color: '#10B981' },
    { value: 'document', label: 'Documento', icon: '📄', color: '#F59E0B' },
    { value: 'code', label: 'Código', icon: '💻', color: '#8B5CF6' },
    { value: 'mindmap', label: 'Mapa Mental', icon: '🗺️', color: '#EC4899' },
    { value: 'interactive', label: 'Interactivo', icon: '🎮', color: '#EF4444' },
  ];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private courseService: CourseService,
    private moduleService: ModuleModelService,
    private topicService: TopicService,
    private lessonService: LessonService,
    private lessonContentService: LessonContentService,
    private cdRef: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadCourseData();
  }

  loadCourseData(): void {
    this.isLoading = true;
    const courseId = this.route.snapshot.paramMap.get('id');
    console.log('Course ID from route:', courseId);

    if (courseId) {
      this.courseService.findById(parseInt(courseId)).subscribe({
        next: (course) => {
          console.log('Course loaded:', course);
          this.course = course;
          this.loadModules();
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error loading course:', err);
          this.showError('Error al cargar el curso');
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
      });
    }
  }

  loadModules(): void {
    if (!this.course) return;

    console.log('Loading modules for course:', this.course.id);
    this.moduleService.findByCourseId(this.course.id!).subscribe({
      next: (modules) => {
        console.log('Modules loaded:', modules);
        this.modules = modules;
        this.filteredModules = [...modules];
        this.isLoading = false;
        this.cdRef.detectChanges();
      },
      error: (err) => {
        console.error('Error loading modules:', err);
        this.showError('Error al cargar los módulos');
        this.isLoading = false;
        this.cdRef.detectChanges();
      },
    });
  }

  applyFilters(): void {
    if (!this.searchTerm.trim()) {
      this.filteredModules = [...this.modules];
      return;
    }

    this.filteredModules = this.modules.filter(
      (module) =>
        module.title.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        (module.description &&
          module.description.toLowerCase().includes(this.searchTerm.toLowerCase())) ||
        this.hasMatchingTopic(module) ||
        this.hasMatchingLesson(module)
    );
  }

  hasMatchingTopic(module: ModuleModel): boolean {
    return (
      module.topics?.some(
        (topic) =>
          topic.title.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
          (topic.description &&
            topic.description.toLowerCase().includes(this.searchTerm.toLowerCase()))
      ) || false
    );
  }

  hasMatchingLesson(module: ModuleModel): boolean {
    return (
      module.topics?.some((topic) =>
        topic.lessons?.some((lesson) =>
          lesson.title.toLowerCase().includes(this.searchTerm.toLowerCase())
        )
      ) || false
    );
  }

  onSearchChange(): void {
    this.applyFilters();
  }

  toggleModule(moduleId: number): void {
    if (this.expandedModules.has(moduleId)) {
      this.expandedModules.delete(moduleId);
    } else {
      this.expandedModules.add(moduleId);
    }
  }

  toggleTopic(topicId: number): void {
    if (this.expandedTopics.has(topicId)) {
      this.expandedTopics.delete(topicId);
    } else {
      this.expandedTopics.add(topicId);
    }
  }

  // Module Management
  openCreateModuleModal(): void {
    this.isEditMode = false;
    this.newModule = {
      id: 0,
      title: '',
      description: '',
      duration: '',
      points: 100,
      progress: 0,
      completed: false,
      topics: [],
    };
    this.isModuleModalOpen = true;
  }

  openEditModuleModal(module: ModuleModel): void {
    this.isEditMode = true;
    this.newModule = { ...module };
    this.isModuleModalOpen = true;
  }

  closeModuleModal(): void {
    this.isModuleModalOpen = false;
    this.cdRef.detectChanges();
  }

  saveModule(): void {
    if (!this.validateModule()) return;

    this.isLoading = true;

    if (this.isEditMode) {
      this.moduleService.update(this.newModule).subscribe({
        next: (updatedModule) => {
          const index = this.modules.findIndex((m) => m.id === updatedModule.id);
          if (index !== -1) {
            this.modules[index] = updatedModule;
          }
          this.applyFilters();
          this.showSuccess('Módulo actualizado correctamente');
          this.closeModuleModal();
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error updating module:', err);
          this.showError('Error al actualizar el módulo');
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
      });
    } else {
      if (!this.course) return;

      // Para crear un módulo, necesitamos enviar el courseId en el cuerpo
      const moduleToCreate = {
        ...this.newModule,
        courseId: this.course.id,
      };

      this.moduleService.save(moduleToCreate, this.course.id).subscribe({
        next: (createdModule) => {
          this.modules.push(createdModule);
          this.applyFilters();
          this.showSuccess('Módulo creado correctamente');
          this.closeModuleModal();
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error creating module:', err);
          this.showError('Error al crear el módulo');
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
      });
    }
  }

  validateModule(): boolean {
    if (!this.newModule.title.trim()) {
      this.showError('El título del módulo es requerido');
      return false;
    }
    if (!this.newModule.description!.trim()) {
      this.showError('La descripción es requerida');
      return false;
    }
    if (this.newModule.points! < 0) {
      this.showError('Los puntos deben ser positivos');
      return false;
    }
    return true;
  }

  // Topic Management
  openCreateTopicModal(module: ModuleModel): void {
    this.isEditMode = false;
    this.selectedModule = module;
    this.newTopic = {
      id: 0,
      title: '',
      description: '',
      completed: false,
      lessons: [],
    };
    this.isTopicModalOpen = true;
  }

  openEditTopicModal(topic: Topic, module: ModuleModel): void {
    this.isEditMode = true;
    this.selectedModule = module;
    this.newTopic = { ...topic };
    this.isTopicModalOpen = true;
  }

  closeTopicModal(): void {
    this.isTopicModalOpen = false;
    this.selectedModule = null;
    this.cdRef.detectChanges();
  }

  saveTopic(): void {
    if (!this.validateTopic()) return;

    this.isLoading = true;

    if (this.isEditMode) {
      this.topicService.update(this.newTopic).subscribe({
        next: (updatedTopic) => {
          this.updateTopicInModule(updatedTopic);
          this.showSuccess('Tema actualizado correctamente');
          this.closeTopicModal();
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error updating topic:', err);
          this.showError('Error al actualizar el tema');
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
      });
    } else {
      if (!this.selectedModule) return;

      // Para crear un tema, necesitamos enviar el moduleId en el cuerpo
      const topicToCreate = {
        ...this.newTopic,
        moduleId: this.selectedModule.id,
      };

      this.topicService.save(topicToCreate, this.selectedModule.id).subscribe({
        next: (createdTopic) => {
          this.addTopicToModule(createdTopic);
          this.showSuccess('Tema creado correctamente');
          this.closeTopicModal();
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error creating topic:', err);
          this.showError('Error al crear el tema');
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
      });
    }
  }

  updateTopicInModule(updatedTopic: Topic): void {
    const moduleIndex = this.modules.findIndex((m) => m.id === this.selectedModule?.id);
    if (moduleIndex !== -1) {
      const topicIndex =
        this.modules[moduleIndex].topics?.findIndex((t) => t.id === updatedTopic.id) ?? -1;
      if (topicIndex !== -1 && this.modules[moduleIndex].topics) {
        this.modules[moduleIndex].topics![topicIndex] = updatedTopic;
      }
    }
  }

  addTopicToModule(topic: Topic): void {
    const moduleIndex = this.modules.findIndex((m) => m.id === this.selectedModule?.id);
    if (moduleIndex !== -1) {
      if (!this.modules[moduleIndex].topics) {
        this.modules[moduleIndex].topics = [];
      }
      this.modules[moduleIndex].topics!.push(topic);
    }
  }

  validateTopic(): boolean {
    if (!this.newTopic.title.trim()) {
      this.showError('El título del tema es requerido');
      return false;
    }
    return true;
  }

  // Lesson Management
  openCreateLessonModal(topic: Topic): void {
    this.isEditMode = false;
    this.selectedTopic = topic;
    this.newLesson = {
      id: 0,
      title: '',
      duration: '',
      completed: false,
      isPreview: false,
    };
    this.isLessonModalOpen = true;
  }

  openEditLessonModal(lesson: Lesson, topic: Topic): void {
    this.isEditMode = true;
    this.selectedTopic = topic;
    this.newLesson = { ...lesson };
    this.isLessonModalOpen = true;
  }

  closeLessonModal(): void {
    this.isLessonModalOpen = false;
    this.selectedTopic = null;
    this.cdRef.detectChanges();
  }

  saveLesson(): void {
    if (!this.validateLesson()) return;

    this.isLoading = true;

    if (this.isEditMode) {
      this.lessonService.update(this.newLesson).subscribe({
        next: (updatedLesson) => {
          this.updateLessonInTopic(updatedLesson);
          this.showSuccess('Lección actualizada correctamente');
          this.closeLessonModal();
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error updating lesson:', err);
          this.showError('Error al actualizar la lección');
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
      });
    } else {
      if (!this.selectedTopic) return;

      // Para crear una lección, necesitamos enviar el topicId en el cuerpo
      const lessonToCreate = {
        ...this.newLesson,
        topicId: this.selectedTopic.id,
      };

      this.lessonService.save(lessonToCreate, this.selectedTopic.id).subscribe({
        next: (createdLesson) => {
          this.addLessonToTopic(createdLesson);
          this.showSuccess('Lección creada correctamente');
          this.closeLessonModal();
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
        error: (err) => {
          console.error('Error creating lesson:', err);
          this.showError('Error al crear la lección');
          this.isLoading = false;
          this.cdRef.detectChanges();
        },
      });
    }
  }

  updateLessonInTopic(updatedLesson: Lesson): void {
    const moduleIndex = this.modules.findIndex((m) =>
      m.topics?.some((t) => t.id === this.selectedTopic?.id)
    );
    if (moduleIndex !== -1) {
      const topicIndex =
        this.modules[moduleIndex].topics?.findIndex((t) => t.id === this.selectedTopic?.id) ?? -1;
      if (topicIndex !== -1) {
        const lessonIndex =
          this.modules[moduleIndex].topics![topicIndex].lessons?.findIndex(
            (l) => l.id === updatedLesson.id
          ) ?? -1;
        if (lessonIndex !== -1 && this.modules[moduleIndex].topics![topicIndex].lessons) {
          this.modules[moduleIndex].topics![topicIndex].lessons![lessonIndex] = updatedLesson;
        }
      }
    }
  }

  addLessonToTopic(lesson: Lesson): void {
    const moduleIndex = this.modules.findIndex((m) =>
      m.topics?.some((t) => t.id === this.selectedTopic?.id)
    );
    if (moduleIndex !== -1) {
      const topicIndex =
        this.modules[moduleIndex].topics?.findIndex((t) => t.id === this.selectedTopic?.id) ?? -1;
      if (topicIndex !== -1) {
        if (!this.modules[moduleIndex].topics![topicIndex].lessons) {
          this.modules[moduleIndex].topics![topicIndex].lessons = [];
        }
        this.modules[moduleIndex].topics![topicIndex].lessons!.push(lesson);
      }
    }
  }

  validateLesson(): boolean {
    if (!this.newLesson.title.trim()) {
      this.showError('El título de la lección es requerido');
      return false;
    }
    return true;
  }

  // Lesson Content Management
  openContentModal(lesson: Lesson): void {
    this.selectedLesson = lesson;

    if (lesson.content) {
      this.newLessonContent = { ...lesson.content };
    } else {
      this.newLessonContent = {
        video: '',
        audio: '',
        document: '',
        code: '',
        mindmap: '',
        interactive: '',
        codeExplanations: [],
      };
    }

    this.isContentModalOpen = true;
    this.activeContentTab = 'video';
  }

  closeContentModal(): void {
    this.isContentModalOpen = false;
    this.selectedLesson = null;
    this.cdRef.detectChanges();
  }

  saveLessonContent(): void {
    if (!this.selectedLesson) return;

    this.isLoading = true;

    // Para guardar el contenido, necesitamos enviar el lessonId
    const contentToSave = {
      ...this.newLessonContent,
      lessonId: this.selectedLesson.id,
    };

    this.lessonContentService.save(contentToSave).subscribe({
      next: (savedContent) => {
        this.selectedLesson!.content = savedContent;
        this.showSuccess('Contenido guardado correctamente');
        this.closeContentModal();
        this.isLoading = false;
        this.cdRef.detectChanges();
      },
      error: (err) => {
        console.error('Error saving lesson content:', err);
        this.showError('Error al guardar el contenido');
        this.isLoading = false;
        this.cdRef.detectChanges();
      },
    });
  }

  // Delete Management
  openDeleteModal(type: 'module' | 'topic' | 'lesson' | 'content', item: any): void {
    this.deleteType = type;
    this.itemToDelete = item;
    this.isDeleteModalOpen = true;
  }

  closeDeleteModal(): void {
    this.isDeleteModalOpen = false;
    this.itemToDelete = null;
    this.cdRef.detectChanges();
  }

  confirmDelete(): void {
    if (!this.itemToDelete) return;

    this.isLoading = true;

    switch (this.deleteType) {
      case 'module':
        this.moduleService.delete(this.itemToDelete.id).subscribe({
          next: () => {
            this.modules = this.modules.filter((m) => m.id !== this.itemToDelete.id);
            this.applyFilters();
            this.showSuccess('Módulo eliminado correctamente');
            this.closeDeleteModal();
            this.isLoading = false;
            this.cdRef.detectChanges();
          },
          error: (err) => {
            console.error('Error deleting module:', err);
            this.showError('Error al eliminar el módulo');
            this.isLoading = false;
            this.cdRef.detectChanges();
          },
        });
        break;

      case 'topic':
        this.topicService.delete(this.itemToDelete.id).subscribe({
          next: () => {
            this.removeTopicFromModule(this.itemToDelete.id);
            this.showSuccess('Tema eliminado correctamente');
            this.closeDeleteModal();
            this.isLoading = false;
            this.cdRef.detectChanges();
          },
          error: (err) => {
            console.error('Error deleting topic:', err);
            this.showError('Error al eliminar el tema');
            this.isLoading = false;
            this.cdRef.detectChanges();
          },
        });
        break;

      case 'lesson':
        this.lessonService.delete(this.itemToDelete.id).subscribe({
          next: () => {
            this.removeLessonFromTopic(this.itemToDelete.id);
            this.showSuccess('Lección eliminada correctamente');
            this.closeDeleteModal();
            this.isLoading = false;
            this.cdRef.detectChanges();
          },
          error: (err) => {
            console.error('Error deleting lesson:', err);
            this.showError('Error al eliminar la lección');
            this.isLoading = false;
            this.cdRef.detectChanges();
          },
        });
        break;
    }
  }

  removeTopicFromModule(topicId: number): void {
    this.modules.forEach((module) => {
      if (module.topics) {
        module.topics = module.topics.filter((t) => t.id !== topicId);
      }
    });
  }

  removeLessonFromTopic(lessonId: number): void {
    this.modules.forEach((module) => {
      module.topics?.forEach((topic) => {
        if (topic.lessons) {
          topic.lessons = topic.lessons.filter((l) => l.id !== lessonId);
        }
      });
    });
  }

  // Métodos auxiliares para el template
  getTotalLessons(): number {
    return this.modules.reduce((total, module) => {
      const moduleLessons =
        module.topics?.reduce((topicTotal, topic) => {
          return topicTotal + (topic.lessons?.length || 0);
        }, 0) || 0;
      return total + moduleLessons;
    }, 0);
  }

  getTotalPoints(): number {
    return this.modules.reduce((total, module) => total + (module.points || 0), 0);
  }

  getProgressPercentage(module: ModuleModel): number {
    return module.progress || 0;
  }

  getTotalTopics(): number {
    return this.modules.reduce((total, module) => total + (module.topics?.length || 0), 0);
  }

  getItemName(): string {
    if (!this.itemToDelete) return '';

    switch (this.deleteType) {
      case 'module':
        return this.itemToDelete.title;
      case 'topic':
        return this.itemToDelete.title;
      case 'lesson':
        return this.itemToDelete.title;
      case 'content':
        return 'el contenido';
      default:
        return 'este elemento';
    }
  }

  getDeleteMessage(): string {
    switch (this.deleteType) {
      case 'module':
        return 'Esta acción eliminará todos los temas y lecciones asociados y no se puede deshacer.';
      case 'topic':
        return 'Esta acción eliminará todas las lecciones asociadas y no se puede deshacer.';
      case 'lesson':
        return 'Esta acción eliminará todo el contenido asociado y no se puede deshacer.';
      case 'content':
        return 'Esta acción eliminará todo el contenido multimedia y no se puede deshacer.';
      default:
        return 'Esta acción no se puede deshacer.';
    }
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

  goBack(): void {
    this.router.navigate(['/admin/cursos']);
  }
}
