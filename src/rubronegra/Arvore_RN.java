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
	
	/*private void inserir(int chave, No_RN index){
		No inserido = inserirInternamente(chave, index); // Insere e recebe nó
		
		No_RN inserido_RN = new No_RN(inserido.chave, inserido.noPai);
		inserido_RN.color = RED;
		
		if ()
		
	}*/
	
	public void caso1(No_RN raiz){
		if (raiz.noPai == null)
			raiz.color = BLACK;
		else
			caso2(raiz);
	}
	
	public void caso2(No_RN no){
		if (no.noPai.color == RED){
			caso3(no);
		}
		return;
	}
	
	public void caso3(No_RN no){
		No_RN tio = acharTio(no);
		No_RN aux;
		
		if ((tio != null) && (tio.color == RED)){
			no.noPai.color = BLACK;
			tio.color = BLACK;
			aux = acharAvo(no);
			aux.color = RED;
			caso1(aux);
		}
		else {
			caso4(no);
		}
		
	}
	
	public void caso4(No_RN no){
		No_RN avo = acharAvo(no);
		
		if ((no == no.noPai.noDir) && (no.noPai == avo.noEsq)){
			rotacionarEsq(no.noPai);
			no = no.noEsq;
		}
		else if ((no == no.noPai.noEsq) && (no.noPai == avo.noDir)){
			rotacionarDir(no.noPai);
			no = no.noDir;
		}
		else{
			caso5(no);
		}
	}
	
	public void caso5(No_RN no){
		No_RN avo = acharAvo(no);
		no.noPai.color = BLACK;
		avo.color = RED;
		
		if ((no == no.noPai.noEsq) && (no.noPai == avo.noEsq)){
			rotacionarDir(avo);
		}
		else if ((no == no.noPai.noDir) && (no.noPai == avo.noDir)){
			rotacionarEsq(no);
		}
	}
	
	public void rotacionarDir(No_RN no){ // tem que receber o pai do novo nó
		no.noDir.noPai = no.noPai;	//filho dir chama avô de pai
		no.noPai.noEsq = no.noDir;	//pai chama neto dir de filho esq
		no.noDir = no.noPai;		// chamo pai de filho Dir
		no.noPai = no.noPai.noPai;	// chamo avô de pai
	}
	
	public void rotacionarEsq(No_RN no){
		
	}
	
	public No_RN acharTio(No_RN no){
		if (no.noPai.chave > no.chave){
			return no.noPai.noDir;
		}
		else{
			return no.noPai.noEsq;
		}
	}
	
	public No_RN acharAvo(No_RN no){
		return no.noPai.noPai;
	}

}
