import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { AtributosPabellonComponent } from '../atributos-pabellon/atributos-pabellon.component';
import { AtributosPabellon, FuncionalidadTipo } from '../atributos-pabellon';
import { ServicioPabellonService } from '../servicio-pabellon.service';


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

  atributosPabellonList: AtributosPabellon[] = [];
  servicioPabellonService: ServicioPabellonService = inject(ServicioPabellonService);

  constructor() {
    this.atributosPabellonList = this.servicioPabellonService.getPabellones();
  }
}
