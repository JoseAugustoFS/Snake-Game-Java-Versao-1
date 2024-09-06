package Snake;

import javax.swing.JLabel;

import javax.swing.JLayeredPane;

import java.awt.Color;

import java.awt.Font;

import java.util.Random;

public class Main {

	public static void main(String[] args)
	{
		Janela janela = new Janela();
		Maca maca = new Maca();
		Fundo fundo = new Fundo();
		Cabeca_Cobra cabeca = new Cabeca_Cobra();
		Corpo_Cobra corpo = new Corpo_Cobra();
		Teclas tecla = new Teclas();
		Colissao colidir = new Colissao();
		
		JLayeredPane layeredpane = new JLayeredPane();
		Random aleatorio = new Random();
		JLabel fim = new JLabel();
		JLabel comeco = new JLabel();
		JLabel obs = new JLabel();
		

		fim.setFont(new Font("Teste", Font.PLAIN, 55));
		
		comeco.setBounds(200, 150, 500, 200);
		comeco.setFont(new Font("Teste", Font.PLAIN, 55));
		comeco.setForeground(new Color(0,120,20));
		comeco.setText("Snake");
		obs.setBounds(80, 250, 500, 200);
		obs.setFont(new Font("Teste", Font.PLAIN, 20));
		obs.setForeground(new Color(0,240,0));
		obs.setText("Pressione 'ESPAÇO' ou 'ENTER' para começar!");
		
		
		//Iniciar
		layeredpane.setBounds(20, 20, 600, 600);
		
		janela.criarJanela();
		maca.setOpaque(false);
		maca.setBounds(20, 20, 600, 600);
		fundo.setOpaque(false);
		fundo.setBounds(20, 20, 600, 600);
		cabeca.setOpaque(false);
		cabeca.setBounds(20, 20, 600, 600);
		corpo.setOpaque(false);
		corpo.setBounds(20, 20, 600, 600);
		
		fundo.isQuadriculado(false);
		
		layeredpane.add(comeco);
		layeredpane.add(obs);
		layeredpane.add(fim);
		
		layeredpane.add(cabeca);
		layeredpane.add(corpo);
		layeredpane.add(maca);
		layeredpane.add(fundo);
		janela.tela.add(layeredpane);
		janela.tela.addKeyListener(tecla);
		int direcao, tamanho=5+2, poscicao_atual, velocidade=500;
		int x_cabeca=10 ,y_cabeca=10 ,x_maca=aleatorio.nextInt(20)+1 ,y_maca=aleatorio.nextInt(20)+1 ;
		int[] x_corpo = new int[40];
		int[] y_corpo = new int[40];
		boolean vitoria=false, inicio=false;
		
		for(poscicao_atual=tamanho;poscicao_atual>=0;poscicao_atual--)
		{
			x_corpo[poscicao_atual]=25;
			y_corpo[poscicao_atual]=25;
		}
		
		//Loop do jogo

		
		while((colidir.Borda(x_cabeca, y_cabeca)==false)&&(colidir.Corpo(x_corpo, y_corpo,x_cabeca,y_cabeca, tamanho)==false))
		{
			maca.setVisible(inicio);
			cabeca.setVisible(inicio);
			corpo.setVisible(inicio); 
			if(inicio==false)
			{
				inicio=tecla.Inicar();
				System.out.println(inicio);
			}
			else
			{	
				comeco.setVisible(false);
				obs.setVisible(false);
				x_corpo[0]=x_cabeca;
				y_corpo[0]=y_cabeca;
				for(poscicao_atual=tamanho;poscicao_atual>0;poscicao_atual--)
				{
					x_corpo[poscicao_atual]=x_corpo[poscicao_atual-1];
					y_corpo[poscicao_atual]=y_corpo[poscicao_atual-1];
				}
				corpo.setPossicoes(x_corpo, y_corpo, tamanho);
				corpo.repaint();
				
				cabeca.setPossicoes(x_cabeca, y_cabeca);
				cabeca.repaint();
				
				maca.setPossicoes(x_maca, y_maca);
				maca.repaint();
				janela.pontuacao.setText("Pontuacao: "+(tamanho-7)+"/25");
				if(tamanho==32)
				{
					maca.setVisible(false);
					vitoria=true;
					break;
				}
				direcao=tecla.getDirecao();
				switch(direcao)
				{
				case 1://direita
					x_cabeca+=1;
					break;
				case 2://esquerda
					x_cabeca-=1;
					break;
				case 3://baixo
					y_cabeca+=1;
					break;
				case 4://cima
					y_cabeca-=1;
					break;
				}
				
				
				if((x_maca==x_cabeca)&&(y_maca==y_cabeca))
				{
					boolean termino=false;
					do
					{
						x_maca=aleatorio.nextInt(21);
						y_maca=aleatorio.nextInt(21);
						
						if((x_maca!=x_cabeca)&&(y_maca!=y_cabeca))
						{
							for(int i =0; i<tamanho;i++)
							{
								if((x_maca!=x_corpo[i])&&(y_maca!=y_corpo[i]))
									termino=true;
							}
						}
						
					}while(termino==false);
					tamanho++;
					if(velocidade>=100)
						velocidade-=25;
				}
				
				
				
				try { Thread.sleep (velocidade); } catch (InterruptedException ex) {}
			}
			

		}
		
	
		if(vitoria)
		{
			fim.setBounds(150, 150, 500, 200);
			fim.setForeground(new Color(0,125,50));
			fim.setText("VITÓRIA!!!");
		}
		else
		{
			fim.setBounds(100, 150, 500, 200);
			fim.setForeground(new Color(125,0,0));
			fim.setText("GAMEOVER!!!");
		}
		
	}
	
	

}
