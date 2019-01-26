import { Component, OnInit } from '@angular/core';
import { CategoryExpense } from './CategoryExpense';
import { CategoryExpenseService } from './category-expense.service';

@Component({
  selector: 'app-category-expense',
  templateUrl: './category-expense.component.html',
  styleUrls: ['./category-expense.component.css']
})
export class CategoryExpenseComponent implements OnInit{

  categoryExpenses : CategoryExpense[];

  constructor(private categoryExpenseService : CategoryExpenseService){}

  ngOnInit(){
    this.categoryExpenseService.getCategoryExpenses()
      .subscribe(categoryExpenses => this.categoryExpenses = categoryExpenses);
  }

}
