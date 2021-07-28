import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TimelinesComponent} from './timelines-app/timelines/timelines.component';
import {YoutubePlaylistComponent} from './playlist-app/youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './playlist-app/youtube-player/youtube-player.component';
import {ProductListComponent} from "./product-management/product/product-list/product-list.component";
import {ProductCreateComponent} from './product-management/product/product-create/product-create.component';

const routes: Routes = [
  {
    path: 'timelines',
    component: TimelinesComponent
  },
  {
    path: 'youtube',
    component: YoutubePlaylistComponent,
    children: [{
      path: ':id',
      component: YoutubePlayerComponent
    }]
  },
  {
    path: 'product/list',
    component: ProductListComponent
  },
  {
    path: 'product/create',
    component: ProductCreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
