package entitites;

import entitities.exception.ExcecaoConta;

public class Conta {

	private String usuario;
	private Double saldo;
	private Integer num;
	private Double saqLimite;

	public Conta(String usuario, Double saldo, Integer num, Double saqLimite) {

		this.usuario = usuario;
		this.saldo = saldo;
		this.num = num;
		this.saqLimite = saqLimite;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getSaqLimite() {
		return saqLimite;
	}
	
	public void saque( Double valor) {
		
		if(valor > saqLimite) {
			throw new ExcecaoConta("Saque invalido: Saque não pode ser maior que o saque limite de: " +getSaqLimite());
		}
		else if(saldo > 0 && valor <= saldo) {
			saldo -=  valor;
			System.out.println("Saque realizado com sucesso.");
		}
		else {
			throw new ExcecaoConta("Saldo insuficiente");
		}
		
	}
	public void deposito(Double valor) {
		if(valor <= 0) {
			throw new ExcecaoConta("Valores não podem ser negativos ou nulos");
		}
		else {
			saldo += valor;
		}
	}
	
	public String toStrinh() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ");
		sb.append(usuario + "\n");
		sb.append("Conta: ");
		sb.append(num + "\n");
		sb.append("Saldo: " );
		sb.append(saldo+"\n");
		
		return sb.toString();
	}
	
	
}
