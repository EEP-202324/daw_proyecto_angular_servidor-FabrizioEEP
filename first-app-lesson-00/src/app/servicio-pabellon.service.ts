import { Injectable } from '@angular/core';
import { AtributosPabellon, FuncionalidadTipo } from './atributos-pabellon';

@Injectable({
  providedIn: 'root'
})
export class ServicioPabellonService {
  readonly baseUrl = 'https://angular.io/assets/images/tutorials/faa';

  atributosPabellonList: AtributosPabellon[] = [];

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
