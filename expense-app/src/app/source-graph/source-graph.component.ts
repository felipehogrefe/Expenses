import { Component, OnInit, Injectable } from '@angular/core';
import { SourceExpense } from '../source-expense/SourceExpense';
import { SourceExpenseService } from '../source-expense/source-expense.service';
import { Chart } from 'chart.js';
import { RandomColor } from '../RandomColors';

@Component({
  selector: 'app-source-graph',
  templateUrl: './source-graph.component.html',
  styleUrls: ['./source-graph.component.css']
})
@Injectable({
  providedIn: 'root'
})
export class SourceGraphComponent implements OnInit {
  sourceExpenses: SourceExpense[]
  public pieChartType: string = 'pie';

  chart: any;

  constructor(private ses: SourceExpenseService, private rc: RandomColor) { }

  ngOnInit() {

    this.ses.getSourceExpenses()
      .subscribe(sourceExpenses => {
        this.sourceExpenses = sourceExpenses;

        let sourceLabels = sourceExpenses.map(sourceExpenses => sourceExpenses.source_name)
        let sourceValues = sourceExpenses.map(sourceExpenses => sourceExpenses.total)

        let colors = this.rc.getColorList(sourceLabels.length)

        this.chart = new Chart('canvas', {
          type: 'pie',
          data: {
            labels: sourceLabels,
            datasets: [
              {
                data: sourceValues,
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
