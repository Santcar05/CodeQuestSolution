export interface ResourceModel {
  id: number;
  title: string;
  description: string;
  icon: string;
  type: 'documento' | 'video' | 'repositorio' | 'articulo';
  url: string;
}
