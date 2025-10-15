import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from '../sidebar-component/sidebar-component';

export interface Publicacion {
  id: number;
  usuario: string;
  avatar: string;
  nivel: string;
  fecha: string;
  contenido: string;
  imagen?: string;
  likes: number;
  comentarios: { usuario: string; texto: string; avatar: string }[];
  liked: boolean;
}

export interface MiembroDestacado {
  id: number;
  nombre: string;
  avatar: string;
  nivel: string;
  puntos: number;
  insignia: string;
  online: boolean;
}

export interface Tendencia {
  id: number;
  tag: string;
  publicaciones: number;
  trending: boolean;
}

@Component({
  selector: 'app-comunidad',
  standalone: true,
  imports: [CommonModule, FormsModule, SidebarComponent],
  templateUrl: './comunidad-component.html',
  styleUrls: ['./comunidad-component.css'],
})
export class ComunidadComponent implements OnInit {
  // Datos del usuario actual
  usuarioActual = {
    nombre: 'TuNombre',
    avatar: '👨‍💻',
    nivel: 'Avanzado',
  };

  // Formulario nueva publicación
  nuevoContenido: string = '';
  nuevaImagen: string = '';
  publicando: boolean = false;

  // Lista de publicaciones
  publicaciones: Publicacion[] = [
    {
      id: 1,
      usuario: 'Ana García',
      avatar: '👩‍💻',
      nivel: 'Avanzado',
      fecha: 'Hace 2 horas',
      contenido:
        '¡Acabo de completar el curso de Angular! 🎉 La inyección de dependencias y los servicios son increíbles. ¿Alguien más está aprendiendo Angular?',
      imagen: 'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=600&h=400&fit=crop',
      likes: 24,
      liked: false,
      comentarios: [
        { usuario: 'Carlos López', texto: '¡Felicidades Ana! Angular es genial 🚀', avatar: '👨‍🎓' },
        {
          usuario: 'María Fernández',
          texto: 'Estoy empezando con Angular, algún consejo?',
          avatar: '👩‍🎨',
        },
      ],
    },
    {
      id: 2,
      usuario: 'David Chen',
      avatar: '👨‍🔬',
      nivel: 'Experto',
      fecha: 'Hace 5 horas',
      contenido:
        'Comparto mi último proyecto: una aplicación de gestión de tareas con React y TypeScript. Incluye drag & drop y sincronización en tiempo real!',
      imagen: 'https://images.unsplash.com/photo-1551650975-87deedd944c3?w=600&h=400&fit=crop',
      likes: 42,
      liked: true,
      comentarios: [
        {
          usuario: 'Laura Martínez',
          texto: 'Increíble trabajo David! El código está muy limpio 👏',
          avatar: '👩‍💼',
        },
      ],
    },
    {
      id: 3,
      usuario: 'Sofia Rodríguez',
      avatar: '👩‍🔧',
      nivel: 'Intermedio',
      fecha: 'Hace 1 día',
      contenido:
        'Alguien tiene experiencia con WebSockets en Node.js? Estoy implementando un chat en tiempo real y tengo dudas sobre la escalabilidad.',
      likes: 15,
      liked: false,
      comentarios: [
        {
          usuario: 'Pedro González',
          texto: 'Te recomiendo usar Socket.IO, maneja reconexiones automáticamente',
          avatar: '👨‍🏫',
        },
        {
          usuario: 'David Chen',
          texto: 'Para escalar, considera usar Redis con Socket.IO 👍',
          avatar: '👨‍🔬',
        },
      ],
    },
    {
      id: 4,
      usuario: 'Miguel Torres',
      avatar: '👨‍🚀',
      nivel: 'Principiante',
      fecha: 'Hace 1 día',
      contenido:
        'Mi primer "Hello World" en Python! 🐍 Estoy emocionado por comenzar este viaje en la programación. ¿Qué me recomiendan aprender después?',
      likes: 38,
      liked: false,
      comentarios: [
        {
          usuario: 'Ana García',
          texto: '¡Bienvenido Miguel! Te recomiendo empezar con los fundamentos de programación',
          avatar: '👩‍💻',
        },
        {
          usuario: 'Elena Vargas',
          texto: 'Felicidades! Python es un gran lenguaje para empezar 🎯',
          avatar: '👩‍🔬',
        },
      ],
    },
    {
      id: 5,
      usuario: 'Laura Martínez',
      avatar: '👩‍💼',
      nivel: 'Avanzado',
      fecha: 'Hace 2 días',
      contenido:
        'Acabo de publicar mi primer paquete en NPM! 🎊 Es una librería de utilidades para fechas en JavaScript. Link en comentarios.',
      imagen: 'https://images.unsplash.com/photo-1526374965328-7f61d4dc18c5?w=600&h=400&fit=crop',
      likes: 57,
      liked: true,
      comentarios: [
        {
          usuario: 'Carlos López',
          texto: '¡Impresionante Laura! Voy a probarlo en mi proyecto',
          avatar: '👨‍🎓',
        },
        {
          usuario: 'Sofia Rodríguez',
          texto: 'Muy útil la librería, buena documentación 👌',
          avatar: '👩‍🔧',
        },
      ],
    },
  ];

