// logros-component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from '../sidebar-component/sidebar-component';

interface Logro {
  id: number;
  nombre: string;
  descripcion: string;
  categoria: string;
  rareza: 'Común' | 'Raro' | 'Épico' | 'Legendario' | 'Mítico';
  puntos: number;
  imagen: string;
  desbloqueado: boolean;
  requisitos: string;
  fechaDesbloqueo?: Date;
}

@Component({
  selector: 'app-logros-component',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarComponent],
  templateUrl: './logros-component.html',
  styleUrls: ['./logros-component.css'],
})
export class LogrosComponent implements OnInit {
  // Search
  searchTerm: string = '';

  // Filter states
  showCategoriaFilter: boolean = false;
  showRarezaFilter: boolean = false;
  showEstadoFilter: boolean = false;
  showSortFilter: boolean = false;

  // Filter options
  categorias: string[] = [
    'Progreso',
    'Tecnología',
    'Comunidad',
    'Aprendizaje',
    'Proyectos',
    'Retos',
    'Especiales',
    'Temporada',
  ];
  rarezas: string[] = ['Común', 'Raro', 'Épico', 'Legendario', 'Mítico'];
  estados: string[] = ['Desbloqueados', 'Por desbloquear'];
  sortOptions = [
    { label: 'Más recientes', value: 'recent' },
    { label: 'Puntos (alto a bajo)', value: 'points' },
    { label: 'Rareza', value: 'rarity' },
    { label: 'Alfabético A-Z', value: 'az' },
  ];

  // Selected filters
  selectedCategorias: string[] = [];
  selectedRarezas: string[] = [];
  selectedEstados: string[] = [];
  selectedSort: string = 'recent';

