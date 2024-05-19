import { Injectable } from '@angular/core';
import { AtributosPabellon } from './atributos-pabellon';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { Observable, switchMap, tap } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class ServicioPabellonService {
  readonly baseUrl = 'https://angular.io/assets/images/tutorials/faa';
  url = 'http://localhost:8080/pabellones';
  constructor(private http: HttpClient) { }

  getPabellones() {
    return this.http.get<AtributosPabellon[]>(this.url);
  }

  getPabellon(id: number) {
    return this.http.get<AtributosPabellon>(`${this.url}/${id}`);
  }

  agregarPabellon(nombre: string, ubicacion: string, aforo: number, disponibilidad: boolean, photo: string): Observable<AtributosPabellon> {
    const pabellonData = {
      nombre: nombre,
      ubicacion: ubicacion,
      aforo: aforo,
      disponibilidad: disponibilidad,
      photo: photo,
    };

    return this.http.post<AtributosPabellon>(this.url, pabellonData).pipe(
      tap(() => {
        console.log(`Pabellón agregado: nombre: ${nombre}, ubicacion: ${ubicacion}, aforo: ${aforo}, disponibilidad: ${disponibilidad}, photo: ${photo}`);
      })
    );
  }

  actualizarPabellon(atributosPabellon: AtributosPabellon) {
    // const url = ${this.url}/${pabellon.id};
    return this.http.put<AtributosPabellon>(`${this.url}/${atributosPabellon.id}`, atributosPabellon).pipe(
      tap(() => {
        console.log('Pabellón actualizado correctamente');
      })
    );
  }

  eliminarPabellon(id: number) {
    return this.http.get<AtributosPabellon>(`${this.url}/${id}`).pipe(
      switchMap(pabellon =>
        this.http.delete(`${this.url}/${id}`).pipe(
          tap(() => {
            console.log(`Pabellón ${pabellon.id} eliminado correctamente`);
          })
        )
      )
    );
  }
}

