import { Component, Inject, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { ServicioPabellonService } from '../servicio-pabellon.service';
import { AtributosPabellon } from '../atributos-pabellon';

@Component({
  selector: 'app-detalles',
  standalone: true,
  imports: [],
  templateUrl: './detalles.component.html',
  styleUrl: './detalles.component.css'
})
export class DetallesComponent {
  route: ActivatedRoute = inject(ActivatedRoute);
  servicioPabellonService = inject(ServicioPabellonService);
  atributosPabellon: AtributosPabellon | undefined;

  constructor() {
      const atributosPabellonId = Number(this.route.snapshot.params['id']);
      this.atributosPabellon =
  this.servicioPabellonService?.getPabellon(atributosPabellonId);
  }
}
