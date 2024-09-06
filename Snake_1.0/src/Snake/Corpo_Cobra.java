package Snake;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Corpo_Cobra extends JPanel {

	private int[] x = new int[40]; 
	private int[] y = new int[40];
	private int tamanho;
	
	public void setPossicoes(int[] x, int[] y, int tamanho) {
		this.x=x;
		this.y=y;
		this.tamanho=tamanho;
	}
	
	public void paintComponent(Graphics g)
	{
		int corpo_atual;
		g.setColor(Color.GREEN);
		for(corpo_atual=0;corpo_atual<tamanho;corpo_atual++)
		{
			g.fillRect(1+(x[corpo_atual]*25), 1+(y[corpo_atual]*25), 24, 24);
		}
		
	}

}