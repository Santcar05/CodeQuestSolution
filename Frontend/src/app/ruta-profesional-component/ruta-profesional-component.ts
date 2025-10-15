import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { SidebarComponent } from '../sidebar-component/sidebar-component';

interface RoadmapItem {
  id: number;
  title: string;
  description: string;
  icon: string;
  status: 'completed' | 'current' | 'upcoming';
  courses: number;
  xp: number;
  duration: string;
}

interface Course {
  id: number;
  title: string;
  description: string;
  status: 'completed' | 'in-progress' | 'not-started';
  duration: string;
  difficulty: 'Principiante' | 'Intermedio' | 'Avanzado';
  xp: number;
  prerequisites: string[];
}

interface Challenge {
  id: number;
  title: string;
  description: string;
  icon: string;
  xp: number;
  type: 'weekly' | 'special' | 'consistency' | 'wisdom' | 'hidden';
  completed: boolean;
}

interface Skill {
  name: string;
  level: number;
  target: number;
  category: 'technical' | 'soft';
}

interface Project {
  id: number;
  title: string;
  description: string;
  status: 'completed' | 'in-progress' | 'planned';
  type: 'guided' | 'free' | 'collaborative';
  xp: number;
  technologies: string[];
}

interface Badge {
  id: number;
  name: string;
  description: string;
  icon: string;
  earned: boolean;
  xp: number;
  category: string;
}

interface CareerPath {
  id: string;
  title: string;
  subtitle: string;
  description: string;
  role: string;
  level: string;
  totalXP: number;
  currentXP: number;
  requiredXP: number;
  salaryRange: string;
  opportunities: string[];
  technologies: string[];
}

@Component({
  selector: 'app-ruta-profesional',
  standalone: true,
  imports: [CommonModule, SidebarComponent],
  templateUrl: './ruta-profesional-component.html',
  styleUrls: ['./ruta-profesional-component.css'],
})
export class RutaProfesionalComponent implements OnInit {
  careerPath: CareerPath = {
    id: 'web-developer',
    title: 'Desarrollador Web Full Stack',
    subtitle: 'Construye aplicaciones web completas desde el frontend hasta el backend',
    description:
      'Conviértete en un desarrollador web completo capaz de crear aplicaciones modernas, escalables y responsivas. Domina las tecnologías más demandadas del mercado y construye tu portafolio con proyectos reales.',
    role: 'Full Stack Developer',
    level: 'Arquitecto Web',
    totalXP: 12500,
    currentXP: 8450,
    requiredXP: 10000,
    salaryRange: '$45,000 - $95,000',
    opportunities: ['Startups', 'Empresas tech', 'Freelance', 'Agencias digitales'],
    technologies: ['HTML/CSS', 'JavaScript', 'React', 'Node.js', 'MongoDB', 'Git'],
  };

  roadmapItems: RoadmapItem[] = [
    {
      id: 1,
      title: 'Fundamentos Web',
      description: 'HTML5, CSS3, JavaScript moderno y desarrollo responsivo',
      icon: '🌐',
      status: 'completed',
      courses: 5,
      xp: 1500,
      duration: '4 semanas',
    },
    {
      id: 2,
      title: 'Frontend Avanzado',
      description: 'React, Vue o Angular, estado global y patrones de diseño',
      icon: '⚡',
      status: 'completed',
      courses: 4,
      xp: 2000,
      duration: '6 semanas',
    },
    {
      id: 3,
      title: 'Backend y APIs',
      description: 'Node.js, Express, bases de datos y arquitectura REST',
      icon: '🔧',
      status: 'current',
      courses: 6,
      xp: 2500,
      duration: '8 semanas',
    },
    {
      id: 4,
      title: 'Bases de Datos',
      description: 'SQL, NoSQL, modelado y optimización de consultas',
      icon: '🗄️',
      status: 'upcoming',
      courses: 3,
      xp: 1500,
      duration: '4 semanas',
    },
    {
      id: 5,
      title: 'DevOps Web',
      description: 'Git, Docker, CI/CD y despliegue en la nube',
      icon: '🚀',
      status: 'upcoming',
      courses: 4,
      xp: 2000,
      duration: '5 semanas',
    },
    {
      id: 6,
      title: 'Proyecto Final',
      description: 'Aplicación web completa con todas las tecnologías aprendidas',
      icon: '🏆',
      status: 'upcoming',
      courses: 1,
      xp: 1500,
      duration: '4 semanas',
    },
  ];

  courses: Course[] = [
    {
      id: 1,
      title: 'JavaScript Moderno ES6+',
      description: 'Domina las nuevas características de JavaScript',
      status: 'completed',
      duration: '15h',
      difficulty: 'Intermedio',
      xp: 500,
      prerequisites: ['HTML Básico', 'CSS Básico'],
    },
    {
      id: 2,
      title: 'React desde Cero',
      description: 'Aprende React con Hooks y Context API',
      status: 'completed',
      duration: '20h',
      difficulty: 'Intermedio',
      xp: 750,
      prerequisites: ['JavaScript Moderno'],
    },
    {
      id: 3,
      title: 'Node.js y Express',
      description: 'Construye APIs RESTful con Node.js',
      status: 'in-progress',
      duration: '25h',
      difficulty: 'Intermedio',
      xp: 800,
      prerequisites: ['JavaScript Moderno'],
    },
    {
      id: 4,
      title: 'MongoDB y Mongoose',
      description: 'Bases de datos NoSQL para aplicaciones modernas',
      status: 'not-started',
      duration: '18h',
      difficulty: 'Intermedio',
      xp: 600,
      prerequisites: ['Node.js y Express'],
    },
  ];

