import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { AtributosPabellonComponent } from '../atributos-pabellon/atributos-pabellon.component';

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

}
