import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AtributosPabellon } from '../atributos-pabellon';
import { ServicioPabellonService } from '../servicio-pabellon.service';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-eliminacion',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './eliminacion.component.html',
  styleUrl: './eliminacion.component.css'
})
export class EliminacionComponent {
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
  enviarEliminacion(): void {
    if (this.formularioSolicitud.valid) {
      const pabellonId = this.formularioSolicitud.get('id')?.value;
      if (pabellonId) {
        this.servicioPabellonService.eliminarPabellon(pabellonId).subscribe({
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
    } else {
      alert('Por favor, complete el formulario correctamente');
    }
  }

}
