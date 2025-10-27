// visualizar-tema.component.ts
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DomSanitizer, SafeResourceUrl, SafeUrl } from '@angular/platform-browser';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { environment } from '../../../environment';

// Pipe para sanitizar URLs de recursos
import { Pipe, PipeTransform } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ModuleModel } from '../models/ModuleModel';
import { LearningMethod } from '../models/LearningMethod';
import { CommentModel } from '../models/Comment';
import { Topic } from '../models/Topic';
import { Lesson } from '../models/Lesson';
import { CodeExplanation } from '../models/CodeExplanation';
import { LessonContent } from '../models/LessonContent';

// Servicios
import { ModuleModelService } from '../service/ModuleModel/module-model-service';
import { TopicService } from '../service/Topic/topic-service';
import { LessonService } from '../service/Lesson/lesson-service';
import { CommentModelService } from '../service/CommentModel/comment-model-service';
import { LessonContentService } from '../service/LessonContent/lesson-content-service';

@Pipe({
  name: 'safeResourceUrl',
  standalone: true,
})
export class SafeResourceUrlPipe implements PipeTransform {
  constructor(private sanitizer: DomSanitizer) {}

  transform(url: string): SafeResourceUrl {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }
}

@Pipe({
  name: 'safeUrl',
  standalone: true,
})
export class SafeUrlPipe implements PipeTransform {
  constructor(private sanitizer: DomSanitizer) {}

  transform(url: string): SafeUrl {
    return this.sanitizer.bypassSecurityTrustUrl(url);
  }
}

@Component({
  selector: 'app-visualizar-tema',
  standalone: true,
  imports: [CommonModule, FormsModule, SafeResourceUrlPipe, SafeUrlPipe, HttpClientModule],
  templateUrl: './visualizar-tema-component.html',
  styleUrls: ['./visualizar-tema-component.css'],
})
export class VisualizarTemaComponent implements OnInit {
  // Configuración de JDoodl
  private readonly JDoodleConfig = {
    clientId: environment.clientIdJDoodle,
    clientSecret: environment.clientSecretDoodle,
    apiUrl: 'https://api.jdoodle.com/v1/execute',
  };

  constructor(
    private sanitizer: DomSanitizer,
    private http: HttpClient,
    private router: Router,
    private route: ActivatedRoute,
    private moduleService: ModuleModelService,
    private topicService: TopicService,
    private lessonService: LessonService,
    private lessonContentService: LessonContentService,
    private commentService: CommentModelService,
    private cdRef: ChangeDetectorRef
  ) {}

  // Datos que vendrán del backend
  modules: ModuleModel[] = [];
  learningMethods: LearningMethod[] = [
    {
      id: 'visual',
      name: 'Visual',
      icon: '🎬',
      color: '#ff5a00',
      description: 'Videos, mapas mentales y contenido visual',
    },
    {
      id: 'auditivo',
      name: 'Auditivo',
      icon: '🎧',
      color: '#10b981',
      description: 'Podcasts y explicaciones auditivas',
    },
    {
      id: 'lectura',
      name: 'Lectura',
      icon: '📚',
      color: '#3b82f6',
      description: 'Documentos y artículos detallados',
    },
    {
      id: 'kinestesico',
      name: 'Kinestésico',
      icon: '⌨️',
      color: '#f59e0b',
      description: 'Ejercicios prácticos y código interactivo',
    },
    {
      id: 'mixto',
      name: 'Mixto',
      icon: '🔄',
      color: '#8b5cf6',
      description: 'Combinación de todos los métodos',
    },
  ];

  comments: CommentModel[] = [];

  // Estado del componente
  selectedModule: ModuleModel | null = null;
  selectedTopic: Topic | null = null;
  selectedLesson: Lesson | null = null;
  selectedMethod: LearningMethod = this.learningMethods[0];

  // Código del usuario
  userCode: string = '';
  codeOutput: string = '';
  isCompiling: boolean = false;

  newComment: string = '';
  selectedFile: File | null = null;
  expandedModules: boolean[] = [];
  expandedTopics: boolean[][] = [];

