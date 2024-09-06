package Snake;

import java.awt.Color;

import javax.swing.JFrame;

import javax.swing.JLabel;

public class Janela {

	JFrame tela = new JFrame("Snake");
	JLabel pontuacao = new JLabel();
	public void criarJanela()
	{
		tela.setSize(580, 605);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setVisible(true);
		tela.getContentPane().setBackground(new Color(100,0,0));
		tela.setResizable(false);
		
		pontuacao.setBounds(20, 5, 170, 10);
		pontuacao.setText("Pontuacao: "+0+"/"+25);
		pontuacao.setForeground(Color.WHITE);
		
		tela.add(pontuacao);
		
		
	}
	

	
}
