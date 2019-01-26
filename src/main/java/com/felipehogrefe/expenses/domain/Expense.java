package com.felipehogrefe.expenses.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense implements Serializable, Comparable<Expense>{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private int _id, ano_movimentacao, mes_movimentacao, orgao_codigo, unidade_codigo, 
	categoria_economica_codigo, grupo_despesa_codigo, modalidade_aplicacao_codigo,
	elemento_codigo, subelemento_codigo, funcao_codigo, subfuncao_codigo, programa_codigo,
	acao_codigo, fonte_recurso_codigo, empenho_ano, empenho_modalidade_codigo, empenho_numero,
	subempenho, credor_codigo, modalidade_licitacao_codigo;
	private String orgao_nome, unidade_nome, categoria_economica_nome, grupo_despesa_nome, 
	modalidade_aplicacao_nome, elemento_nome, subelemento_nome, funcao_nome, subfuncao_nome, 
	programa_nome, acao_nome, fonte_recurso_nome, empenho_modalidade_nome, indicador_subempenho, 
	credor_nome, modalidade_licitacao_nome, valor_empenhado, valor_liquidado, valor_pago;

	
	public Expense() {}
	
	public Expense(int _id, int id, String orgaoNome, int anoMovimentacao, int mesMovimentacao, int categoriaEconomicaCodigo,
			int fonteRecursoCodigo, String categoriaEconomicaNome, String fonteRecursoNome, String valorEmpenhado,
			String valorLiquidado, String valorPago) {
		super();
		this.id = _id;
		this._id = id;
		this.orgao_nome = orgaoNome;
		this.ano_movimentacao = anoMovimentacao;
		this.mes_movimentacao = mesMovimentacao;
		this.categoria_economica_codigo = categoriaEconomicaCodigo;
		this.fonte_recurso_codigo = fonteRecursoCodigo;
		this.categoria_economica_nome = categoriaEconomicaNome;
		this.fonte_recurso_nome = fonteRecursoNome;
		this.valor_empenhado = valorEmpenhado;
		this.valor_liquidado = valorLiquidado;
		this.valor_pago = valorPago;
	}
		
	@Override
	public String toString() {
		return "Expense [id=" + _id + ", orgaoNome=" + orgao_nome + ", dataMovimentacao=" + mes_movimentacao + "/"+ano_movimentacao+
				", categoriaEconomicaCodigo=" + categoria_economica_codigo + ", fonteRecursoCodigo="+fonte_recurso_codigo+
				", valorPago= "+valor_pago+"]";
	}

	public Integer getId() {
		return id;
	}	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public int compareTo(Expense p) {
		
		return 0;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public int getAno_movimentacao() {
		return ano_movimentacao;
	}

	public void setAno_movimentacao(int ano_movimentacao) {
		this.ano_movimentacao = ano_movimentacao;
	}

	public int getMes_movimentacao() {
		return mes_movimentacao;
	}

	public void setMes_movimentacao(int mes_movimentacao) {
		this.mes_movimentacao = mes_movimentacao;
	}

	public int getOrgao_codigo() {
		return orgao_codigo;
	}

	public void setOrgao_codigo(int orgao_codigo) {
		this.orgao_codigo = orgao_codigo;
	}

	public int getUnidade_codigo() {
		return unidade_codigo;
	}

	public void setUnidade_codigo(int unidade_codigo) {
		this.unidade_codigo = unidade_codigo;
	}

	public int getCategoria_economica_codigo() {
		return categoria_economica_codigo;
	}

	public void setCategoria_economica_codigo(int categoria_economica_codigo) {
		this.categoria_economica_codigo = categoria_economica_codigo;
	}

	public int getGrupo_despesa_codigo() {
		return grupo_despesa_codigo;
	}

	public void setGrupo_despesa_codigo(int grupo_despesa_codigo) {
		this.grupo_despesa_codigo = grupo_despesa_codigo;
	}

	public int getModalidade_aplicacao_codigo() {
		return modalidade_aplicacao_codigo;
	}

	public void setModalidade_aplicacao_codigo(int modalidade_aplicacao_codigo) {
		this.modalidade_aplicacao_codigo = modalidade_aplicacao_codigo;
	}

	public int getElemento_codigo() {
		return elemento_codigo;
	}

	public void setElemento_codigo(int elemento_codigo) {
		this.elemento_codigo = elemento_codigo;
	}

	public int getSubelemento_codigo() {
		return subelemento_codigo;
	}

	public void setSubelemento_codigo(int subelemento_codigo) {
		this.subelemento_codigo = subelemento_codigo;
	}

	public int getFuncao_codigo() {
		return funcao_codigo;
	}

	public void setFuncao_codigo(int funcao_codigo) {
		this.funcao_codigo = funcao_codigo;
	}

	public int getSubfuncao_codigo() {
		return subfuncao_codigo;
	}

	public void setSubfuncao_codigo(int subfuncao_codigo) {
		this.subfuncao_codigo = subfuncao_codigo;
	}

	public int getPrograma_codigo() {
		return programa_codigo;
	}

	public void setPrograma_codigo(int programa_codigo) {
		this.programa_codigo = programa_codigo;
	}

	public int getAcao_codigo() {
		return acao_codigo;
	}

	public void setAcao_codigo(int acao_codigo) {
		this.acao_codigo = acao_codigo;
	}

	public int getFonte_recurso_codigo() {
		return fonte_recurso_codigo;
	}

	public void setFonte_recurso_codigo(int fonte_recurso_codigo) {
		this.fonte_recurso_codigo = fonte_recurso_codigo;
	}

	public int getEmpenho_ano() {
		return empenho_ano;
	}

	public void setEmpenho_ano(int empenho_ano) {
		this.empenho_ano = empenho_ano;
	}

	public int getEmpenho_modalidade_codigo() {
		return empenho_modalidade_codigo;
	}

	public void setEmpenho_modalidade_codigo(int empenho_modalidade_codigo) {
		this.empenho_modalidade_codigo = empenho_modalidade_codigo;
	}

	public int getEmpenho_numero() {
		return empenho_numero;
	}

	public void setEmpenho_numero(int empenho_numero) {
		this.empenho_numero = empenho_numero;
	}

	public int getSubempenho() {
		return subempenho;
	}

	public void setSubempenho(int subempenho) {
		this.subempenho = subempenho;
	}

	public int getCredor_codigo() {
		return credor_codigo;
	}

	public void setCredor_codigo(int credor_codigo) {
		this.credor_codigo = credor_codigo;
	}

	public int getModalidade_licitacao_codigo() {
		return modalidade_licitacao_codigo;
	}

	public void setModalidade_licitacao_codigo(int modalidade_licitacao_codigo) {
		this.modalidade_licitacao_codigo = modalidade_licitacao_codigo;
	}

	public String getOrgao_nome() {
		return orgao_nome;
	}

	public void setOrgao_nome(String orgao_nome) {
		this.orgao_nome = orgao_nome;
	}

	public String getUnidade_nome() {
		return unidade_nome;
	}

	public void setUnidade_nome(String unidade_nome) {
		this.unidade_nome = unidade_nome;
	}

	public String getCategoria_economica_nome() {
		return categoria_economica_nome;
	}

	public void setCategoria_economica_nome(String categoria_economica_nome) {
		this.categoria_economica_nome = categoria_economica_nome;
	}

	public String getGrupo_despesa_nome() {
		return grupo_despesa_nome;
	}

	public void setGrupo_despesa_nome(String grupo_despesa_nome) {
		this.grupo_despesa_nome = grupo_despesa_nome;
	}

	public String getModalidade_aplicacao_nome() {
		return modalidade_aplicacao_nome;
	}

	public void setModalidade_aplicacao_nome(String modalidade_aplicacao_nome) {
		this.modalidade_aplicacao_nome = modalidade_aplicacao_nome;
	}

	public String getElemento_nome() {
		return elemento_nome;
	}

	public void setElemento_nome(String elemento_nome) {
		this.elemento_nome = elemento_nome;
	}

	public String getSubelemento_nome() {
		return subelemento_nome;
	}

	public void setSubelemento_nome(String subelemento_nome) {
		this.subelemento_nome = subelemento_nome;
	}

	public String getFuncao_nome() {
		return funcao_nome;
	}

	public void setFuncao_nome(String funcao_nome) {
		this.funcao_nome = funcao_nome;
	}

	public String getSubfuncao_nome() {
		return subfuncao_nome;
	}

	public void setSubfuncao_nome(String subfuncao_nome) {
		this.subfuncao_nome = subfuncao_nome;
	}

	public String getPrograma_nome() {
		return programa_nome;
	}

	public void setPrograma_nome(String programa_nome) {
		this.programa_nome = programa_nome;
	}

	public String getAcao_nome() {
		return acao_nome;
	}

	public void setAcao_nome(String acao_nome) {
		this.acao_nome = acao_nome;
	}

	public String getFonte_recurso_nome() {
		return fonte_recurso_nome;
	}

	public void setFonte_recurso_nome(String fonte_recurso_nome) {
		this.fonte_recurso_nome = fonte_recurso_nome;
	}

	public String getEmpenho_modalidade_nome() {
		return empenho_modalidade_nome;
	}

	public void setEmpenho_modalidade_nome(String empenho_modalidade_nome) {
		this.empenho_modalidade_nome = empenho_modalidade_nome;
	}

	public String getIndicador_subempenho() {
		return indicador_subempenho;
	}

	public void setIndicador_subempenho(String indicador_subempenho) {
		this.indicador_subempenho = indicador_subempenho;
	}

	public String getCredor_nome() {
		return credor_nome;
	}

	public void setCredor_nome(String credor_nome) {
		this.credor_nome = credor_nome;
	}

	public String getModalidade_licitacao_nome() {
		return modalidade_licitacao_nome;
	}

	public void setModalidade_licitacao_nome(String modalidade_licitacao_nome) {
		this.modalidade_licitacao_nome = modalidade_licitacao_nome;
	}

	public String getValor_empenhado() {
		return valor_empenhado;
	}

	public void setValor_empenhado(String valor_empenhado) {
		this.valor_empenhado = valor_empenhado;
	}

	public String getValor_liquidado() {
		return valor_liquidado;
	}

	public void setValor_liquidado(String valor_liquidado) {
		this.valor_liquidado = valor_liquidado;
	}

	public String getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(String valor_pago) {
		this.valor_pago = valor_pago;
	}
	
}