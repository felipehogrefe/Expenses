export class CategoryExpense {
    
    id : number;
    category_code : number;
	category_name : string;
    total : number;
    
    constructor(_id:number,code:number, name:string,_total:number){
        this.id=_id;
        this.category_code=code;
        this.category_name=name;
        this.total=_total;
    }
}