export class SourceExpense {

    id : number;
    source_code : number;
	source_name : string;
    total : number;
    
    constructor(_id:number,code:number, name:string,_total:number){
        this.id=_id;
        this.source_code=code;
        this.source_name=name;
        this.total=_total;
    }
}