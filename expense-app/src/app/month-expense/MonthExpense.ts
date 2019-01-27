export class MonthExpense {

    id : number;
    movimentation_month : string;
    total : number;

    constructor(_id:number, month:string, _total:number){
        this.id = _id;
        this.movimentation_month=month;
        this.total=_total;
    }

}