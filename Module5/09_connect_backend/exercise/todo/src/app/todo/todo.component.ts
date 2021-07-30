import {Component, OnInit} from '@angular/core';
import {Todo} from '../todo';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {TodoService} from '../todo.service';


let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();
  todo!: Todo;
  editForm!: FormGroup;
  hidden = true;

  constructor(private todoService: TodoService,
              private fb: FormBuilder) {
    this.editForm = this.fb.group({
      content: [''],
      complete: [''],
    });
  }

  ngOnInit() {
    this.getTodos();
  }

  getTodos() {
    this.todoService.getAll().subscribe(todos => {
      this.todos = todos;
    });
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }
}
