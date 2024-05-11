import { Injectable } from '@angular/core';
import { AtributosPabellon, FuncionalidadTipo } from './atributos-pabellon';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServicioPabellonService {
  readonly baseUrl = 'https://angular.io/assets/images/tutorials/faa';
  url = 'http://localhost:3000/locations';
  constructor(private http: HttpClient) { }

  getPabellones() {
    return this.http.get<AtributosPabellon[]>(this.url);
  }

  getPabellon(id: number) {
    return this.http.get<AtributosPabellon>(`${this.url}/${id}`);
  }

  agregarPabellon(nombre: string, ubicacion: string, aforo: number, funcionalidad: FuncionalidadTipo, disponibilidad: boolean, photo: string, fechaDisponibilidad: Date) {
    console.log(`Aplicación de pabellon recibido: nombre: ${nombre}, ubicacion: ${ubicacion}, aforo: ${aforo}, funcionalidad: ${funcionalidad}, disponibilidad: ${disponibilidad}, photo: ${photo}, fechaDisponible${fechaDisponibilidad}`)
  }
}
