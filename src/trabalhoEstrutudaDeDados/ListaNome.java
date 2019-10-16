package trabalhoEstrutudaDeDados;
import java.util.Scanner;
public class ListaNome {
	private NodeNome first;
	private NodeNome last;
	private int qtd;
	public Boolean isEmpty(){
		if(qtd == 0){
			return true;
		}
		return false;
	}
	public NodeNome buscaMelhorada(String nome){
		NodeNome aux = first;
		if(isEmpty()==true){
			return null;
		}
		else if(nome.compareToIgnoreCase(last.getInfo().getNome())>0){
			return null;
		}
		else{
			while(aux!=null){
				if(nome.compareToIgnoreCase(aux.getInfo().getNome())==0){
					return aux;
				}
				else if(aux.getInfo().getNome().compareToIgnoreCase(nome)>0){
					return null;
				}
				else{
					aux = aux.getNext();
				}
			}
		}
		return null;
	}
	public void inserirOrdenado(String nome){
		Contato contato;
		Scanner leitor = new Scanner (System.in);
		NodeNome aux,novo,anterior;
		if(isEmpty()==true){
			contato = new Contato(nome);
			novo= new NodeNome(contato);
			inserir(contato);
			first = novo;
			last = novo;
			qtd = 1;
		}
		else if(nome.compareToIgnoreCase(first.getInfo().getNome())==0){
			System.out.println("nome ja cadastrado");
		}else if(nome.compareToIgnoreCase(first.getInfo().getNome())<0){
			contato = new Contato(nome);
			novo = new NodeNome(contato);
			inserir(contato);
			first.setPrev(novo);
			novo.setNext(first);
			first = novo;
			qtd++;
		}
		else if(nome.compareToIgnoreCase(last.getInfo().getNome())==0){
			System.out.println("nome ja cadastrado");
		}
		else if(nome.compareToIgnoreCase(last.getInfo().getNome())>0){
			contato = new Contato(nome);
			novo = new NodeNome(contato);
			inserir(contato);
			last.setNext(novo);
			novo.setPrev(last);
			last=novo;
			qtd++;
		}
		else{
			aux=first.getNext();
			while(aux!=null){
				if(aux.getInfo().getNome().compareToIgnoreCase(nome)==0){
					System.out.println("nome já cadastrado");
				}
				else if(aux.getInfo().getNome().compareToIgnoreCase(nome)>0){
					contato = new Contato(nome);
					novo = new NodeNome(contato);
					inserir(contato);
					anterior = aux.getPrev();
					anterior.setNext(novo);
					novo.setPrev(anterior);
					aux.setPrev(anterior);
					novo.setNext(aux);
					qtd++;
				}
				else{
					aux= aux.getNext();
				}
			}
		}		
	}
	public void inserir(Contato contato){
		Scanner leitor = new Scanner (System.in);
		System.out.println("digite o email do usuario a ser cadastrado");
		String email = leitor.next();
		leitor.nextLine();
		contato.setEmail(email);
		System.out.println("digite o telefone do usuario a ser cadastrado");
		String telefone = leitor.next();
		leitor.nextLine();
		contato.setTelefone(telefone);
	}
	public void remover(String nome){
		NodeNome aux,atual,anterior,proximo;
		atual = buscaMelhorada(nome);
		if(atual==null){
			System.out.println("nome não encontrado");
		}
		else if(nome.compareToIgnoreCase(first.getInfo().getNome())==0){
			removerPrimeiro();
		}
		else if(nome.compareToIgnoreCase(last.getInfo().getNome())==0){
			removerUltimo();
		}
		else{
			aux=first.getNext();
			while(aux!=null){
				if(aux == atual){
					anterior=atual.getPrev();
					proximo=atual.getNext();
					anterior.setNext(proximo);
					proximo.setPrev(anterior);
					qtd--;
				}
				aux=aux.getNext();
			}
		}
	}
	public void removerPrimeiro(){
		if(qtd == 1){
			first = null;
			last=null;
			qtd = 0;
		}
		else{
			first=first.getNext();
			first.setPrev(null);
			qtd--;
		}
	}
	public void removerUltimo(){
		if(qtd == 1){
			first=null;
			last=null;
			qtd=0;
		}else{
			NodeNome aux = first;
			while(aux.getNext()!= last){
				aux=aux.getNext();
			}
			NodeNome prox = aux.getNext();
			prox.setPrev(null);
			aux.setNext(null);
		}
	}
	public void exibirEmailETelefone(String nome){
		NodeNome aux = buscaMelhorada(nome);
		if(aux == null){
			System.out.println("nome não encontrado");
		}else{
			System.out.println("email: "+aux.getInfo().getEmail()+" Telefone: "+aux.getInfo().getTelefone());
		}
	}
	public void alterarEmailEOuTelefone(String nome){
		Scanner leitor = new Scanner(System.in);
		NodeNome aux = buscaMelhorada(nome);
		if(aux == null){
			System.out.println("nome não encontrado");
		}else{
			int op;
			do{
				System.out.println("o que voce deseja alterar?");
				System.out.println("1-email");
				System.out.println("2-telefone");
				System.out.println("3-os dois");
				op = leitor.nextInt();
				if(op==1){
					System.out.println("digite o novo e-mail");
					String email = leitor.next();
					leitor.nextLine();
					aux.getInfo().setEmail(email);
				}
				else if(op == 2){
					System.out.println("digite o novo telefone");
					String telefone = leitor.next();
					leitor.nextLine();
					aux.getInfo().setTelefone(telefone);
				}else if(op==3){
					System.out.println("digite o novo e-mail");
					String email = leitor.next();
					leitor.nextLine();
					aux.getInfo().setEmail(email);
					System.out.println("digite o novo telefone");
					String telefone = leitor.next();
					leitor.nextLine();
					aux.getInfo().setTelefone(telefone);
				}
			}while(op < 1 || op > 3);		
		}
	}
	public void exibirTodosContatosL(){
		System.out.println("exibindo2");
		NodeNome aux = first;
		while (aux != null){
			System.out.println(aux.getInfo());
			aux=aux.getNext();
		}
	}
}