import { Component } from '@angular/core';
import { Expense } from './expense/expense';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'REFICE EXPENSES';
  
  monthExpenses = [];
  categoryExpenses = [];
  sourceExpenses = [];

  source = false
  category = false
  month = false

  showCategory():void{
    this.source = false
    this.category = true
    this.month = false
  }

  showSource():void{
    this.source = true
    this.category = false
    this.month = false
  }

  showMonth():void{
    this.source = false
    this.category = false
    this.month = true
  }


}
