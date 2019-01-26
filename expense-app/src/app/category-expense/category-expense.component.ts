import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-category-expense',
  templateUrl: './category-expense.component.html',
  styleUrls: ['./category-expense.component.css']
})
export class CategoryExpenseComponent {

  tasks = [];

  task = "";
  isAdmin = true;

  add():void{
    this.tasks.push(this.task)
    this.task = "";
  }

}
