import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { LOCALE_ID } from '@angular/core';
import { registerLocaleData, CommonModule } from '@angular/common';
import localePt from '@angular/common/locales/pt';
import { ChartsModule } from 'ng2-charts';


registerLocaleData(localePt);

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategoryExpenseComponent } from './category-expense/category-expense.component';
import { SourceExpenseComponent } from './source-expense/source-expense.component';
import { MonthExpenseComponent } from './month-expense/month-expense.component';
import { ExpenseComponent } from './expense/expense.component';
import { MonthGraphComponent } from './month-graph/month-graph.component';
import { SourceGraphComponent } from './source-graph/source-graph.component';
import { CategoryGraphComponent } from './category-graph/category-graph.component';
import { ExpensesDataComponent } from './expenses-data/expenses-data.component';
import { ExpensesGraphComponent } from './expenses-graph/expenses-graph.component';

@NgModule({
  declarations: [
    AppComponent,
    CategoryExpenseComponent,
    SourceExpenseComponent,
    MonthExpenseComponent,
    ExpenseComponent,
    MonthGraphComponent,
    SourceGraphComponent,
    CategoryGraphComponent,
    ExpensesDataComponent,
    ExpensesGraphComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule,
    ChartsModule,
    CommonModule,    
  ],
  providers: [{provide: LOCALE_ID, useValue: 'pt-BR'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
