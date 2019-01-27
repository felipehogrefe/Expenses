

export class Expense {
    public id : number;
    public _id : number;
    public ano_movimentacao : number;
    public mes_movimentacao : number;
    public orgao_codigo : number;
    public unidade_codigo : number;
    public categoria_economica_codigo : number;
    public grupo_despesa_codigo : number;
    public modalidade_aplicacao_codigo : number;
    public elemento_codigo : number;
    public subelemento_codigo : number;
    public funcao_codigo : number;
    public subfuncao_codigo : number;
    public programa_codigo : number;
    public acao_codigo : number;
    public fonte_recurso_codigo : number;
    public empenho_ano : number;
    public empenho_modalidade_codigo : number;
    public empenho_numero : number;
    public subempenho : number;
    public credor_codigo : number;
    public modalidade_licitacao_codigo : number;
    public orgao_nome : string;
    public unidade_nome : string;
    public categoria_economica_nome : string;
    public grupo_despesa_nome : string;
    public modalidade_aplicacao_nome : string;
    public elemento_nome : string;
    public subelemento_nome : string;
    public funcao_nome : string;
    public subfuncao_nome : string;
    public programa_nome : string;
    public acao_nome : string;
    public fonte_recurso_nome : string;
    public empenho_modalidade_nome : string;
    public indicador_subempenho : string;
    public credor_nome : string;
    public modalidade_licitacao_nome : string;
    public valor_empenhado : string;
    public valor_liquidado : string;
    public valor_pago : string

    constructor(json : JSON){
        for (var key in json) {
            if (this.hasOwnProperty(key)) {
                this[key] = json[key];
            }
        };
    }

    
}