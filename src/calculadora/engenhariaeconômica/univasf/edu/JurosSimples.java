package calculadora.engenhariaeconômica.univasf.edu;

public class JurosSimples extends Juros {
	// VF = VP*(1+i*n)
	// J = C*n*i
	public JurosSimples(double VP, double VF, double J, double i, double n) {
		super(VP, VF, J, i, n);
	}
	@Override
	public void calcularValorPresente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void calcularValorFuturo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void calcularValorJuros() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void calcularTaxaJuros() { 
		
		double novaTaxaJuros = 0;
		if (getNúmeroParcelas() > 0 && getValorPresente() > 0) {
			if (getValorJuros() > 0) { // i = J/(C*n)
				novaTaxaJuros = getValorJuros()/(getValorPresente()*getNúmeroParcelas());
			}
			else if (getValorFuturo() > 0) { // i = (VF/VP - 1)/n 
				novaTaxaJuros = ((getValorFuturo()/getValorPresente()) - 1)/getNúmeroParcelas();
			}
		}
		
		setTaxaJuros(novaTaxaJuros); 		
	}
	
	@Override
	public void calcularNúmeroParcelas() {
		// TODO Auto-generated method stub

	}
}
