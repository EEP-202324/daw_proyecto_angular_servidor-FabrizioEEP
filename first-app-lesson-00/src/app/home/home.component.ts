import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { AtributosPabellonComponent } from '../atributos-pabellon/atributos-pabellon.component';
import { AtributosPabellon, FuncionalidadTipo } from '../atributos-pabellon';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    AtributosPabellonComponent,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  readonly baseUrl = 'https://angular.io/assets/images/tutorials/faa';

  atributosPabellon: AtributosPabellon = {
    id: 9999,
    nombre: 'Test Pabellón',
    ubicacion: 12,
    aforo: 2000,
    funcionalidad: FuncionalidadTipo.Aula,
    disponibilidad: true,
    photo: `${this.baseUrl}/example-house.jpg`,
    // serviciosAdicionales: ['hola', 'como'],
    fechaDisponibilidad: new Date('2002-12-12')
  };
}
