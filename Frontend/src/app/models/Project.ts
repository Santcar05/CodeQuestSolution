import { Resource } from '@angular/core';
import { Requirement } from './Requirement';
import { RoadmapPhase } from './RoadMapPhase';
import { Technology } from './Technology';
import { TestCase } from './TestCase';
import { Badge } from './Badge';
import { ResourceModel } from './Resource';

export interface Project {
  id: number;
  title: string;
  subtitle?: string;
  description: string;
  type: 'guiado' | 'libre' | 'colaborativo' | 'desafio-ia' | 'guided' | 'free' | 'collaborative';
  difficulty: 'principiante' | 'intermedio' | 'avanzado' | 'experto';
  duration: string;
  totalXP: number;
  baseXP: number;
  bonusXP: number;
  iaEvaluation: boolean;
  progress: number;
  status: 'no-iniciado' | 'en-progreso' | 'completado' | 'completed' | 'planned';
  technologies: Technology[];
  roadmap: RoadmapPhase[];
  requirements?: Requirement[];
  testCases?: TestCase[];
  badges?: Badge[];
  resources?: ResourceModel[];
}
