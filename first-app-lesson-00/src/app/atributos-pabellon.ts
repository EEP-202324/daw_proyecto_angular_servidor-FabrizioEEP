export interface AtributosPabellon {
  id: number;
  nombre: string;
  ubicacion: number;
  aforo: number;
  funcionalidad: FuncionalidadTipo;
  disponibilidad: boolean;
  photo: string;
  serviciosAdicionales: string[];
  fechaDisponibilidad: Date;
}

export enum FuncionalidadTipo {
  Auditorio = 'Auditorio',
  Aula = 'Aula',
  Laboratorio = 'Laboratorio',
  Otro = 'Otro',
}
