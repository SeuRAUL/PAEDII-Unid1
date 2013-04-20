package code;

public class No {
	
	public No(int chave, No pai){
		this.chave = chave;
		this.noPai = pai;
		this.noDir = null;
		this.noEsq = null;
		this.red = true;
	}
	
	public No noPai;
	public No noEsq;
	public No noDir;
	public int chave;
	
	public boolean getCor() {
		return red;
	}
	
	public void setCor(boolean red) {
		this.red = red;
	}
	
	public boolean red;
}
