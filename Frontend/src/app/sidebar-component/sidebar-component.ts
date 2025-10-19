// sidebar.component.ts
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { UserProfile } from '../models/UserProfile';
import { MenuItem } from '../models/MenuItem';

@Component({
  selector: 'app-sidebar-component',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sidebar-component.html',
  styleUrls: ['./sidebar-component.css'],
})
export class SidebarComponent implements OnInit {
  constructor(private router: Router) {}

  isCollapsed = false;
  activeItem = 'inicio';

  userProfile: UserProfile = {
    id: 0,
    name: 'Santiago Castro',
    level: 24,
    xp: 3250,
    maxXp: 5000,
    avatar: 'https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?w=150&h=150&fit=crop',
    rank: 'Maestro del Código',
  };

  menuItems: MenuItem[] = [
    {
      id: 'inicio',
      label: 'Inicio',
      icon: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"/><polyline points="9 22 9 12 15 12 15 22"/></svg>',
      path: '',
    },
    {
      id: 'mi-ruta',
      label: 'Mi Ruta',
      icon: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0 1 18 0z"/><circle cx="12" cy="10" r="3"/></svg>',
      path: '/mi-ruta',
      badge: 3,
    },
    {
      id: 'catalogo-cursos',
      label: 'Cursos',
      icon: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M2 3h6a4 4 0 0 1 4 4v14a3 3 0 0 0-3-3H2z"/><path d="M22 3h-6a4 4 0 0 0-4 4v14a3 3 0 0 1 3-3h7z"/></svg>',
      path: '/catalogo-cursos',
    },
    {
      id: 'logros',
      label: 'Logros',
      icon: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M6 9H4.5a2.5 2.5 0 0 1 0-5H6"/><path d="M18 9h1.5a2.5 2.5 0 0 0 0-5H18"/><path d="M4 22h16"/><path d="M10 14.66V17c0 .55-.47.98-.97 1.21C7.85 18.75 7 20.24 7 22"/><path d="M14 14.66V17c0 .55.47.98.97 1.21C16.15 18.75 17 20.24 17 22"/><path d="M18 2H6v7a6 6 0 0 0 12 0V2Z"/></svg>',
      path: '/logros',
      badge: 2,
    },
    {
      id: 'comunidad',
      label: 'Comunidad',
      icon: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"/><circle cx="9" cy="7" r="4"/><path d="M23 21v-2a4 4 0 0 0-3-3.87"/><path d="M16 3.13a4 4 0 0 1 0 7.75"/></svg>',
      path: '/comunidad',
      badge: 12,
    },
    {
      id: 'empleabilidad',
      label: 'Empleabilidad',
      icon: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><rect x="2" y="7" width="20" height="14" rx="2" ry="2"/><path d="M16 21V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16"/></svg>',
      path: '/employability',
      isNew: true,
    },
    {
      id: 'Proyectos',
      label: 'Proyectos',
      icon: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2"/></svg>',
      path: '/proyectos',
    },
    {
      id: 'shop',
      label: 'CodeTienda',
      icon: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><circle cx="9" cy="21" r="1"/><circle cx="20" cy="21" r="1"/><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"/></svg>',
      path: '/shop',
    },

    //Cerrar Sesion
    {
      id: 'logout',
      label: 'Cerrar Sesion',
      icon: '<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"/><path d="M16 17l5-5-5-5"/><path d="M21 12H9"/></svg>',
      path: '/logout',
    },
  ];

  ngOnInit() {
    // Inicialización del componente
  }

  toggleSidebar() {
    this.isCollapsed = !this.isCollapsed;
  }

  setActiveItem(itemId: string) {
    this.activeItem = itemId;
    // Lógica de Navegacion
    this.router.navigate([`/${itemId}`]);

    console.log('Navegando a:', itemId);
  }
}
