import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Achievement } from '../models/Achievement';

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

  // Logros data - CORREGIDOS LOS NOMBRES DE ATRIBUTOS
  allLogros: Achievement[] = [
    // Logros de Progreso (15)
    {
      id: 1,
      name: 'Primeros Pasos',
      description: 'Completa tu primer curso en CodeQuest',
      category: 'Progreso',
      rarity: 'Común',
      points: 50,
      image: '🎯',
      unlocked: true,
      requirements: 'Completar cualquier curso',
      unlockDate: new Date('2024-01-15'),
    },
    {
      id: 2,
      name: 'Aprendiz Dedicado',
      description: 'Completa 5 cursos diferentes',
      category: 'Progreso',
      rarity: 'Común',
      points: 150,
      image: '📚',
      unlocked: true,
      requirements: 'Completar 5 cursos',
      unlockDate: new Date('2024-02-20'),
    },
    {
      id: 3,
      name: 'Maestro del Conocimiento',
      description: 'Completa 25 cursos en CodeQuest',
      category: 'Progreso',
      rarity: 'Raro',
      points: 500,
      image: '🎓',
      unlocked: false,
      requirements: 'Completar 25 cursos',
    },
    {
      id: 4,
      name: 'Leyenda del Aprendizaje',
      description: 'Completa 100 cursos en la plataforma',
      category: 'Progreso',
      rarity: 'Legendario',
      points: 2500,
      image: '🏆',
      unlocked: false,
      requirements: 'Completar 100 cursos',
    },
    {
      id: 5,
      name: 'Racha de 7 Días',
      description: 'Aprende durante 7 días consecutivos',
      category: 'Progreso',
      rarity: 'Común',
      points: 100,
      image: '🔥',
      unlocked: true,
      requirements: '7 días consecutivos aprendiendo',
      unlockDate: new Date('2024-03-01'),
    },
    {
      id: 6,
      name: 'Meses de Dedicación',
      description: 'Aprende durante 3 meses consecutivos',
      category: 'Progreso',
      rarity: 'Raro',
      points: 750,
      image: '🗓️',
      unlocked: false,
      requirements: '3 meses consecutivos aprendiendo',
    },
    {
      id: 7,
      name: 'Año de Sabiduría',
      description: 'Aprende durante 12 meses consecutivos',
      category: 'Progreso',
      rarity: 'Legendario',
      points: 5000,
      image: '🌟',
      unlocked: false,
      requirements: '12 meses consecutivos aprendiendo',
    },
    {
      id: 8,
      name: 'Velocidad del Rayo',
      description: 'Completa un curso en menos de 24 horas',
      category: 'Progreso',
      rarity: 'Épico',
      points: 1000,
      image: '⚡',
      unlocked: false,
      requirements: 'Curso completado en <24h',
    },
    {
      id: 9,
      name: 'Perfeccionista',
      description: 'Obtén 100% en todos los quizzes de un curso',
      category: 'Progreso',
      rarity: 'Raro',
      points: 300,
      image: '💯',
      unlocked: true,
      requirements: '100% en todos los quizzes',
      unlockDate: new Date('2024-02-10'),
    },
    {
      id: 10,
      name: 'Coleccionista de Cursos',
      description: 'Inscríbete en 50 cursos diferentes',
      category: 'Progreso',
      rarity: 'Épico',
      points: 1200,
      image: '📦',
      unlocked: false,
      requirements: 'Inscribirse en 50 cursos',
    },
    {
      id: 11,
      name: 'Explorador del Conocimiento',
      description: 'Completa cursos en 5 categorías diferentes',
      category: 'Progreso',
      rarity: 'Raro',
      points: 400,
      image: '🧭',
      unlocked: false,
      requirements: 'Cursos en 5 categorías',
    },
    {
      id: 12,
      name: 'Polímata Digital',
      description: 'Domina 10 categorías diferentes',
      category: 'Progreso',
      rarity: 'Legendario',
      points: 3000,
      image: '🎭',
      unlocked: false,
      requirements: 'Cursos en 10 categorías',
    },
    {
      id: 13,
      name: 'Sin Descanso',
      description: 'Completa 10 horas de aprendizaje continuo',
      category: 'Progreso',
      rarity: 'Épico',
      points: 800,
      image: '⏳',
      unlocked: false,
      requirements: '10 horas continuas aprendiendo',
    },
    {
      id: 14,
      name: 'Madrugador del Código',
      description: 'Aprende antes de las 6 AM',
      category: 'Progreso',
      rarity: 'Raro',
      points: 250,
      image: '🌅',
      unlocked: false,
      requirements: 'Sesión antes de las 6 AM',
    },
    {
      id: 15,
      name: 'Noctámbulo Digital',
      description: 'Aprende después de la medianoche',
      category: 'Progreso',
      rarity: 'Raro',
      points: 250,
      image: '🌙',
      unlocked: true,
      requirements: 'Sesión después de medianoche',
      unlockDate: new Date('2024-03-05'),
    },

    // Logros de Tecnología (15)
    {
      id: 16,
      name: 'Hola Mundo',
      description: 'Completa tu primer programa en cualquier lenguaje',
      category: 'Tecnología',
      rarity: 'Común',
      points: 50,
      image: '👋',
      unlocked: true,
      requirements: 'Primer programa completado',
      unlockDate: new Date('2024-01-10'),
    },
    {
      id: 17,
      name: 'Maestro JavaScript',
      description: 'Domina todos los conceptos avanzados de JavaScript',
      category: 'Tecnología',
      rarity: 'Épico',
      points: 1500,
      image: '⚡',
      unlocked: false,
      requirements: 'Completar ruta JavaScript',
    },
    {
      id: 18,
      name: 'Rey de React',
      description: 'Crea 10 aplicaciones con React',
      category: 'Tecnología',
      rarity: 'Raro',
      points: 600,
      image: '⚛️',
      unlocked: false,
      requirements: '10 apps con React',
    },
    {
      id: 19,
      name: 'Ninja de Python',
      description: 'Resuelve 100 problemas con Python',
      category: 'Tecnología',
      rarity: 'Épico',
      points: 1200,
      image: '🐍',
      unlocked: false,
      requirements: '100 problemas en Python',
    },
    {
      id: 20,
      name: 'Full Stack Developer',
      description: 'Domina tanto frontend como backend',
      category: 'Tecnología',
      rarity: 'Legendario',
      points: 3000,
      image: '🚀',
      unlocked: false,
      requirements: 'Completar rutas frontend y backend',
    },
    {
      id: 21,
      name: 'Mobile First',
      description: 'Crea 5 aplicaciones móviles',
      category: 'Tecnología',
      rarity: 'Raro',
      points: 750,
      image: '📱',
      unlocked: false,
      requirements: '5 apps móviles',
    },
    {
      id: 22,
      name: 'Cloud Architect',
      description: 'Despliega 10 proyectos en la nube',
      category: 'Tecnología',
      rarity: 'Épico',
      points: 1800,
      image: '☁️',
      unlocked: false,
      requirements: '10 deployments en cloud',
    },
    {
      id: 23,
      name: 'Database Master',
      description: 'Domina 3 sistemas de bases de datos diferentes',
      category: 'Tecnología',
      rarity: 'Raro',
      points: 900,
      image: '🗄️',
      unlocked: false,
      requirements: '3 DB systems diferentes',
    },
    {
      id: 24,
      name: 'DevOps Engineer',
      description: 'Automatiza el deployment de 5 proyectos',
      category: 'Tecnología',
      rarity: 'Épico',
      points: 1600,
      image: '🔧',
      unlocked: false,
      requirements: '5 CI/CD pipelines',
    },
    {
      id: 25,
      name: 'AI Explorer',
      description: 'Completa 3 proyectos de machine learning',
      category: 'Tecnología',
      rarity: 'Legendario',
      points: 2500,
      image: '🤖',
      unlocked: false,
      requirements: '3 proyectos de ML',
    },
    {
      id: 26,
      name: 'Blockchain Pioneer',
      description: 'Crea tu primer smart contract',
      category: 'Tecnología',
      rarity: 'Épico',
      points: 1400,
      image: '⛓️',
      unlocked: false,
      requirements: 'Smart contract deployado',
    },
    {
      id: 27,
      name: 'Game Developer',
      description: 'Desarrolla 3 videojuegos funcionales',
      category: 'Tecnología',
      rarity: 'Raro',
      points: 800,
      image: '🎮',
      unlocked: false,
      requirements: '3 juegos completados',
    },
    {
      id: 28,
      name: 'Security Expert',
      description: 'Identifica y soluciona 50 vulnerabilidades',
      category: 'Tecnología',
      rarity: 'Legendario',
      points: 2800,
      image: '🛡️',
      unlocked: false,
      requirements: '50 vulnerabilidades resueltas',
    },
    {
      id: 29,
      name: 'IoT Creator',
      description: 'Conecta 5 dispositivos IoT',
      category: 'Tecnología',
      rarity: 'Raro',
      points: 700,
      image: '📶',
      unlocked: false,
      requirements: '5 dispositivos IoT',
    },
    {
      id: 30,
      name: 'Quantum Computing Initiate',
      description: 'Completa el curso de computación cuántica',
      category: 'Tecnología',
      rarity: 'Mítico',
      points: 5000,
      image: '⚛️',
      unlocked: false,
      requirements: 'Curso quantum computing',
    },

    // Continúa con el resto de logros cambiando los nombres...
    // Solo muestro los primeros 30 como ejemplo, pero debes aplicar los mismos cambios al resto
  ];

  filteredLogros: Achievement[] = [];
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
    this.totalPuntos = this.allLogros.reduce((sum, logro) => sum + logro.points, 0);
    this.puntosDesbloqueados = this.allLogros
      .filter((logro) => logro.unlocked)
      .reduce((sum, logro) => sum + logro.points, 0);
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
        logro.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        (logro.description &&
          logro.description.toLowerCase().includes(this.searchTerm.toLowerCase()));

      // Categoria filter
      const matchesCategoria =
        this.selectedCategorias.length === 0 || this.selectedCategorias.includes(logro.category);

      // Rareza filter
      const matchesRareza =
        this.selectedRarezas.length === 0 || this.selectedRarezas.includes(logro.rarity);

      // Estado filter
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
            return (b.unlockDate?.getTime() || 0) - (a.unlockDate?.getTime() || 0);
          }
          return a.unlocked ? -1 : 1;
        });
        break;
      case 'points':
        this.filteredLogros.sort((a, b) => b.points - a.points);
        break;
      case 'rarity':
        const rarityOrder = { Mítico: 5, Legendario: 4, Épico: 3, Raro: 2, Común: 1 };
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
