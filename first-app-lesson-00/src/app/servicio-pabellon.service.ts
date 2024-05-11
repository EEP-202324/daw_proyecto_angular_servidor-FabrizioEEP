import { Injectable } from '@angular/core';
import { AtributosPabellon, FuncionalidadTipo } from './atributos-pabellon';

@Injectable({
  providedIn: 'root'
})
export class ServicioPabellonService {
  readonly baseUrl = 'https://angular.io/assets/images/tutorials/faa';

  atributosPabellonList: AtributosPabellon[] = [
    {
      id: 9999,
      nombre: 'Test Pabellón 1',
      ubicacion: 'Av.America',
      aforo: 2000,
      funcionalidad: FuncionalidadTipo.Aula,
      disponibilidad: true,
      photo: `${this.baseUrl}/bernard-hermant-CLKGGwIBTaY-unsplash.jpg`,
      fechaDisponibilidad: new Date('2002-12-12')
    },
    {
      id: 10001,
      nombre: 'Test Pabellón 2',
      ubicacion: 'Av. de la Paz',
      aforo: 1500,
      funcionalidad: FuncionalidadTipo.Auditorio,
      disponibilidad: false,
      photo: `${this.baseUrl}/brandon-griggs-wR11KBaB86U-unsplash.jpg`,
      fechaDisponibilidad: new Date('2003-05-25')
    },
    {
      id: 10002,
      nombre: 'Test Pabellón 3',
      ubicacion: 'Badajoz',
      aforo: 1800,
      funcionalidad: FuncionalidadTipo.Laboratorio,
      disponibilidad: true,
      photo: `${this.baseUrl}/i-do-nothing-but-love-lAyXdl1-Wmc-unsplash.jpg`,
      fechaDisponibilidad: new Date('2004-08-10')
    },
    {
      id: 10003,
      nombre: 'Test Pabellón 4',
      ubicacion: 'Gutierrez',
      aforo: 2200,
      funcionalidad: FuncionalidadTipo.Aula,
      disponibilidad: true,
      photo: `${this.baseUrl}/krzysztof-hepner-978RAXoXnH4-unsplash.jpg`,
      fechaDisponibilidad: new Date('2005-10-15')
    },
    {
      id: 10004,
      nombre: 'Test Pabellón 5',
      ubicacion: 'Av.Lagosta',
      aforo: 3000,
      funcionalidad: FuncionalidadTipo.Auditorio,
      disponibilidad: false,
      photo: `${this.baseUrl}/r-architecture-JvQ0Q5IkeMM-unsplash.jpg`,
      fechaDisponibilidad: new Date('2006-02-28')
    },
    {
      id: 10005,
      nombre: 'Test Pabellón 6',
      ubicacion: 'Felipe VII',
      aforo: 1800,
      funcionalidad: FuncionalidadTipo.Laboratorio,
      disponibilidad: true,
      photo: `${this.baseUrl}/phil-hearing-IYfp2Ixe9nM-unsplash.jpg`,
      fechaDisponibilidad: new Date('2007-07-20')
    },
    {
      id: 10006,
      nombre: 'Test Pabellón 7',
      ubicacion: 'Goya',
      aforo: 2500,
      funcionalidad: FuncionalidadTipo.Otro,
      disponibilidad: true,
      photo: `${this.baseUrl}/r-architecture-GGupkreKwxA-unsplash.jpg`,
      fechaDisponibilidad: new Date('2008-11-12')
    },
    {
      id: 10007,
      nombre: 'Test Pabellón 8',
      ubicacion: 'Pinto',
      aforo: 2800,
      funcionalidad: FuncionalidadTipo.Auditorio,
      disponibilidad: false,
      photo: `${this.baseUrl}/saru-robert-9rP3mxf8qWI-unsplash.jpg`,
      fechaDisponibilidad: new Date('2009-04-05')
    },
    {
      id: 10008,
      nombre: 'Test Pabellón 9',
      ubicacion: 'Lista',
      aforo: 2000,
      funcionalidad: FuncionalidadTipo.Aula,
      disponibilidad: true,
      photo: `${this.baseUrl}/webaliser-_TPTXZd9mOo-unsplash.jpg`,
      fechaDisponibilidad: new Date('2010-09-30')
    }
  ];

  getPabellones(): AtributosPabellon[] {
    return this.atributosPabellonList;
  }

  getPabellon(id: number): AtributosPabellon | undefined {
    return this.atributosPabellonList.find(atributosPabellon => atributosPabellon.id === id);
  }

  agregarPabellon(nombre: string, ubicacion: string, aforo: number, funcionalidad: FuncionalidadTipo, disponibilidad: boolean, photo: string, fechaDisponibilidad: Date) {
    console.log(`Aplicación de pabellon recibido: nombre: ${nombre}, ubicacion: ${ubicacion}, aforo: ${aforo}, funcionalidad: ${funcionalidad}, disponibilidad: ${disponibilidad}, photo: ${photo}, fechaDisponible${fechaDisponibilidad}`)
  }
}
