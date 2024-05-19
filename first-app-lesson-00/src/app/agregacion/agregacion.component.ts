import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AtributosPabellon } from '../atributos-pabellon';
import { ServicioPabellonService } from '../servicio-pabellon.service';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-agregacion',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './agregacion.component.html',
  styleUrl: './agregacion.component.css'
})
export class AgregacionComponent {
  pabellon: AtributosPabellon | undefined;
  formularioSolicitud: FormGroup;

  constructor(private route: ActivatedRoute, private servicioPabellonService: ServicioPabellonService) {
    this.formularioSolicitud = new FormGroup({
      nombre: new FormControl('',Validators.required),
      ubicacion: new FormControl('',Validators.required),
      aforo: new FormControl(0,Validators.required),
      disponibilidad: new FormControl(false, Validators.required),
      photo: new FormControl('',Validators.required),
    });
  }

  enviarAgregacion(): void {
    if (this.formularioSolicitud.valid) {
      const pabellonDatos = this.formularioSolicitud.value;
      this.servicioPabellonService.agregarPabellon(
        pabellonDatos.nombre,
        pabellonDatos.ubicacion,
        pabellonDatos.aforo,
        pabellonDatos.disponibilidad,
        pabellonDatos.photo
      ).subscribe({
        next: pabellonAgregado => {
          alert('Pabellón agregado con éxito');
        },
        error: error => {
          alert('Ha ocurrido un error al agregar el pabellón');
          console.log('Ha ocurrido un error al agregar el pabellón', error);
        }
      });
    } else {
      alert('No se ha especificado un ID de pabellón para eliminar');
    }
  }

  enviarEliminacion(): void {
    if (this.formularioSolicitud.valid) {
      const pabellonDatos = this.formularioSolicitud.value;
      if (this.pabellon && this.pabellon.id) {
        this.servicioPabellonService.eliminarPabellon(this.pabellon.id).subscribe({
          next: () => {
            alert('Pabellón eliminado con éxito');
          },
          error: error => {
            alert('Ha ocurrido un error al eliminar el pabellón');
            console.log('Ha ocurrido un error al eliminar el pabellón', error);
          }
        });
      } else {
        alert('No se ha especificado un ID de pabellón para eliminar');
      }
    }
  }



}
