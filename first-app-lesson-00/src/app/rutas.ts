import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DetallesComponent } from './detalles/detalles.component';

const routeConfig: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'Home page'
  },
  {
    path: 'detalles/:id',
    component: DetallesComponent,
    title: 'Home detalles'
  }
];

export default routeConfig;
