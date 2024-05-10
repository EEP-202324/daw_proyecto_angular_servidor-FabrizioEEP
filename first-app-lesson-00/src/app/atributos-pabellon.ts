export interface AtributosPabellon {
  id: number;
  nombre: string;
  ubicacion: number;
  aforo: number;
  funcionalidad: FuncionalidadTipo;
  disponibilidad: boolean;
  photo: string;
  // serviciosAdicionales: string[]; NO. Porque para cada tabla de BD solo acepta una palabra
  fechaDisponibilidad: Date;
}

export enum FuncionalidadTipo {
  Auditorio = 'Auditorio',
  Aula = 'Aula',
  Laboratorio = 'Laboratorio',
  Otro = 'Otro',
}

// COnvertirlo en una talba en base de datos.
