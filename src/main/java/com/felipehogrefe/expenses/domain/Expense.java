package com.felipehogrefe.expenses.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expense implements Serializable, Comparable<Expense>{	
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer _id;
	
	public int ano_movimentacao, mesMovimentacao, orgaoCodigo, unidadeCodigo, 
	categoriaEconomicaCodigo, grupoDespesaCodigo, modalidadeAplicacaoCodigo,
	elementoCodigo, subelementoCodigo, funcaoCodigo, subfuncaoCodigo, programaCodigo,
	acaoCodigo, fonteRecursoCodigo, empenhoAno, empenhoModalidadeCodigo, empenhoNumero,
	subempenho, credorCodigo, modalidadeLicitacaoCodigo;
	public String orgaoNome, unidadeNome, categoriaEconomicaNome, grupoDespesaNome, 
	modalidadeAplicacaoNome, elementoNome, subelementoNome, funcaoNome, subfuncaoNome, 
	programaNome, acaoNome, fonteRecursoNome, empenhoModalidadeNome, indicadorSubempenho, 
	credorNome, modalidadeLicitacaoNome, valorEmpenhado, valorLiquidado, valorPago;

	public Expense() {}
		
	@Override
	public String toString() {
		return "Expense [_id=" + _id + ", ano_movimentacao=" + ano_movimentacao + ", mes_movimentacao="
				+ mesMovimentacao + ", orgao_codigo=" + orgaoCodigo + ", unidade_codigo=" + unidadeCodigo
				+ ", categoria_economica_codigo=" + categoriaEconomicaCodigo + ", grupo_despesa_codigo="
				+ grupoDespesaCodigo + ", modalidade_aplicacao_codigo=" + modalidadeAplicacaoCodigo
				+ ", elemento_codigo=" + elementoCodigo + ", subelemento_codigo=" + subelementoCodigo
				+ ", funcao_codigo=" + funcaoCodigo + ", subfuncao_codigo=" + subfuncaoCodigo + ", programa_codigo="
				+ programaCodigo + ", acao_codigo=" + acaoCodigo + ", fonte_recurso_codigo=" + fonteRecursoCodigo
				+ ", empenho_ano=" + empenhoAno + ", empenho_modalidade_codigo=" + empenhoModalidadeCodigo
				+ ", empenho_numero=" + empenhoNumero + ", subempenho=" + subempenho + ", credor_codigo="
				+ credorCodigo + ", modalidade_licitacao_codigo=" + modalidadeLicitacaoCodigo + ", orgao_nome="
				+ orgaoNome + ", unidade_nome=" + unidadeNome + ", categoria_economica_nome="
				+ categoriaEconomicaNome + ", grupo_despesa_nome=" + grupoDespesaNome
				+ ", modalidade_aplicacao_nome=" + modalidadeAplicacaoNome + ", elemento_nome=" + elementoNome
				+ ", subelemento_nome=" + subelementoNome + ", funcao_nome=" + funcaoNome + ", subfuncao_nome="
				+ subfuncaoNome + ", programa_nome=" + programaNome + ", acao_nome=" + acaoNome
				+ ", fonte_recurso_nome=" + fonteRecursoNome + ", empenho_modalidade_nome=" + empenhoModalidadeNome
				+ ", indicador_subempenho=" + indicadorSubempenho + ", credor_nome=" + credorNome
				+ ", modalidade_licitacao_nome=" + modalidadeLicitacaoNome + ", valor_empenhado=" + valorEmpenhado
				+ ", valor_liquidado=" + valorLiquidado + ", valor_pago=" + valorPago + "]";
	}
	
	

	public Integer getId() {
		return _id;
	}	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
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
	
	public void setId(int _id) {
		this._id = _id;
	}

	public int getAno_movimentacao() {
		return ano_movimentacao;
	}

	public void setAno_movimentacao(int ano_movimentacao) {
		this.ano_movimentacao = ano_movimentacao;
	}

	public int getMes_movimentacao() {
		return mesMovimentacao;
	}

	public void setMes_movimentacao(int mes_movimentacao) {
		this.mesMovimentacao = mes_movimentacao;
	}

	public int getOrgao_codigo() {
		return orgaoCodigo;
	}

	public void setOrgao_codigo(int orgao_codigo) {
		this.orgaoCodigo = orgao_codigo;
	}

	public int getUnidade_codigo() {
		return unidadeCodigo;
	}

	public void setUnidade_codigo(int unidade_codigo) {
		this.unidadeCodigo = unidade_codigo;
	}

	public int getCategoria_economica_codigo() {
		return categoriaEconomicaCodigo;
	}

	public void setCategoria_economica_codigo(int categoria_economica_codigo) {
		this.categoriaEconomicaCodigo = categoria_economica_codigo;
	}

	public int getGrupo_despesa_codigo() {
		return grupoDespesaCodigo;
	}

	public void setGrupo_despesa_codigo(int grupo_despesa_codigo) {
		this.grupoDespesaCodigo = grupo_despesa_codigo;
	}

	public int getModalidade_aplicacao_codigo() {
		return modalidadeAplicacaoCodigo;
	}

	public void setModalidade_aplicacao_codigo(int modalidade_aplicacao_codigo) {
		this.modalidadeAplicacaoCodigo = modalidade_aplicacao_codigo;
	}

	public int getElemento_codigo() {
		return elementoCodigo;
	}

	public void setElemento_codigo(int elemento_codigo) {
		this.elementoCodigo = elemento_codigo;
	}

	public int getSubelemento_codigo() {
		return subelementoCodigo;
	}

	public void setSubelemento_codigo(int subelemento_codigo) {
		this.subelementoCodigo = subelemento_codigo;
	}

	public int getFuncao_codigo() {
		return funcaoCodigo;
	}

	public void setFuncao_codigo(int funcao_codigo) {
		this.funcaoCodigo = funcao_codigo;
	}

	public int getSubfuncao_codigo() {
		return subfuncaoCodigo;
	}

	public void setSubfuncao_codigo(int subfuncao_codigo) {
		this.subfuncaoCodigo = subfuncao_codigo;
	}

	public int getPrograma_codigo() {
		return programaCodigo;
	}

	public void setPrograma_codigo(int programa_codigo) {
		this.programaCodigo = programa_codigo;
	}

	public int getAcao_codigo() {
		return acaoCodigo;
	}

	public void setAcao_codigo(int acao_codigo) {
		this.acaoCodigo = acao_codigo;
	}

	public int getFonte_recurso_codigo() {
		return fonteRecursoCodigo;
	}

	public void setFonte_recurso_codigo(int fonte_recurso_codigo) {
		this.fonteRecursoCodigo = fonte_recurso_codigo;
	}

	public int getEmpenho_ano() {
		return empenhoAno;
	}

	public void setEmpenho_ano(int empenho_ano) {
		this.empenhoAno = empenho_ano;
	}

	public int getEmpenho_modalidade_codigo() {
		return empenhoModalidadeCodigo;
	}

	public void setEmpenho_modalidade_codigo(int empenho_modalidade_codigo) {
		this.empenhoModalidadeCodigo = empenho_modalidade_codigo;
	}

	public int getEmpenho_numero() {
		return empenhoNumero;
	}

	public void setEmpenho_numero(int empenho_numero) {
		this.empenhoNumero = empenho_numero;
	}

	public int getSubempenho() {
		return subempenho;
	}

	public void setSubempenho(int subempenho) {
		this.subempenho = subempenho;
	}

	public int getCredor_codigo() {
		return credorCodigo;
	}

	public void setCredor_codigo(int credor_codigo) {
		this.credorCodigo = credor_codigo;
	}

	public int getModalidade_licitacao_codigo() {
		return modalidadeLicitacaoCodigo;
	}

	public void setModalidade_licitacao_codigo(int modalidade_licitacao_codigo) {
		this.modalidadeLicitacaoCodigo = modalidade_licitacao_codigo;
	}

	public String getOrgao_nome() {
		return orgaoNome;
	}

	public void setOrgao_nome(String orgao_nome) {
		this.orgaoNome = orgao_nome;
	}

	public String getUnidade_nome() {
		return unidadeNome;
	}

	public void setUnidade_nome(String unidade_nome) {
		this.unidadeNome = unidade_nome;
	}

	public String getCategoria_economica_nome() {
		return categoriaEconomicaNome;
	}

	public void setCategoria_economica_nome(String categoria_economica_nome) {
		this.categoriaEconomicaNome = categoria_economica_nome;
	}

	public String getGrupo_despesa_nome() {
		return grupoDespesaNome;
	}

	public void setGrupo_despesa_nome(String grupo_despesa_nome) {
		this.grupoDespesaNome = grupo_despesa_nome;
	}

	public String getModalidade_aplicacao_nome() {
		return modalidadeAplicacaoNome;
	}

	public void setModalidade_aplicacao_nome(String modalidade_aplicacao_nome) {
		this.modalidadeAplicacaoNome = modalidade_aplicacao_nome;
	}

	public String getElemento_nome() {
		return elementoNome;
	}

	public void setElemento_nome(String elemento_nome) {
		this.elementoNome = elemento_nome;
	}

	public String getSubelemento_nome() {
		return subelementoNome;
	}

	public void setSubelemento_nome(String subelemento_nome) {
		this.subelementoNome = subelemento_nome;
	}

	public String getFuncao_nome() {
		return funcaoNome;
	}

	public void setFuncao_nome(String funcao_nome) {
		this.funcaoNome = funcao_nome;
	}

	public String getSubfuncao_nome() {
		return subfuncaoNome;
	}

	public void setSubfuncao_nome(String subfuncao_nome) {
		this.subfuncaoNome = subfuncao_nome;
	}

	public String getPrograma_nome() {
		return programaNome;
	}

	public void setPrograma_nome(String programa_nome) {
		this.programaNome = programa_nome;
	}

	public String getAcao_nome() {
		return acaoNome;
	}

	public void setAcao_nome(String acao_nome) {
		this.acaoNome = acao_nome;
	}

	public String getFonte_recurso_nome() {
		return fonteRecursoNome;
	}

	public void setFonte_recurso_nome(String fonte_recurso_nome) {
		this.fonteRecursoNome = fonte_recurso_nome;
	}

	public String getEmpenho_modalidade_nome() {
		return empenhoModalidadeNome;
	}

	public void setEmpenho_modalidade_nome(String empenho_modalidade_nome) {
		this.empenhoModalidadeNome = empenho_modalidade_nome;
	}

	public String getIndicador_subempenho() {
		return indicadorSubempenho;
	}

	public void setIndicador_subempenho(String indicador_subempenho) {
		this.indicadorSubempenho = indicador_subempenho;
	}

	public String getCredor_nome() {
		return credorNome;
	}

	public void setCredor_nome(String credor_nome) {
		this.credorNome = credor_nome;
	}

	public String getModalidade_licitacao_nome() {
		return modalidadeLicitacaoNome;
	}

	public void setModalidade_licitacao_nome(String modalidade_licitacao_nome) {
		this.modalidadeLicitacaoNome = modalidade_licitacao_nome;
	}

	public String getValor_empenhado() {
		return valorEmpenhado;
	}

	public void setValor_empenhado(String valor_empenhado) {
		this.valorEmpenhado = valor_empenhado;
	}

	public String getValor_liquidado() {
		return valorLiquidado;
	}

	public void setValor_liquidado(String valor_liquidado) {
		this.valorLiquidado = valor_liquidado;
	}

	public String getValor_pago() {
		return valorPago;
	}

	public void setValor_pago(String valor_pago) {
		this.valorPago = valor_pago;
	}	
}