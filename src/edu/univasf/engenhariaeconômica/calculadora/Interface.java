package edu.univasf.engenhariaeconômica.calculadora;
import javax.swing.*;  

public class Interface {

	public Interface() {
		// TODO Auto-generated constructor stub
	}  
    public static void main(String[] args) {  
	    JFrame f=new JFrame();//creating instance of JFrame 
	    JFileChooser chooser = new JFileChooser();
	    chooser.showOpenDialog(null);
	    JOptionPane.showMessageDialog(null, "Minha mensagem!");
	    JButton b=new JButton("click");//creating instance of JButton  
	    b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
	              
	    f.add(b);//adding button in JFrame  
	              
	    f.setSize(400,500);//400 width and 500 height  
	    f.setLayout(null);//using no layout managers  
	    f.setVisible(true);//making the frame visible 
	    
	    
	    JButton botaoCarregar = new JButton("Carregar XML");
	    JButton botaoSair = new JButton("Sair");

	    JPanel painel = new JPanel();
	    painel.add(botaoCarregar);
	    painel.add(botaoSair);
	    JFrame janela = new JFrame("Argentum");
	    janela.add(painel);
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    janela.pack();
	    janela.setVisible(true);
    }  
}
