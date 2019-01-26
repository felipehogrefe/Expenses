export class MonthExpense {

    id : number;
    mes_movimentacao : string;
    total : number;

    constructor(_id:number, mes:string, _total:number){
        this.id = _id;
        this.mes_movimentacao=mes;
        this.total=_total;
    }

}