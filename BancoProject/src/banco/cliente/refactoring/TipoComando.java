package banco.cliente.refactoring;

public enum TipoComando {
	SAQUE("1"),LOGIN("2");

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
