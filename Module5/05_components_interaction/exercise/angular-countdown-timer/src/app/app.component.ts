import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-countdown-timer';
  @Input() times = 10;
  time = '';
  msg = '';

  display(e: string[]) {
    this.time = e[0];
    this.msg = 'còn lại: ' + e[1] + 's';
  }
}