  challenges: Challenge[] = [
    {
      id: 1,
      title: 'Reto Semanal: CRUD API',
      description: 'Crea una API REST completa en 7 días',
      icon: '⚡',
      xp: 300,
      type: 'weekly',
      completed: false,
    },
    {
      id: 2,
      title: 'Bono de Consistencia',
      description: 'Estudia 5 días seguidos',
      icon: '🔥',
      xp: 150,
      type: 'consistency',
      completed: true,
    },
    {
      id: 3,
      title: 'Sabiduría IA',
      description: 'Resuelve 3 problemas de algoritmos',
      icon: '🧠',
      xp: 200,
      type: 'wisdom',
      completed: false,
    },
    {
      id: 4,
      title: 'Easter Egg',
      description: 'Descubre funcionalidades ocultas',
      icon: '🎁',
      xp: 100,
      type: 'hidden',
      completed: false,
    },
  ];

  skills: Skill[] = [
    { name: 'HTML/CSS', level: 90, target: 100, category: 'technical' },
    { name: 'JavaScript', level: 85, target: 100, category: 'technical' },
    { name: 'React', level: 75, target: 100, category: 'technical' },
    { name: 'Node.js', level: 60, target: 100, category: 'technical' },
    { name: 'Bases de Datos', level: 40, target: 100, category: 'technical' },
    { name: 'Git', level: 70, target: 100, category: 'technical' },
    { name: 'Resolución Problemas', level: 80, target: 100, category: 'soft' },
    { name: 'Trabajo en Equipo', level: 75, target: 100, category: 'soft' },
  ];

  projects: Project[] = [
    {
      id: 1,
      title: 'E-commerce React',
      description: 'Tienda online con carrito de compras y pasarela de pago',
      status: 'completed',
      type: 'guided',
      xp: 1000,
      technologies: ['React', 'Node.js', 'MongoDB'],
    },
    {
      id: 2,
      title: 'API REST Social Media',
      description: 'Backend completo para red social con autenticación JWT',
      status: 'in-progress',
      type: 'free',
      xp: 1500,
      technologies: ['Node.js', 'Express', 'MongoDB', 'JWT'],
    },
    {
      id: 3,
      title: 'Dashboard Analytics',
      description: 'Panel de administración con gráficos y estadísticas',
      status: 'planned',
      type: 'guided',
      xp: 1200,
      technologies: ['React', 'D3.js', 'Node.js'],
    },
  ];

  badges: Badge[] = [
    {
      id: 1,
      name: 'Maestro del Frontend',
      description: 'Completa todos los cursos de frontend',
      icon: '🎨',
      earned: true,
      xp: 500,
      category: 'frontend',
    },
    {
      id: 2,
      name: 'Arquitecto Backend',
      description: 'Domina el desarrollo del lado del servidor',
      icon: '⚙️',
      earned: false,
      xp: 750,
      category: 'backend',
    },
    {
      id: 3,
      name: 'Rey de las APIs',
      description: 'Crea 5 APIs REST diferentes',
      icon: '🔗',
      earned: false,
      xp: 600,
      category: 'backend',
    },
    {
      id: 4,
      name: 'Git Master',
      description: 'Domina el control de versiones',
      icon: '📚',
      earned: true,
      xp: 300,
      category: 'tools',
    },
    {
      id: 5,
      name: 'Full Stack Pro',
      description: 'Completa toda la ruta profesional',
      icon: '🏆',
      earned: false,
      xp: 2000,
      category: 'completion',
    },
  ];

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      const pathId = params.get('id');
      this.loadCareerPath(pathId || 'web-developer');
    });
  }

  loadCareerPath(pathId: string) {
    // En una aplicación real, aquí cargarías los datos de la API
    console.log('Cargando ruta profesional:', pathId);
  }

  get progressPercentage(): number {
    return (this.careerPath.currentXP / this.careerPath.requiredXP) * 100;
  }

  get remainingXP(): number {
    return this.careerPath.requiredXP - this.careerPath.currentXP;
  }

  getRingRotation(): number {
    return (this.progressPercentage / 100) * 360 - 45;
  }

  startCourse(courseId: number) {
    console.log('Iniciando curso:', courseId);
    // this.router.navigate(['/curso', courseId]);
  }

  takeChallenge(challengeId: number) {
    console.log('Tomando desafío:', challengeId);
    // Lógica para iniciar desafío
  }

  viewProject(projectId: number) {
    console.log('Viendo proyecto:', projectId);
    this.router.navigate(['/detalle-proyecto', projectId]);
  }

  simulateProgress() {
    // Simular progreso adicional (para demo)
    this.careerPath.currentXP = Math.min(
      this.careerPath.currentXP + 500,
      this.careerPath.requiredXP
    );
  }

  getTechnicalSkills(): Skill[] {
    return this.skills.filter((skill) => skill.category === 'technical');
  }

  getSoftSkills(): Skill[] {
    return this.skills.filter((skill) => skill.category === 'soft');
  }

  getEarnedBadges(): Badge[] {
    return this.badges.filter((badge) => badge.earned);
  }

  getLockedBadges(): Badge[] {
    return this.badges.filter((badge) => !badge.earned);
  }

  navigateToRoadmapItem(id: number) {
    this.router.navigate(['/detalle-curso', id]);
  }
}
