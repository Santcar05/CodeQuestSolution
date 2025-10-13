import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
interface Power {
  id: number;
  name: string;
  description: string;
  price: number;
  duration: string;
  uses: number;
  owned: boolean;
  isFeatured: boolean;
  color: string;
  icon: string;
  iconSize: number;
}

interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  type: string;
  rarity: string;
  owned: boolean;
  isFeatured: boolean;
  image: string;
  color: string;
  icon: string;
  iconSize: number;
}

interface PremiumPlan {
  id: number;
  name: string;
  description: string;
  price: string;
  period: string;
  savings: string;
  recommended: boolean;
  features: string[];
}

interface Course {
  id: number;
  title: string;
  description: string;
  image: string;
  level: string;
  duration: string;
  students: number;
  price: string;
  originalPrice?: string;
}

@Component({
  selector: 'app-tienda-codequest',
  standalone: true,
  imports: [CommonModule, SidebarComponent],
  templateUrl: './tienda-codequest-component.html',
  styleUrls: ['./tienda-codequest-component.css'],
})
export class TiendaCodequestComponent implements OnInit {
  activeTab: string = 'poderes';
  userBalance: number = 12500;
  dailyBonus: number = 100;
  streakDays: number = 7;

  showPurchaseModal: boolean = false;
  selectedItem: any = null;
  isModalClosing: boolean = false;

  powers: Power[] = [
    {
      id: 1,
      name: 'Congelar Racha',
      description:
        'Protege tu racha de aprendizaje por 24 horas. No perderás tu progreso incluso si no estudias hoy.',
      price: 500,
      duration: '24 horas',
      uses: 3,
      owned: false,
      isFeatured: true,
      color: 'linear-gradient(135deg, #3b82f6 0%, #1d4ed8 100%)',
      icon: 'M13 2L3 14h9l-1 8 10-12h-9l1-8z',
      iconSize: 24,
    },
    {
      id: 2,
      name: 'Multiplicador x2',
      description: 'Duplica los CodeCoins que ganes en las próximas 5 lecciones completadas.',
      price: 750,
      duration: '5 lecciones',
      uses: 1,
      owned: true,
      isFeatured: false,
      color: 'linear-gradient(135deg, #fbbf24 0%, #f59e0b 100%)',
      icon: 'M12 6v12m-3-6h6',
      iconSize: 24,
    },
    {
      id: 3,
      name: 'Respuesta Instantánea',
      description: 'Obtén respuestas inmediatas a tus dudas del mentor IA durante 48 horas.',
      price: 1200,
      duration: '48 horas',
      uses: 1,
      owned: false,
      isFeatured: false,
      color: 'linear-gradient(135deg, #10b981 0%, #059669 100%)',
      icon: 'M8 10h.01M12 10h.01M16 10h.01M9 16H5a2 2 0 01-2-2V6a2 2 0 012-2h14a2 2 0 012 2v8a2 2 0 01-2 2h-5l-5 5v-5z',
      iconSize: 24,
    },
    {
      id: 4,
      name: 'Salto de Módulo',
      description: 'Desbloquea automáticamente el siguiente módulo sin completar los requisitos.',
      price: 2000,
      duration: 'Permanente',
      uses: 1,
      owned: false,
      isFeatured: true,
      color: 'linear-gradient(135deg, #8b5cf6 0%, #7c3aed 100%)',
      icon: 'M13 7l5 5m0 0l-5 5m5-5H6',
      iconSize: 24,
    },
    {
      id: 5,
      name: 'Energía Ilimitada',
      description:
        'Elimina el límite de lecciones diarias por 24 horas. Estudia sin restricciones.',
      price: 1500,
      duration: '24 horas',
      uses: 2,
      owned: false,
      isFeatured: false,
      color: 'linear-gradient(135deg, #ef4444 0%, #dc2626 100%)',
      icon: 'M13 10V3L4 14h7v7l9-11h-7z',
      iconSize: 24,
    },
    {
      id: 6,
      name: 'Protector de Puntos',
      description:
        'Evita perder puntos en los próximos 3 quizzes, incluso si fallas las respuestas.',
      price: 800,
      duration: '3 quizzes',
      uses: 1,
      owned: false,
      isFeatured: false,
      color: 'linear-gradient(135deg, #06b6d4 0%, #0891b2 100%)',
      icon: 'M12 15v2m-6 4h12a2 2 0 002-2v-6a2 2 0 00-2-2H6a2 2 0 00-2 2v6a2 2 0 002 2zm10-10V7a4 4 0 00-8 0v4h8z',
      iconSize: 24,
    },
  ];

