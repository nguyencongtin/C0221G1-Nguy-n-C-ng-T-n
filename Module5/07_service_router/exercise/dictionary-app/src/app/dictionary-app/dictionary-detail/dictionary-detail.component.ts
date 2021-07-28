import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {DictionaryServiceService} from '../dictionary-service.service';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  public word: string;
  public result: string;

  constructor(activate: ActivatedRoute, trans: DictionaryServiceService) {
    activate.paramMap.subscribe((param: ParamMap) => {
      this.word = param.get('word');
      this.result = trans.translate(this.word);
    });
  }

  ngOnInit(): void {
  }

}
