import { Component, OnInit, Injectable } from '@angular/core';
import { MonthExpense } from '../month-expense/MonthExpense';
import { MonthExpenseService } from '../month-expense/month-expense.service';
import { Chart } from 'chart.js';
import { RandomColor } from '../RandomColors';

@Component({
  selector: 'app-month-graph',
  templateUrl: './month-graph.component.html',
  styleUrls: ['./month-graph.component.css']
})
@Injectable({
  providedIn: 'root'
})
export class MonthGraphComponent implements OnInit {
  monthExpenses: MonthExpense[]  

  chart : any;

  constructor(private mes: MonthExpenseService, private rc: RandomColor) { }

  ngOnInit() {
    this.mes.getMonthExpenses()
      .subscribe(monthExpenses => {

        this.monthExpenses = monthExpenses;

        let monthLabels = monthExpenses.map(sourceExpenses => sourceExpenses.movimentation_month)
        let monthValues = monthExpenses.map(sourceExpenses => sourceExpenses.total)      
        let colors = this.rc.getColorList(monthLabels.length)
        
        this.chart = new Chart('canvas', {
          type: 'pie',
          data: {
            labels: monthLabels,
            datasets: [
              {
                data: monthValues,
                backgroundColor: colors
              }
            ]
          },
          options: {
            animation: {
              animateScale: true
            },
            legend: {
              labels: {
                fontColor: 'black'
              }
            }
          }
        })
      });

  }

}