  // Logros data
  allLogros: Logro[] = [
    // Logros de Progreso (15)
    {
      id: 1,
      nombre: 'Primeros Pasos',
      descripcion: 'Completa tu primer curso en CodeQuest',
      categoria: 'Progreso',
      rareza: 'Común',
      puntos: 50,
      imagen: '🎯',
      desbloqueado: true,
      requisitos: 'Completar cualquier curso',
      fechaDesbloqueo: new Date('2024-01-15'),
    },
    {
      id: 2,
      nombre: 'Aprendiz Dedicado',
      descripcion: 'Completa 5 cursos diferentes',
      categoria: 'Progreso',
      rareza: 'Común',
      puntos: 150,
      imagen: '📚',
      desbloqueado: true,
      requisitos: 'Completar 5 cursos',
      fechaDesbloqueo: new Date('2024-02-20'),
    },
    {
      id: 3,
      nombre: 'Maestro del Conocimiento',
      descripcion: 'Completa 25 cursos en CodeQuest',
      categoria: 'Progreso',
      rareza: 'Raro',
      puntos: 500,
      imagen: '🎓',
      desbloqueado: false,
      requisitos: 'Completar 25 cursos',
    },
    {
      id: 4,
      nombre: 'Leyenda del Aprendizaje',
      descripcion: 'Completa 100 cursos en la plataforma',
      categoria: 'Progreso',
      rareza: 'Legendario',
      puntos: 2500,
      imagen: '🏆',
      desbloqueado: false,
      requisitos: 'Completar 100 cursos',
    },
    {
      id: 5,
      nombre: 'Racha de 7 Días',
      descripcion: 'Aprende durante 7 días consecutivos',
      categoria: 'Progreso',
      rareza: 'Común',
      puntos: 100,
      imagen: '🔥',
      desbloqueado: true,
      requisitos: '7 días consecutivos aprendiendo',
      fechaDesbloqueo: new Date('2024-03-01'),
    },
    {
      id: 6,
      nombre: 'Meses de Dedicación',
      descripcion: 'Aprende durante 3 meses consecutivos',
      categoria: 'Progreso',
      rareza: 'Raro',
      puntos: 750,
      imagen: '🗓️',
      desbloqueado: false,
      requisitos: '3 meses consecutivos aprendiendo',
    },
    {
      id: 7,
      nombre: 'Año de Sabiduría',
      descripcion: 'Aprende durante 12 meses consecutivos',
      categoria: 'Progreso',
      rareza: 'Legendario',
      puntos: 5000,
      imagen: '🌟',
      desbloqueado: false,
      requisitos: '12 meses consecutivos aprendiendo',
    },
    {
      id: 8,
      nombre: 'Velocidad del Rayo',
      descripcion: 'Completa un curso en menos de 24 horas',
      categoria: 'Progreso',
      rareza: 'Épico',
      puntos: 1000,
      imagen: '⚡',
      desbloqueado: false,
      requisitos: 'Curso completado en <24h',
    },
    {
      id: 9,
      nombre: 'Perfeccionista',
      descripcion: 'Obtén 100% en todos los quizzes de un curso',
      categoria: 'Progreso',
      rareza: 'Raro',
      puntos: 300,
      imagen: '💯',
      desbloqueado: true,
      requisitos: '100% en todos los quizzes',
      fechaDesbloqueo: new Date('2024-02-10'),
    },
    {
      id: 10,
      nombre: 'Coleccionista de Cursos',
      descripcion: 'Inscríbete en 50 cursos diferentes',
      categoria: 'Progreso',
      rareza: 'Épico',
      puntos: 1200,
      imagen: '📦',
      desbloqueado: false,
      requisitos: 'Inscribirse en 50 cursos',
    },
    {
      id: 11,
      nombre: 'Explorador del Conocimiento',
      descripcion: 'Completa cursos en 5 categorías diferentes',
      categoria: 'Progreso',
      rareza: 'Raro',
      puntos: 400,
      imagen: '🧭',
      desbloqueado: false,
      requisitos: 'Cursos en 5 categorías',
    },
    {
      id: 12,
      nombre: 'Polímata Digital',
      descripcion: 'Domina 10 categorías diferentes',
      categoria: 'Progreso',
      rareza: 'Legendario',
      puntos: 3000,
      imagen: '🎭',
      desbloqueado: false,
      requisitos: 'Cursos en 10 categorías',
    },
    {
      id: 13,
      nombre: 'Sin Descanso',
      descripcion: 'Completa 10 horas de aprendizaje continuo',
      categoria: 'Progreso',
      rareza: 'Épico',
      puntos: 800,
      imagen: '⏳',
      desbloqueado: false,
      requisitos: '10 horas continuas aprendiendo',
    },
    {
      id: 14,
      nombre: 'Madrugador del Código',
      descripcion: 'Aprende antes de las 6 AM',
      categoria: 'Progreso',
      rareza: 'Raro',
      puntos: 250,
      imagen: '🌅',
      desbloqueado: false,
      requisitos: 'Sesión antes de las 6 AM',
    },
    {
      id: 15,
      nombre: 'Noctámbulo Digital',
      descripcion: 'Aprende después de la medianoche',
      categoria: 'Progreso',
      rareza: 'Raro',
      puntos: 250,
      imagen: '🌙',
      desbloqueado: true,
      requisitos: 'Sesión después de medianoche',
      fechaDesbloqueo: new Date('2024-03-05'),
    },

    // Logros de Tecnología (15)
    {
      id: 16,
      nombre: 'Hola Mundo',
      descripcion: 'Completa tu primer programa en cualquier lenguaje',
      categoria: 'Tecnología',
      rareza: 'Común',
      puntos: 50,
      imagen: '👋',
      desbloqueado: true,
      requisitos: 'Primer programa completado',
      fechaDesbloqueo: new Date('2024-01-10'),
    },
    {
      id: 17,
      nombre: 'Maestro JavaScript',
      descripcion: 'Domina todos los conceptos avanzados de JavaScript',
      categoria: 'Tecnología',
      rareza: 'Épico',
      puntos: 1500,
      imagen: '⚡',
      desbloqueado: false,
      requisitos: 'Completar ruta JavaScript',
    },
    {
      id: 18,
      nombre: 'Rey de React',
      descripcion: 'Crea 10 aplicaciones con React',
      categoria: 'Tecnología',
      rareza: 'Raro',
      puntos: 600,
      imagen: '⚛️',
      desbloqueado: false,
      requisitos: '10 apps con React',
    },
    {
      id: 19,
      nombre: 'Ninja de Python',
      descripcion: 'Resuelve 100 problemas con Python',
      categoria: 'Tecnología',
      rareza: 'Épico',
      puntos: 1200,
      imagen: '🐍',
      desbloqueado: false,
      requisitos: '100 problemas en Python',
    },
    {
      id: 20,
      nombre: 'Full Stack Developer',
      descripcion: 'Domina tanto frontend como backend',
      categoria: 'Tecnología',
      rareza: 'Legendario',
      puntos: 3000,
      imagen: '🚀',
      desbloqueado: false,
      requisitos: 'Completar rutas frontend y backend',
    },
    {
      id: 21,
      nombre: 'Mobile First',
      descripcion: 'Crea 5 aplicaciones móviles',
      categoria: 'Tecnología',
      rareza: 'Raro',
      puntos: 750,
      imagen: '📱',
      desbloqueado: false,
      requisitos: '5 apps móviles',
    },
    {
      id: 22,
      nombre: 'Cloud Architect',
      descripcion: 'Despliega 10 proyectos en la nube',
      categoria: 'Tecnología',
      rareza: 'Épico',
      puntos: 1800,
      imagen: '☁️',
      desbloqueado: false,
      requisitos: '10 deployments en cloud',
    },
    {
      id: 23,
      nombre: 'Database Master',
      descripcion: 'Domina 3 sistemas de bases de datos diferentes',
      categoria: 'Tecnología',
      rareza: 'Raro',
      puntos: 900,
      imagen: '🗄️',
      desbloqueado: false,
      requisitos: '3 DB systems diferentes',
    },
    {
      id: 24,
      nombre: 'DevOps Engineer',
      descripcion: 'Automatiza el deployment de 5 proyectos',
      categoria: 'Tecnología',
      rareza: 'Épico',
      puntos: 1600,
      imagen: '🔧',
      desbloqueado: false,
      requisitos: '5 CI/CD pipelines',
    },
    {
      id: 25,
      nombre: 'AI Explorer',
      descripcion: 'Completa 3 proyectos de machine learning',
      categoria: 'Tecnología',
      rareza: 'Legendario',
      puntos: 2500,
      imagen: '🤖',
      desbloqueado: false,
      requisitos: '3 proyectos de ML',
    },
    {
      id: 26,
      nombre: 'Blockchain Pioneer',
      descripcion: 'Crea tu primer smart contract',
      categoria: 'Tecnología',
      rareza: 'Épico',
      puntos: 1400,
      imagen: '⛓️',
      desbloqueado: false,
      requisitos: 'Smart contract deployado',
    },
    {
      id: 27,
      nombre: 'Game Developer',
      descripcion: 'Desarrolla 3 videojuegos funcionales',
      categoria: 'Tecnología',
      rareza: 'Raro',
      puntos: 800,
      imagen: '🎮',
      desbloqueado: false,
      requisitos: '3 juegos completados',
    },
    {
      id: 28,
      nombre: 'Security Expert',
      descripcion: 'Identifica y soluciona 50 vulnerabilidades',
      categoria: 'Tecnología',
      rareza: 'Legendario',
      puntos: 2800,
      imagen: '🛡️',
      desbloqueado: false,
      requisitos: '50 vulnerabilidades resueltas',
    },
    {
      id: 29,
      nombre: 'IoT Creator',
      descripcion: 'Conecta 5 dispositivos IoT',
      categoria: 'Tecnología',
      rareza: 'Raro',
      puntos: 700,
      imagen: '📶',
      desbloqueado: false,
      requisitos: '5 dispositivos IoT',
    },
    {
      id: 30,
      nombre: 'Quantum Computing Initiate',
      descripcion: 'Completa el curso de computación cuántica',
      categoria: 'Tecnología',
      rareza: 'Mítico',
      puntos: 5000,
      imagen: '⚛️',
      desbloqueado: false,
      requisitos: 'Curso quantum computing',
    },

    // Logros de Comunidad (15)
    {
      id: 31,
      nombre: 'Buen Samaritano',
      descripcion: 'Ayuda a 10 compañeros en el foro',
      categoria: 'Comunidad',
      rareza: 'Común',
      puntos: 200,
      imagen: '🤝',
      desbloqueado: true,
      requisitos: '10 ayudas en foros',
      fechaDesbloqueo: new Date('2024-02-15'),
    },
    {
      id: 32,
      nombre: 'Mentor Destacado',
      descripcion: 'Conviértete en mentor de 5 estudiantes',
      categoria: 'Comunidad',
      rareza: 'Raro',
      puntos: 800,
      imagen: '🧙',
      desbloqueado: false,
      requisitos: 'Mentor de 5 estudiantes',
    },
    {
      id: 33,
      nombre: 'Líder de la Comunidad',
      descripcion: 'Crea un grupo de estudio con 50+ miembros',
      categoria: 'Comunidad',
      rareza: 'Épico',
      puntos: 1500,
      imagen: '👑',
      desbloqueado: false,
      requisitos: 'Grupo de 50+ miembros',
    },
    {
      id: 34,
      nombre: 'Contribuidor Open Source',
      descripcion: 'Contribuye a 3 proyectos open source',
      categoria: 'Comunidad',
      rareza: 'Raro',
      puntos: 600,
      imagen: '📖',
      desbloqueado: false,
      requisitos: '3 contribuciones OSS',
    },
    {
      id: 35,
      nombre: 'Speaker Naciente',
      descripcion: 'Presenta en un meetup de CodeQuest',
      categoria: 'Comunidad',
      rareza: 'Épico',
      puntos: 1200,
      imagen: '🎤',
      desbloqueado: false,
      requisitos: 'Presentación en meetup',
    },
    {
      id: 36,
      nombre: 'Code Reviewer',
      descripcion: 'Revisa 100 pull requests',
      categoria: 'Comunidad',
      rareza: 'Legendario',
      puntos: 2200,
      imagen: '🔍',
      desbloqueado: false,
      requisitos: '100 PRs revisados',
    },
    {
      id: 37,
      nombre: 'Bug Hunter',
      descripcion: 'Reporta 50 bugs en proyectos',
      categoria: 'Comunidad',
      rareza: 'Raro',
      puntos: 750,
      imagen: '🐛',
      desbloqueado: false,
      requisitos: '50 bugs reportados',
    },
    {
      id: 38,
      nombre: 'Trailblazer',
      descripcion: 'Sé de los primeros en completar un nuevo curso',
      categoria: 'Comunidad',
      rareza: 'Épico',
      puntos: 1000,
      imagen: '🚩',
      desbloqueado: false,
      requisitos: 'Primero en curso nuevo',
    },
    {
      id: 39,
      nombre: 'Polyglot Programmer',
      descripcion: 'Contribuye en 5 lenguajes diferentes',
      categoria: 'Comunidad',
      rareza: 'Legendario',
      puntos: 2800,
      imagen: '🌐',
      desbloqueado: false,
      requisitos: '5 lenguajes diferentes',
    },
    {
      id: 40,
      nombre: 'Documentation Hero',
      descripcion: 'Escribe documentación para 10 proyectos',
      categoria: 'Comunidad',
      rareza: 'Raro',
      puntos: 650,
      imagen: '📝',
      desbloqueado: false,
      requisitos: 'Documentar 10 proyectos',
    },
    {
      id: 41,
      nombre: 'Community Moderator',
      descripcion: 'Conviértete en moderador de la comunidad',
      categoria: 'Comunidad',
      rareza: 'Épico',
      puntos: 1800,
      imagen: '🛡️',
      desbloqueado: false,
      requisitos: 'Ser nombrado moderador',
    },
    {
      id: 42,
      nombre: 'Workshop Leader',
      descripcion: 'Dirige 5 workshops exitosos',
      categoria: 'Comunidad',
      rareza: 'Legendario',
      puntos: 2400,
      imagen: '👨‍🏫',
      desbloqueado: false,
      requisitos: '5 workshops dirigidos',
    },
    {
      id: 43,
      nombre: 'Code Mentor Pro',
      descripcion: 'Mentorea a 50 estudiantes',
      categoria: 'Comunidad',
      rareza: 'Mítico',
      puntos: 4000,
      imagen: '🎯',
      desbloqueado: false,
      requisitos: '50 estudiantes mentorados',
    },
    {
      id: 44,
      nombre: 'Open Source Advocate',
      descripcion: 'Mantén un proyecto open source por 1 año',
      categoria: 'Comunidad',
      rareza: 'Legendario',
      puntos: 3000,
      imagen: '❤️',
      desbloqueado: false,
      requisitos: 'Proyecto OSS por 1 año',
    },
    {
      id: 45,
      nombre: 'Community Legend',
      descripcion: 'Alcanza el nivel máximo de contribución comunitaria',
      categoria: 'Comunidad',
      rareza: 'Mítico',
      puntos: 5000,
      imagen: '🏛️',
      desbloqueado: false,
      requisitos: 'Máxima contribución comunitaria',
    },

    // Logros de Aprendizaje (15)
    {
      id: 46,
      nombre: 'Curioso Insaciable',
      descripcion: 'Completa 50 quizzes con 90%+ de aciertos',
      categoria: 'Aprendizaje',
      rareza: 'Raro',
      puntos: 600,
      imagen: '❓',
      desbloqueado: false,
      requisitos: '50 quizzes con 90%+',
    },
    {
      id: 47,
      nombre: 'Memoria Fotográfica',
      descripcion: 'Obtén 100% en 25 quizzes consecutivos',
      categoria: 'Aprendizaje',
      rareza: 'Épico',
      puntos: 1500,
      imagen: '📸',
      desbloqueado: false,
      requisitos: '25 quizzes 100% consecutivos',
    },
    {
      id: 48,
      nombre: 'Aprendiz Rápido',
      descripcion: 'Completa un curso avanzado en tiempo récord',
      categoria: 'Aprendizaje',
      rareza: 'Raro',
      puntos: 800,
      imagen: '🎯',
      desbloqueado: false,
      requisitos: 'Curso avanzado en tiempo récord',
    },
    {
      id: 49,
      nombre: 'Investigador Nato',
      descripcion: 'Lee 100 artículos técnicos',
      categoria: 'Aprendizaje',
      rareza: 'Épico',
      puntos: 1200,
      imagen: '🔬',
      desbloqueado: false,
      requisitos: '100 artículos leídos',
    },
    {
      id: 50,
      nombre: 'Síntesis Maestra',
      descripcion: 'Crea 25 resúmenes de cursos',
      categoria: 'Aprendizaje',
      rareza: 'Raro',
      puntos: 700,
      imagen: '📊',
      desbloqueado: false,
      requisitos: '25 resúmenes creados',
    },
    {
      id: 51,
      nombre: 'Pensador Crítico',
      descripcion: 'Participa en 50 debates técnicos',
      categoria: 'Aprendizaje',
      rareza: 'Épico',
      puntos: 1100,
      imagen: '💭',
      desbloqueado: false,
      requisitos: '50 debates técnicos',
    },
    {
      id: 52,
      nombre: 'Autodidacta Pro',
      descripcion: 'Completa 10 cursos sin ayuda de mentor',
      categoria: 'Aprendizaje',
      rareza: 'Legendario',
      puntos: 2000,
      imagen: '🎓',
      desbloqueado: false,
      requisitos: '10 cursos sin mentor',
    },
    {
      id: 53,
      nombre: 'Metodología Ágil',
      descripcion: 'Completa 5 proyectos usando metodologías ágiles',
      categoria: 'Aprendizaje',
      rareza: 'Raro',
      puntos: 900,
      imagen: '🔄',
      desbloqueado: false,
      requisitos: '5 proyectos con metodología ágil',
    },
    {
      id: 54,
      nombre: 'Visión Sistémica',
      descripcion: 'Diseña 3 arquitecturas de software completas',
      categoria: 'Aprendizaje',
      rareza: 'Épico',
      puntos: 1600,
      imagen: '🏗️',
      desbloqueado: false,
      requisitos: '3 arquitecturas diseñadas',
    },
    {
      id: 55,
      nombre: 'Patrón de Diseño Master',
      descripcion: 'Implementa 15 patrones de diseño diferentes',
      categoria: 'Aprendizaje',
      rareza: 'Legendario',
      puntos: 2800,
      imagen: '🎨',
      desbloqueado: false,
      requisitos: '15 patrones implementados',
    },
    {
      id: 56,
      nombre: 'Algoritmo Expert',
      descripcion: 'Resuelve 500 problemas de algoritmos',
      categoria: 'Aprendizaje',
      rareza: 'Mítico',
      puntos: 4500,
      imagen: '⚡',
      desbloqueado: false,
      requisitos: '500 problemas de algoritmos',
    },
    {
      id: 57,
      nombre: 'Clean Code Advocate',
      descripcion: 'Mantén 95%+ de code quality en 10 proyectos',
      categoria: 'Aprendizaje',
      rareza: 'Épico',
      puntos: 1400,
      imagen: '✨',
      desbloqueado: false,
      requisitos: '95%+ quality en 10 proyectos',
    },
    {
      id: 58,
      nombre: 'Testing Master',
      descripcion: 'Escribe 1000 tests unitarios',
      categoria: 'Aprendizaje',
      rareza: 'Legendario',
      puntos: 2200,
      imagen: '🧪',
      desbloqueado: false,
      requisitos: '1000 tests unitarios',
    },
    {
      id: 59,
      nombre: 'Performance Guru',
      descripcion: 'Optimiza 5 aplicaciones críticas',
      categoria: 'Aprendizaje',
      rareza: 'Épico',
      puntos: 1800,
      imagen: '🚀',
      desbloqueado: false,
      requisitos: '5 apps optimizadas',
    },
    {
      id: 60,
      nombre: 'Aprendizaje Continuo',
      descripcion: 'Mantén streak de aprendizaje por 365 días',
      categoria: 'Aprendizaje',
      rareza: 'Mítico',
      puntos: 5000,
      imagen: '∞',
      desbloqueado: false,
      requisitos: '365 días consecutivos',
    },

    // Logros de Proyectos y Especiales (15)
    {
      id: 61,
      nombre: 'Artista del Código',
      descripcion: 'Crea un proyecto visualmente impresionante',
      categoria: 'Proyectos',
      rareza: 'Épico',
      puntos: 1200,
      imagen: '🎨',
      desbloqueado: false,
      requisitos: 'Proyecto visual destacado',
    },
    {
      id: 62,
      nombre: 'Innovador Disruptivo',
      descripcion: 'Desarrolla una solución única para un problema real',
      categoria: 'Proyectos',
      rareza: 'Legendario',
      puntos: 3000,
      imagen: '💡',
      desbloqueado: false,
      requisitos: 'Solución innovadora real',
    },
    {
      id: 63,
      nombre: 'Scale Master',
      descripcion: 'Proyecto que maneja 1M+ usuarios',
      categoria: 'Proyectos',
      rareza: 'Mítico',
      puntos: 5000,
      imagen: '📈',
      desbloqueado: false,
      requisitos: '1M+ usuarios manejados',
    },
    {
      id: 64,
      nombre: 'Open Source Star',
      descripcion: 'Proyecto open source con 1000+ stars',
      categoria: 'Proyectos',
      rareza: 'Legendario',
      puntos: 3500,
      imagen: '⭐',
      desbloqueado: false,
      requisitos: '1000+ stars en GitHub',
    },
    {
      id: 65,
      nombre: 'Startup Founder',
      descripcion: 'Lanza un producto al mercado',
      categoria: 'Proyectos',
      rareza: 'Mítico',
      puntos: 6000,
      imagen: '🚀',
      desbloqueado: false,
      requisitos: 'Producto lanzado al mercado',
    },
    {
      id: 66,
      nombre: 'Hackathon Champion',
      descripcion: 'Gana 3 hackathones consecutivos',
      categoria: 'Retos',
      rareza: 'Legendario',
      puntos: 2800,
      imagen: '🏅',
      desbloqueado: false,
      requisitos: '3 hackathones ganados',
    },
    {
      id: 67,
      nombre: 'Bug Bounty Hunter',
      descripcion: 'Encuentra vulnerabilidades críticas',
      categoria: 'Retos',
      rareza: 'Épico',
      puntos: 2000,
      imagen: '💰',
      desbloqueado: false,
      requisitos: 'Vulnerabilidad crítica encontrada',
    },
    {
      id: 68,
      nombre: 'Code Golf Master',
      descripcion: 'Gana 10 competencias de code golf',
      categoria: 'Retos',
      rareza: 'Raro',
      puntos: 800,
      imagen: '⛳',
      desbloqueado: false,
      requisitos: '10 code golf ganados',
    },
    {
      id: 69,
      nombre: 'Speed Coder',
      descripcion: 'Resuelve problema complejo en <5 minutos',
      categoria: 'Retos',
      rareza: 'Épico',
      puntos: 1500,
      imagen: '⚡',
      desbloqueado: false,
      requisitos: 'Problema complejo en <5min',
    },
    {
      id: 70,
      nombre: 'Season Explorer',
      descripcion: 'Completa todos los logros de una temporada',
      categoria: 'Temporada',
      rareza: 'Legendario',
      puntos: 2500,
      imagen: '🎄',
      desbloqueado: false,
      requisitos: 'Todos los logros de temporada',
    },
    {
      id: 71,
      nombre: 'Anniversary Special',
      descripcion: 'Usa CodeQuest por 2 años consecutivos',
      categoria: 'Especiales',
      rareza: 'Legendario',
      puntos: 2000,
      imagen: '🎂',
      desbloqueado: false,
      requisitos: '2 años en la plataforma',
    },
    {
      id: 72,
      nombre: 'CodeQuest Legend',
      descripcion: 'Desbloquea todos los logros comunes y raros',
      categoria: 'Especiales',
      rareza: 'Mítico',
      puntos: 10000,
      imagen: '👑',
      desbloqueado: false,
      requisitos: 'Todos los logros C+R',
    },
    {
      id: 73,
      nombre: 'Digital Nomad',
      descripcion: 'Aprende desde 10 países diferentes',
      categoria: 'Especiales',
      rareza: 'Épico',
      puntos: 1800,
      imagen: '✈️',
      desbloqueado: false,
      requisitos: '10 países diferentes',
    },
    {
      id: 74,
      nombre: 'Midnight Coder',
      descripcion: 'Completa 100 sesiones de medianoche',
      categoria: 'Especiales',
      rareza: 'Raro',
      puntos: 600,
      imagen: '🌌',
      desbloqueado: false,
      requisitos: '100 sesiones nocturnas',
    },
    {
      id: 75,
      nombre: 'Eternal Learner',
      descripcion: 'Alcanza el nivel máximo de experiencia',
      categoria: 'Especiales',
      rareza: 'Mítico',
      puntos: 7500,
      imagen: '📚',
      desbloqueado: false,
      requisitos: 'Nivel máximo de experiencia',
    },
  ];

