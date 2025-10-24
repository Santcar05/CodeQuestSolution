import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SkillService } from '../service/Skill/skill-service';
import { Skill } from '../models/Skill';

@Component({
  selector: 'app-admin-skill',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './admin-skill-component.html',
  styleUrls: ['./admin-skill-component.css'],
})
export class AdminSkillComponent implements OnInit {
  skills: Skill[] = [];
  filteredSkills: Skill[] = [];
  selectedSkill: Skill | null = null;
  isEditMode: boolean = false;
  isModalOpen: boolean = false;
  isDeleteModalOpen: boolean = false;
  skillToDelete: Skill | null = null;
  searchTerm: string = '';
  filterCategory: string = 'all';
  sortBy: string = 'name';
  isLoading: boolean = false;
  showSuccessMessage: boolean = false;
  successMessage: string = '';
  showErrorMessage: boolean = false;
  errorMessage: string = '';

  newSkill: Skill = {
    name: '',
    level: 0,
    target: 100,
    category: 'TECNICA',
  };

  categories = [
    { value: 'TECNICA', label: 'TECNICA', icon: '💻', color: '#ff5a00' },
    { value: 'BLANDA', label: 'BLANDA', icon: '🤝', color: '#10b981' },
    //{ value: 'technical', label: 'Technical', icon: '⚙️', color: '#3b82f6' },
    //{ value: 'soft', label: 'Soft', icon: '💡', color: '#f59e0b' },
  ];

  constructor(private skillService: SkillService) {}

  ngOnInit(): void {
    this.loadSkills();
  }

  loadSkills(): void {
    this.isLoading = true;
    this.skillService.findAll().subscribe({
      next: (skills) => {
        this.skills = skills;
        this.applyFilters();
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error loading skills:', err);
        this.showError('Error al cargar las habilidades');
        this.isLoading = false;
      },
    });
  }

  applyFilters(): void {
    let result = [...this.skills];

    // Aplicar filtro de búsqueda
    if (this.searchTerm.trim()) {
      result = result.filter((skill) =>
        skill.name.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    }

    // Aplicar filtro de categoría
    if (this.filterCategory !== 'all') {
      result = result.filter((skill) => skill.category === this.filterCategory);
    }

    // Aplicar ordenamiento
    result.sort((a, b) => {
      switch (this.sortBy) {
        case 'name':
          return a.name.localeCompare(b.name);
        //case 'level':
        //return (b.level || 0) - (a.level || 0);
        case 'category':
          return (a.category || '').localeCompare(b.category || '');
        default:
          return 0;
      }
    });

    this.filteredSkills = result;
  }

  onSearchChange(): void {
    this.applyFilters();
  }

  onFilterChange(): void {
    this.applyFilters();
  }

  onSortChange(): void {
    this.applyFilters();
  }

  openCreateModal(): void {
    this.isEditMode = false;
    this.newSkill = {
      name: '',
      level: 0,
      target: 100,
      category: 'TECNICA',
    };
    this.isModalOpen = true;
  }

  openEditModal(skill: Skill): void {
    this.isEditMode = true;
    this.newSkill = { ...skill };
    this.isModalOpen = true;
  }

  closeModal(): void {
    this.isModalOpen = false;
    this.newSkill = {
      name: '',
      level: 0,
      target: 100,
      category: 'TECNICA',
    };
  }

  saveSkill(): void {
    if (!this.validateSkill()) {
      return;
    }

    this.isLoading = true;

    if (this.isEditMode && this.newSkill.id) {
      this.skillService.update(this.newSkill).subscribe({
        next: (updatedSkill) => {
          const index = this.skills.findIndex((s) => s.id === updatedSkill.id);
          if (index !== -1) {
            this.skills[index] = updatedSkill;
          }
          this.applyFilters();
          this.showSuccess('Habilidad actualizada exitosamente');
          this.closeModal();
          this.isLoading = false;
        },
        error: (err) => {
          console.error('Error updating skill:', err);
          this.showError('Error al actualizar la habilidad');
          this.isLoading = false;
        },
      });
    } else {
      this.skillService.save(this.newSkill).subscribe({
        next: (createdSkill) => {
          this.skills.push(createdSkill);
          this.applyFilters();
          this.showSuccess('Habilidad creada exitosamente');
          this.closeModal();
          this.isLoading = false;
        },
        error: (err) => {
          console.error('Error creating skill:', err);
          this.showError('Error al crear la habilidad');
          this.isLoading = false;
        },
      });
    }
  }

  validateSkill(): boolean {
    if (!this.newSkill.name.trim()) {
      this.showError('El nombre de la habilidad es requerido');
      return false;
    }
    /*
    if (this.newSkill.level < 0 || this.newSkill.level > 100) {
      this.showError('El nivel debe estar entre 0 y 100');
      return false;
    }
    if (this.newSkill.target && (this.newSkill.target < 0 || this.newSkill.target > 100)) {
      this.showError('El objetivo debe estar entre 0 y 100');
      return false;
    }
      */
    return true;
  }

  openDeleteModal(skill: Skill): void {
    this.skillToDelete = skill;
    this.isDeleteModalOpen = true;
  }

  closeDeleteModal(): void {
    this.isDeleteModalOpen = false;
    this.skillToDelete = null;
  }

  confirmDelete(): void {
    if (this.skillToDelete && this.skillToDelete.id) {
      this.isLoading = true;
      this.skillService.delete(this.skillToDelete.id).subscribe({
        next: () => {
          this.skills = this.skills.filter((s) => s.id !== this.skillToDelete!.id);
          this.applyFilters();
          this.showSuccess('Habilidad eliminada exitosamente');
          this.closeDeleteModal();
          this.isLoading = false;
        },
        error: (err) => {
          console.error('Error deleting skill:', err);
          this.showError('Error al eliminar la habilidad');
          this.isLoading = false;
        },
      });
    }
  }

  showSuccess(message: string): void {
    this.successMessage = message;
    this.showSuccessMessage = true;
    setTimeout(() => {
      this.showSuccessMessage = false;
    }, 3000);
  }

  showError(message: string): void {
    this.errorMessage = message;
    this.showErrorMessage = true;
    setTimeout(() => {
      this.showErrorMessage = false;
    }, 3000);
  }

  getCategoryInfo(category: string | undefined) {
    return this.categories.find((c) => c.value === category) || this.categories[0];
  }

  getSkillsByCategory(category: string): number {
    return this.skills.filter((s) => s.category === category).length;
  }

  getAverageLevel(): number {
    if (this.skills.length === 0) return 0;
    const sum = this.skills.reduce((acc, skill) => acc + (skill.level || 0), 0);
    return Math.round(sum / this.skills.length);
    return 0;
  }

  getProgressPercentage(skill: Skill): number {
    /*
    if (!skill.target || skill.target === 0) return 100;
    return Math.min(Math.round((skill.level / skill.target) * 100), 100);
  }
    */
    return 0;
  }
}
