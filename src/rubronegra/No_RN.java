package rubronegra;

import code.No;

public class No_RN{
	
	static final boolean RED = false;
	static final boolean BLACK = true;
	
	public No_RN(int chave, No_RN pai) {
		this.chave = chave;
		this.noPai = pai;
		this.noDir = null;
		this.noEsq = null;
		this.color = RED; // Novo nó sempre é vermelho
	}
	
	public No_RN noPai;
	public No_RN noEsq;
	public No_RN noDir;
	public int chave;
	public boolean color;
	
	private void mudaCor(){
		if (this.color) // se preto
			this.color = RED;
		else
			this.color = BLACK;
	}

}
