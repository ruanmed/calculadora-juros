package edu.univasf.engenhariaeconômica.calculadora.ui;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import edu.univasf.engenhariaeconômica.calculadora.Aposentadoria;
import edu.univasf.engenhariaeconômica.calculadora.PagamentoFixo;  

public class CalculadoraUI {
	private JFrame janela;
	private JLabel rotuloCabecalho;
	private JLabel rotuloEstado;
	private JTabbedPane painelPrincipal;
	
	private JPanel painelAposentadoria;
	private JPanel painelPrestações;
	private JPanel painelAmortização;
	private JPanel painelJurosSimples;
	private JPanel painelJurosCompostos;

	public CalculadoraUI() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		new CalculadoraUI().montaTela();
	}
	private void montaTela() {
		// TODO Auto-generated method stub
		preparaJanela();
		preparaPainelAposentadoria();
		preparaPainelPrestações();
		preparaPainelAmortização();
		preparaPainelJurosSimples();
		preparaPainelJurosCompostos();
		
		preparaPainelPrincipal();
		preparaBotaoCarregar();
		preparaBotaoSair();
		preparaMenu();
		mostraJanela();

	}


	private void preparaMenu() {
		// TODO Auto-generated method stub
		//create a menu bar
		final JMenuBar menuBar = new JMenuBar();

		//create menus
		//JMenu menuSelecionar = new JMenu("Selecionar Calculadora");
		final JMenu menuAjuda = new JMenu("Ajuda");
		//menuSelecionar.setMnemonic(KeyEvent.VK_S);
		menuAjuda.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem menuAjudaSobre = new JMenuItem("Sobre");
		menuAjudaSobre.setActionCommand("Sobre");
		

		//	Criando Menu Selecionar Calculadora com botões radiais
		final JRadioButtonMenuItem menuSelecionarAposentadoria = new JRadioButtonMenuItem("Aposentadoria");
		menuSelecionarAposentadoria.setMnemonic(KeyEvent.VK_A);
		menuSelecionarAposentadoria.setActionCommand("Aposentadoria");

		final JRadioButtonMenuItem menuSelecionarPrestações = new JRadioButtonMenuItem("Prestações");
		menuSelecionarPrestações.setMnemonic(KeyEvent.VK_P);
		menuSelecionarPrestações.setActionCommand("Prestações");

		final JRadioButtonMenuItem menuSelecionarAmortização= new JRadioButtonMenuItem("Amortização");
		menuSelecionarAmortização.setMnemonic(KeyEvent.VK_M);
		menuSelecionarAmortização.setActionCommand("Amortização");
		
		final JRadioButtonMenuItem menuSelecionarJurosSimples= new JRadioButtonMenuItem("Juros Simples");
		menuSelecionarJurosSimples.setMnemonic(KeyEvent.VK_J);
		menuSelecionarJurosSimples.setActionCommand("Juros Simples");
		
		final JRadioButtonMenuItem menuSelecionarJurosCompostos= new JRadioButtonMenuItem("Juros Compostos");
		menuSelecionarJurosCompostos.setMnemonic(KeyEvent.VK_C);
		menuSelecionarJurosCompostos.setActionCommand("Juros Compostos");
		
		// Só permite que um seja selecionado por vez, efeito visual
		ButtonGroup grupoSelecionar = new ButtonGroup();
		grupoSelecionar.add(menuSelecionarAposentadoria);
		grupoSelecionar.add(menuSelecionarPrestações);
		grupoSelecionar.add(menuSelecionarAmortização);
		grupoSelecionar.add(menuSelecionarJurosSimples);
		grupoSelecionar.add(menuSelecionarJurosCompostos);		

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setActionCommand("Exit");

		MenuItemListener menuItemListener = new MenuItemListener();

		menuAjudaSobre.addActionListener(menuItemListener);
		
		menuSelecionarAposentadoria.addActionListener(menuItemListener);
		menuSelecionarPrestações.addActionListener(menuItemListener);
		menuSelecionarAmortização.addActionListener(menuItemListener);
		menuSelecionarJurosSimples.addActionListener(menuItemListener);
		menuSelecionarJurosCompostos.addActionListener(menuItemListener);
		exitMenuItem.addActionListener(menuItemListener);

		//add menu items to menus
		
		menuAjuda.add(menuAjudaSobre);
		
		
//		menuSelecionar.add(menuSelecionarAposentadoria);
//		menuSelecionar.add(menuSelecionarPrestações);
//		menuSelecionar.add(menuSelecionarAmortização);
//		menuSelecionar.addSeparator();
//		menuSelecionar.add(menuSelecionarJurosSimples);
//		menuSelecionar.add(menuSelecionarJurosCompostos);     
//		menuSelecionar.addSeparator();
//		menuSelecionar.add(exitMenuItem);        


		//add menu to menubar
//		menuBar.add(menuSelecionar);
		menuBar.add(menuAjuda);     

		//add menubar to the frame
		janela.setJMenuBar(menuBar); 	
	}
	class MenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rotuloEstado.setText(e.getActionCommand() + " JMenuItem clicked.");
		}
	}
	private void preparaJanela() {
		// TODO Auto-generated method stub
		janela = new JFrame("Calculadora");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    rotuloCabecalho = new JLabel("",JLabel.CENTER); 
	    rotuloEstado = new JLabel("",JLabel.CENTER);        
	    rotuloEstado.setSize(350,100);
	    janela.add(rotuloCabecalho);
	    janela.add(rotuloEstado);
	}
	private void preparaPainelAposentadoria() {
		painelAposentadoria = new JPanel();
		
		JLabel tituloJanela = new JLabel("Calculadora de Aposentadoria",JLabel.CENTER);
		tituloJanela.setSize(500,100);
		tituloJanela.setVerticalAlignment(JLabel.TOP);
		painelAposentadoria.add(tituloJanela);
		
	    NumberFormat format1 = NumberFormat.getInstance();
	    NumberFormatter formatoIdade = new NumberFormatter(format1);
	    formatoIdade.setValueClass(Integer.class);
	    formatoIdade.setMinimum(0);
	    formatoIdade.setMaximum(150);
	    formatoIdade.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatoIdade.setCommitsOnValidEdit(true);
	    //JFormattedTextField field = new JFormattedTextField(formatter);
	    //MaskFormatter formatoIdade = createFormatter("###");
	  
	    
	    NumberFormat format2 = NumberFormat.getInstance();
	    format2.setMaximumFractionDigits(7);
	    format2.setMinimumFractionDigits(2);
	    NumberFormatter formatoPorcento = new NumberFormatter(format2);
	    formatoPorcento.setValueClass(Double.class);
	    formatoPorcento.setMinimum(0.000);
	    formatoPorcento.setMaximum(3000.00);
	    formatoPorcento.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatoPorcento.setCommitsOnValidEdit(true);
	    //MaskFormatter formatoPorcento = createFormatter("#####.###");
	    
	    NumberFormat format3 = NumberFormat.getInstance();
	    format3.setMaximumFractionDigits(5);
	    format3.setMinimumFractionDigits(2);
	    NumberFormatter formatoDinheiro = new NumberFormatter(format3);
	    formatoDinheiro.setValueClass(Double.class);
	    formatoDinheiro.setMinimum(0.00);
	    //formatoDinheiro.setMaximum(300000.00);
	    formatoDinheiro.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatoDinheiro.setCommitsOnValidEdit(true);
	    //MaskFormatter formatoDinheiro = createFormatter("########.###");

		
		int x =10, y =30, w = 150, h =20;
		JLabel rotulo1 = new JLabel("Idade Atual"); 
		rotulo1.setBounds(x, y, w, h);
		JFormattedTextField campoIdadeAtual = new JFormattedTextField(formatoIdade);
		campoIdadeAtual.setBounds(x, y+h, w, h);
		
		JLabel rotulo2 = new JLabel("Idade Aposentadoria"); 
		rotulo2.setBounds((x+=(w+20)), y, w, h);
		JFormattedTextField campoIdadeAposentadoria = new JFormattedTextField(formatoIdade);
		campoIdadeAposentadoria.setBounds(x, y+h, w, h);
		
		JLabel rotulo3 = new JLabel("Idade Final"); 
		rotulo3.setBounds((x+=(w+20)), y, w, h);
		JFormattedTextField campoIdadeFinal = new JFormattedTextField(formatoIdade);
		campoIdadeFinal.setBounds(x, y+h, w, h);
		
		JLabel rotulo4 = new JLabel("Renda Desejada R$"); 
		rotulo4.setBounds((x-=(2*(w+20))), (y+=50), w, h);
		JFormattedTextField campoRendaDesejada = new JFormattedTextField(formatoDinheiro);
		campoRendaDesejada.setBounds(x, y+h, w, h);
		
		JLabel rotulo5 = new JLabel("Inflação % (a.m.)"); 
		rotulo5.setBounds((x+=(w+20)), y, w, h);
		JFormattedTextField campoInflação = new JFormattedTextField(formatoPorcento);
		campoInflação.setBounds(x, y+h, w, h);
		
		JLabel rotulo6 = new JLabel("Pagamento Necessário R$"); 
		rotulo6.setBounds((x+=(w+20)), y, w, h);
		JFormattedTextField campoPagamentoNecessário = new JFormattedTextField(formatoDinheiro);
		campoPagamentoNecessário.setBounds(x, y+h, w, h);
		
//		JLabel rotulo7 = new JLabel("Renda de Aposentado");
//		rotulo7.setBounds((x-=(w+20)), (y+=50), w, h);
//		JTextField campoPagamentoPosterior = new JFormattedTextField(formatter);
//		campoPagamentoPosterior.setBounds(x, y+h, w, h);

		campoIdadeAtual.setValue(0);
		campoIdadeAposentadoria.setValue(0);
		campoIdadeFinal.setValue(0);
		campoRendaDesejada.setValue(0.0);
		campoInflação.setValue(0.0);
		campoPagamentoNecessário.setValue(0.0);
				
		painelAposentadoria.setLayout(null); 
		painelAposentadoria.add(rotulo1);
		painelAposentadoria.add(campoIdadeAtual);
		painelAposentadoria.add(rotulo2);
		painelAposentadoria.add(campoIdadeAposentadoria);
		painelAposentadoria.add(rotulo3);
		painelAposentadoria.add(campoIdadeFinal);
		painelAposentadoria.add(rotulo4);
		painelAposentadoria.add(campoRendaDesejada);
		painelAposentadoria.add(rotulo5);
		painelAposentadoria.add(campoInflação);
		painelAposentadoria.add(rotulo6);
		painelAposentadoria.add(campoPagamentoNecessário);
		//painelAposentadoria.add(rotulo7);
		//painelAposentadoria.add(campoPagamentoPosterior);
		painelAposentadoria.setSize(500,500);

		JButton botãoCalcular = new JButton("Calcular");
		botãoCalcular.setBounds(x,(y+50),100,50);
		botãoCalcular.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Aposentadoria temp = new Aposentadoria(
								(Integer) campoIdadeAtual.getValue(),
								(Integer) campoIdadeAposentadoria.getValue(),
								(Integer) campoIdadeFinal.getValue(),
								(Double) campoRendaDesejada.getValue(),
								((Double) campoInflação.getValue())/100.0,
								(Double) campoPagamentoNecessário.getValue()
								);
						temp.calcularAposentadoria();;
						
						
						campoIdadeAtual.setValue(temp.getIdadeAtual());
						campoIdadeAposentadoria.setValue(temp.getIdadeAposentadoria());
						campoIdadeFinal.setValue(temp.getIdadeFinal());
						campoRendaDesejada.setValue(temp.getRendaDesejada());
						campoInflação.setValue(temp.getInflação()*100.0);
						campoPagamentoNecessário.setValue(temp.getPagamentoNecessário());
						
						//System.exit(0);
					}
				}
		);
		painelAposentadoria.add(botãoCalcular);
	}

	private void preparaPainelPrestações() {
		// TODO Auto-generated method stub
		painelPrestações = new JPanel();
		
		JLabel tituloJanela = new JLabel("Calculadora de Prestações",JLabel.CENTER);
		tituloJanela.setSize(500,100);
		tituloJanela.setVerticalAlignment(JLabel.TOP);
		painelPrestações.add(tituloJanela);
		
	    NumberFormat format1 = NumberFormat.getInstance();
	    NumberFormatter formatoInteiro = new NumberFormatter(format1);
	    formatoInteiro.setValueClass(Integer.class);
	    formatoInteiro.setMinimum(0);
	    formatoInteiro.setMaximum(Integer.MAX_VALUE);
	    formatoInteiro.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatoInteiro.setCommitsOnValidEdit(true);
	    //JFormattedTextField field = new JFormattedTextField(formatter);
	    //MaskFormatter formatoIdade = createFormatter("###");
	  
	    
	    NumberFormat format2 = NumberFormat.getInstance();
	    format2.setMaximumFractionDigits(7);
	    format2.setMinimumFractionDigits(2);
	    NumberFormatter formatoPorcento = new NumberFormatter(format2);
	    formatoPorcento.setValueClass(Double.class);
	    formatoPorcento.setMinimum(0.000);
	    formatoPorcento.setMaximum(3000.00);
	    formatoPorcento.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatoPorcento.setCommitsOnValidEdit(true);
	    //MaskFormatter formatoPorcento = createFormatter("#####.###");
	    
	    NumberFormat format3 = NumberFormat.getInstance();
	    format3.setMaximumFractionDigits(2);
	    format3.setMinimumFractionDigits(2);
	    NumberFormatter formatoDinheiro = new NumberFormatter(format3);
	    formatoDinheiro.setValueClass(Double.class);
	    formatoDinheiro.setMinimum(0.00);
	    //formatoDinheiro.setMaximum(300000.00);
	    formatoDinheiro.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatoDinheiro.setCommitsOnValidEdit(true);
	    //MaskFormatter formatoDinheiro = createFormatter("########.###");

		
		int x =10, y =30, w = 150, h =20;
		
		JLabel rotulo1 = new JLabel("Valor do Produto R$"); 
		rotulo1.setBounds(x, y, w, h);
		JFormattedTextField campoValorProduto = new JFormattedTextField(formatoDinheiro);
		campoValorProduto.setBounds(x, y+h, w, h);
		
		JLabel rotulo2 = new JLabel("Taxa de Juros % (a.m.)"); 
		rotulo2.setBounds((x+=(w+20)), y, w, h);
		JFormattedTextField campoTaxaJuros = new JFormattedTextField(formatoPorcento);
		campoTaxaJuros.setBounds(x, y+h, w, h);
		
		JLabel rotulo3 = new JLabel("Parcelas (Número de meses)"); 
		rotulo3.setBounds((x+=(w+20)), y, w, h);
		JFormattedTextField campoParcelas = new JFormattedTextField(formatoInteiro);
		campoParcelas.setBounds(x, y+h, w, h);

		JLabel rotulo4 = new JLabel("Valor da Parcela R$"); 
		rotulo4.setBounds((x-=(2*(w+20))), (y+=50), w, h);
		JFormattedTextField campoValorParcela = new JFormattedTextField(formatoDinheiro);
		campoValorParcela.setBounds(x, y+h, w, h);
		
		JLabel rotulo5 = new JLabel("Valor Total R$"); 
		rotulo5.setBounds((x+=(w+20)), y, w, h);
		//JFormattedTextField campoTaxaJuros = new JFormattedTextField(formatoDinheiro);
		JLabel campoValorTotal = new JLabel("0.0"); 
		campoValorTotal.setBounds(x, y+h, w, h);
		
		JLabel rotulo6 = new JLabel("Total de Juros R$"); 
		rotulo6.setBounds((x+=(w+20)), y, w, h);
		//JFormattedTextField campoParcelas = new JFormattedTextField(formatoDinheiro);
		JLabel campoJurosTotais = new JLabel("0.0"); 
		campoJurosTotais.setBounds(x, y+h, w, h);
		
		campoValorProduto.setValue(0.0);
		campoTaxaJuros.setValue(0.0);
		campoParcelas.setValue(0);
		campoValorParcela.setValue(0.0);
				
		painelPrestações.setLayout(null); 
		painelPrestações.add(rotulo1);
		painelPrestações.add(campoValorProduto);
		painelPrestações.add(rotulo2);
		painelPrestações.add(campoTaxaJuros);
		painelPrestações.add(rotulo3);
		painelPrestações.add(campoParcelas);
		painelPrestações.add(rotulo4);
		painelPrestações.add(campoValorParcela);
		painelPrestações.add(rotulo5);
		painelPrestações.add(campoValorTotal);
		painelPrestações.add(rotulo6);
		painelPrestações.add(campoJurosTotais);

		painelPrestações.setSize(500,500);

		JButton botãoCalcular = new JButton("Calcular");
		botãoCalcular.setBounds(x,(y+50),100,50);
		botãoCalcular.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						PagamentoFixo temp = new PagamentoFixo(
								(Double) campoValorProduto.getValue(),
								0.0,
								0.0,
								((Double) campoTaxaJuros.getValue())/100.0,
								(Integer) campoParcelas.getValue(),
								(Double) campoValorParcela.getValue()
								);
						temp.calcularZeros();
						temp.calcularZeros();
						
						campoValorProduto.setValue(temp.getValorPresente());
						campoTaxaJuros.setValue(temp.getTaxaJuros()*100.0);
						
						campoParcelas.setValue((new Double(temp.getNúmeroParcelas()).intValue()));
						campoValorParcela.setValue(temp.getPagamentoPeriódico());
						
						campoValorTotal.setText(new Double(temp.getValorFuturo()).toString());
						campoJurosTotais.setText(new Double(temp.getValorJuros()).toString());
						
						
						//System.exit(0);
					}
				}
		);
		painelPrestações.add(botãoCalcular);
	}
	
	private void preparaPainelAmortização() {
		// TODO Auto-generated method stub
		painelAmortização = new JPanel();
	}
	private void preparaPainelJurosSimples() {
		// TODO Auto-generated method stub
		painelJurosSimples = new JPanel();
	}
	private void preparaPainelJurosCompostos() {
		// TODO Auto-generated method stub
		painelJurosCompostos = new JPanel();
	}

	private void preparaPainelPrincipal() {
		// TODO Auto-generated method stub
		painelPrincipal = new JTabbedPane();
		
		painelPrincipal.addTab("Aposentadoria", null, painelAposentadoria,
		                  "Calculadora simples de pagamento mensal para obter uma renda desejada"
		                  + "depois em planos de previdência privada");
		painelPrincipal.setMnemonicAt(0, KeyEvent.VK_1);

		painelPrincipal.addTab("Prestações", null, painelPrestações,
		                  "Calculadora de valor de prestações mensais para parcelar um produto"
		                  + " qualquer considerando que são utilizados juros compostos ao mês");
		painelPrincipal.setMnemonicAt(1, KeyEvent.VK_2);

		painelPrincipal.addTab("Amortização", null, painelAmortização,
		                  "Still does nothing");
		painelPrincipal.setMnemonicAt(2, KeyEvent.VK_3);
		
		painelPrincipal.addTab("Juros Simples", null, painelJurosSimples,
                "Uma calculadora simples para cálculo de juros simples");
		painelPrincipal.setMnemonicAt(2, KeyEvent.VK_4);

		painelPrincipal.addTab("Juros Compostos", null, painelJurosCompostos,
				"Uma calculadora simples para cálculo de juros compostos");
		painelPrincipal.setMnemonicAt(2, KeyEvent.VK_5);

		JComponent panel4 = makeTextPanel(
		        "Panel #4 (has a preferred size of 410 x 50).");
		panel4.setPreferredSize(new Dimension(410, 50));
		
//		painelPrincipal.addTab("Tab 4", null, panel4,
//		                      "Does nothing at all");
//		painelPrincipal.setMnemonicAt(3, KeyEvent.VK_6);
		
		janela.add(painelPrincipal);
		janela.setSize(600, 600);
	}
	protected JComponent makeTextPanel(String text) {
	    JPanel panel = new JPanel(false);
	    JLabel filler = new JLabel(text);
	    
	    filler.setHorizontalAlignment(JLabel.CENTER);
	    panel.setLayout(new GridLayout(1, 1));
	    panel.add(filler);
	    return panel;
	}
	protected MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(s);
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }
	    return formatter;
	}
	private void preparaBotaoCarregar() {
		// TODO Auto-generated method stub
		JButton botaoCarregar = new JButton("Carregar XML");
		botaoCarregar.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//new EscolhedorDeXML().escolhe();
					}
				}
		);
		botaoCarregar.setVerticalAlignment(JButton.TOP);
		painelAposentadoria.add(botaoCarregar);
	}
	private void preparaBotaoSair() {
		// TODO Auto-generated method stub
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				}
		);
		painelPrincipal.add(botaoSair);
		
	}
	private void mostraJanela() {
		// TODO Auto-generated method stub  
		janela.pack();
	    janela.setSize(540, 540);
	    janela.setVisible(true);
	}
}
