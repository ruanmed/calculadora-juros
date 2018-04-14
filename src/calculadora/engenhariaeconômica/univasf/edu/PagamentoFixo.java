package calculadora.engenhariaeconômica.univasf.edu;

public class PagamentoFixo extends JurosCompostos {
	double valorPagamentoPeriódico;	//PGTO
	
	
	public PagamentoFixo(double VP, double VF, double J, double i, double n, double PGTO) {
		super(VP, VF, J, i, n);
		// TODO Auto-generated constructor stub
	}
	
	void setPagamentoPeriódico(double novoValorPagamentoPeriódico) {
		valorPagamentoPeriódico = novoValorPagamentoPeriódico;
	}
	double getPagamentoPeriódico() {
		return valorPagamentoPeriódico;
	}
	
	public void calcularPagamentoPeriodico() { // VF = PGTO*(((1+i)^n - 1)/i)
		if (getTaxaJuros() > 0 && getNúmeroParcelas() > 0) {
			if (getValorFuturo() > 0) { // PGTO = (VF*i)/((1+i)^n - 1)
				valorPagamentoPeriódico = (getValorFuturo() * getTaxaJuros()) / 
						((Math.pow(1+getTaxaJuros(), getNúmeroParcelas()) - 1));
			}
			else if (getValorPresente() > 0) { // PGTO == VP * [ i*(1+i)^n / ( (1+i)^n - 1) ] 
				valorPagamentoPeriódico = getValorPresente() * ( ( getTaxaJuros()*Math.pow(1 + getTaxaJuros(), getNúmeroParcelas()) ) /
						(Math.pow(1+getTaxaJuros(), getNúmeroParcelas()) - 1 )) ;
			}
		}
	}
	
	public void calcularValorPresente() {	// VP = PGTO/ [ i*(1+i)^n /  ( (1+i)^n - 1) ]
		super.calcularValorPresente();
		
		
	}
	
}
