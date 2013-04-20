package code;


public class Arvore_RN extends Arvore{
	
	static final boolean RED = false;
	static final boolean BLACK = true;
	
	

	public Arvore_RN(int chave){
		super(chave);
	}

	public void caso1(No raiz){
		if (raiz.noPai == null)
			raiz.red = BLACK;
		else
			caso2(raiz);
	}
	
	public void caso2(No no){
		if (no.noPai.red == RED){
			caso3(no);
		}
		return;
	}
	
	public void caso3(No no){
		No tio = acharTio(no);
		No aux;
		
		if ((tio != null) && (tio.red == RED)){
			no.noPai.red = BLACK;
			tio.red = BLACK;
			aux = acharAvo(no);
			aux.red = RED;
			caso1(aux);
		}
		else {
			caso4(no);
		}
		
	}
	
	public void caso4(No no){
		No avo = acharAvo(no);
		
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
	
	public void caso5(No no){
		No avo = acharAvo(no);
		no.noPai.red = BLACK;
		avo.red = RED;
		
		if ((no == no.noPai.noEsq) && (no.noPai == avo.noEsq)){
			rotacionarDir(avo);
		}
		else if ((no == no.noPai.noDir) && (no.noPai == avo.noDir)){
			rotacionarEsq(no);
		}
	}

	private void rotacionarEsq(No no) {
		// TODO Auto-generated method stub
		
	}

	public boolean filhoEsq(No node){
		if(node.chave < node.noPai.chave){
			return true;
		}
		else  
			return false;
	}
	public void rotacionarDir(No node){ // tem que receber o pai do novo nó
		node.noDir.noPai = node.noPai;	//filho dir chama avô de pai
		node.noPai.noEsq = node.noDir;	//pai chama neto dir de filho esq
		node.noDir = node.noPai;		// chamo pai de filho Dir
		node.noPai.noPai = node;
		node.noPai = acharAvo(node);	// chamo avô de pai
		if(filhoEsq(node.noPai)){
			acharAvo(node).noEsq = node; 
		}
		else 
			acharAvo(node).noDir = node;
		
		
	}
	
	
	
	
	public No acharTio(No no){
		if (no.noPai.chave > no.chave){
			return no.noPai.noDir;
		}
		else{
			return no.noPai.noEsq;
		}
	}
	
	public No acharAvo(No no){
		return no.noPai.noPai;
	}

}
