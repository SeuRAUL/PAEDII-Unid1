package rubronegra;

import code.No;

public class No_RN extends No{
	
	static final boolean RED = false;
	static final boolean BLACK = true;
	
	public No_RN(int chave, No pai) {
		super(chave, pai);
		this.color = RED;
	}
	
	public boolean color;
	
	private void mudaCor(){
		if (this.color) // se preto
			this.color = RED;
		else
			this.color = BLACK;
	}

}
