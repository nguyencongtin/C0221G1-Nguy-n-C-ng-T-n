import { Component, OnInit } from '@angular/core';
import {NavList} from '../nav-list';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  navLists: NavList[] = [{
    name: 'new',
    url: 'https://news.ycombinator.com/newest'
  }, {
    name: 'past',
    url: 'https://news.ycombinator.com/front'
  }, {
    name: 'comments',
    url: 'https://news.ycombinator.com/newcomments'
  }, {
    name: 'ask',
    url: 'https://news.ycombinator.com/ask'
  }, {
    name: 'show',
    url: 'https://news.ycombinator.com/show'
  },{
    name: 'jobs',
    url: 'https://news.ycombinator.com/jobs'
  },{
    name: 'submit',
    url: 'https://news.ycombinator.com/submit'
  }];
  constructor() { }

  ngOnInit(): void {
  }

}
