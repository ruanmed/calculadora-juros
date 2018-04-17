package edu.univasf.engenhariaeconômica.calculadora;

public class Aposentadoria {	//
	private int idadeAtual;
	private int idadeAposentadoria;
	private int idadeFinal;
	private double rendaDesejada;
	private double inflação;
	private double pagamentoNecessário;
	private PagamentoFixo antes;	//	PGTO inicial	-	 quanto paga até aposentar
	private PagamentoFixo depois;	//	PGTO final - quanto recebe de aposentadoria
	//double valorAposentadoria;	//	PGTO Final
	//double valorParcela;	//	PGTO inicial
	
	
	public Aposentadoria(int iI, int iA, int iF, double renda, double inf, double pgto) {
		setIdadeAtual(iI);
		setIdadeAposentadoria(iA);
		setIdadeFinal(iF);
		setRendaDesejada(renda);
		setInflação(inf);
		setPagamentoNecessário(pgto);
	}
	
	
	public void setIdadeAtual(int novaIdadeAtual) {
		idadeAtual = novaIdadeAtual;
	}
	public void setIdadeAposentadoria(int novaIdadeAposentadoria) {
		idadeAposentadoria = novaIdadeAposentadoria;
	}
	public void setIdadeFinal(int novaIdadeFinal) {
		idadeFinal = novaIdadeFinal;
	}
	public void setRendaDesejada(double novaRendaDesejada) {
		rendaDesejada = novaRendaDesejada;
	}
	public void setInflação(double novaInflação) {
		inflação = novaInflação;
	}
	public void setPagamentoNecessário(double novoPagamentoNecessário) {
		pagamentoNecessário = novoPagamentoNecessário;
	}
	
	public int getIdadeAtual() {
		return idadeAtual;
	}
	public int getIdadeAposentadoria() {
		return idadeAposentadoria;
	}
	public int getIdadeFinal() {
		return idadeFinal;
	}
	public double getRendaDesejada() {
		return rendaDesejada;
	}
	public double getInflação() {
		return inflação;
	}
	public double getPagamentoNecessário() {
		return antes.getPagamentoPeriódico();
	}
	public double getPagamentoPosterior() {
		return depois.getPagamentoPeriódico();
	}
	public void calcularAposentadoria() {
		//if (pagamentoNecessário <= 0) {
			double tempoAntes = Math.abs((getIdadeAposentadoria() - getIdadeAtual())*12);
			double tempoDepois= Math.abs((getIdadeFinal() - getIdadeAposentadoria())*12);
	
			depois = new PagamentoFixo(0,0,0,getInflação(),tempoDepois,getRendaDesejada());
			antes = new PagamentoFixo(0,depois.getValorPresente(),0,getInflação(),tempoAntes,0);
//			System.out.println("\nDEPOIS " + depois.toString());
//			System.out.println("\nANTES " + antes.toString());
		//}
	}
	
	public String toString() {
		return new String(
				"\nIdade Atual: " + getIdadeAtual() +
				"\nIdade Aposentadoria: " + getIdadeAposentadoria() +
				"\nIdade Final: " + getIdadeFinal() +
				"\nRenda Desejada :" + getRendaDesejada() +
				"\nInflação: " + getInflação() +
				"\nPagamento Necessário: " + antes.getPagamentoPeriódico() +
				"\nPagamento Posterior: " + depois.getPagamentoPeriódico() );
	}
	
	public static void main(String[] args) {
		Aposentadoria nova = new Aposentadoria(22,60,85,1200,0.003,0.0);
		nova.calcularAposentadoria();
		
		System.out.println(nova.toString());
		
	}
}
