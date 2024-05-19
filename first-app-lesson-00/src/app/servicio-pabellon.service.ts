import { Injectable } from '@angular/core';
import { AtributosPabellon, FuncionalidadTipo } from './atributos-pabellon';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { tap } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class ServicioPabellonService {
  readonly baseUrl = 'https://angular.io/assets/images/tutorials/faa';
  url = 'http://localhost:3000/atributos';
  constructor(private http: HttpClient) { }

  getPabellones() {
    return this.http.get<AtributosPabellon[]>(this.url);
  }

  getPabellon(id: number) {
    return this.http.get<AtributosPabellon>(`${this.url}/${id}`);
  }

  agregarPabellon(atributosPabellon: AtributosPabellon, nombre: string, ubicacion: string, aforo: number, funcionalidad: FuncionalidadTipo, disponibilidad: boolean, photo: string, fechaDisponibilidad: Date) {
    return this.http.post<AtributosPabellon>(this.url, atributosPabellon).pipe(
    tap(() => {
      console.log(`Aplicación de pabellon recibido: nombre: ${nombre}, ubicacion: ${ubicacion}, aforo: ${aforo}, funcionalidad: ${funcionalidad}, disponibilidad: ${disponibilidad}, photo: ${photo}, fechaDisponible${fechaDisponibilidad}`);
    })
  )
  };

  actualizarPabellon(atributosPabellon: AtributosPabellon) {
    // const url = ${this.url}/${pabellon.id};
    return this.http.put<AtributosPabellon>(`${this.url}/${atributosPabellon.id}`, atributosPabellon).pipe(
      tap(() => {
        console.log('Pabellón actualizado correctamente');
      })
    );
  }

  eliminarPabellon(id: number) {
    return this.http.delete(`${this.url}/${id}`).pipe(
      tap(() => {
        console.log('Pabellón eliminado correctamente');
      })
    );
  }
}


