package Snake;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class Teclas extends KeyAdapter {
	
	private int direcao=1;
	private boolean update=false, inicio=false;
	
	public int getDirecao()
	{
		update=true;
		return direcao;
	}
	
	public boolean Inicar()
	{
		return inicio;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int tecla = e.getKeyCode();
		if((inicio==false)&&((tecla==KeyEvent.VK_SPACE)||(tecla==KeyEvent.VK_ENTER)))
			inicio=true;
		if(update)
		{	
			switch(tecla)
			{
			case KeyEvent.VK_W:
			case KeyEvent.VK_UP:
				if(direcao!=3)
					direcao=4;
				break;
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN:
				if(direcao!=4)
					direcao=3;
				break;
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT:
				if(direcao!=1)
					direcao=2;
				break;
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
				if(direcao!=2)
					direcao=1;
				break;
			}
		}
		update=false;
			
	}
	
	public void keyReleased(KeyEvent e)
	{
		
	}

}
