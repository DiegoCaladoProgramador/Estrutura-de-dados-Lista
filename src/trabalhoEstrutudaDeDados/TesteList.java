package trabalhoEstrutudaDeDados;
import java.util.Scanner;
public class TesteList {
	public static void main(String[]args){
		Scanner leitor = new Scanner (System.in);
		ListaLetra lista = new ListaLetra();
		int op;
		do{
			System.out.println("--menu--");
			System.out.println("1-cadastrar novo contato");
			System.out.println("2-remover contato");
			System.out.println("3-exibir email e telefone do contato");
			System.out.println("4-alterar telefone/ou email do contato");
			System.out.println("5-exibir todos os contatos");
			System.out.println("6-exibir nomes começando pela letra");
			System.out.println("7-sair");
			op=leitor.nextInt();
			switch(op){
			case 1:
				System.out.println("digite o nome do contato que deseja cadastar");
				String nome = leitor.next();
				leitor.nextLine();
				lista.Cadastrar(nome);
				break;
			case 2:
				System.out.println("digite o contato a ser removido");
				nome =leitor.next();
				leitor.nextLine();
				lista.remover(nome);
				break;
			case 3:
				System.out.println("digite o contato que deseja buscar");
				nome =leitor.next();
				leitor.nextLine();
				lista.exibirEmailETelefone(nome);
				break;
			case 4:
				System.out.println("digite o nome do usúario que deseja alterar os dados");
				nome =leitor.next();
				leitor.nextLine();
				lista.alterarEmailEOuTelefone(nome);
				break;
			case 5:
				lista.exibirTodosContatos();
				break;
			case 6:
				System.out.println("digite a letra que deseja buscar");
				char letra = leitor.next().charAt(0);
				leitor.nextLine();
				lista.exibirNomeComLetra(letra);
				break;
			case 7:
				break;
			default:
				System.out.println("numero invalido");
			}
		}
		while(op!=7);
	}
}