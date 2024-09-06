package Snake;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Fundo extends JPanel{
	

	private boolean quadriculado=true;
	
	public void isQuadriculado(boolean quadriculado)
	{
		this.quadriculado=quadriculado;
	}
	
	public void paintComponent(Graphics g)
	{

		
		g.setColor(Color.BLACK);
		//g.fillRect(20, 20, 560, 560);
		g.fillRect(0, 0, 525, 525);
		g.setColor(Color.WHITE);
		if(quadriculado)
		{			
			for(int i =0;i<=21;i++)
			{
				g.drawLine(0, 0+(25*i), 525, 0+(25*i));
				g.drawLine(0+(25*i), 0, 0+(25*i), 525);
			}
		}
		
	}

}
