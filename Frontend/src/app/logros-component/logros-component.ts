import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Achievement } from '../models/Achievement';
import { AchievementService } from '../service/achievement/achievement-service';

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

  // Datos dinámicos
  allLogros: Achievement[] = [];
  filteredLogros: Achievement[] = [];
  totalLogros: number = 0;
  totalPuntos: number = 0;
  puntosDesbloqueados: number = 0;
  progresoGlobal: number = 0;

  // Estado de carga y errores
  loading: boolean = false;
  error: string | null = null;

  constructor(private achievementService: AchievementService) {}

  ngOnInit() {
    this.cargarLogros();
  }

  cargarLogros() {
    this.loading = true;
    this.error = null;

    this.achievementService.findAll().subscribe({
      next: (data: Achievement[]) => {
        this.allLogros = data.map((logro) => ({
          ...logro,
        }));

        this.filteredLogros = [...this.allLogros];
        this.calculateStats();
        this.sortLogros();
        this.loading = false;
        this.filterLogros();
      },
      error: (err) => {
        console.error('Error al cargar los logros', err);
        this.error = 'No se pudieron cargar los logros.';
        this.loading = false;
      },
    });
  }

  calculateStats() {
    this.totalLogros = this.allLogros.length;
    this.totalPuntos = this.allLogros.reduce((sum, logro) => sum + logro.points, 0);
    this.puntosDesbloqueados = this.allLogros
      .filter((logro) => logro.unlocked)
      .reduce((sum, logro) => sum + logro.points, 0);
    this.progresoGlobal = this.totalPuntos
      ? Math.round((this.puntosDesbloqueados / this.totalPuntos) * 100)
      : 0;
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
      const matchesSearch =
        !this.searchTerm ||
        logro.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        (logro.description &&
          logro.description.toLowerCase().includes(this.searchTerm.toLowerCase()));

      const matchesCategoria =
        this.selectedCategorias.length === 0 || this.selectedCategorias.includes(logro.category);

      const matchesRareza =
        this.selectedRarezas.length === 0 || this.selectedRarezas.includes(logro.rarity);

      const matchesEstado =
        this.selectedEstados.length === 0 ||
        (this.selectedEstados.includes('Desbloqueados') && logro.unlocked) ||
        (this.selectedEstados.includes('Por desbloquear') && !logro.unlocked);

      return matchesSearch && matchesCategoria && matchesRareza && matchesEstado;
    });

    this.sortLogros();
  }

  sortLogros() {
    switch (this.selectedSort) {
      case 'recent':
        this.filteredLogros.sort((a, b) => {
          if (a.unlocked && b.unlocked) {
            return (
              (b.unlockDate ? new Date(b.unlockDate).getTime() : 0) -
              (a.unlockDate ? new Date(a.unlockDate).getTime() : 0)
            );
          }
          return a.unlocked ? -1 : 1;
        });
        break;
      case 'points':
        this.filteredLogros.sort((a, b) => b.points - a.points);
        break;
      case 'rarity':
        const rarityOrder = { MÍTICO: 5, LEGENDARIO: 4, ÉPICO: 3, RARO: 2, COMÚN: 1 };
        this.filteredLogros.sort((a, b) => rarityOrder[b.rarity] - rarityOrder[a.rarity]);
        break;
      case 'az':
        this.filteredLogros.sort((a, b) => a.name.localeCompare(b.name));
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
    //Como parametro se recibe una cadena como COMÚN
    rareza = rareza.toLowerCase().charAt(0).toUpperCase() + rareza.toLowerCase().slice(1);
    switch (rareza) {
      case 'COMÚN':
        return '#6b7280';
      case 'RARO':
        return '#3b82f6';
      case 'ÉPICO':
        return '#8b5cf6';
      case 'LEGENDARIO':
        return '#f59e0b';
      case 'MÍTICO':
        return '#ef4444';
      default:
        //nEGRO
        return '#000000';
    }
  }

  getRarezaGradient(rareza: string): string {
    rareza = rareza.charAt(0).toUpperCase() + rareza.slice(1);
    switch (rareza) {
      case 'COMÚN':
        return 'linear-gradient(135deg, #000000 0%, #9ca3af 100%)';
      case 'RARO':
        return 'linear-gradient(135deg, #3b82f6 0%, #60a5fa 100%)';
      case 'ÉPICO':
        return 'linear-gradient(135deg, #8b5cf6 0%, #a78bfa 100%)';
      case 'LEGENDARIO':
        return 'linear-gradient(135deg, #f59e0b 0%, #fbbf24 100%)';
      case 'MÍTICO':
        return 'linear-gradient(135deg, #ef4444 0%, #f87171 100%)';
      default:
        return 'linear-gradient(135deg, #0A9987 0%, #9ca3af 100%)';
    }
  }
}
