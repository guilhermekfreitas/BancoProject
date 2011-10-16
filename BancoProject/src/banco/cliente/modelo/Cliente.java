package banco.cliente.modelo;

public class Cliente {
	private String numConta; 
	private String nome;
	private String saldo;
	private String cliServidor; 
	private String cpf;
	private String rg;
	private String dataNasc;
	private String login;
	private String senha;
	
	public Cliente(){
		numConta = "";
		nome = "";
		saldo = "";
		cliServidor = "";
		cpf = "";
		rg = "";
		dataNasc = "";
		login = "";
		senha = "";
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
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

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s Conta: %s Saldo: %s",nome,numConta,saldo);
	}

	
}
