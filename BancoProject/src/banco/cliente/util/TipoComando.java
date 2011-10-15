package banco.cliente.util;

public enum TipoComando {
	// arrumar depois
	ERRO("[0]"),SUCESSO("[1]"),LOGIN("1"),SAQ("3"),DEPOSITO("3"), SALDO("3"), CADASTRO("2");

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
