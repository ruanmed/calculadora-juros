package edu.univasf.engenhariaeconômica.calculadora;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.univasf.engenhariaeconômica.calculadora.ui.CalculadoraUI;

public class Payback {	//	Payback Descontado (PBD)
	private int n;			//	Número de Períodos + 1 para considerar o zero
	private double TMA;		//	Taxa mínima de atratividade
	private	double[] FC; 	// Fluxo de Caixa
	private double[] VP;	//	Valor Presente
	private double[] VA;		//	Saldo ou Valor Acumulado
	private double PBD; 		//	Tempo de retorno descontado
	
	private double VPL; 	//	Valor presente líquido
	private double TIR; 	//	Taxa interna de retorno
	
	public Payback(int númeroPeríodos, double valorInicial, double[] fluxosDeCaixa) {
		n = númeroPeríodos;
		FC = new double[n+1];
		VP = new double[n+1];
		VA = new double[n+1];
		
		FC[0] = VP[0] = VA[0] = VPL = valorInicial;
		
		for (int c = 0; c < fluxosDeCaixa.length; c++) {
			FC[c+1] = fluxosDeCaixa[c];
		}
	}
	public Payback(double valorInicial, double[] fluxosDeCaixa) {
		n = fluxosDeCaixa.length +1;
		FC = new double[n+1];
		VP = new double[n+1];
		VA = new double[n+1];
		
		FC[0] = VP[0] = VA[0] = valorInicial;
		
		for (int c = 0; c < n; c++) {
			FC[c+1] = fluxosDeCaixa[c];
		}
		
	}
	public Payback(double valorInicial, List<Double> fluxosDeCaixa, double taxaAtratividade) {
		n = fluxosDeCaixa.size();
		TMA = taxaAtratividade;
		FC = new double[n+1];
		VP = new double[n+1];
		VA = new double[n+1];
		
		FC[0] = VP[0] = VA[0] = VPL = valorInicial;
		TIR = TMA;
		for (int c = 0; c < n; c++) {
			FC[c+1] = fluxosDeCaixa.get(c);
		}
		PBD = 0.0;
		calcular();
	}
	public void calcular() {
		double min = 0.0, max = 1.0;
		//double vMin, vMax;
		while(Math.abs(VPL) > 0.00001) {
			calcularAux((max+min)/2.0);
			if (VPL > 0)
				min = (max+min)/2;
			else 
				max = (max+min)/2;
		}
		TIR = (max+min)/2;
		calcularAux(TMA);
	}
	
	public void calcularAux(double TMAatual) {
		for (int c = 1; c <= n; c++) {	//	Calculando Valores Presentes e atualizando saldo
			VP[c] = FC[c]/Math.pow(1+TMAatual,c);
			VA[c] = VA[c-1]+VP[c];
			
			if (PBD == 0.0 && VA[c] >= 0) { // Calculando o PBD - Tempo de Retorno
				PBD = c + (VA[c-1]/VP[c]);
			}
			VPL = VA[c];
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double valor = 0, taxa = 0;
		List<Double> fluxo = new ArrayList<>();
		
		System.out.println("Digite o valor inicial (R$), usar negativo para indicar a saída: ");
		valor = scan.nextDouble();
		
		System.out.println("Digite a (TMA) Taxa Mínima de Atratividade (%): ");
		taxa = scan.nextDouble()/100;
		
		do {
			System.out.println("Digite uma entrada para o fluxo de caixa (digite 0 para parar): ");
			fluxo.add(scan.nextDouble());
		}
		while (fluxo.get(fluxo.size()-1) != 0);
		fluxo.remove(fluxo.size()-1);
		
		Payback retono = new Payback(valor, fluxo, taxa);
		
		System.out.println(retono.toString());
		
		scan.close();
	}
	
	public String toString() {
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		//format.setMaximumIntegerDigits(2);
		format.setRoundingMode(RoundingMode.HALF_UP);
		
		String saída = new String(" _____________________________________________________________________________________\n"
				+ "|\t\t\t\t ORÇAMENTO DE CAPITAL \t\t\t\t\t|\n"
				+ "|Período\t"
				+ "|Fluxo de Caixa (R$)\t"
				+ "|Valor Presente (R$)\t"
				+ "|Saldo (R$)\t\t"
				+ "|\n" );
		for (int c = 0; c <= n; c++) {
			saída += "|" + c + "\t\t" 
						+ "|" + format.format(FC[c]) + "\t\t"
						+ "|" + format.format(VP[c]) + "\t\t"
						+ "|" + format.format(VA[c]) + "\t\t"
						+ "|\n";
		}
		saída += "(PBD) Payback Descontado: " + format.format(PBD) + "\n";
		saída += "(VPL) Valor Presente Líquido: " + format.format(VPL) + "\n";
		saída += "(TIR) Taxa Interna de Retorno: " + format.format(TIR) + " ou " + format.format(TIR*100) +"% \n";
		
//		Número de Períodos + 1 para considerar o zero
//		private	double[] FC; 	// Fluxo de Caixa
//		private double[] VP;	//	Valor Presente
//		private double[] VA;		//	Saldo ou Valor Acumulado
//		private double PBT; 		//	Tempo de retorno
		
		
		
		return saída;
	}
	
	
}
