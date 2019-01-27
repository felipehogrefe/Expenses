import { Component, OnInit } from '@angular/core';
import { MonthExpenseService } from '../month-expense/month-expense.service';
import { RandomColor } from '../RandomColors';
import { MonthExpense } from '../month-expense/MonthExpense';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-expenses-graph',
  templateUrl: './expenses-graph.component.html',
  styleUrls: ['./expenses-graph.component.css']
})
export class ExpensesGraphComponent implements OnInit {

  chart: any;
  total: number;

  constructor(private mes: MonthExpenseService, private rc: RandomColor) { }

  ngOnInit() {
    this.mes.getMonthExpenses()
      .subscribe(monthExpenses => {


        let monthLabels = monthExpenses.map(monthExpenses => monthExpenses.movimentation_month)
        let monthValues = monthExpenses.map(monthExpenses => monthExpenses.total)

        let totalList = [];
        let total = 0

        for (let item of monthValues) {
          total += item
          totalList.push(total)
        }

        Chart.defaults.global.defaultFontColor='black';

        this.chart = new Chart('canvas', {
          type: 'line',
          data: {
            labels: monthLabels,
            datasets: [
              {
                label: 'Gasto Total (R$)',
                data: totalList,
                borderColor: '#3cba9f',

              }
            ]
          },
          options: {
            legend: {
              labels: {
                fontColor: 'black'
              }
            }
          },
          scales: {
            yAxes: [{fontColor: "black"}],
            xAxes: [{fontColor: "black"}]
          }
        })
      });
  }

}
