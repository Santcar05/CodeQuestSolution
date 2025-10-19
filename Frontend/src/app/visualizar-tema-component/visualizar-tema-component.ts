// visualizar-tema.component.ts
import { Component, OnInit } from '@angular/core';
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
import { Router } from '@angular/router';

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

interface LearningMethod {
  id: string;
  name: string;
  icon: string;
  color: string;
  description: string;
}

interface CodeExplanation {
  line: number;
  code: string;
  explanation: string;
}

interface Lesson {
  id: number;
  title: string;
  duration: string;
  content: {
    video?: string;
    audio?: string;
    document?: string;
    code?: string;
    mindmap?: string;
    interactive?: string;
    codeExplanations?: CodeExplanation[];
  };
  completed: boolean;
  isPreview: boolean;
}

interface Topic {
  id: number;
  title: string;
  description: string;
  lessons: Lesson[];
  completed: boolean;
}

interface Module {
  id: number;
  title: string;
  description: string;
  progress: number;
  topics: Topic[];
  completed: boolean;
}

interface Comment {
  id: number;
  user: string;
  avatar: string;
  text: string;
  timestamp: Date;
  likes: number;
  image?: string;
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
    clientId: environment.clientIdJDoodle, // Regístrate en https://www.jdoodle.com/
    clientSecret: environment.clientSecretDoodle, // Obtén tus credenciales
    apiUrl: 'https://api.jdoodle.com/v1/execute',
  };

  constructor(private sanitizer: DomSanitizer, private http: HttpClient, private router: Router) {}
  // Datos de ejemplo actualizados con explicaciones de código
  modules: Module[] = [
    {
      id: 1,
      title: 'Fundamentos de C++',
      description: 'Aprende los conceptos básicos de C++',
      progress: 75,
      completed: false,
      topics: [
        {
          id: 1,
          title: 'Sintaxis Básica',
          description: 'Estructura fundamental del código C++',
          completed: true,
          lessons: [
            {
              id: 1,
              title: 'Hola Mundo en C++',
              duration: '15 min',
              completed: true,
              isPreview: true,
              content: {
                video: 'https://www.youtube.com/embed/dQw4w9WgXcQ',
                audio: 'https://www.soundjay.com/button/beep-07.wav',
                document: 'https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf',
                code: `#include <iostream>
using namespace std;

int main() {
    cout << "¡Hola Mundo!" << endl;
    return 0;
}`,
                codeExplanations: [
                  {
                    line: 1,
                    code: '#include <iostream>',
                    explanation: 'Incluye la biblioteca estándar de entrada/salida de C++',
                  },
                  {
                    line: 2,
                    code: 'using namespace std;',
                    explanation:
                      'Permite usar elementos de la biblioteca estándar sin el prefijo std::',
                  },
                  {
                    line: 3,
                    code: 'int main() {',
                    explanation: 'Función principal donde comienza la ejecución del programa',
                  },
                  {
                    line: 4,
                    code: '    cout << "¡Hola Mundo!" << endl;',
                    explanation:
                      'Imprime el texto "¡Hola Mundo!" en la consola y añade un salto de línea',
                  },
                  {
                    line: 5,
                    code: '    return 0;',
                    explanation:
                      'Termina la función main indicando que el programa finalizó correctamente',
                  },
                  { line: 6, code: '}', explanation: 'Cierra la función main' },
                ],
              },
            },
            {
              id: 2,
              title: 'Variables y Tipos de Datos',
              duration: '25 min',
              completed: true,
              isPreview: false,
              content: {
                video: 'https://www.youtube.com/embed/dQw4w9WgXcQ',
                code: `#include <iostream>
using namespace std;

int main() {
    // Declaración de variables
    int edad = 25;
    double altura = 1.75;
    char letra = 'A';
    string nombre = "Juan";
    bool esEstudiante = true;
    
    // Mostrar valores
    cout << "Nombre: " << nombre << endl;
    cout << "Edad: " << edad << " años" << endl;
    cout << "Altura: " << altura << " metros" << endl;
    cout << "Letra: " << letra << endl;
    cout << "Es estudiante: " << (esEstudiante ? "Sí" : "No") << endl;
    
    return 0;
}`,
                codeExplanations: [
                  {
                    line: 5,
                    code: 'int edad = 25;',
                    explanation: 'Declara una variable entera llamada "edad" con valor 25',
                  },
                  {
                    line: 6,
                    code: 'double altura = 1.75;',
                    explanation: 'Declara una variable decimal de doble precisión llamada "altura"',
                  },
                  {
                    line: 7,
                    code: 'char letra = "A";',
                    explanation: 'Declara una variable carácter que almacena un solo caracter',
                  },
                  {
                    line: 8,
                    code: 'string nombre = "Juan";',
                    explanation: 'Declara una variable string que almacena texto',
                  },
                  {
                    line: 9,
                    code: 'bool esEstudiante = true;',
                    explanation: 'Declara una variable booleana que puede ser true o false',
                  },
                  {
                    line: 12,
                    code: 'cout << "Nombre: " << nombre << endl;',
                    explanation: 'Concatena y muestra múltiples valores en la consola',
                  },
                ],
              },
            },
          ],
        },
        {
          id: 2,
          title: 'Estructuras de Control',
          description: 'Condicionales y bucles en C++',
          completed: false,
          lessons: [
            {
              id: 3,
              title: 'Condicional if-else',
              duration: '20 min',
              completed: false,
              isPreview: false,
              content: {
                code: `#include <iostream>
using namespace std;

int main() {
    int numero;
    
    cout << "Ingresa un número: ";
    cin >> numero;
    
    if (numero > 0) {
        cout << "El número es positivo" << endl;
    } else if (numero < 0) {
        cout << "El número es negativo" << endl;
    } else {
        cout << "El número es cero" << endl;
    }
    
    return 0;
}`,
                codeExplanations: [
                  {
                    line: 5,
                    code: 'int numero;',
                    explanation: 'Declara una variable entera sin inicializar',
                  },
                  {
                    line: 7,
                    code: 'cout << "Ingresa un número: ";',
                    explanation: 'Muestra un mensaje pidiendo al usuario que ingrese un número',
                  },
                  {
                    line: 8,
                    code: 'cin >> numero;',
                    explanation:
                      'Lee un valor desde el teclado y lo almacena en la variable numero',
                  },
                  {
                    line: 10,
                    code: 'if (numero > 0) {',
                    explanation: 'Condicional que verifica si el número es mayor que cero',
                  },
                  {
                    line: 11,
                    code: '    cout << "El número es positivo" << endl;',
                    explanation: 'Se ejecuta solo si la condición anterior es verdadera',
                  },
                  {
                    line: 12,
                    code: '} else if (numero < 0) {',
                    explanation: 'Condición alternativa si la primera condición es falsa',
                  },
                  {
                    line: 13,
                    code: '    cout << "El número es negativo" << endl;',
                    explanation: 'Se ejecuta si el número es menor que cero',
                  },
                  {
                    line: 14,
                    code: '} else {',
                    explanation:
                      'Bloque que se ejecuta si todas las condiciones anteriores son falsas',
                  },
                  {
                    line: 15,
                    code: '    cout << "El número es cero" << endl;',
                    explanation: 'Se ejecuta cuando el número es exactamente cero',
                  },
                ],
              },
            },
          ],
        },
      ],
    },
  ];

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

  comments: Comment[] = [
    {
      id: 1,
      user: 'Ana Martínez',
      avatar:
        'https://images.unsplash.com/photo-1438761681033-6461ffad8d80?w=100&h=100&fit=crop&crop=face',
      text: 'Excelente explicación sobre la sintaxis básica. Me ayudó mucho a entender la estructura del código.',
      timestamp: new Date('2024-01-15T10:30:00'),
      likes: 12,
    },
  ];

  // Estado del componente
  selectedModule: Module = this.modules[0];
  selectedTopic: Topic = this.modules[0].topics[0];
  selectedLesson: Lesson = this.modules[0].topics[0].lessons[0];
  selectedMethod: LearningMethod = this.learningMethods[0];

  // Código del usuario
  userCode: string = '';
  codeOutput: string = '';
  isCompiling: boolean = false;

  newComment: string = '';
  selectedFile: File | null = null;
  expandedModules: boolean[] = [];
  expandedTopics: boolean[][] = [];

  ngOnInit() {
    // Inicializar estados expandidos
    this.expandedModules = new Array(this.modules.length).fill(false);
    this.expandedTopics = this.modules.map((module) => new Array(module.topics.length).fill(false));

    // Expandir el primer módulo y tema por defecto
    if (this.expandedModules.length > 0) {
      this.expandedModules[0] = true;
    }
    if (this.expandedTopics[0]?.length > 0) {
      this.expandedTopics[0][0] = true;
    }

    // Inicializar el código del usuario con el código de ejemplo
    if (this.selectedLesson.content.code) {
      this.userCode = this.selectedLesson.content.code;
    }
  }

  selectModule(module: Module): void {
    this.selectedModule = module;
    if (module.topics.length > 0) {
      this.selectTopic(module.topics[0]);
    }
  }

  selectTopic(topic: Topic): void {
    this.selectedTopic = topic;
    if (topic.lessons.length > 0) {
      this.selectLesson(topic.lessons[0]);
    }
  }

  selectLesson(lesson: Lesson): void {
    this.selectedLesson = lesson;
    // Actualizar el código del usuario cuando cambia la lección
    if (lesson.content.code) {
      this.userCode = lesson.content.code;
    } else {
      this.userCode = '';
    }
    this.codeOutput = '';
  }

  selectMethod(method: LearningMethod): void {
    this.selectedMethod = method;
  }

  toggleModule(index: number): void {
    this.expandedModules[index] = !this.expandedModules[index];
  }

  toggleTopic(moduleIndex: number, topicIndex: number): void {
    this.expandedTopics[moduleIndex][topicIndex] = !this.expandedTopics[moduleIndex][topicIndex];
  }

  // Navegar a la siguiente explicación
  nextExplanation(): void {
    const currentTopic = this.selectedTopic;
    const currentLessonIndex = currentTopic.lessons.findIndex(
      (lesson) => lesson.id === this.selectedLesson.id
    );

    if (currentLessonIndex < currentTopic.lessons.length - 1) {
      // Siguiente lección en el mismo tema
      this.selectLesson(currentTopic.lessons[currentLessonIndex + 1]);
    } else {
      // Buscar siguiente tema
      const currentModule = this.selectedModule;
      const currentTopicIndex = currentModule.topics.findIndex(
        (topic) => topic.id === currentTopic.id
      );

      if (currentTopicIndex < currentModule.topics.length - 1) {
        // Siguiente tema en el mismo módulo
        const nextTopic = currentModule.topics[currentTopicIndex + 1];
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

  // Compilar y ejecutar código C++
  // Compilar y ejecutar código C++ usando el backend Spring Boot
  compileAndRun(): void {
    this.isCompiling = true;
    this.codeOutput = '🔄 Compilando y ejecutando código...\n\n';

    // Preparar el código a enviar
    const codeToCompile = this.userCode;

    // Configurar el cuerpo que se enviará al backend
    const requestBody = {
      script: codeToCompile,
      language: 'cpp',
      versionIndex: '0', // versión más reciente de C++
      clientId: this.JDoodleConfig.clientId,
      clientSecret: this.JDoodleConfig.clientSecret,
    };

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    // Enviar la petición a tu backend (NO directamente a JDoodle)
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
      });
  }

  // Método alternativo usando Judge0 API (opción de respaldo)
  async compileWithJudge0(): Promise<void> {
    this.isCompiling = true;
    this.codeOutput = '🔄 Compilando con Judge0 API...\n\n';

    try {
      // Judge0 es otra API gratuita para compilar código
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
    }
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
  }

  addComment(): void {
    if (this.newComment.trim()) {
      const comment: Comment = {
        id: this.comments.length + 1,
        user: 'Tú',
        avatar:
          'https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?w=100&h=100&fit=crop&crop=face',
        text: this.newComment,
        timestamp: new Date(),
        likes: 0,
        image: this.selectedFile ? URL.createObjectURL(this.selectedFile) : undefined,
      };

      this.comments.unshift(comment);
      this.newComment = '';
      this.selectedFile = null;
    }
  }

  onFileSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      this.selectedFile = file;
    }
  }

  removeFile(): void {
    this.selectedFile = null;
  }

  likeComment(comment: Comment): void {
    comment.likes++;
  }

  getCurrentContent(): any {
    const content = this.selectedLesson.content;

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
        return content.video;
    }
  }

  getContentType(): string {
    const content = this.getCurrentContent();
    if (!content) return 'none';

    if (typeof content === 'string') {
      if (content.includes('youtube') || content.includes('video')) return 'video';
      if (content.includes('audio') || content.includes('.wav') || content.includes('.mp3'))
        return 'audio';
      if (content.includes('pdf') || content.includes('document')) return 'document';
    }

    return 'code';
  }

  isMethodAvailable(method: LearningMethod): boolean {
    const content = this.selectedLesson.content;

    switch (method.id) {
      case 'visual':
        return !!(content.video || content.mindmap);
      case 'auditivo':
        return !!content.audio;
      case 'lectura':
        return !!content.document;
      case 'kinestesico':
        return !!content.code;
      case 'mixto':
        return true;
      default:
        return false;
    }
  }

  completeLesson(): void {
    this.selectedLesson.completed = true;

    // Actualizar progreso del tema
    const allLessonsCompleted = this.selectedTopic.lessons.every((lesson) => lesson.completed);
    if (allLessonsCompleted) {
      this.selectedTopic.completed = true;
    }

    // Actualizar progreso del módulo
    const completedTopics = this.selectedModule.topics.filter((topic) => topic.completed).length;
    this.selectedModule.progress = Math.round(
      (completedTopics / this.selectedModule.topics.length) * 100
    );

    if (this.selectedModule.progress === 100) {
      this.selectedModule.completed = true;
    }
  }

  // Obtener explicaciones de código si existen
  getCodeExplanations(): CodeExplanation[] {
    return this.selectedLesson.content.codeExplanations || [];
  }

  closeSidebar(): void {
    this.router.navigate(['/detalle-curso', this.selectedTopic.id]);
  }

  openQuiz(): void {
    this.router.navigate(['/examen', this.selectedLesson.id]);
  }
}
