import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Project } from '../models/Project';
import { Technology } from '../models/Technology';
import { Requirement } from '../models/Requirement';
import { RoadmapPhase } from '../models/RoadMapPhase';
import { Skill } from '../models/Skill';
import { ChatMessage } from '../models/ChatMessage';
import { TestCase } from '../models/TestCase';
import { Badge } from '../models/Badge';
import { ResourceModel } from '../models/Resource';

// Servicios
import { ProjectService } from '../service/Project/project-service';
import { TechnologyService } from '../service/Technology/technology-service';
import { RequirementService } from '../service/Requirement/requirement-service';
import { RoadmapPhaseService } from '../service/RoadmapPhase/roadmap-phase-service';
import { SkillService } from '../service/Skill/skill-service';
import { ChatMessageService } from '../service/ChatMessage/chat-message-service';
import { TestCaseService } from '../service/TestCase/test-case-service';
import { BadgeService } from '../service/Badge/badge-service';
import { ResourceModelService } from '../service/ResourceModel/resource-model-service';

@Component({
  selector: 'app-detalle-proyecto',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarComponent],
  templateUrl: './detalle-proyecto-component.html',
  styleUrls: ['./detalle-proyecto-component.css'],
})
export class DetalleProyectoComponent implements OnInit {
  project: Project | null = null;
  technologies: Technology[] = [];
  requirements: Requirement[] = [];
  roadmapPhases: RoadmapPhase[] = [];
  skills: Skill[] = [];
  chatMessages: ChatMessage[] = [];
  testCases: TestCase[] = [];
  badges: Badge[] = [];
  resources: ResourceModel[] = [];

  newMessage: string = '';
  activePhase: number = 1;
  isLoading: boolean = true;
  hasError: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private projectService: ProjectService,
    private technologyService: TechnologyService,
    private requirementService: RequirementService,
    private roadmapPhaseService: RoadmapPhaseService,
    private skillService: SkillService,
    private chatMessageService: ChatMessageService,
    private testCaseService: TestCaseService,
    private badgeService: BadgeService,
    private resourceService: ResourceModelService,
    private cdRef: ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      const projectId = params.get('id');
      if (projectId) {
        this.loadProjectData(parseInt(projectId));
      } else {
        this.hasError = true;
        this.isLoading = false;
      }
    });
  }

  loadProjectData(projectId: number) {
    this.isLoading = true;
    this.hasError = false;

    // Cargar proyecto principal
    this.projectService.findById(projectId).subscribe({
      next: (project) => {
        this.project = project;
        this.loadRelatedData(projectId);
      },
      error: (err) => {
        console.error('Error cargando proyecto:', err);
        this.hasError = true;
        this.isLoading = false;
        this.cdRef.detectChanges();
      },
    });
  }

  loadRelatedData(projectId: number) {
    let completedRequests = 0;
    const totalRequests = 8;

    const checkAllRequestsCompleted = () => {
      completedRequests++;
      if (completedRequests === totalRequests) {
        this.isLoading = false;
        this.cdRef.detectChanges();
      }
    };

    // Cargar tecnologías
    this.technologyService.findAll().subscribe({
      next: (technologies) => {
        this.technologies = technologies;
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando tecnologías:', err);
        this.technologies = [];
        checkAllRequestsCompleted();
      },
    });

    // Cargar requisitos
    this.requirementService.findAll().subscribe({
      next: (requirements) => {
        this.requirements = requirements;
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando requisitos:', err);
        this.requirements = [];
        checkAllRequestsCompleted();
      },
    });

    // Cargar fases del roadmap
    this.roadmapPhaseService.findAll().subscribe({
      next: (phases) => {
        this.roadmapPhases = phases;
        if (phases.length > 0) {
          this.activePhase = phases[0].id;
        }
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando fases del roadmap:', err);
        this.roadmapPhases = [];
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

    // Cargar casos de prueba
    this.testCaseService.findAll().subscribe({
      next: (testCases) => {
        this.testCases = testCases;
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando casos de prueba:', err);
        this.testCases = [];
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

    // Cargar recursos
    this.resourceService.findAll().subscribe({
      next: (resources) => {
        this.resources = resources;
        checkAllRequestsCompleted();
      },
      error: (err) => {
        console.error('Error cargando recursos:', err);
        this.resources = [];
        checkAllRequestsCompleted();
      },
    });
  }

  getRingRotation(): number {
    if (!this.project?.progress) return 0;
    return (this.project.progress / 100) * 360 - 45;
  }

  getTechnicalSkills(): Skill[] {
    return this.skills.filter((skill) => skill.category === 'tecnica');
  }

  getSoftSkills(): Skill[] {
    return this.skills.filter((skill) => skill.category === 'blanda');
  }

  getEarnedBadges(): Badge[] {
    return this.badges.filter((badge) => badge.earned);
  }

  getLockedBadges(): Badge[] {
    return this.badges.filter((badge) => !badge.earned);
  }

  getPassedTests(): TestCase[] {
    return this.testCases.filter((test) => test.status === 'pasado');
  }

  getFailedTests(): TestCase[] {
    return this.testCases.filter((test) => test.status === 'fallado');
  }

  getPendingTests(): TestCase[] {
    return this.testCases.filter((test) => test.status === 'no-ejecutado');
  }

  sendMessage() {
    if (this.newMessage.trim()) {
      const userMessage: ChatMessage = {
        id: this.chatMessages.length + 1,
        text: this.newMessage,
        isUser: true,
        timestamp: new Date(),
        type: 'pista',
      };

      this.chatMessages.push(userMessage);

      // Simular respuesta de IA (en un caso real, llamarías a un servicio de IA)
      setTimeout(() => {
        const aiMessage: ChatMessage = {
          id: this.chatMessages.length + 1,
          text: this.generateAIResponse(this.newMessage),
          isUser: false,
          timestamp: new Date(),
          type: 'feedback',
        };
        this.chatMessages.push(aiMessage);
        this.cdRef.detectChanges();
      }, 1000);

      this.newMessage = '';
    }
  }

  generateAIResponse(userMessage: string): string {
    const responses = [
      'Interesante pregunta. Te recomiendo revisar la documentación de la fase actual.',
      'Basado en tu progreso, sugiero enfocarte en completar los tests fallidos primero.',
      '¡Excelente avance! Tu comprensión de los conceptos está mejorando notablemente.',
      'Detecté que podrías optimizar esa implementación. ¿Quieres que te muestre algunas mejoras?',
      'Tu código está bien estructurado. Considera añadir más comentarios para mejor documentación.',
    ];

    return responses[Math.floor(Math.random() * responses.length)];
  }

  startProject() {
    if (this.project) {
      this.project.status = 'en-progreso';
      console.log('Iniciando proyecto...');
      // Aquí podrías llamar a un servicio para actualizar el estado del proyecto
    }
  }

  submitForEvaluation() {
    console.log('Enviando proyecto para evaluación IA...');
    // Lógica de evaluación - llamar al servicio correspondiente
  }

  downloadCertificate() {
    console.log('Descargando certificado...');
    // Lógica para descargar certificado
  }

  shareProject() {
    console.log('Compartiendo proyecto con la comunidad...');
    // Lógica para compartir proyecto
  }

  runTests() {
    console.log('Ejecutando pruebas automáticas...');
    // Lógica para ejecutar tests - llamar al servicio correspondiente
  }

  setActivePhase(phaseId: number) {
    this.activePhase = phaseId;
  }

  getActivePhase(): RoadmapPhase | null {
    return this.roadmapPhases.find((phase) => phase.id === this.activePhase) || null;
  }
}
