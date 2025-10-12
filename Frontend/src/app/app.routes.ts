import { Routes } from '@angular/router';
import path from 'path';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./dashboard-component/dashboard-component').then((m) => m.DashboardComponent),
  },
];
