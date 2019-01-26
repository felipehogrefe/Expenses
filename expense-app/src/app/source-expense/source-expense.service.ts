import { Injectable } from '@angular/core';
import { SourceExpense } from './SourceExpense';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SourceExpenseService {

  constructor(private http : Http) { }

  getSourceExpenses(): Observable<SourceExpense[]>{
    return this.http.get('http://localhost:8080/sourceexpenses/all').pipe(map(response => response.json()));
  }
}
