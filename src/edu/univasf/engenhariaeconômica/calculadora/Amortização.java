package edu.univasf.engenhariaeconômica.calculadora;

import java.util.List;

public class Amortização {
	private int n; //Número de Parcelas
	private int tipoCarência;
	private int períodoCarência;
	private double taxaJuros;
	private List<Double> SD; 	// Saldo devedor
	private List<Double> A;		//	Amortização
	private List<Double> J;		//	Juros
	private List<Double> P;		//	Prestação
	public Amortização() {	
		// TODO Auto-generated constructor stub
	}
	public boolean inserir(int posição, double saldoD, double amortiza, double juros, double prestação) {
		SD.add(posição, new Double(saldoD));
		A.add(posição, new Double(amortiza)) ;
		J.add(posição, new Double(juros)) ;
		P.add(posição, new Double(prestação));
		return true;
	}
	public boolean remover(int posição) {
		SD.remove(posição);
		A.remove(posição);
		J.remove(posição);
		P.remove(posição);
		return true;
	}
	public double calcularValorPrestação() { // Calcular valor da parcela
		double PGTO = 0;
		//SD.add(index, element);
		//test[2];
		PagamentoFixo temp = new PagamentoFixo(SD.get(0),0,0,taxaJuros,n,0);
		temp.calcularPagamentoPeriódico();
		PGTO = temp.getPagamentoPeriódico();
		
		for (int c = 0; c < n; c++) {
			P.set(c, PGTO);
		}
		return PGTO;
	}
	public final static int
		SEM_CARÊNCIA			= 0,
		COM_CARÊNCIA_COMPENSA	= 1,
		COM_CARÊNCIA_SALDO		= 2,
		BEGIN			= 3;
	public final static String[] spellings = {
			"id",
			"true",
			"false"
			};
}
