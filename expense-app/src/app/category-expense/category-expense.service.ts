import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { CategoryExpense } from './CategoryExpense';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CategoryExpenseService {

  constructor(private http : Http) { }

  getCategoryExpenses(): Observable<CategoryExpense[]>{
    return this.http.get('http://localhost:8080/categoryexpenses/all').pipe(map(response => response.json()));
  }
}
