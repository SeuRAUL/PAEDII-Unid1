package code;

import rubronegra.No_RN;

public class Arvore {
	
	public Arvore(int chave){
		this.raiz = new No(chave, null);
	}
	
	
	/* Relativos à inserção */
	public void inserir(int chave){
		inserirInternamente(chave, this.raiz);
	}
	
	public No inserirInternamente(int chave, No index){
		if(chave > index.chave){
			if(index.noDir != null){
				inserirInternamente(chave, index.noDir);
			}else{
				index.noDir = new No(chave, index);
				return index.noDir;
			}
		}else if(chave < index.chave){
			if(index.noEsq != null){
				inserirInternamente(chave, index.noEsq);
			} else {
				index.noEsq = new No(chave, index);
				return index.noEsq;
			}
		}
	}
	
	/* Impressão */
	public void imprimir(No raiz){
		if(raiz == null) return;
		System.out.println(raiz.chave);
		imprimir(raiz.noDir);
		imprimir(raiz.noEsq);
	}
	
	public void remover(int chave){
		No index = buscar(chave, this.raiz);
		
		if(index == null){
			System.out.println("N� inexistente na �rvore!");
			return;
		}else if(index.noDir == null && index.noEsq == null){
			index = null;
		}else if(index.noDir != null && index.noEsq == null){
			(index.noPai).noDir = index.noDir;
			index = null;
		}else if(index.noDir == null && index.noEsq != null){
			(index.noPai).noEsq = index.noEsq;
			index = null;
		}
	}
	
	public No buscar(int chave, No index){
		if(index == null){
			return null;
		}else{
			if(index.chave == chave){
				return index;
			}else if(index.chave > chave){
				return buscar(chave, index.noEsq);
			}else if(index.chave < chave){
				return buscar(chave, index.noDir);
			}
		}
		
		return null;
	}
	
	public void rotacionarDir(No no){ // tem que receber o pai do novo nó
		no.noDir.noPai = no.noPai;	//filho dir chama avô de pai
		no.noPai.noEsq = no.noDir;	//pai chama neto dir de filho esq
		no.noDir = no.noPai;		// chamo pai de filho Dir
		no.noPai = no.noPai.noPai;	// chamo avô de pai
	}
	
	
	/* Variáveis */
	public No raiz;
}
