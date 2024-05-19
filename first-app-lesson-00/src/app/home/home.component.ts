import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { AtributosPabellonComponent } from '../atributos-pabellon/atributos-pabellon.component';
import { AtributosPabellon } from '../atributos-pabellon';
import { ServicioPabellonService } from '../servicio-pabellon.service';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    AtributosPabellonComponent,
    RouterLink,
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

  eliminarPabellon(id: number) {
    this.listaPabellonesFiltado = this.listaPabellonesFiltado.filter(u => u.id !== id);
  }
}
