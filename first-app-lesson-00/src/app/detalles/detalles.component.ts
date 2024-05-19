import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router'; // Importa Router también
import { CommonModule } from '@angular/common';
import { ServicioPabellonService } from '../servicio-pabellon.service';
import { AtributosPabellon } from '../atributos-pabellon';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-detalles',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './detalles.component.html',
  styleUrls: ['./detalles.component.css'] // Corrige "styleUrl" a "styleUrls"
})
export class DetallesComponent implements OnInit{
  pabellon: AtributosPabellon | undefined;
  formularioSolicitud: FormGroup;

  constructor(private route: ActivatedRoute,
              private router: Router, // Inyecta Router
              private servicioPabellonService: ServicioPabellonService) {
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

  eliminarPabellon(): void {
    if (this.pabellon) {
      this.servicioPabellonService.eliminarPabellon(this.pabellon.id).subscribe(
        () => {
          console.log('Pabellón eliminado exitosamente');
          this.router.navigate(['/']); // Utiliza el router para navegar
        },
        error => {
          console.error('Error al eliminar el pabellón:', error);
        }
      );
    }
  }
}
