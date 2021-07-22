import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  red = 0;
  green = 0;
  blue = 0;
  constructor() { }

  ngOnInit(): void {
  }

}
