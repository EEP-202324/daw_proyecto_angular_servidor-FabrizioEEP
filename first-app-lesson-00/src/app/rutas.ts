import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DetallesComponent } from './detalles/detalles.component';
import { AgregacionComponent } from './agregacion/agregacion.component';
import { EliminacionComponent } from './eliminacion/eliminacion.component';

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
  },
  {
    path: 'agregacion',
    component: AgregacionComponent,
    title: 'Home agregacion'
  },
  {
    path: 'eliminacion',
    component: EliminacionComponent,
    title: 'Home eliminacion'
  }
];

export default routeConfig;