  // Estado de carga
  isLoading: boolean = true;
  error: string | null = null;

  // ID del curso
  courseId: number = 0;

  ngOnInit() {
    // Obtener el ID del curso de los parámetros de la ruta
    this.route.params.subscribe((params) => {
      this.courseId = +params['id'];
      console.log('ID del curso:', this.courseId);
      this.loadData();
    });
  }

  // Cargar datos desde el backend
  loadData(): void {
    this.isLoading = true;
    this.error = null;

    // Cargar módulos del curso
    this.moduleService.findByCourseId(this.courseId).subscribe({
      next: (modules) => {
        this.modules = modules || [];

        if (this.modules.length === 0) {
          this.error = 'No se encontraron módulos para este curso.';
          this.isLoading = false;
          this.cdRef.detectChanges();
          return;
        }

        // Cargar topics para cada módulo
        this.loadTopicsForModules();
      },
      error: (error) => {
        console.error('Error cargando módulos:', error);
        this.error = 'Error al cargar los módulos del curso.';
        this.isLoading = false;
        this.cdRef.detectChanges();
      },
    });
  }

  // Cargar topics para todos los módulos
  private loadTopicsForModules(): void {
    const moduleRequests = this.modules.map((module) =>
      this.topicService.findByModuleId(module.id!).pipe(
        catchError((error) => {
          console.error(`Error cargando topics para módulo ${module.id}:`, error);
          return of([]);
        })
      )
    );

    // Esperar a que todos los requests de topics terminen
    let completedRequests = 0;

    moduleRequests.forEach((request, index) => {
      request.subscribe({
        next: (topics) => {
          this.modules[index].topics = topics || [];
          completedRequests++;

          // Si todos los topics se cargaron, cargar las lessons
          if (completedRequests === moduleRequests.length) {
            this.loadLessonsForTopics();
          }
        },
        error: () => {
          completedRequests++;
          if (completedRequests === moduleRequests.length) {
            this.loadLessonsForTopics();
          }
        },
      });
    });
  }

  // Cargar lessons para todos los topics
  private loadLessonsForTopics(): void {
    const lessonRequests: any[] = [];

    this.modules.forEach((module) => {
      if (module.topics) {
        module.topics.forEach((topic) => {
          if (topic.id) {
            const request = this.lessonService.findByTopicId(topic.id).pipe(
              catchError((error) => {
                console.error(`Error cargando lessons para topic ${topic.id}:`, error);
                return of([]);
              })
            );
            lessonRequests.push({ module, topic, request });
          }
        });
      }
    });

    if (lessonRequests.length === 0) {
      this.finalizeDataLoading();
      return;
    }

    let completedRequests = 0;

    lessonRequests.forEach(({ module, topic, request }) => {
      request.subscribe({
        next: (lessons: Lesson[]) => {
          topic.lessons = lessons || [];
          completedRequests++;

          if (completedRequests === lessonRequests.length) {
            // Cargar contenido para todas las lecciones
            this.loadContentForLessons();
          }
        },
        error: () => {
          completedRequests++;
          if (completedRequests === lessonRequests.length) {
            this.finalizeDataLoading();
          }
        },
      });
    });
  }

  // Cargar contenido para todas las lecciones
  private loadContentForLessons(): void {
    const contentRequests: any[] = [];

    // Recopilar todas las lecciones que necesitan contenido
    this.modules.forEach((module) => {
      if (module.topics) {
        module.topics.forEach((topic) => {
          if (topic.lessons) {
            topic.lessons.forEach((lesson) => {
              if (lesson.id) {
                const request = this.lessonContentService.findByLessonId(lesson.id).pipe(
                  catchError((error) => {
                    console.error(`Error cargando contenido para lección ${lesson.id}:`, error);
                    return of(null);
                  })
                );
                contentRequests.push({ module, topic, lesson, request });
              }
            });
          }
        });
      }
    });

    if (contentRequests.length === 0) {
      this.finalizeDataLoading();
      return;
    }

    let completedRequests = 0;

    contentRequests.forEach(({ module, topic, lesson, request }) => {
      request.subscribe({
        next: (lessonContent: LessonContent | null) => {
          // Asignar el contenido a la lección correspondiente
          if (lessonContent) {
            lesson.content = lessonContent;
          }

          completedRequests++;

          if (completedRequests === contentRequests.length) {
            this.finalizeDataLoading();
          }
        },
        error: () => {
          completedRequests++;
          if (completedRequests === contentRequests.length) {
            this.finalizeDataLoading();
          }
        },
      });
    });
  }