  products: Product[] = [
    {
      id: 1,
      name: 'Avatar Épico',
      description:
        'Desbloquea un avatar exclusivo y único para tu perfil. Demuestra tu estatus en la comunidad.',
      price: 2500,
      type: 'Cosmético',
      rarity: 'Épico',
      owned: false,
      isFeatured: true,
      image: 'https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?w=400&h=200&fit=crop',
      color: 'linear-gradient(135deg, #fbbf24 0%, #f59e0b 100%)',
      icon: 'M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z',
      iconSize: 24,
    },
    {
      id: 2,
      name: 'Marco de Perfil Dorado',
      description:
        'Un marco dorado exclusivo que resaltará tu perfil entre la comunidad de estudiantes.',
      price: 1800,
      type: 'Cosmético',
      rarity: 'Raro',
      owned: true,
      isFeatured: false,
      image: 'https://images.unsplash.com/photo-1579546929662-711aa81148cf?w=400&h=200&fit=crop',
      color: 'linear-gradient(135deg, #fbbf24 0%, #f59e0b 100%)',
      icon: 'M4 16l4.586-4.586a2 2 0 012.828 0L16 16m-2-2l1.586-1.586a2 2 0 012.828 0L20 14m-6-6h.01M6 20h12a2 2 0 002-2V6a2 2 0 00-2-2H6a2 2 0 00-2 2v12a2 2 0 002 2z',
      iconSize: 24,
    },
    {
      id: 3,
      name: 'Tema Oscuro Premium',
      description:
        'Desbloquea un tema de interfaz exclusivo con colores únicos y animaciones especiales.',
      price: 3200,
      type: 'Personalización',
      rarity: 'Legendario',
      owned: false,
      isFeatured: true,
      image: 'https://images.unsplash.com/photo-1519681393784-d120267933ba?w=400&h=200&fit=crop',
      color: 'linear-gradient(135deg, #8b5cf6 0%, #7c3aed 100%)',
      icon: 'M20.354 15.354A9 9 0 018.646 3.646 9.003 9.003 0 0012 21a9.003 9.003 0 008.354-5.646z',
      iconSize: 24,
    },
    {
      id: 4,
      name: 'Pack de Emojis',
      description: 'Expresa tus emociones con emojis exclusivos en los comentarios y foros.',
      price: 900,
      type: 'Social',
      rarity: 'Común',
      owned: false,
      isFeatured: false,
      image: 'https://images.unsplash.com/photo-1611605698335-8b1569810432?w=400&h=200&fit=crop',
      color: 'linear-gradient(135deg, #10b981 0%, #059669 100%)',
      icon: 'M14.828 14.828a4 4 0 01-5.656 0M9 10h.01M15 10h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z',
      iconSize: 24,
    },
  ];

