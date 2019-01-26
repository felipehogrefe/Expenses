import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { MonthExpense } from './MonthExpense';

@Injectable({
  providedIn: 'root'
})
export class MonthExpenseService {

  constructor(private http : Http) { }

  getMonthExpenses(): Observable<MonthExpense[]>{
    return this.http.get('http://localhost:8080/monthexpenses/all').pipe(map(response => response.json()));
  }
}
