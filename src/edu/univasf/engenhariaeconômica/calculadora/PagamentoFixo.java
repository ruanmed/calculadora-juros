package edu.univasf.engenhariaeconômica.calculadora;

public class PagamentoFixo extends JurosCompostos {
	double valorPagamentoPeriódico;	//PGTO
	
	
	public PagamentoFixo(double VP, double VF, double J, double i, double n, double PGTO) {
		super(VP, VF, J, i, n);
		setPagamentoPeriódico(PGTO);
		
		calcularPagamentoPeriódico();
		calcularValorPresente();
		calcularValorFuturo();
		
		// TODO Auto-generated constructor stub
	}
	
	void setPagamentoPeriódico(double novoValorPagamentoPeriódico) {
		valorPagamentoPeriódico = novoValorPagamentoPeriódico;
	}
	double getPagamentoPeriódico() {
		return valorPagamentoPeriódico;
	}
	
	public String toString() {
		return new String(
				super.toString() + 
				"\nPagamento Periódico: " + getPagamentoPeriódico());
	}
	
	public void calcularPagamentoPeriódico() { // VF = PGTO*(((1+i)^n - 1)/i)
		if (getPagamentoPeriódico() <= 0) {
			double novoPagamentoPeriódico = 0;
			if (getTaxaJuros() > 0 && getNúmeroParcelas() > 0) {
				if (getValorFuturo() > 0) { // PGTO = (VF*i)/((1+i)^n - 1)
					novoPagamentoPeriódico = (getValorFuturo() * getTaxaJuros()) / 
							((Math.pow(1+getTaxaJuros(), getNúmeroParcelas()) - 1));
				}
				else if (getValorPresente() > 0) { // PGTO == VP * [ i*(1+i)^n / ( (1+i)^n - 1) ] 
					novoPagamentoPeriódico = getValorPresente() * ( ( getTaxaJuros()*Math.pow(1 + getTaxaJuros(), getNúmeroParcelas()) ) /
							(Math.pow(1+getTaxaJuros(), getNúmeroParcelas()) - 1 )) ;
				}
			}
			setPagamentoPeriódico(novoPagamentoPeriódico);
		}
	}
	
	public void calcularValorPresente() {	// VP = PGTO/ [ i*(1+i)^n /  ( (1+i)^n - 1) ]
		// TODO Auto-generated method stub
		//super.calcularValorPresente();
		if (getValorPresente() <= 0) {
			double novoValorPresente = 0;
			if (getTaxaJuros() > 0 && getNúmeroParcelas() > 0 && getPagamentoPeriódico() > 0) {	// VP = PGTO/ [ i*(1+i)^n /  ( (1+i)^n - 1) ]
				novoValorPresente = getPagamentoPeriódico()*( (Math.pow(1+getTaxaJuros(), getNúmeroParcelas()) - 1 ) /
						( getTaxaJuros()*Math.pow(1 + getTaxaJuros(), getNúmeroParcelas()) ) 
						);
			}
			setValorPresente(novoValorPresente);
		}
	}
	
	public void calcularValorFuturo() {	// VF = PGTO*(((1+i)^n - 1)/i)
		// TODO Auto-generated method stub
		super.calcularValorFuturo();
		if (getValorFuturo() <= 0) {
			double novoValorFuturo = 0;
			if (getTaxaJuros() > 0 && getNúmeroParcelas() > 0 && getPagamentoPeriódico() > 0) {	// VP = PGTO/ [ i*(1+i)^n /  ( (1+i)^n - 1) ]
				novoValorFuturo = getPagamentoPeriódico()*(Math.pow(1+getTaxaJuros(), getNúmeroParcelas()) - 1);
			}
			setValorFuturo(novoValorFuturo);
		}
	}
	
	public void calcularValorJuros() {
		super.calcularValorJuros();
		// TODO Auto-generated method stub
	}
	
	public void calcularTaxaJuros() { 	// VF = PGTO*(((1+i)^n - 1)/i)
		super.calcularTaxaJuros();
		if (getTaxaJuros() <= 0) {
			double novaTaxaJuros = 0;
			if (getNúmeroParcelas() > 0 && getPagamentoPeriódico() > 0) {	// VF = PGTO*(((1+i)^n - 1)/i)
				if (getValorPresente() > 0) {
					// TODO Auto-generated method stub
				}
				else if(getValorFuturo() > 0){
					// TODO Auto-generated method stub
				}
				novaTaxaJuros = getPagamentoPeriódico()*(Math.pow(1+getTaxaJuros(), getNúmeroParcelas()) - 1);
			}
			setTaxaJuros(novaTaxaJuros);
		}
	}
	
	public void calcularNúmeroParcelas() {
		super.calcularNúmeroParcelas();
		// TODO Auto-generated method stub
	}
}
