import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { ServicioPabellonService } from '../servicio-pabellon.service';
import { AtributosPabellon } from '../atributos-pabellon';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

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
export class DetallesComponent implements OnInit{
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

  ngOnInit(): void {
    const pabellonId= Number(this.route.snapshot.params['id']);
    this.servicioPabellonService.getPabellon(pabellonId).subscribe({
      next: pabellon =>{
        this.pabellon=pabellon;
        this.formularioSolicitud.patchValue({
          id: pabellon.id,
          nombre: pabellon.nombre,
          ubicacion: pabellon.ubicacion,
          aforo: pabellon.aforo,
          disponibilidad: pabellon.disponibilidad,
          photo: pabellon.photo,
        });
      },
      error: error =>{
        console.log('Error al modificar el Pabellón', error)
      }
  });
}

  enviar(): void{
    if(this.formularioSolicitud.valid){
      const pabellonDatos=this.formularioSolicitud.value;
      pabellonDatos.id=this.pabellon?.id
      this.servicioPabellonService.actualizarPabellon(pabellonDatos).subscribe({
        next: pabellonActualizado =>{
            alert('Pabellón actualizado con éxito');
        },
        error: error =>{
          alert('Ha ocurrido un error al actualizar el pabellón');
          console.log('Ha ocurrido un error al actualizar el pabellón',error)
        }
      })
    }
  }
    // presentarSolicitud(){
    //   this.servicioPabellonService.presentarSolicitud(
    //     this.formularioSolicitud.value.Nombre ?? '',
    //     this.formularioSolicitud.value.Apellido ?? '',
    //     this.formularioSolicitud.value.email ?? ''
    //   );
    // }
}
