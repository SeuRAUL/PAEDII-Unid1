package code;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arvore_RN arv = new Arvore_RN(5);
		arv.inserir(4);
		arv.inserir(2);
		arv.inserir(5);
		arv.inserir(1);
		arv.inserir(3);
		
		arv.imprimir(arv.raiz);
		
		arv.rotacionarDir(arv.buscar(2, arv.raiz)); // testando rotação direita
		/*System.out.println("Removendo...\n\n");
		arv.remover(6);*/
		System.out.println("-------------------");
		arv.imprimir(arv.raiz);
	}

}
