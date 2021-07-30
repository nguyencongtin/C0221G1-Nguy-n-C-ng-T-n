import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment';
import {Todo} from './todo';
import {Observable} from 'rxjs';
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(API_URL + '/todos');
  }
}
