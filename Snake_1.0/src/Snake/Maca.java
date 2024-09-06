package Snake;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Maca extends JPanel{

	private int x , y;
	
	public void setPossicoes(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void paintComponent(Graphics g)
	{
		
		g.setColor(new Color(255,50,50));
		g.fillOval(7+(x*25), 7+(y*25), 13, 13);
		
	}
	
}
