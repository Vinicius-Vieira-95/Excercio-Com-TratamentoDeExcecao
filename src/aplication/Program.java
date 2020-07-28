package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import entitites.Conta;
import entitities.exception.ExcecaoConta;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("Entre com o nome do usuario: ");
			String usuario = sc.nextLine();
			System.out.print("Numero da conta: ");
			int num = sc.nextInt();
			System.out.print("Saldo da conta: ");
			Double saldo = sc.nextDouble();
			System.out.println("Saldo limite para saque: ");
			Double saqLimite = sc.nextDouble();
			
			Conta conta = new Conta(usuario, saldo, num, saqLimite);
			
			System.out.print("Quanto você deseja depositar?: $");
			Double valor = sc.nextDouble();
			conta.deposito(valor);
			
			System.out.println("Quanto você deseja sacar?: $");
			valor = sc.nextDouble();
			conta.saque(valor);
			
			System.out.println();
			System.out.println(conta.toStrinh());
			
		}
		catch(InputMismatchException e) {
			System.out.println("Erro inesperado: Não pode colocar letras ao inves de numeros.");	
		}
		catch(ExcecaoConta e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		
		
		
		sc.close();

	}

}
