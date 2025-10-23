import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Router } from '@angular/router';
import { Skill } from '../models/Skill';
import { RoadmapItem } from '../models/RoadMapItem';
import { CareerPath } from '../models/CarrerPath';
import { Badge } from '../models/Badge';
import { ChatMessage } from '../models/ChatMessage';
import { UserProfile } from '../models/UserProfile';

// Servicios
import { SkillService } from '../service/Skill/skill-service';
import { RoadmapItemService } from '../service/RoadmapItem/roadmap-item-service';
import { CareerPathService } from '../service/CareerPath/career-path-service';
import { BadgeService } from '../service/Badge/badge-service';
import { ChatMessageService } from '../service/ChatMessage/chat-message-service';
import { UserProfileService } from '../service/UserProfile/user-profile-service';

@Component({
  selector: 'app-mi-ruta',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarComponent],
  templateUrl: './mi-ruta-component.html',
  styleUrls: ['./mi-ruta-component.css'],
})
export class MiRutaComponent implements OnInit {
  // User Progress Data
  userProfile: UserProfile | null = null;

  // Datos cargados desde servicios
  skills: Skill[] = [];
  roadmapItems: RoadmapItem[] = [];
  careerPaths: CareerPath[] = [];
  badges: Badge[] = [];
  chatMessages: ChatMessage[] = [];

  // Practice Options (estáticos ya que no hay interfaz específica)
  practiceOptions = [
    { icon: '💬', title: 'Playground', description: 'Practica cualquier lenguaje' },
    { icon: '🧠', title: 'Ejercicios IA', description: 'Generados para tu nivel' },
    { icon: '⚡', title: 'Modo Desafío', description: 'Problemas con tiempo' },
    { icon: '🎯', title: 'Entrevistas', description: 'Simulador técnico' },
  ];

  newMessage: string = '';
  isLoading: boolean = true;
  hasError: boolean = false;

  constructor(
    private router: Router,
    private skillService: SkillService,
    private roadmapItemService: RoadmapItemService,
    private careerPathService: CareerPathService,
    private badgeService: BadgeService,
    private chatMessageService: ChatMessageService,
    private userProfileService: UserProfileService,
    private cdRef: ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.loadAllData();
  }

  loadAllData() {
    this.isLoading = true;
    this.hasError = false;

    let completedRequests = 0;
    const totalRequests = 6; // Número total de servicios a llamar

    const checkAllRequestsCompleted = () => {
      completedRequests++;
      if (completedRequests === totalRequests) {
        this.isLoading = false;
        this.cdRef.detectChanges();
      }
    };

    // Cargar perfil de usuario
    this.userProfileService.findById(0).subscribe({
      next: (profile) => {
        // Tomar el primer perfil (en una app real, usarías el perfil del usuario logueado)
        this.userProfile = profile;
        console.log('Perfil de usuario cargado:', this.userProfile);
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando perfil de usuario:', err);
        this.userProfile = null;
        checkAllRequestsCompleted();
      },
    });

    // Cargar habilidades
    this.skillService.findAll().subscribe({
      next: (skills) => {
        this.skills = skills;
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando habilidades:', err);
        this.skills = [];
        checkAllRequestsCompleted();
      },
    });

    // Cargar items del roadmap
    this.roadmapItemService.findAll().subscribe({
      next: (items) => {
        this.roadmapItems = items;
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando roadmap:', err);
        this.roadmapItems = [];
        checkAllRequestsCompleted();
      },
    });

    // Cargar rutas profesionales
    this.careerPathService.findAll().subscribe({
      next: (careers) => {
        this.careerPaths = careers;
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando rutas profesionales:', err);
        this.careerPaths = [];
        checkAllRequestsCompleted();
      },
    });

    // Cargar insignias
    this.badgeService.findAll().subscribe({
      next: (badges) => {
        this.badges = badges;
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando insignias:', err);
        this.badges = [];
        checkAllRequestsCompleted();
      },
    });

    // Cargar mensajes del chat
    this.chatMessageService.findAll().subscribe({
      next: (messages) => {
        this.chatMessages = messages;
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando mensajes del chat:', err);
        this.chatMessages = [];
        checkAllRequestsCompleted();
      },
    });
  }

  // Getters para mantener compatibilidad con el template
  get userLevel(): number {
    return this.userProfile?.level || 0;
  }

  get userXP(): number {
    return this.userProfile?.xp || 0;
  }

  get nextLevelXP(): number {
    return this.userProfile?.maxXp || 1000;
  }

  get totalCourses(): number {
    // Esto debería venir de otro servicio, por ahora valor por defecto
    return 8;
  }

  get completedCourses(): number {
    // Esto debería venir de otro servicio, por ahora valor por defecto
    return 5;
  }

  get currentStreak(): number {
    // Esto debería venir del perfil de usuario, por ahora valor por defecto
    return 7;
  }

  get progressPercentage(): number {
    if (!this.userProfile?.maxXp) return 0;
    return (this.userProfile.xp / this.userProfile.maxXp) * 100;
  }

  get currentCareerPath(): CareerPath {
    return this.careerPaths.find((path) => path.selected) || this.careerPaths[0];
  }

  selectCareerPath(pathId: number) {
    this.careerPaths.forEach((path) => {
      path.selected = path.id === pathId;
    });
    this.loadCareerPath(pathId);
  }

  loadCareerPath(pathId: number) {
    this.router.navigate(['/ruta-profesional', pathId]);
  }

  sendMessage() {
    if (this.newMessage.trim()) {
      // Agregar mensaje del usuario
      const userMessage: ChatMessage = {
        id: this.chatMessages.length + 1,
        text: this.newMessage,
        isUser: true,
        timestamp: new Date(),
      };

      this.chatMessages.push(userMessage);

      // Simular respuesta de la IA
      setTimeout(() => {
        const aiMessage: ChatMessage = {
          id: this.chatMessages.length + 1,
          text: this.generateAIResponse(this.newMessage),
          isUser: false,
          timestamp: new Date(),
        };
        this.chatMessages.push(aiMessage);
        this.cdRef.detectChanges();
      }, 1000);

      this.newMessage = '';
    }
  }

  generateAIResponse(userMessage: string): string {
    const responses = [
      'Interesante pregunta. Te recomiendo revisar los ejercicios prácticos de esa sección.',
      'Basado en tu progreso, sugiero enfocarte en los conceptos fundamentales primero.',
      '¡Excelente avance! Tu comprensión de los temas está mejorando notablemente.',
      'Detecté que podrías practicar más ese tema. ¿Quieres que genere ejercicios específicos?',
      'Tu ruta de aprendizaje se está adaptando a tu ritmo. ¡Sigue así!',
    ];

    return responses[Math.floor(Math.random() * responses.length)];
  }

  startPractice(type: string) {
    console.log(`Iniciando práctica: ${type}`);
    // this.router.navigate(['/practice', type]);
  }

  generateNewExercises() {
    console.log('Generando nuevos ejercicios personalizados...');
  }

  adjustLearningPath() {
    console.log('Ajustando ruta de aprendizaje...');
  }

  exportProgress() {
    console.log('Exportando progreso y CV técnico...');
  }
}
