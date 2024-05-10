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

  // atributosPabellon: AtributosPabellon = {
  //   id: 9999,
  //   nombre: 'Test Pabellón',
  //   ubicacion: 12,
  //   aforo: 2000,
  //   funcionalidad: FuncionalidadTipo.Aula,
  //   disponibilidad: true,
  //   photo: `${this.baseUrl}/example-house.jpg`,
  //   // serviciosAdicionales: ['hola', 'como'],
  //   fechaDisponibilidad: new Date('2002-12-12')
  // };

  atributosPabellon: AtributosPabellon[] = [
    {
      id: 9999,
      nombre: 'Test Pabellón 1',
      ubicacion: 12,
      aforo: 2000,
      funcionalidad: FuncionalidadTipo.Aula,
      disponibilidad: true,
      photo: `${this.baseUrl}/example-house1.jpg`,
      fechaDisponibilidad: new Date('2002-12-12')
    },
    {
      id: 10001,
      nombre: 'Test Pabellón 2',
      ubicacion: 15,
      aforo: 1500,
      funcionalidad: FuncionalidadTipo.Auditorio,
      disponibilidad: false,
      photo: `${this.baseUrl}/example-house2.jpg`,
      fechaDisponibilidad: new Date('2003-05-25')
    },
    {
      id: 10002,
      nombre: 'Test Pabellón 3',
      ubicacion: 20,
      aforo: 1800,
      funcionalidad: FuncionalidadTipo.Laboratorio,
      disponibilidad: true,
      photo: `${this.baseUrl}/example-house3.jpg`,
      fechaDisponibilidad: new Date('2004-08-10')
    }
  ];
}


