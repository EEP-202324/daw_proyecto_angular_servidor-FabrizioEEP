import { Component, Inject, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { ServicioPabellonService } from '../servicio-pabellon.service';
import { AtributosPabellon, FuncionalidadTipo } from '../atributos-pabellon';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-detalles',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './detalles.component.html',
  styleUrl: './detalles.component.css'
})
export class DetallesComponent {
  route: ActivatedRoute = inject(ActivatedRoute);
  servicioPabellonService = inject(ServicioPabellonService);
  atributosPabellon: AtributosPabellon | undefined;

  formularioSolicitud = new FormGroup({
    nombre: new FormControl(''),
    ubicacion: new FormControl(''),
    aforo: new FormControl(0),
    funcionalidad: new FormControl(FuncionalidadTipo.Aula),
    disponibilidad: new FormControl(false),
    photo: new FormControl(''),
    fechaDisponibilidad: new FormControl(new Date())
  });

  constructor() {
      const atributosPabellonId = Number(this.route.snapshot.params['id']);
      this.atributosPabellon =
  this.servicioPabellonService?.getPabellon(atributosPabellonId);
  }
  enviarSolicitud() {
    this.servicioPabellonService.agregarPabellon(
      this.formularioSolicitud.value.nombre ?? '',
      this.formularioSolicitud.value.ubicacion ?? '',
      this.formularioSolicitud.value.aforo ?? 0,
      this.formularioSolicitud.value.funcionalidad ?? FuncionalidadTipo.Aula,
      this.formularioSolicitud.value.disponibilidad ?? false,
      this.formularioSolicitud.value.photo ?? '',
      this.formularioSolicitud.value.fechaDisponibilidad ?? new Date(),
    );
  }
}
