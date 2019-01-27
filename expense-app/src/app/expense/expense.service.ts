import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Expense } from './Expense';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  constructor(private http : Http) { }

  getExpenses(from:number): Observable<Expense[]>{
    console.log('http://localhost:8080/expenses/offset/'+from)
    return this.http.get('http://localhost:8080/expenses/offset/'+from).pipe(map(response => response.json()));
  }
}
