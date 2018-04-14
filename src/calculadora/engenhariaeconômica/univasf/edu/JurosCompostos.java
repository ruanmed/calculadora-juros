package calculadora.engenhariaeconômica.univasf.edu;

public class JurosCompostos extends Juros {
//	VF = VP*(1+i)^n
	
	public JurosCompostos(double VP, double VF, double J, double i, double n) {
		super(VP, VF, J, i, n);
	}
	@Override
	public void calcularValorPresente() { 	//	VP = VF/((1+i)^n)
											
		// TODO Auto-generated method stub
		double novoValorPresente = 0;
		if (getTaxaJuros() > 0 && getNúmeroParcelas() >= 0) {
			if (getValorFuturo() > 0) {	//	VP = VF/((1+i)^n)
				novoValorPresente = getValorFuturo()/Math.pow(1+getTaxaJuros(),getNúmeroParcelas());
			}
			else if (getValorJuros() > 0) {	//	VP = J/(((1+i)^n) - 1)
				novoValorPresente = getValorJuros()/(Math.pow(1+getTaxaJuros(),getNúmeroParcelas())-1);
			}
		}
		else if (getValorFuturo() > 0) {	//	VP = VF - J
			novoValorPresente = getValorFuturo();
			if (getValorJuros() > 0) {
				novoValorPresente -= getValorJuros();
			}
		}
		setValorPresente(novoValorPresente);
	}

	@Override
	public void calcularValorFuturo() {	//	VF = VP*(1+i)^n
		// TODO Auto-generated method stub
		double novoValorFuturo = 0;
		if (getTaxaJuros() > 0 && getNúmeroParcelas() > 0) {
			if (getValorPresente()  > 0) {	//	VF = VP*(1+i)^n
				novoValorFuturo = getValorPresente()*Math.pow(1+getTaxaJuros(), getNúmeroParcelas());
			}
			else if (getValorJuros() > 0) {	//	VF = J/(1 - 1/(1+i)^n)
				novoValorFuturo = getValorJuros()/(1-(1/Math.pow(1+getTaxaJuros(),getNúmeroParcelas())));
			}
		}
		else if (getValorPresente() > 0) {	//	VF = VP + J
			novoValorFuturo = getValorPresente();
			if (getValorJuros() > 0) {
				novoValorFuturo += getValorJuros();
			}
		}
		setValorFuturo(novoValorFuturo);
	}

	@Override
	public void calcularValorJuros() {	//	VF - VP = J = VP*((1+i)^n - 1)
		// TODO Auto-generated method stub
		double novoValorJuros = 0;
		if (getTaxaJuros() > 0 && getNúmeroParcelas() > 0) {
			if (getValorPresente() > 0) {	// J = VP*((1+i)^n - 1)
				novoValorJuros= getValorPresente()*(Math.pow(1+getTaxaJuros(), getNúmeroParcelas()) - 1);
			}
			else if (getValorFuturo() > 0) {	// J = VF*(1-1/(1+i)^n)
				novoValorJuros = getValorFuturo()*(1-(1/Math.pow(1+getTaxaJuros(), getNúmeroParcelas())));
			}
		}
		else if (getValorPresente() > 0 && getValorFuturo() > 0) { // J = VF - VP 
			novoValorJuros = getValorFuturo() - getValorPresente();
		}
		setValorJuros(novoValorJuros);
	}
	
	@Override
	public void calcularTaxaJuros() { 	//	i = raizn-ezima(VF/VP) - 1
										
		// TODO Auto-generated method stub
		double novaTaxaJuros = 0;
		if (getNúmeroParcelas() > 0) {
			if (getValorPresente() > 0) {
				if (getValorFuturo() > 0) 	//	i = (VF/VP)^(1/n) - 1
					novaTaxaJuros = Math.pow((getValorFuturo()/getValorPresente()),
												(1/getNúmeroParcelas())
											) 
									- 1; 
				else if (getValorJuros() > 0) {	// i = (1+(J/VP))^(1/n) -1
					novaTaxaJuros = Math.pow(1+(getValorJuros()/getValorPresente()), 
												(1/getNúmeroParcelas())
											) 
									- 1; 
				}
			}
			else if (getValorFuturo() > 0 && getValorJuros() > 0) {
				// i = (1-VF/J)^(1/n) - 1
				novaTaxaJuros = Math.pow(1-(getValorFuturo()/getValorJuros()), 
											(1/getNúmeroParcelas())
										) 
										- 1; 
			}
		}
		else if (getValorPresente() > 0 && getValorFuturo() > 0 && getValorJuros() > 0) {
			
		}
		setTaxaJuros(novaTaxaJuros); 
	}
	@Override
	public void calcularNúmeroParcelas() {	//	n = log(VF/VP)/log(1+i)
		// TODO Auto-generated method stub
		double novoNúmeroParcelas = 0;
		if (getTaxaJuros() > 0) {
			if (getValorPresente() > 0) { 	// n = log(VF/VP)/log(1+i)
				if (getValorFuturo() > 0) {
					novoNúmeroParcelas = Math.log10(getValorFuturo()/getValorPresente())/Math.log10(1+getTaxaJuros());
				}
				else if (getValorJuros() > 0) {	//	n = log(1+J/VP)/log(1+i)
					novoNúmeroParcelas = Math.log10((1+(getValorJuros()/getValorPresente())))/Math.log10(1+getTaxaJuros());
				}
			}
			else if (getValorFuturo() > 0 && getValorJuros() > 0) { // n = log(1-VF/J)/log(1+i)
				novoNúmeroParcelas = Math.log10(1-(getValorFuturo()/getValorJuros()))/Math.log10(1+getTaxaJuros());
			}
		}
		setNúmeroParcelas(novoNúmeroParcelas);
	}
}
