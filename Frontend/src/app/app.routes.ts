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

    path: 'pago',
    loadComponent: () =>
      import('./payment-component/payment-component').then((m) => m.PaymentComponent),
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
    path: 'comunidad',
    loadComponent: () =>
      import('./comunidad-component/comunidad-component').then((m) => m.ComunidadComponent),
  },
  {

    path: 'mi-ruta',
    loadComponent: () =>
      import('./mi-ruta-component/mi-ruta-component').then((m) => m.MiRutaComponent),
  },
  {
    path: 'ruta-profesional/:id',
    loadComponent: () =>
      import('./ruta-profesional-component/ruta-profesional-component').then(
        (m) => m.RutaProfesionalComponent
      ),
  },
  {
    path: 'detalle-proyecto/:id',
    loadComponent: () =>
      import('./detalle-proyecto-component/detalle-proyecto-component').then(
        (m) => m.DetalleProyectoComponent
      ),
  },
  {
    path: 'visualizar-tema/:id',
    loadComponent: () =>
      import('./visualizar-tema-component/visualizar-tema-component').then(
        (m) => m.VisualizarTemaComponent
      ),
  },
  {
    path: 'examen/:id',
    loadComponent: () =>
      import('./examen-component/examen-component').then((m) => m.ExamenComponent),
  },
  {
    path: '',
    loadComponent: () =>
      import('./formulario-inicial-component/formulario-inicial-component').then(
        (m) => m.FormularioInicialComponent
      ),
  },


];