  filteredLogros: Logro[] = [];
  totalLogros: number = 0;
  totalPuntos: number = 0;
  puntosDesbloqueados: number = 0;
  progresoGlobal: number = 0;

  ngOnInit() {
    this.filteredLogros = [...this.allLogros];
    this.calculateStats();
    this.sortLogros();
  }

  calculateStats() {
    this.totalLogros = this.allLogros.length;
    this.totalPuntos = this.allLogros.reduce((sum, logro) => sum + logro.puntos, 0);
    this.puntosDesbloqueados = this.allLogros
      .filter((logro) => logro.desbloqueado)
      .reduce((sum, logro) => sum + logro.puntos, 0);
    this.progresoGlobal = Math.round((this.puntosDesbloqueados / this.totalPuntos) * 100);
  }

  toggleFilter(filterType: string) {
    switch (filterType) {
      case 'categoria':
        this.showCategoriaFilter = !this.showCategoriaFilter;
        this.showRarezaFilter = false;
        this.showEstadoFilter = false;
        this.showSortFilter = false;
        break;
      case 'rareza':
        this.showRarezaFilter = !this.showRarezaFilter;
        this.showCategoriaFilter = false;
        this.showEstadoFilter = false;
        this.showSortFilter = false;
        break;
      case 'estado':
        this.showEstadoFilter = !this.showEstadoFilter;
        this.showCategoriaFilter = false;
        this.showRarezaFilter = false;
        this.showSortFilter = false;
        break;
      case 'sort':
        this.showSortFilter = !this.showSortFilter;
        this.showCategoriaFilter = false;
        this.showRarezaFilter = false;
        this.showEstadoFilter = false;
        break;
    }
  }

