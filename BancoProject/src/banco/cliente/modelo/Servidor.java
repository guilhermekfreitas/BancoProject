package banco.cliente.modelo;

public class Servidor {
	private String nome;
	private String enderecoIP;
	private int porta;
	
	public Servidor(String nome, String enderecoIP, int porta){
		this.nome = nome;
		this.enderecoIP = enderecoIP;
		this.porta = porta;
	}
	
	public int getPorta() {
		return porta;
	}
	public String getNome() {
		return nome;
	}
	public String getEnderecoIP() {
		return enderecoIP;
	}
	
	public String toString(){
		return String.format("Endereco IP:(%s) porta:(%d)", enderecoIP, porta);
	}
}
