package Snake;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Cabeca_Cobra extends JPanel {

	private int x , y;
	
	public void setPossicoes(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void paintComponent(Graphics g)
	{
		
		g.setColor(new Color(0,120,0));
		g.fillRect(1+(x*25), 1+(y*25), 24, 24);
		
	}

}
