import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalculatorComponent } from './03_angular_overview/calculator/calculator.component';
import { TypescriptVariableComponent } from './02_typescript/typescript-variable/typescript-variable.component';

@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    TypescriptVariableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
