package edu.univasf.engenhariaeconômica.calculadora;

public class Aposentadoria {	//
	int idadeAtual;
	int idadeAposentadoria;
	int idadeFinal;
	double rendaDesejada;
	double inflação;
	PagamentoFixo antes;	//	PGTO inicial	-	 quanto paga até aposentar
	PagamentoFixo depois;	//	PGTO final - quanto recebe de aposentadoria
	//double valorAposentadoria;	//	PGTO Final
	//double valorParcela;	//	PGTO inicial
	
	
	public Aposentadoria(int iI, int iA, int iF, double renda, double inf) {
		setIdadeAtual(iI);
		setIdadeAposentadoria(iA);
		setIdadeFinal(iF);
		setRendaDesejada(renda);
		setInflação(inf);
	}
	
	
	void setIdadeAtual(int novaIdadeAtual) {
		idadeAtual = novaIdadeAtual;
	}
	void setIdadeAposentadoria(int novaIdadeAposentadoria) {
		idadeAposentadoria = novaIdadeAposentadoria;
	}
	void setIdadeFinal(int novaIdadeFinal) {
		idadeFinal = novaIdadeFinal;
	}
	void setRendaDesejada(double novaRendaDesejada) {
		rendaDesejada = novaRendaDesejada;
	}
	void setInflação(double novaInflação) {
		inflação = novaInflação;
	}
	
	int getIdadeAtual() {
		return idadeAtual;
	}
	int getIdadeAposentadoria() {
		return idadeAposentadoria;
	}
	int getIdadeFinal() {
		return idadeFinal;
	}
	double getRendaDesejada() {
		return rendaDesejada;
	}
	double getInflação() {
		return inflação;
	}
	public void calcularAposentadoria() {
		double tempoAntes = Math.abs((getIdadeAposentadoria() - getIdadeAtual())*12);
		double tempoDepois= Math.abs((getIdadeFinal() - getIdadeAposentadoria())*12);

		depois = new PagamentoFixo(0,0,0,getInflação(),tempoDepois,getRendaDesejada());

		System.out.println("\nDEPOIS " + depois.toString());
		
		antes = new PagamentoFixo(0,depois.getValorPresente(),0,getInflação(),tempoAntes,0);
		
		System.out.println("\nANTES " + antes.toString());
	}
	
	public String toString() {
		return new String(
				"\nIdade Atual: " + getIdadeAtual() +
				"\nIdade Aposentadoria: " + getIdadeAposentadoria() +
				"\nIdade Final: " + getIdadeFinal() +
				"\nRenda Desejada :" + getRendaDesejada() +
				"\nInflação: " + getInflação() +
				"\nPagamento Necessário: " + antes.getPagamentoPeriódico() );
	}
	
	public static void main(String[] args) {
		Aposentadoria nova = new Aposentadoria(22,40,85,3083,0.003);
		nova.calcularAposentadoria();
		
		System.out.println(nova.toString());
		
	}
}