  // Finalizar la carga de datos
  private finalizeDataLoading(): void {
    // Cargar comentarios
    this.commentService.findAll().subscribe({
      next: (comments) => {
        this.comments = comments || [];

        // Inicializar estados expandidos
        this.expandedModules = new Array(this.modules.length).fill(false);
        this.expandedTopics = this.modules.map((module) =>
          new Array(module.topics?.length || 0).fill(false)
        );

        // Seleccionar primer módulo, topic y lesson por defecto
        if (this.modules.length > 0) {
          this.selectModule(this.modules[0]);
          this.expandedModules[0] = true;
        }

        this.isLoading = false;
        this.cdRef.detectChanges();
      },
      error: (error) => {
        console.error('Error cargando comentarios:', error);
        this.comments = [];

        // Inicializar estados expandidos incluso si fallan los comentarios
        this.expandedModules = new Array(this.modules.length).fill(false);
        this.expandedTopics = this.modules.map((module) =>
          new Array(module.topics?.length || 0).fill(false)
        );

        if (this.modules.length > 0) {
          this.selectModule(this.modules[0]);
          this.expandedModules[0] = true;
        }

        this.isLoading = false;
        this.cdRef.detectChanges();
      },
    });
  }

  selectModule(module: ModuleModel): void {
    this.selectedModule = module;
    if (module.topics && module.topics.length > 0) {
      this.selectTopic(module.topics[0]);
    } else {
      this.selectedTopic = null;
      this.selectedLesson = null;
      this.userCode = '';
    }
    this.cdRef.detectChanges();
  }

  selectTopic(topic: Topic): void {
    this.selectedTopic = topic;
    if (topic.lessons && topic.lessons.length > 0) {
      this.selectLesson(topic.lessons[0]);
    } else {
      this.selectedLesson = null;
      this.userCode = '';
    }
    this.cdRef.detectChanges();
  }

  selectLesson(lesson: Lesson): void {
    this.selectedLesson = lesson;

    // Actualizar el código del usuario cuando cambia la lección
    this.updateUserCode();

    this.codeOutput = '';
    this.cdRef.detectChanges();
  }

  // Método para actualizar el código del usuario basado en la lección actual
  private updateUserCode(): void {
    if (!this.selectedLesson) {
      this.userCode = '';
      return;
    }

    // Buscar código en el contenido de la lección
    const lesson = this.selectedLesson;

    if (lesson.content?.code) {
      this.userCode = lesson.content.code;
    } else {
      // Código por defecto si no hay código específico
      this.userCode = `#include <iostream>\nusing namespace std;\n\nint main() {\n    // Escribe tu código aquí\n    cout << "¡Hola Mundo!" << endl;\n    return 0;\n}`;
    }
  }

  selectMethod(method: LearningMethod): void {
    this.selectedMethod = method;
    this.cdRef.detectChanges();
  }

  toggleModule(index: number): void {
    this.expandedModules[index] = !this.expandedModules[index];
    this.cdRef.detectChanges();
  }

  toggleTopic(moduleIndex: number, topicIndex: number): void {
    this.expandedTopics[moduleIndex][topicIndex] = !this.expandedTopics[moduleIndex][topicIndex];
    this.cdRef.detectChanges();
  }