  toggleCategoria(categoria: string) {
    const index = this.selectedCategorias.indexOf(categoria);
    if (index > -1) {
      this.selectedCategorias.splice(index, 1);
    } else {
      this.selectedCategorias.push(categoria);
    }
    this.filterLogros();
  }

  toggleRareza(rareza: string) {
    const index = this.selectedRarezas.indexOf(rareza);
    if (index > -1) {
      this.selectedRarezas.splice(index, 1);
    } else {
      this.selectedRarezas.push(rareza);
    }
    this.filterLogros();
  }

  toggleEstado(estado: string) {
    const index = this.selectedEstados.indexOf(estado);
    if (index > -1) {
      this.selectedEstados.splice(index, 1);
    } else {
      this.selectedEstados.push(estado);
    }
    this.filterLogros();
  }

  selectSort(sortValue: string) {
    this.selectedSort = sortValue;
    this.showSortFilter = false;
    this.sortLogros();
  }

  filterLogros() {
    this.filteredLogros = this.allLogros.filter((logro) => {
      // Search filter
      const matchesSearch =
        !this.searchTerm ||
        logro.nombre.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        logro.descripcion.toLowerCase().includes(this.searchTerm.toLowerCase());

      // Categoria filter
      const matchesCategoria =
        this.selectedCategorias.length === 0 || this.selectedCategorias.includes(logro.categoria);

      // Rareza filter
      const matchesRareza =
        this.selectedRarezas.length === 0 || this.selectedRarezas.includes(logro.rareza);

      // Estado filter
      const matchesEstado =
        this.selectedEstados.length === 0 ||
        (this.selectedEstados.includes('Desbloqueados') && logro.desbloqueado) ||
        (this.selectedEstados.includes('Por desbloquear') && !logro.desbloqueado);

      return matchesSearch && matchesCategoria && matchesRareza && matchesEstado;
    });

    this.sortLogros();
  }

