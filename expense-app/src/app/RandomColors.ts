import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })
export class RandomColor{    
    colors : string[] = ['#fbb4ae','#b3cde3','#ccebc5','#fbb4ae','#b3cde3','#ccebc5','#decbe4','#fbb4ae','#b3cde3','#ccebc5','#decbe4','#fed9a6','#fbb4ae','#b3cde3','#ccebc5','#decbe4','#fed9a6','#ffffcc','#fbb4ae','#b3cde3','#ccebc5','#decbe4','#fed9a6','#ffffcc','#e5d8bd','#fbb4ae','#b3cde3','#ccebc5','#decbe4','#fed9a6','#ffffcc','#e5d8bd','#fddaec','#fbb4ae','#b3cde3','#ccebc5','#decbe4','#fed9a6','#ffffcc','#e5d8bd','#fddaec','#f2f2f2','#b3e2cd','#fdcdac','#cbd5e8','#b3e2cd','#fdcdac','#cbd5e8','#f4cae4','#b3e2cd','#fdcdac','#cbd5e8','#f4cae4','#e6f5c9','#b3e2cd','#fdcdac','#cbd5e8','#f4cae4','#e6f5c9','#fff2ae','#b3e2cd','#fdcdac','#cbd5e8','#f4cae4','#e6f5c9','#fff2ae','#f1e2cc','#b3e2cd','#fdcdac','#cbd5e8','#f4cae4','#e6f5c9','#fff2ae','#f1e2cc','#cccccc']

    getRandomPastelColor():string {        
        let color = this.colors[Math.floor(Math.random()*this.colors.length)];
        return color;     
      }

      getRandomColor():string{
        var letters = '0123456789ABCDEF';
        var color = '#'
        for (var i = 0; i < 6; i++) {
          color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
      }

      getColorList(size : number):string[]{
          let colors = []
          if (size < this.colors.length) {

            while (colors.length !=size) {
              let color: string = this.getRandomPastelColor()
  
              while (colors.indexOf(color) > -1) {
                color = this.getRandomPastelColor()
              }
              colors.push(color)
            }
          } else {
            while (colors.length != size) {
              let color: string = this.getRandomColor()
              colors.push(color)
            }
          }
          return colors;
      }
}