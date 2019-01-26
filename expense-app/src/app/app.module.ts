import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategoryExpenseComponent } from './category-expense/category-expense.component';
import { SourceExpenseComponent } from './source-expense/source-expense.component';
import { MonthExpenseComponent } from './month-expense/month-expense.component';
import { ExpenseComponent } from './expense/expense.component';

@NgModule({
  declarations: [
    AppComponent,
    CategoryExpenseComponent,
    SourceExpenseComponent,
    MonthExpenseComponent,
    ExpenseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
