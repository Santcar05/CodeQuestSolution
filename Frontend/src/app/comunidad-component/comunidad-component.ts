import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from '../sidebar-component/sidebar-component';
import { Post } from '../models/Post';
import { FeaturedUser } from '../models/FeaturedUser';
import { Trend } from '../models/Trend';

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
  publicaciones: Post[] = [
    {
      id: 1,
      user: 'Ana García',
      avatar: '👩‍💻',
      level: 'Avanzado',
      date: 'Hace 2 horas',
      content:
        '¡Acabo de completar el curso de Angular! 🎉 La inyección de dependencias y los servicios son increíbles. ¿Alguien más está aprendiendo Angular?',
      image: 'https://images.unsplash.com/photo-1627398242454-45a1465c2479?w=600&h=400&fit=crop',
      likes: 24,
      liked: false,
      comments: [
        {
          id: 1,
          user: 'Carlos López',
          text: '¡Felicidades Ana! Angular es genial 🚀',
          avatar: '👨‍🎓',
          timestamp: new Date(),
          likes: 3,
        },
        {
          id: 2,
          user: 'María Fernández',
          text: 'Estoy empezando con Angular, algún consejo?',
          avatar: '👩‍🎨',
          timestamp: new Date(),
          likes: 1,
        },
      ],
    },
    {
      id: 2,
      user: 'David Chen',
      avatar: '👨‍🔬',
      level: 'Experto',
      date: 'Hace 5 horas',
      content:
        'Comparto mi último proyecto: una aplicación de gestión de tareas con React y TypeScript. Incluye drag & drop y sincronización en tiempo real!',
      image: 'https://images.unsplash.com/photo-1551650975-87deedd944c3?w=600&h=400&fit=crop',
      likes: 42,
      liked: true,
      comments: [
        {
          id: 1,
          user: 'Laura Martínez',
          text: 'Increíble trabajo David! El código está muy limpio 👏',
          avatar: '👩‍💼',
          timestamp: new Date(),
          likes: 4,
        },
      ],
    },
    {
      id: 3,
      user: 'Sofia Rodríguez',
      avatar: '👩‍🔧',
      level: 'Intermedio',
      date: 'Hace 1 día',
      content:
        '¿Alguien tiene experiencia con WebSockets en Node.js? Estoy implementando un chat en tiempo real y tengo dudas sobre la escalabilidad.',
      likes: 15,
      liked: false,
      comments: [
        {
          id: 1,
          user: 'Pedro González',
          text: 'Te recomiendo usar Socket.IO, maneja reconexiones automáticamente',
          avatar: '👨‍🏫',
          timestamp: new Date(),
          likes: 2,
        },
        {
          id: 2,
          user: 'David Chen',
          text: 'Para escalar, considera usar Redis con Socket.IO 👍',
          avatar: '👨‍🔬',
          timestamp: new Date(),
          likes: 1,
        },
      ],
    },
    {
      id: 4,
      user: 'Miguel Torres',
      avatar: '👨‍🚀',
      level: 'Principiante',
      date: 'Hace 1 día',
      content:
        '¡Mi primer "Hello World" en Python! 🐍 Estoy emocionado por comenzar este viaje en la programación. ¿Qué me recomiendan aprender después?',
      likes: 38,
      liked: false,
      comments: [
        {
          id: 1,
          user: 'Ana García',
          text: '¡Bienvenido Miguel! Te recomiendo empezar con los fundamentos de programación',
          avatar: '👩‍💻',
          timestamp: new Date(),
          likes: 2,
        },
        {
          id: 2,
          user: 'Elena Vargas',
          text: 'Felicidades! Python es un gran lenguaje para empezar 🎯',
          avatar: '👩‍🔬',
          timestamp: new Date(),
          likes: 1,
        },
      ],
    },
    {
      id: 5,
      user: 'Laura Martínez',
      avatar: '👩‍💼',
      level: 'Avanzado',
      date: 'Hace 2 días',
      content:
        '¡Acabo de publicar mi primer paquete en NPM! 🎊 Es una librería de utilidades para fechas en JavaScript. Link en comentarios.',
      image: 'https://images.unsplash.com/photo-1526374965328-7f61d4dc18c5?w=600&h=400&fit=crop',
      likes: 57,
      liked: true,
      comments: [
        {
          id: 1,
          user: 'Carlos López',
          text: '¡Impresionante Laura! Voy a probarlo en mi proyecto',
          avatar: '👨‍🎓',
          timestamp: new Date(),
          likes: 5,
        },
        {
          id: 2,
          user: 'Sofia Rodríguez',
          text: 'Muy útil la librería, buena documentación 👌',
          avatar: '👩‍🔧',
          timestamp: new Date(),
          likes: 3,
        },
      ],
    },
  ];

  // Miembros destacados
  miembrosDestacados: FeaturedUser[] = [
    {
      id: 1,
      name: 'David Chen',
      avatar: '👨‍🔬',
      level: 'Experto',
      points: 2840,
      badges: '🏆',
      online: true,
    },
    {
      id: 2,
      name: 'Ana García',
      avatar: '👩‍💻',
      level: 'Avanzado',
      points: 2150,
      badges: '⭐',
      online: true,
    },
    {
      id: 3,
      name: 'Carlos López',
      avatar: '👨‍🎓',
      level: 'Avanzado',
      points: 1980,
      badges: '🚀',
      online: false,
    },
    {
      id: 4,
      name: 'Elena Vargas',
      avatar: '👩‍🔬',
      level: 'Experto',
      points: 2650,
      badges: '🎯',
      online: true,
    },
    {
      id: 5,
      name: 'Pedro González',
      avatar: '👨‍🏫',
      level: 'Intermedio',
      points: 1420,
      badges: '💡',
      online: false,
    },
  ];

  // Tendencias
  tendencias: Trend[] = [
    { id: 1, tag: '#Angular', posts: 142, trending: true },
    { id: 2, tag: '#TypeScript', posts: 98, trending: true },
    { id: 3, tag: '#WebDevelopment', posts: 87, trending: false },
    { id: 4, tag: '#AIProgramming', posts: 76, trending: true },
    { id: 5, tag: '#ReactJS', posts: 203, trending: false },
    { id: 6, tag: '#Python', posts: 165, trending: true },
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
      publicacion.comments.push({
        user: this.usuarioActual.nombre,
        text: this.nuevoComentario,
        avatar: this.usuarioActual.avatar,
        id: 0,
        timestamp: new Date(),
        likes: 0,
      });
      this.nuevoComentario = '';
      this.comentarioActivo = null;
    }
  }

  crearPublicacion() {
    if (!this.nuevoContenido.trim() && !this.nuevaImagen) return;

    this.publicando = true;

    setTimeout(() => {
      const nuevaPublicacion: Post = {
        id: this.publicaciones.length + 1,
        user: this.usuarioActual.nombre,
        avatar: this.usuarioActual.avatar,
        level: this.usuarioActual.nivel,
        date: 'Ahora mismo',
        content: this.nuevoContenido,
        image: this.nuevaImagen || undefined,
        likes: 0,
        liked: false,
        comments: [],
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
