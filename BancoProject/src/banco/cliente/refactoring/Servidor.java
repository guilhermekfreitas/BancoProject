package banco.cliente.refactoring;

public class Servidor {
	private String nome;
	private String enderecoIP;
	
	public Servidor(String nome, String enderecoIP){
		this.nome = nome;
		this.enderecoIP = enderecoIP;
	}
	
	public String getNome() {
		return nome;
	}
	public String getEnderecoIP() {
		return enderecoIP;
	}
	
	public String toString(){
		return String.format("Servidor %s: (%s)", nome, enderecoIP);
	}
}
