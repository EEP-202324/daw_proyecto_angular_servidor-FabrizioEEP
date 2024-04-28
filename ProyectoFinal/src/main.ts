import { bootstrapApplication } from '@angular/platform-browser';
import { MainComponent } from './app/main/main.component';

bootstrapApplication(MainComponent)  // Para que inicie desde el componente main
.catch(err => console.error(err));



