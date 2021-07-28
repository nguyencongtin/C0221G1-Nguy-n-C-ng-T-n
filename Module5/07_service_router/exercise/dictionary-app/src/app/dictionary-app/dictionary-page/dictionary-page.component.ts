import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  public word: string;

  constructor() {
  }

  ngOnInit(): void {
  }

}
