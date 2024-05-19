import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { AtributosPabellon } from '../atributos-pabellon';
import { ActivatedRoute } from '@angular/router';
import { ServicioPabellonService } from '../servicio-pabellon.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-atributos-pabellon',
  templateUrl: './atributos-pabellon.component.html',
  styleUrls: ['./atributos-pabellon.component.css'],
  standalone: true,
  imports: [
    RouterModule,
  ],
})
export class AtributosPabellonComponent implements OnInit {
  @Input() atributosPabellon!: AtributosPabellon;
  @Output() pabellonEliminado = new EventEmitter<number>();

  formularioSolicitud: FormGroup;

  constructor(private route: ActivatedRoute, private servicioPabellonService: ServicioPabellonService) {
    this.formularioSolicitud = new FormGroup({
      id: new FormControl('', Validators.required),
      nombre: new FormControl('', Validators.required),
      ubicacion: new FormControl('', Validators.required),
      aforo: new FormControl(0, Validators.required),
      disponibilidad: new FormControl(false, Validators.required),
      photo: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {
    const pabellonId = Number(this.route.snapshot.params['id']);
    if (pabellonId) {
      this.servicioPabellonService.getPabellon(pabellonId).subscribe({
        next: pabellon => {
          this.formularioSolicitud.patchValue({
            id: pabellon.id,
            nombre: pabellon.nombre,
            ubicacion: pabellon.ubicacion,
            aforo: pabellon.aforo,
            disponibilidad: pabellon.disponibilidad,
            photo: pabellon.photo,
          });
        },
        error: error => {
          console.log('Error al cargar el Pabellón', error);
        }
      });
    }
  }

  eliminarPabellon(id: number) {
    this.servicioPabellonService.eliminarPabellon(id).subscribe(
      () => {
        console.log('Pabellón eliminado exitosamente');
        this.pabellonEliminado.emit(id);
      },
      error => {
        console.error('Error al eliminar el pabellón:', error);
      }
    );
  }
}

