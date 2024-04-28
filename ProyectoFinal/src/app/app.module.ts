import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { MainComponent } from './main/main.component';
// import { PabellonLocationComponent } from './pabellon-location/pabellon-location.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    // PabellonLocationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeComponent,
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
