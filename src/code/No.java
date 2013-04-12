package code;

public class No {
	
	public No(int chave, No pai){
		this.chave = chave;
		this.noPai = pai;
		this.noDir = null;
		this.noEsq = null;
	}
	
	public No noPai;
	public No noEsq;
	public No noDir;
	public int chave;
}
