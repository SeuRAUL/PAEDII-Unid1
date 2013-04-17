package rubronegra;

import code.Arvore;
import code.No;

public class Arvore_RN extends Arvore{
	
	static final boolean RED = false;
	static final boolean BLACK = true;
	
	public No_RN raiz;

	public Arvore_RN(int chave){
		this.raiz = new No_RN(chave, null);
		this.raiz.color = BLACK; // raiz sempre é preta
	}
	
	private void inserir(int chave, No_RN index){
		
	}
	

}
