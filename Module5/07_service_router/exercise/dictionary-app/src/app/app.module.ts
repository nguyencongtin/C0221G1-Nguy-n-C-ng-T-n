import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {DictionaryDetailComponent} from './dictionary-app/dictionary-detail/dictionary-detail.component';
import {DictionaryPageComponent} from './dictionary-app/dictionary-page/dictionary-page.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    DictionaryDetailComponent,
    DictionaryPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
