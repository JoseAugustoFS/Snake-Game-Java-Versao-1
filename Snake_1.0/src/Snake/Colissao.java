package Snake;

public class Colissao {

	public boolean Borda(int x, int y)
	{
		if((x<0)||(x>20)||(y<0)||(y>20))
			return true;
		return false;
	}
	public boolean Corpo(int[] x_corpo, int[] y_corpo, int x_cabeca, int y_cabeca, int tamanho)
	{
		int posicao_atual;
		for(posicao_atual=2;posicao_atual<tamanho;posicao_atual++)
		{
			if((x_corpo[posicao_atual]==x_cabeca)&&(y_corpo[posicao_atual]==y_cabeca))
				return true;
		}
		return false;
	}
	
}
