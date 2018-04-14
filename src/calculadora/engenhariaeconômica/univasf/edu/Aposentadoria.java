package calculadora.engenhariaeconômica.univasf.edu;

public class Aposentadoria {
	int idadeAtual;
	int idadeAposentadoria;
	int idadeFinal;
	double rendaDesejada;
	double inflação;
	PagamentoFixo antes;	//	PGTO inicial	-	 quanto paga até aposentar
	PagamentoFixo depois;	//	PGTO final - quanto recebe de aposentadoria
	//double valorAposentadoria;	//	PGTO Final
	//double valorParcela;	//	PGTO inicial
	
	
	public Aposentadoria(int iI, int iA, int iF, double renda, double inf) {
		setIdadeAtual(iI);
		setIdadeAposentadoria(iA);
		setIdadeFinal(iF);
		setRendaDesejada(renda);
		setInflação(inf);
	}
	
	
	void setIdadeAtual(int novaIdadeAtual) {
		idadeAtual = novaIdadeAtual;
	}
	void setIdadeAposentadoria(int novaIdadeAposentadoria) {
		idadeAposentadoria = novaIdadeAposentadoria;
	}
	void setIdadeFinal(int novaIdadeFinal) {
		idadeFinal = novaIdadeFinal;
	}
	void setRendaDesejada(double novaRendaDesejada) {
		rendaDesejada = novaRendaDesejada;
	}
	void setInflação(double novaInflação) {
		inflação = novaInflação;
	}
	
	int getIdadeAtual() {
		return idadeAtual;
	}
	int getIdadeAposentadoria() {
		return idadeAposentadoria;
	}
	int getIdadeFinal() {
		return idadeFinal;
	}
	double getRendaDesejada() {
		return rendaDesejada;
	}
	double getInflação() {
		return inflação;
	}
	public void calcularAposentadoria() {
		double tempoAntes = Math.abs((getIdadeAposentadoria() - getIdadeAtual())*12);
		double tempoDepois= Math.abs((getIdadeFinal() - getIdadeAposentadoria())*12);

		antes = new PagamentoFixo(0,0,0,getInflação(),tempoDepois,getRendaDesejada());
		
		depois = new PagamentoFixo(0,antes.getPagamentoPeriódico(),0,getInflação(),tempoAntes,0);
	}
	
	
	public static int main() {
		
		System.out.println("at");
		return 0;
	}
}
