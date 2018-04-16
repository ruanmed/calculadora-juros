package edu.univasf.engenhariaeconômica.calculadora;

public class Prestações {

	double valorProduto;
	double taxaJuros;
	PagamentoFixo compraParcelada;
	public Prestações(double VP, double VF, double J, double i, double n, double PGTO) {
		//super(VP, VF, J, i, n);
		// TODO Auto-generated constructor stub
		compraParcelada = new PagamentoFixo(VP, VF, J, i, n, PGTO);
	}

}
