// dashboard.component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { PaymentComponent } from '../payment-component/payment-component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
interface Course {
  id: number;
  name: string;
  progress: number;
  icon: string;
  lessons: number;
  completedLessons: number;
  nextLesson: string;
  category: string;
}

interface WishlistCourse {
  id: number;
  name: string;
  image: string;
  level: string;
  duration: string;
  students: number;
}

interface Achievement {
  id: number;
  name: string;
  icon: string;
  date: string;
  rarity: 'common' | 'rare' | 'epic' | 'legendary';
}

interface UpcomingAchievement {
  id: number;
  name: string;
  icon: string;
  progress: number;
  required: number;
}

interface WeeklyActivity {
  day: string;
  value: number;
}

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, SidebarComponent, PaymentComponent, HttpClientModule],
  templateUrl: './dashboard-component.html',
  styleUrls: ['./dashboard-component.css'],
})
export class DashboardComponent implements OnInit {
  streak = 15;
  coins = 2450;
  animateStats = false;

  courses: Course[] = [
    {
      id: 1,
      name: 'JavaScript Avanzado',
      progress: 68,
      icon: '🚀',
      lessons: 45,
      completedLessons: 31,
      nextLesson: 'Promesas y Async/Await',
      category: 'Frontend',
    },
    {
      id: 2,
      name: 'React Pro',
      progress: 42,
      icon: '⚛️',
      lessons: 60,
      completedLessons: 25,
      nextLesson: 'Context API',
      category: 'Frontend',
    },
    {
      id: 3,
      name: 'Node.js Backend',
      progress: 25,
      icon: '🟢',
      lessons: 52,
      completedLessons: 13,
      nextLesson: 'Express Routing',
      category: 'Backend',
    },
  ];

  wishlistCourses: WishlistCourse[] = [
    {
      id: 1,
      name: 'TypeScript Master',
      image: 'https://images.unsplash.com/photo-1619410283995-43d9134e7656?w=400&h=300&fit=crop',
      level: 'Avanzado',
      duration: '12h',
      students: 15420,
    },
    {
      id: 2,
      name: 'Python para Data Science',
      image: 'https://images.unsplash.com/photo-1526374965328-7f61d4dc18c5?w=400&h=300&fit=crop',
      level: 'Intermedio',
      duration: '15h',
      students: 23150,
    },
    {
      id: 3,
      name: 'Docker & Kubernetes',
      image: 'https://images.unsplash.com/photo-1605745341112-85968b19335b?w=400&h=300&fit=crop',
      level: 'Avanzado',
      duration: '18h',
      students: 18790,
    },
    {
      id: 4,
      name: 'React Native para Android',
      image: 'https://images.unsplash.com/photo-1605745341112-85968b19335b?w=400&h=300&fit=crop',
      level: 'Intermedio',
      duration: '14h',
      students: 15420,
    },
    {
      id: 5,
      name: 'React Native para iOS',
      image: 'https://images.unsplash.com/photo-1605745341112-85968b19335b?w=400&h=300&fit=crop',
      level: 'Intermedio',
      duration: '14h',
      students: 15420,
    },
    {
      id: 6,
      name: 'React Native para Web',
      image: 'https://images.unsplash.com/photo-1605745341112-85968b19335b?w=400&h=300&fit=crop',
      level: 'Intermedio',
      duration: '14h',
      students: 15420,
    },
  ];

  recentAchievements: Achievement[] = [
    { id: 1, name: 'Racha de 15 días', icon: '🔥', date: 'Hoy', rarity: 'rare' },
    { id: 2, name: 'Primer Proyecto', icon: '🎯', date: 'Hace 2 días', rarity: 'common' },
    { id: 3, name: 'Code Master', icon: '👑', date: 'Hace 5 días', rarity: 'epic' },
  ];

  upcomingAchievements: UpcomingAchievement[] = [
    { id: 1, name: 'Racha de 30 días', icon: '🔥', progress: 50, required: 30 },
    { id: 2, name: 'Completar 5 cursos', icon: '📚', progress: 60, required: 5 },
    { id: 3, name: '100 Desafíos', icon: '⚡', progress: 75, required: 100 },
  ];

  weeklyActivity: WeeklyActivity[] = [
    { day: 'L', value: 3 },
    { day: 'M', value: 5 },
    { day: 'X', value: 2 },
    { day: 'J', value: 4 },
    { day: 'V', value: 6 },
    { day: 'S', value: 1 },
    { day: 'D', value: 4 },
  ];

  ngOnInit() {
    setTimeout(() => {
      this.animateStats = true;
    }, 100);
  }
}
