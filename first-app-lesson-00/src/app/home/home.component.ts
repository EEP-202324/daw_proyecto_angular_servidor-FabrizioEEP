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

  listaPabellonesFiltado: AtributosPabellon[] = [];
  atributosPabellonList: AtributosPabellon[] = [];
  servicioPabellonService: ServicioPabellonService = inject(ServicioPabellonService);

  constructor() {

    this.servicioPabellonService.getPabellones().subscribe(
      pabellones => {
        this.atributosPabellonList = pabellones;
        this.listaPabellonesFiltado = pabellones;
      }
    )
  }

  filtrarResultado(texto: string) {
    if (!texto) {
      this.listaPabellonesFiltado = this.atributosPabellonList;
      return;
    }
    this.listaPabellonesFiltado = this.atributosPabellonList.filter(
      atributosPabellon =>
  atributosPabellon?.nombre.toLowerCase().includes(texto.toLowerCase())
    );
  }
}
