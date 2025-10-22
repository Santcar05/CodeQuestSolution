import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Router } from '@angular/router';

import { Power } from '../models/Power';
import { Product } from '../models/Product';
import { PremiumPlan } from '../models/PremiumPlan';
import { Course } from '../models/Course';

// Importar los servicios
import { PowerService } from '../service/Power/power-service';
import { ProductService } from '../service/Product/product-service';
import { PremiumPlanService } from '../service/PremiumPlan/premium-plan-service';
import { CourseService } from '../service/Course/course-service';

@Component({
  selector: 'app-tienda-codequest',
  standalone: true,
  imports: [CommonModule, SidebarComponent],
  templateUrl: './tienda-codequest-component.html',
  styleUrls: ['./tienda-codequest-component.css'],
})
export class TiendaCodequestComponent implements OnInit {
  constructor(
    private router: Router,
    private powerService: PowerService,
    private productService: ProductService,
    private premiumPlanService: PremiumPlanService,
    private courseService: CourseService
  ) {}

  activeTab: string = 'poderes';
  userBalance: number = 12500;
  dailyBonus: number = 100;
  streakDays: number = 7;

  showPurchaseModal: boolean = false;
  selectedItem: any = null;
  isModalClosing: boolean = false;

  // 🔹 Inicializamos vacíos
  powers: Power[] = [];
  products: Product[] = [];
  premiumPlans: PremiumPlan[] = [];
  individualCourses: Course[] = [];

  ngOnInit() {
    console.log('🛒 Tienda CodeQuest inicializada');
    this.loadData();
  }

  /**
   * Carga los datos del backend
   */
  loadData(): void {
    this.powerService.findAll().subscribe({
      next: (data) => {
        this.powers = data;
        console.log('Poderes cargados:', this.powers);
      },
      error: (err) => console.error('Error cargando poderes:', err),
    });

    this.productService.findAll().subscribe({
      next: (data) => {
        this.products = data;
        console.log('Productos cargados:', this.products);
      },
      error: (err) => console.error('Error cargando productos:', err),
    });

    this.premiumPlanService.findAll().subscribe({
      next: (data) => {
        this.premiumPlans = data;
        console.log('Planes premium cargados:', this.premiumPlans);
      },
      error: (err) => console.error('Error cargando planes premium:', err),
    });

    this.courseService.findAll().subscribe({
      next: (data) => {
        this.individualCourses = data;
        console.log('Cursos cargados:', this.individualCourses);
      },
      error: (err) => console.error('Error cargando cursos:', err),
    });
  }

  setActiveTab(tab: string): void {
    this.activeTab = tab;
  }

  purchaseItem(item: any): void {
    this.selectedItem = item;
    if (item.owned) return;

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
    setTimeout(() => {
      this.showPurchaseModal = false;
      this.selectedItem = null;
      this.isModalClosing = false;
    }, 300);
  }

  getRemainingBalance(): number {
    return this.selectedItem ? this.userBalance - this.selectedItem.price : this.userBalance;
  }

  buyPremiumPlan(): void {
    this.router.navigate(['/pago']);
  }
}
