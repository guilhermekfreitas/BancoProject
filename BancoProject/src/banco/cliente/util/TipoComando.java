package banco.cliente.util;

public enum TipoComando {
	// arrumar depois
	ERRO("[0]"),SUCESSO("[1]"),LOGIN("1"),DEPOSITO_SAQUE("2"), SALDO("3"),CADASTRO("2"), ADD_MOVIMENTACAO("7");

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
