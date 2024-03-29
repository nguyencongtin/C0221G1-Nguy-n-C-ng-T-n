import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './03_angular_overview/font-size-editor/font-size-editor.component';
import {FormsModule} from "@angular/forms";
import { PetComponent } from './03_angular_overview/pet/pet.component';
import { ProductComponent } from './03_angular_overview/product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    ProductComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