  // Navegar a la siguiente explicación
  nextExplanation(): void {
    if (!this.selectedTopic || !this.selectedLesson || !this.selectedModule) {
      return;
    }

    const currentTopic = this.selectedTopic;
    const currentLessonIndex =
      currentTopic.lessons?.findIndex((lesson) => lesson.id === this.selectedLesson!.id) ?? -1;

    if (currentLessonIndex !== -1 && currentLessonIndex < (currentTopic.lessons?.length || 0) - 1) {
      // Siguiente lección en el mismo tema
      this.selectLesson(currentTopic.lessons![currentLessonIndex + 1]);
    } else {
      // Buscar siguiente tema
      const currentModule = this.selectedModule;
      const currentTopicIndex =
        currentModule.topics?.findIndex((topic) => topic.id === currentTopic.id) ?? -1;

      if (currentTopicIndex !== -1 && currentTopicIndex < (currentModule.topics?.length || 0) - 1) {
        // Siguiente tema en el mismo módulo
        const nextTopic = currentModule.topics![currentTopicIndex + 1];
        this.selectTopic(nextTopic);
      } else {
        // Buscar siguiente módulo
        const currentModuleIndex = this.modules.findIndex(
          (module) => module.id === currentModule.id
        );
        if (currentModuleIndex < this.modules.length - 1) {
          const nextModule = this.modules[currentModuleIndex + 1];
          this.selectModule(nextModule);
        }
      }
    }
  }

  // Compilar y ejecutar código C++ usando el backend Spring Boot
  compileAndRun(): void {
    if (!this.userCode.trim()) {
      this.codeOutput = '❌ No hay código para compilar.';
      return;
    }

    this.isCompiling = true;
    this.codeOutput = '🔄 Compilando y ejecutando código...\n\n';

    // Preparar el código a enviar
    const codeToCompile = this.userCode;

    // Configurar el cuerpo que se enviará al backend
    const requestBody = {
      script: codeToCompile,
      language: 'cpp',
      versionIndex: '0',
      clientId: this.JDoodleConfig.clientId,
      clientSecret: this.JDoodleConfig.clientSecret,
    };

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    // Enviar la petición a tu backend
    this.http
      .post<any>('http://localhost:8080/api/jdoodle/execute', requestBody, { headers })
      .pipe(
        catchError((error) => {
          console.error('Error al comunicarse con el backend:', error);
          return of({
            output: `❌ Error al comunicarse con el servidor: ${error.message}`,
            statusCode: 500,
          });
        })
      )
      .subscribe((response) => {
        this.isCompiling = false;

        try {
          const parsedResponse = typeof response === 'string' ? JSON.parse(response) : response;

          if (parsedResponse.output) {
            this.codeOutput = parsedResponse.output;

            if (parsedResponse.cpuTime) {
              this.codeOutput += `\n⏱️ Tiempo de CPU: ${parsedResponse.cpuTime}s`;
            }
            if (parsedResponse.memory) {
              this.codeOutput += `\n💾 Memoria usada: ${parsedResponse.memory}KB`;
            }

            this.codeOutput += '\n\n✅ Ejecución completada';
          } else {
            this.codeOutput = '✅ Programa compilado exitosamente (sin salida)';
          }
        } catch (e) {
          this.codeOutput = '❌ Error procesando la respuesta del servidor.';
        }
        this.cdRef.detectChanges();
      });
  }

