import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ApirestService } from './core/apirest.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { LoadingComponent } from './shared/loading/loading.component';
import { DateformatPipe } from './core/dateformat.pipe';

@NgModule({
  declarations: [
    AppComponent,
    LoadingComponent,
    DateformatPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [
    ApirestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
