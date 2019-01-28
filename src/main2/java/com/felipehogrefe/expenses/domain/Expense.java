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
	private Integer idDB;
	
	public int Id, anoMovimentacao, mesMovimentacao, orgaoCodigo, unidadeCodigo, 
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
		return "Expense [id=" + Id + ", orgaoNome=" + orgaoNome + ", dataMovimentacao=" + mesMovimentacao + "/"+anoMovimentacao+
				", categoriaEconomicaCodigo=" + categoriaEconomicaCodigo + ", fonteRecursoCodigo="+fonteRecursoCodigo+
				", valorPago= "+valorPago+"]";
	}

	public Integer getIdDB() {
		return idDB;
	}	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDB == null) ? 0 : idDB.hashCode());
		return result;
	}

	@Override
	public int compareTo(Expense p) {		
		return 0;
	}

	public int getId() {
		return Id;
	}

	public void setId(int _id) {
		this.Id = _id;
	}

	public int getAnoMovimentacao() {
		return anoMovimentacao;
	}

	public void setAnoMovimentacao(int anoMovimentacao) {
		this.anoMovimentacao = anoMovimentacao;
	}

	public int getMesMovimentacao() {
		return mesMovimentacao;
	}

	public void setMesMovimentacao(int mesMovimentacao) {
		this.mesMovimentacao = mesMovimentacao;
	}

	public int getOrgaoCodigo() {
		return orgaoCodigo;
	}

	public void setOrgaoCodigo(int orgaoCodigo) {
		this.orgaoCodigo = orgaoCodigo;
	}

	public int getUnidadeCodigo() {
		return unidadeCodigo;
	}

	public void setUnidadeCodigo(int unidadeCodigo) {
		this.unidadeCodigo = unidadeCodigo;
	}

	public int getCategoriaEconomicaCodigo() {
		return categoriaEconomicaCodigo;
	}

	public void setCategoriaEconomicaCodigo(int categoriaEconomicaCodigo) {
		this.categoriaEconomicaCodigo = categoriaEconomicaCodigo;
	}

	public int getGrupoDespesaCodigo() {
		return grupoDespesaCodigo;
	}

	public void setGrupoDespesaCodigo(int grupoDespesaCodigo) {
		this.grupoDespesaCodigo = grupoDespesaCodigo;
	}

	public int getModalidadeAplicacaoCodigo() {
		return modalidadeAplicacaoCodigo;
	}

	public void setModalidadeAplicacaoCodigo(int modalidadeAplicacaoCodigo) {
		this.modalidadeAplicacaoCodigo = modalidadeAplicacaoCodigo;
	}

	public int getElementoCodigo() {
		return elementoCodigo;
	}

	public void setElementoCodigo(int elementoCodigo) {
		this.elementoCodigo = elementoCodigo;
	}

	public int getSubelementoCodigo() {
		return subelementoCodigo;
	}

	public void setSubelementoCodigo(int subelementoCodigo) {
		this.subelementoCodigo = subelementoCodigo;
	}

	public int getFuncaoCodigo() {
		return funcaoCodigo;
	}

	public void setFuncaoCodigo(int funcaoCodigo) {
		this.funcaoCodigo = funcaoCodigo;
	}

	public int getSubfuncaoCodigo() {
		return subfuncaoCodigo;
	}

	public void setSubfuncaoCodigo(int subfuncaoCodigo) {
		this.subfuncaoCodigo = subfuncaoCodigo;
	}

	public int getProgramaCodigo() {
		return programaCodigo;
	}

	public void setProgramaCodigo(int programaCodigo) {
		this.programaCodigo = programaCodigo;
	}

	public int getAcaoCodigo() {
		return acaoCodigo;
	}

	public void setAcaoCodigo(int acaoCodigo) {
		this.acaoCodigo = acaoCodigo;
	}

	public int getFonteRecursoCodigo() {
		return fonteRecursoCodigo;
	}

	public void setFonteRecursoCodigo(int fonteRecursoCodigo) {
		this.fonteRecursoCodigo = fonteRecursoCodigo;
	}

	public int getEmpenhoAno() {
		return empenhoAno;
	}

	public void setEmpenhoAno(int empenhoAno) {
		this.empenhoAno = empenhoAno;
	}

	public int getEmpenhoModalidadeCodigo() {
		return empenhoModalidadeCodigo;
	}

	public void setEmpenhoModalidadeCodigo(int empenhoModalidadeCodigo) {
		this.empenhoModalidadeCodigo = empenhoModalidadeCodigo;
	}

	public int getEmpenhoNumero() {
		return empenhoNumero;
	}

	public void setEmpenhoNumero(int empenhoNumero) {
		this.empenhoNumero = empenhoNumero;
	}

	public int getSubempenho() {
		return subempenho;
	}

	public void setSubempenho(int subempenho) {
		this.subempenho = subempenho;
	}

	public int getCredorCodigo() {
		return credorCodigo;
	}

	public void setCredorCodigo(int credorCodigo) {
		this.credorCodigo = credorCodigo;
	}

	public int getModalidadeLicitacaoCodigo() {
		return modalidadeLicitacaoCodigo;
	}

	public void setModalidadeLicitacaoCodigo(int modalidadeLicitacaoCodigo) {
		this.modalidadeLicitacaoCodigo = modalidadeLicitacaoCodigo;
	}

	public String getOrgaoNome() {
		return orgaoNome;
	}

	public void setOrgaoNome(String orgaoNome) {
		this.orgaoNome = orgaoNome;
	}

	public String getUnidadeNome() {
		return unidadeNome;
	}

	public void setUnidadeNome(String unidadeNome) {
		this.unidadeNome = unidadeNome;
	}

	public String getCategoriaEconomicaNome() {
		return categoriaEconomicaNome;
	}

	public void setCategoriaEconomicaNome(String categoriaEconomicaNome) {
		this.categoriaEconomicaNome = categoriaEconomicaNome;
	}

	public String getGrupoDespesaNome() {
		return grupoDespesaNome;
	}

	public void setGrupoDespesaNome(String grupoDespesaNome) {
		this.grupoDespesaNome = grupoDespesaNome;
	}

	public String getModalidadeAplicacaoNome() {
		return modalidadeAplicacaoNome;
	}

	public void setModalidadeAplicacaoNome(String modalidadeAplicacaoNome) {
		this.modalidadeAplicacaoNome = modalidadeAplicacaoNome;
	}

	public String getElementoNome() {
		return elementoNome;
	}

	public void setElementoNome(String elementoNome) {
		this.elementoNome = elementoNome;
	}

	public String getSubelementoNome() {
		return subelementoNome;
	}

	public void setSubelementoNome(String subelementoNome) {
		this.subelementoNome = subelementoNome;
	}

	public String getFuncaoNome() {
		return funcaoNome;
	}

	public void setFuncaoNome(String funcaoNome) {
		this.funcaoNome = funcaoNome;
	}

	public String getSubfuncaoNome() {
		return subfuncaoNome;
	}

	public void setSubfuncaoNome(String subfuncaoNome) {
		this.subfuncaoNome = subfuncaoNome;
	}

	public String getProgramaNome() {
		return programaNome;
	}

	public void setProgramaNome(String programaNome) {
		this.programaNome = programaNome;
	}

	public String getAcaoNome() {
		return acaoNome;
	}

	public void setAcaoNome(String acaoNome) {
		this.acaoNome = acaoNome;
	}

	public String getFonteRecursoNome() {
		return fonteRecursoNome;
	}

	public void setFonteRecursoNome(String fonteRecursoNome) {
		this.fonteRecursoNome = fonteRecursoNome;
	}

	public String getEmpenhoModalidadeNome() {
		return empenhoModalidadeNome;
	}

	public void setEmpenhoModalidadeNome(String empenhoModalidadeNome) {
		this.empenhoModalidadeNome = empenhoModalidadeNome;
	}

	public String getIndicadorSubempenho() {
		return indicadorSubempenho;
	}

	public void setIndicadorSubempenho(String indicadorSubempenho) {
		this.indicadorSubempenho = indicadorSubempenho;
	}

	public String getCredorNome() {
		return credorNome;
	}

	public void setCredorNome(String credorNome) {
		this.credorNome = credorNome;
	}

	public String getModalidadeLicitacaoNome() {
		return modalidadeLicitacaoNome;
	}

	public void setModalidadeLicitacaoNome(String modalidadeLicitacaoNome) {
		this.modalidadeLicitacaoNome = modalidadeLicitacaoNome;
	}

	public String getValorEmpenhado() {
		return valorEmpenhado;
	}

	public void setValorEmpenhado(String valorEmpenhado) {
		this.valorEmpenhado = valorEmpenhado;
	}

	public String getValorLiquidado() {
		return valorLiquidado;
	}

	public void setValorLiquidado(String valorLiquidado) {
		this.valorLiquidado = valorLiquidado;
	}

	public String getValorPago() {
		return valorPago;
	}

	public void setValorPago(String valorPago) {
		this.valorPago = valorPago;
	}	
}