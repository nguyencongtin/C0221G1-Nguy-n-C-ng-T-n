import {Injectable} from '@angular/core';
import {IWord} from './iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  private arr: IWord [];

  constructor() {

    this.arr = [
      {word: 'Hello', mean: 'Xao chìn'},
      {word: 'Good', mean: 'Tốt'},
      {word: 'Stupid', mean: 'Baka'},
      {word: 'Ace', mean: 'Quét sạch'},
      {word: 'Pentakill', mean: 'Mấy con gà'}
    ];
  }

  translate(eng: string): string {
    const trans = this.arr.find(t => t.word === eng);
    if (trans.word) {
      return trans.mean;
    } else {
      return 'Not Found';
    }
  }
}

