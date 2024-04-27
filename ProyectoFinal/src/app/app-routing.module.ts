import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { PabellonLocationComponent } from './pabellon-location/pabellon-location.component';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  CommonModule,
    // PabellonLocationComponent,
  ],
  exports: [RouterModule],
})
export class AppRoutingModule { }

