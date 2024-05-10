import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AtributosPabellon } from '../atributos-pabellon';

@Component({
  selector: 'app-atributos-pabellon',
  standalone: true,
  imports: [],
  templateUrl: './atributos-pabellon.component.html',
  styleUrl: './atributos-pabellon.component.css'
})
export class AtributosPabellonComponent {
  @Input() atributosPabellon!: AtributosPabellon;
}
