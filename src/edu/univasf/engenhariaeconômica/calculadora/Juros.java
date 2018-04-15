package edu.univasf.engenhariaeconômica.calculadora;

public abstract class Juros {
	private double valorPresente;	//	VP ou C (Capital)
	private double valorFuturo;		//	VF ou M (Montante)
	private double valorJuros;		//	J
	private double taxaJuros;		//	i, obrigatoriamente na mesma unidade de tempo que o n 
	private double númeroParcelas;	//	n
	// VF = VP*(1+i*n)
	// J = C*n*i
	public Juros(double VP, double VF, double J, double i, double n) {
		setValorPresente(VP);
		setValorFuturo(VF);
		setValorJuros(J);
		setTaxaJuros(i);
		setNúmeroParcelas(n);
		
		calcularValorPresente();
		calcularValorFuturo();
		calcularValorJuros();
		calcularTaxaJuros();
		calcularNúmeroParcelas();
	}
	double getValorPresente() {
		return valorPresente;
	}
	double getValorFuturo() {
		return valorFuturo;
	}
	double getValorJuros() {
		return valorJuros;
	}
	double getTaxaJuros() {
		return taxaJuros;
	}
	double getNúmeroParcelas() {
		return númeroParcelas;
	}
	void setValorPresente(double novoValorPresente) {
		valorPresente = novoValorPresente;
	}
	void setValorFuturo(double novoValorFuturo) {
		valorFuturo = novoValorFuturo;
	}
	void setValorJuros(double novoValorJuros) {
		valorJuros = novoValorJuros;
	}
	void setTaxaJuros(double novaTaxaJuros) {
		taxaJuros = novaTaxaJuros;
	}
	void setNúmeroParcelas(double novoNúmeroParcelas) {
		númeroParcelas = novoNúmeroParcelas;
	}
	@Override
	public String toString() {
		return new String(
				"\nValor Presente: " + getValorPresente() +
				"\nValor Futuro: " + getValorFuturo() +
				"\nValor Juros: " + getValorJuros() +
				"\nTaxa de Juros: " + getTaxaJuros() +
				"\nNúmero de Parcelas: " + getNúmeroParcelas() );
	}
	public abstract void calcularValorPresente();
	public abstract void calcularValorFuturo();
	public abstract void calcularValorJuros();
	public abstract void calcularTaxaJuros();
	public abstract void calcularNúmeroParcelas();
}
