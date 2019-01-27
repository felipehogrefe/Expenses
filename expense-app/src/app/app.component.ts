import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(){ }

  title = 'GASTOS DE RECIFE';
  
  monthExpenses = [];
  categoryExpenses = [];
  sourceExpenses = [];

  source = false
  category = false
  month = false
  all = false;

  showCategory():void{
    this.source = false
    this.category = true
    this.month = false
    this.all = false
  }

  showSource():void{
    this.source = true
    this.category = false
    this.month = false
    this.all = false
  }

  showMonth():void{
    this.source = false
    this.category = false
    this.month = true
    this.all = false
  }

  showAllData():void{
    this.source = false
    this.category = false
    this.month = false
    this.all = true
  }
}
