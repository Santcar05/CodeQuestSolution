import { Routes } from '@angular/router';
import path from 'path';

export const routes: Routes = [
  {
    path: 'inicio',
    loadComponent: () =>
      import('./dashboard-component/dashboard-component').then((m) => m.DashboardComponent),
  },
  {
    path: 'catalogo-cursos',
    loadComponent: () =>
      import('./ver-cursos-component/ver-cursos-component').then((m) => m.VerCursosComponent),
  },
  {
    path: 'detalle-curso/:id',
    loadComponent: () =>
      import('./detalle-curso-component/detalle-curso-component').then(
        (m) => m.DetalleCursoComponent
      ),
  },
  {
    path: 'shop',
    loadComponent: () =>
      import('./tienda-codequest-component/tienda-codequest-component').then(
        (m) => m.TiendaCodequestComponent
      ),
  },
  {
    path: 'logros',
    loadComponent: () =>
      import('./logros-component/logros-component').then((m) => m.LogrosComponent),
  },
  {
    path: '',
    loadComponent: () =>
      import('./dashboard-component/dashboard-component').then((m) => m.DashboardComponent),
  },
];
