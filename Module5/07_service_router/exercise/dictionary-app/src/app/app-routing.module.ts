import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DictionaryPageComponent} from './dictionary-app/dictionary-page/dictionary-page.component';
import {DictionaryDetailComponent} from './dictionary-app/dictionary-detail/dictionary-detail.component';


const routes: Routes = [
  {
    path: '',
    component: DictionaryPageComponent
  },
  {
    path: 'detail/:word',
    component: DictionaryDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
