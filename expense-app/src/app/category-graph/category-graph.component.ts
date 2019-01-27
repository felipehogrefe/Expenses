import { Component, OnInit, Injectable } from '@angular/core';
import { CategoryExpense } from '../category-expense/CategoryExpense';
import { CategoryExpenseService } from '../category-expense/category-expense.service';
import { Chart } from 'chart.js';
import { RandomColor } from '../RandomColors';

@Component({
  selector: 'app-category-graph',
  templateUrl: './category-graph.component.html',
  styleUrls: ['./category-graph.component.css']
})
@Injectable({
  providedIn: 'root'
})
export class CategoryGraphComponent implements OnInit {
  categoryExpenses: CategoryExpense[]
  public pieChartType:string = 'pie';

  chart : any;

  constructor(private ces: CategoryExpenseService, private rc : RandomColor) { }

  ngOnInit() {
    this.ces.getCategoryExpenses()
      .subscribe(categoryExpenses => {




        this.categoryExpenses = categoryExpenses;

        let sourceLabels = categoryExpenses.map(sourceExpenses => sourceExpenses.category_name)
        let sourceValues = categoryExpenses.map(sourceExpenses => sourceExpenses.total)
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