  // Método alternativo usando Judge0 API (opción de respaldo)
  async compileWithJudge0(): Promise<void> {
    if (!this.userCode.trim()) {
      this.codeOutput = '❌ No hay código para compilar.';
      return;
    }

    this.isCompiling = true;
    this.codeOutput = '🔄 Compilando con Judge0 API...\n\n';

    try {
      const response = await fetch('https://api.judge0.com/submissions?wait=true', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          source_code: this.userCode,
          language_id: 54, // C++ (GCC 9.2.0)
          stdin: '',
          expected_output: null,
        }),
      });

      const result = await response.json();

      if (result.compile_output) {
        this.codeOutput = `❌ Error de compilación:\n${result.compile_output}`;
      } else if (result.stderr) {
        this.codeOutput = `❌ Error en tiempo de ejecución:\n${result.stderr}`;
      } else if (result.stdout) {
        this.codeOutput = result.stdout;
        this.codeOutput += '\n\n✅ Ejecución exitosa';
      } else {
        this.codeOutput = '✅ Programa ejecutado (sin salida visible)';
      }
    } catch (error) {
      this.codeOutput = `❌ Error de conexión: ${error}\n\n`;
      this.codeOutput += '💡 Prueba configurando JDoodle o verifica tu conexión a internet.';
    } finally {
      this.isCompiling = false;
      this.cdRef.detectChanges();
    }
  }

  // Método para detectar y sugerir correcciones en el código
  analyzeCode(): void {
    const code = this.userCode;
    const suggestions: string[] = [];

    // Detectar problemas comunes
    if (!code.includes('#include <iostream>') && code.includes('cout')) {
      suggestions.push('• Agrega: #include <iostream> para usar cout');
    }

    if (!code.includes('using namespace std;') && code.includes('cout')) {
      suggestions.push('• Agrega: using namespace std; o usa std::cout');
    }

    if (!code.includes('int main()')) {
      suggestions.push('• Necesitas una función main: int main() { ... }');
    }

    if (code.includes('cin') && !code.includes('>>')) {
      suggestions.push('• Usa cin con el operador >> para leer entrada');
    }

    if (suggestions.length > 0) {
      this.codeOutput = '💡 Sugerencias para tu código:\n' + suggestions.join('\n');
    } else {
      this.codeOutput = '✅ El código parece estar bien estructurado.';
    }
    this.cdRef.detectChanges();
  }

  // Método para limpiar y formatear el código
  formatCode(): void {
    // Simple formateo básico
    let formattedCode = this.userCode
      .replace(/\t/g, '    ') // Reemplazar tabs por espacios
      .replace(/\n\s*\n/g, '\n\n') // Remover líneas vacías múltiples
      .trim();

    // Asegurar que termine con nueva línea
    if (!formattedCode.endsWith('\n')) {
      formattedCode += '\n';
    }

    this.userCode = formattedCode;
    this.cdRef.detectChanges();
  }

  addComment(): void {
    if (this.newComment.trim()) {
      const comment: CommentModel = {
        id: this.comments.length + 1,
        user: 'Tú',
        avatar:
          'https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?w=100&h=100&fit=crop&crop=face',
        text: this.newComment,
        timestamp: new Date(),
        likes: 0,
        image: this.selectedFile ? URL.createObjectURL(this.selectedFile) : undefined,
      };

      // Guardar comentario en el backend
      this.commentService.save(comment).subscribe({
        next: (savedComment) => {
          this.comments.unshift(savedComment);
          this.newComment = '';
          this.selectedFile = null;
          this.cdRef.detectChanges();
        },
        error: (error) => {
          console.error('Error al guardar comentario:', error);
          // Mostrar comentario localmente aunque falle el guardado
          this.comments.unshift(comment);
          this.newComment = '';
          this.selectedFile = null;
          this.cdRef.detectChanges();
        },
      });
    }
  }

  onFileSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      this.selectedFile = file;
      this.cdRef.detectChanges();
    }
  }

  removeFile(): void {
    this.selectedFile = null;
    this.cdRef.detectChanges();
  }

  likeComment(comment: CommentModel): void {
    comment.likes++;
    // Opcional: Actualizar en el backend
    this.commentService.update(comment).subscribe({
      error: (error) => console.error('Error al actualizar like:', error),
    });
    this.cdRef.detectChanges();
  }

  // Método para obtener contenido basado en el método seleccionado
  getCurrentContent(): any {
    if (!this.selectedLesson?.content) {
      console.log('No lesson content available');
      return null;
    }

    const content = this.selectedLesson.content;
    console.log('Current content:', content);
    console.log('Selected method:', this.selectedMethod.id);

    switch (this.selectedMethod.id) {
      case 'visual':
        return content.video || content.mindmap;
      case 'auditivo':
        return content.audio;
      case 'lectura':
        return content.document;
      case 'kinestesico':
        return content.code;
      case 'mixto':
      default:
        // Para mixto, priorizar video, luego código
        return (
          content.video || content.code || content.document || content.audio || content.mindmap
        );
    }
  }

  getContentType(): string {
    const content = this.getCurrentContent();

    if (!content) {
      console.log('No content found for type detection');
      return 'none';
    }

    console.log('Content found for type detection:', content);

    if (typeof content === 'string') {
      if (
        content.includes('youtube') ||
        content.includes('vimeo') ||
        content.includes('video') ||
        content.includes('.mp4') ||
        content.includes('.webm')
      ) {
        return 'video';
      } else if (
        content.includes('audio') ||
        content.includes('.wav') ||
        content.includes('.mp3')
      ) {
        return 'audio';
      } else if (
        content.includes('pdf') ||
        content.includes('document') ||
        content.includes('.doc')
      ) {
        return 'document';
      } else {
        // Si no coincide con otros tipos, asumir que es código
        return 'code';
      }
    }

    return 'code';
  }

  isMethodAvailable(method: LearningMethod): boolean {
    if (!this.selectedLesson?.content) {
      return false;
    }

    const content = this.selectedLesson.content;
    let hasContent = false;

    switch (method.id) {
      case 'visual':
        hasContent = !!(content.video || content.mindmap);
        break;
      case 'auditivo':
        hasContent = !!content.audio;
        break;
      case 'lectura':
        hasContent = !!content.document;
        break;
      case 'kinestesico':
        hasContent = !!content.code;
        break;
      case 'mixto':
        // Mixto está disponible si hay al menos un tipo de contenido
        hasContent = !!(
          content.video ||
          content.audio ||
          content.document ||
          content.code ||
          content.mindmap
        );
        break;
      default:
        hasContent = false;
    }

    console.log(`Method ${method.name} available:`, hasContent);
    return hasContent;
  }

  completeLesson(): void {
    if (!this.selectedLesson || !this.selectedTopic || !this.selectedModule) {
      return;
    }

    this.selectedLesson.completed = true;

    // Actualizar en el backend
    this.lessonService.update(this.selectedLesson).subscribe({
      error: (error) => console.error('Error al actualizar lección:', error),
    });

    // Actualizar progreso del tema
    const allLessonsCompleted =
      this.selectedTopic.lessons?.every((lesson) => lesson.completed) ?? false;
    if (allLessonsCompleted) {
      this.selectedTopic.completed = true;
      this.topicService.update(this.selectedTopic).subscribe({
        error: (error) => console.error('Error al actualizar tema:', error),
      });
    }

    // Actualizar progreso del módulo
    const completedTopics =
      this.selectedModule.topics?.filter((topic) => topic.completed).length || 0;
    const totalTopics = this.selectedModule.topics?.length || 1;
    this.selectedModule.progress = Math.round((completedTopics / totalTopics) * 100);

    if (this.selectedModule.progress === 100) {
      this.selectedModule.completed = true;
    }

    this.moduleService.update(this.selectedModule).subscribe({
      error: (error) => console.error('Error al actualizar módulo:', error),
    });

    this.cdRef.detectChanges();
  }

  // Obtener explicaciones de código si existen
  getCodeExplanations(): CodeExplanation[] {
    return this.selectedLesson?.content?.codeExplanations || [];
  }

  closeSidebar(): void {
    this.router.navigate(['/detalle-curso', this.courseId]);
  }

  openQuiz(): void {
    if (this.selectedLesson?.id) {
      this.router.navigate(['/examen', this.selectedLesson.id]);
    }
  }

  // Método para recargar datos
  reloadData(): void {
    this.loadData();
  }

  // Método para debug: mostrar información de la lección actual
  debugLessonInfo(): void {
    if (this.selectedLesson) {
      console.log('=== DEBUG LESSON INFO ===');
      console.log('Lesson:', this.selectedLesson);
      console.log('Content:', this.selectedLesson.content);
      console.log('Available methods:');
      this.learningMethods.forEach((method) => {
        console.log(`- ${method.name}: ${this.isMethodAvailable(method)}`);
      });
      console.log('Current content:', this.getCurrentContent());
      console.log('Content type:', this.getContentType());
      console.log('=====================');
    }
  }
}