  premiumPlans: PremiumPlan[] = [
    {
      id: 1,
      name: 'Plan Básico',
      description: 'Perfecto para empezar tu viaje de aprendizaje',
      price: '$2.99',
      period: 'por mes',
      savings: '',
      recommended: false,
      features: [
        'Acceso a 50+ cursos básicos',
        'Certificados de finalización',
        'Soporte de la comunidad',
        'Contenido actualizado mensualmente',
        'Proyectos prácticos incluidos',
      ],
    },
    {
      id: 2,
      name: 'Plan Pro',
      description: 'Recomendado para desarrolladores serios',
      price: '$7.99',
      period: 'por mes',
      savings: '35% de descuento anual',
      recommended: true,
      features: [
        'Acceso completo a TODOS los cursos (200+)',
        'Certificados verificados',
        'Soporte prioritario 24/7',
        'Contenido actualizado semanalmente',
        'Proyectos avanzados y mentoría',
        'CodeCoins mensuales (500 CC)',
        'Early access a nuevos cursos',
        'Sesiones de Q&A con instructores',
      ],
    },
    {
      id: 3,
      name: 'Plan Empresarial',
      description: 'Para equipos y organizaciones',
      price: '$9.99',
      period: 'por mes',
      savings: 'Contactar para precios anuales',
      recommended: false,
      features: [
        'Todas las características del Plan Pro',
        'Hasta 10 licencias de equipo',
        'Dashboard de progreso del equipo',
        'Contenido personalizado',
        'Sesiones de training en vivo',
        'Certificados corporativos',
        'API de integración',
        'Soporte dedicado',
      ],
    },
  ];

  individualCourses: Course[] = [
    {
      id: 1,
      title: 'Angular Avanzado - Arquitectura',
      description: 'Domina patrones avanzados y arquitectura escalable en Angular',
      image: 'https://images.unsplash.com/photo-1555949963-aa79dcee981c?w=400&h=250&fit=crop',
      level: 'Avanzado',
      duration: '22 horas',
      students: 15420,
      price: '$10.99',
      originalPrice: '$5.99',
    },
    {
      id: 2,
      title: 'React Pro - Hooks y Context',
      description: 'Aprende React con hooks avanzados y gestión de estado profesional',
      image: 'https://images.unsplash.com/photo-1633356122544-f134324a6cee?w=400&h=250&fit=crop',
      level: 'Intermedio',
      duration: '18 horas',
      students: 23150,
      price: '$24.99',
    },
    {
      id: 3,
      title: 'Node.js Backend Completo',
      description: 'Construye APIs RESTful y aplicaciones backend escalables',
      image: 'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=400&h=250&fit=crop',
      level: 'Intermedio',
      duration: '15 horas',
      students: 18790,
      price: '$27.99',
      originalPrice: '$39.99',
    },
    {
      id: 4,
      title: 'Python Data Science',
      description: 'Análisis de datos y machine learning con Python',
      image: 'https://images.unsplash.com/photo-1526374965328-7f61d4dc18c5?w=400&h=250&fit=crop',
      level: 'Principiante',
      duration: '20 horas',
      students: 32450,
      price: '$22.99',
    },
  ];

  ngOnInit() {
    console.log('Tienda CodeQuest component initialized');
  }

  setActiveTab(tab: string): void {
    this.activeTab = tab;
  }

  purchaseItem(item: any): void {
    this.selectedItem = item;
    if (item.owned) {
      return;
    }

    //Solo se muestra la info de la modal al oprimir algun elemento del modal(corregir)
    if (this.userBalance >= item.price) {
      this.showPurchaseModal = true;
      this.isModalClosing = false;
    }
  }

  confirmPurchase(): void {
    if (this.selectedItem && this.userBalance >= this.selectedItem.price) {
      this.userBalance -= this.selectedItem.price;
      this.selectedItem.owned = true;
      alert(`¡Felicidades! Has adquirido ${this.selectedItem.name}`);
      this.closeModal();
    }
  }

  closeModal(): void {
    this.isModalClosing = true;
    // Esperar a que termine la animación antes de ocultar el modal
    setTimeout(() => {
      this.showPurchaseModal = false;
      this.selectedItem = null;
      this.isModalClosing = false;
    }, 300);
  }

  getRemainingBalance(): number {
    if (this.selectedItem) {
      return this.userBalance - this.selectedItem.price;
    }
    return this.userBalance;
  }
}
