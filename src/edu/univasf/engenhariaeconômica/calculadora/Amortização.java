package edu.univasf.engenhariaeconômica.calculadora;

import java.util.List;

public class Amortização {
	private int n; //Número de Parcelas
	private double taxaJuros;
	private List<Double> SD; 	// Saldo devedor
	private List<Double> A;		//	Amortização
	private List<Double> J;		//	Juros
	private List<Double> P;		//	Prestação
	public Amortização() {	
		// TODO Auto-generated constructor stub
	}
	
	public double calcularValorPrestação() { // Calcular valor da parcela
		double PGTO = 0;
		PagamentoFixo temp = new PagamentoFixo(SD.get(0),0,0,taxaJuros,n,0);
		temp.calcularPagamentoPeriódico();
		PGTO = temp.getPagamentoPeriódico();
		
		for (int c = 0; c < n; c++) {
			P.set(c, PGTO);
		}
		return PGTO;
	}

}
