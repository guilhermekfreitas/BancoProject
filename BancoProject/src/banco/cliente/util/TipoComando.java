package banco.cliente.util;

public enum TipoComando {
	ERRO("[0]"),LOGIN("1"),SAQ("2"),DEPOSITO("3");

	TipoComando(String comando){
		this.comando = comando;
	}
	
	String comando;
	public String getComando(){
		return comando;
	}
	
	@Override
	public String toString() {
		return comando;
	}
	
}
