package code;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arvore arv = new Arvore(5);
		arv.inserir(4);
		arv.inserir(6);
		arv.inserir(9);
		arv.inserir(2);
		
		arv.imprimir(arv.raiz);
		System.out.println("Removendo...\n\n");
		arv.remover(6);
		
		arv.imprimir(arv.raiz);
		
	}

}
