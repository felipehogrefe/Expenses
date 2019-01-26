export class CategoryExpense {
    category_code : number;
	category_name : string;
    total : number;
    
    constructor(code:number, name:string,_total:number){
        this.category_code=code;
        this.category_name=name;
        this.total=_total;
    }
}