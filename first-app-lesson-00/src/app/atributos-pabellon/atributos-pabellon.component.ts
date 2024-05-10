import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AtributosPabellon } from '../atributos-pabellon';
import { RouterLink } from '@angular/router';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-atributos-pabellon',
  standalone: true,
  imports: [
    RouterLink,
    RouterOutlet,
  ],
  templateUrl: './atributos-pabellon.component.html',
  styleUrl: './atributos-pabellon.component.css'
})
export class AtributosPabellonComponent {
  @Input() atributosPabellon!: AtributosPabellon;
}
