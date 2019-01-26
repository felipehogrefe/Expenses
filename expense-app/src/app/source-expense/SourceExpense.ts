export class SourceExpense {

    source_code : number;
	source_name : string;
    total : number;
    
    constructor(code:number, name:string,_total:number){
        this.source_code=code;
        this.source_name=name;
        this.total=_total;
    }
}