export class MonthExpense {

    mes_movimentacao : number;
    total : number;

    constructor(mes:number, _total:number){
        this.mes_movimentacao=mes;
        this.total=_total;
    }

}