  sortLogros() {
    switch (this.selectedSort) {
      case 'recent':
        this.filteredLogros.sort((a, b) => {
          if (a.desbloqueado && b.desbloqueado) {
            return (b.fechaDesbloqueo?.getTime() || 0) - (a.fechaDesbloqueo?.getTime() || 0);
          }
          return a.desbloqueado ? -1 : 1;
        });
        break;
      case 'points':
        this.filteredLogros.sort((a, b) => b.puntos - a.puntos);
        break;
      case 'rarity':
        const rarityOrder = { Mítico: 5, Legendario: 4, Épico: 3, Raro: 2, Común: 1 };
        this.filteredLogros.sort((a, b) => rarityOrder[b.rareza] - rarityOrder[a.rareza]);
        break;
      case 'az':
        this.filteredLogros.sort((a, b) => a.nombre.localeCompare(b.nombre));
        break;
    }
  }

  clearSearch() {
    this.searchTerm = '';
    this.filterLogros();
  }

  clearAllFilters() {
    this.searchTerm = '';
    this.selectedCategorias = [];
    this.selectedRarezas = [];
    this.selectedEstados = [];
    this.selectedSort = 'recent';
    this.filterLogros();
  }

  hasActiveFilters(): boolean {
    return (
      this.searchTerm !== '' ||
      this.selectedCategorias.length > 0 ||
      this.selectedRarezas.length > 0 ||
      this.selectedEstados.length > 0
    );
  }

  getRarezaColor(rareza: string): string {
    switch (rareza) {
      case 'Común':
        return '#6b7280';
      case 'Raro':
        return '#3b82f6';
      case 'Épico':
        return '#8b5cf6';
      case 'Legendario':
        return '#f59e0b';
      case 'Mítico':
        return '#ef4444';
      default:
        return '#6b7280';
    }
  }

  getRarezaGradient(rareza: string): string {
    switch (rareza) {
      case 'Común':
        return 'linear-gradient(135deg, #6b7280 0%, #9ca3af 100%)';
      case 'Raro':
        return 'linear-gradient(135deg, #3b82f6 0%, #60a5fa 100%)';
      case 'Épico':
        return 'linear-gradient(135deg, #8b5cf6 0%, #a78bfa 100%)';
      case 'Legendario':
        return 'linear-gradient(135deg, #f59e0b 0%, #fbbf24 100%)';
      case 'Mítico':
        return 'linear-gradient(135deg, #ef4444 0%, #f87171 100%)';
      default:
        return 'linear-gradient(135deg, #6b7280 0%, #9ca3af 100%)';
    }
  }
}
