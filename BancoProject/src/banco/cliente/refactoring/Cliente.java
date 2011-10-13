package banco.cliente.refactoring;

public class Cliente {
	
	// converter para tipos
	private String numConta;
	private String nome;
	private String saldo;
	private String cliServidor; // o que é isso!
	
	public Cliente(){
		numConta = "";
		nome = "";
		saldo = "";
		cliServidor = "";
	}
	
	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getCliServidor() {
		return cliServidor;
	}
	public void setCliServidor(String cliServidor) {
		this.cliServidor = cliServidor;
	}
	
	
}