  // Miembros destacados
  miembrosDestacados: MiembroDestacado[] = [
    {
      id: 1,
      nombre: 'David Chen',
      avatar: '👨‍🔬',
      nivel: 'Experto',
      puntos: 2840,
      insignia: '🏆',
      online: true,
    },
    {
      id: 2,
      nombre: 'Ana García',
      avatar: '👩‍💻',
      nivel: 'Avanzado',
      puntos: 2150,
      insignia: '⭐',
      online: true,
    },
    {
      id: 3,
      nombre: 'Carlos López',
      avatar: '👨‍🎓',
      nivel: 'Avanzado',
      puntos: 1980,
      insignia: '🚀',
      online: false,
    },
    {
      id: 4,
      nombre: 'Elena Vargas',
      avatar: '👩‍🔬',
      nivel: 'Experto',
      puntos: 2650,
      insignia: '🎯',
      online: true,
    },
    {
      id: 5,
      nombre: 'Pedro González',
      avatar: '👨‍🏫',
      nivel: 'Intermedio',
      puntos: 1420,
      insignia: '💡',
      online: false,
    },
  ];

  // Tendencias
  tendencias: Tendencia[] = [
    { id: 1, tag: '#Angular', publicaciones: 142, trending: true },
    { id: 2, tag: '#TypeScript', publicaciones: 98, trending: true },
    { id: 3, tag: '#WebDevelopment', publicaciones: 87, trending: false },
    { id: 4, tag: '#AIProgramming', publicaciones: 76, trending: true },
    { id: 5, tag: '#ReactJS', publicaciones: 203, trending: false },
    { id: 6, tag: '#Python', publicaciones: 165, trending: true },
  ];

  // Comentario temporal
  nuevoComentario: string = '';
  comentarioActivo: number | null = null;

  ngOnInit() {
    // Simular carga inicial
    setTimeout(() => {
      document.querySelectorAll('.publicacion-card').forEach((card, index) => {
        (card as HTMLElement).style.animationDelay = `${index * 100}ms`;
      });
    }, 100);
  }

  darLike(publicacionId: number) {
    const publicacion = this.publicaciones.find((p) => p.id === publicacionId);
    if (publicacion) {
      if (publicacion.liked) {
        publicacion.likes--;
        publicacion.liked = false;
      } else {
        publicacion.likes++;
        publicacion.liked = true;

        // Efecto visual de like
        const likeBtn = document.querySelector(`[data-publicacion="${publicacionId}"] .like-btn`);
        if (likeBtn) {
          likeBtn.classList.add('liked-animation');
          setTimeout(() => likeBtn.classList.remove('liked-animation'), 600);
        }
      }
    }
  }

  toggleComentario(publicacionId: number) {
    this.comentarioActivo = this.comentarioActivo === publicacionId ? null : publicacionId;
    this.nuevoComentario = '';
  }

  agregarComentario(publicacionId: number) {
    if (!this.nuevoComentario.trim()) return;

    const publicacion = this.publicaciones.find((p) => p.id === publicacionId);
    if (publicacion) {
      publicacion.comentarios.push({
        usuario: this.usuarioActual.nombre,
        texto: this.nuevoComentario,
        avatar: this.usuarioActual.avatar,
      });
      this.nuevoComentario = '';
      this.comentarioActivo = null;
    }
  }

  crearPublicacion() {
    if (!this.nuevoContenido.trim() && !this.nuevaImagen) return;

    this.publicando = true;

    setTimeout(() => {
      const nuevaPublicacion: Publicacion = {
        id: this.publicaciones.length + 1,
        usuario: this.usuarioActual.nombre,
        avatar: this.usuarioActual.avatar,
        nivel: this.usuarioActual.nivel,
        fecha: 'Ahora mismo',
        contenido: this.nuevoContenido,
        imagen: this.nuevaImagen || undefined,
        likes: 0,
        liked: false,
        comentarios: [],
      };

      this.publicaciones.unshift(nuevaPublicacion);
      this.limpiarFormulario();
      this.publicando = false;

      // Scroll to top para ver la nueva publicación
      window.scrollTo({ top: 0, behavior: 'smooth' });
    }, 1000);
  }

  limpiarFormulario() {
    this.nuevoContenido = '';
    this.nuevaImagen = '';
  }

  getNivelColor(nivel: string): string {
    switch (nivel) {
      case 'Principiante':
        return '#10b981';
      case 'Intermedio':
        return '#3b82f6';
      case 'Avanzado':
        return '#8b5cf6';
      case 'Experto':
        return '#f59e0b';
      default:
        return '#6b7280';
    }
  }

  getNivelGradient(nivel: string): string {
    switch (nivel) {
      case 'Principiante':
        return 'linear-gradient(135deg, #10b981 0%, #34d399 100%)';
      case 'Intermedio':
        return 'linear-gradient(135deg, #3b82f6 0%, #60a5fa 100%)';
      case 'Avanzado':
        return 'linear-gradient(135deg, #8b5cf6 0%, #a78bfa 100%)';
      case 'Experto':
        return 'linear-gradient(135deg, #f59e0b 0%, #fbbf24 100%)';
      default:
        return 'linear-gradient(135deg, #6b7280 0%, #9ca3af 100%)';
    }
  }

  onImageLoad(event: Event) {
    const img = event.target as HTMLImageElement;
    img.classList.add('fade-in');
  }
}
