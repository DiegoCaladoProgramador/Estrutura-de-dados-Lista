package trabalhoEstrutudaDeDados;

public class ListaLetra {
	private NodeLetra first;
	private NodeLetra last;
	private int qtd;
	public boolean isEmpty(){
		if (qtd == 0){
			return true;
		}else{
			return false;
		}
	}
	public NodeLetra buscaMelhorada (char letra){
		NodeLetra aux = first;
		if(isEmpty()==true){
			System.out.println("lista vazia");
			return null;
		}
		else if(letra > last.getLetra().getInfo()){
			return null;
		}
		else{
			while (aux!= null){
				if(aux.getLetra().getInfo()==letra){
					return aux;
				}
				else if(aux.getLetra().getInfo()>letra){
					return null;
				}
				else{
					aux= aux.getNext();
				}
			}
		}
		return null;
	}
	
	public void Cadastrar (String nome){
		
		NodeLetra aux,novo,anterior;
		if(isEmpty()==true){
			Letra nova = new Letra(nome.charAt(0));
			novo = new NodeLetra(nova);
			ListaNome lista = novo.getLetra().getLista();
			lista.inserirOrdenado(nome);
			first = novo;
			last = novo;
			qtd = 1;
		}
		else if(nome.charAt(0)==first.getLetra().getInfo()){
			ListaNome lista = first.getLetra().getLista();
			lista.inserirOrdenado(nome);
		}
		else if(nome.charAt(0) < first.getLetra().getInfo()){
			Letra nova = new Letra(nome.charAt(0));
			novo = new NodeLetra(nova);
			ListaNome lista = novo.getLetra().getLista();
			lista.inserirOrdenado(nome);
			lista.inserirOrdenado(nome);
			first.setPrev(novo);
			novo.setNext(first);
			first=novo;
			qtd++;
		}
		else if(nome.charAt(0) == last.getLetra().getInfo()){
			ListaNome lista =last.getLetra().getLista();
			lista.inserirOrdenado(nome);
		}
		else if(nome.charAt(0) > last.getLetra().getInfo()){
			Letra nova = new Letra(nome.charAt(0));
			novo = new NodeLetra(nova);
			ListaNome lista = novo.getLetra().getLista();
			lista.inserirOrdenado(nome);
			lista.inserirOrdenado(nome);
			last.setNext(novo);
			novo.setPrev(last);
			last = novo;
			qtd++;
		}
		else{
			aux = first.getNext();
			while(aux != null){
				if(aux.getLetra().getInfo()==nome.charAt(0)){
					ListaNome lista = aux.getLetra().getLista();
					lista.inserirOrdenado(nome);
				}
				else if(aux.getLetra().getInfo() > nome.charAt(0)){
					Letra nova = new Letra(nome.charAt(0));
					novo = new NodeLetra(nova);
					ListaNome lista = novo.getLetra().getLista();
					lista.inserirOrdenado(nome);
					lista.inserirOrdenado(nome);
					anterior = aux.getPrev();
					anterior.setNext(novo);
					novo.setPrev(anterior);
					aux.setPrev(novo);
					novo.setNext(aux);
					qtd++;
					return;
				}
				else{
					aux=aux.getNext();
				}
			}
		}
	}
	public void remover(String nome){
		NodeLetra aux,atual,anterior,proximo;
		if(isEmpty()==true){
			System.out.println("lista vazia");
		}else{
			atual=buscaMelhorada(nome.charAt(0));
			if(atual==null){
				System.out.println("nome não encontrado");
			}else{
				atual.getLetra().getLista().remover(nome);
				if(atual.getLetra().getLista().isEmpty()==true){
					if(atual == first){
						removerPrimeiro();
					}
					else if(atual == last){
						removerUltimo();
					}else{
						aux=first.getNext();
						while(aux!=null){
							if(aux == atual){
								System.out.println("ae");
								anterior = atual.getPrev();
								System.out.println(anterior);
								proximo = atual.getNext();
								anterior.setNext(proximo);
								proximo.setPrev(anterior);
								atual.setNext(null);
								atual.setPrev(null);
								qtd --;
								return;
							}
							aux=aux.getNext();
						}
					}
				}
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
			NodeLetra aux = first;
			while(aux.getNext()!= last){
				aux=aux.getNext();
			}
			NodeLetra prox = aux.getNext();
			prox.setPrev(null);
			aux.setNext(null);
			qtd--;
		}
	}
	public void exibirEmailETelefone(String nome){
		if(isEmpty()==true){
			System.out.println("lista vazia");
		}else{
			NodeLetra aux = buscaMelhorada(nome.charAt(0));
			if(aux == null){
				System.out.println("nome não encontrado");
			}else{
				aux.getLetra().getLista().exibirEmailETelefone(nome);
			}
		}
	}
	public void alterarEmailEOuTelefone(String nome){
		if(isEmpty()==true){
			System.out.println("lista vazia");
		}else{
			NodeLetra aux = buscaMelhorada(nome.charAt(0));
			if(aux==null){
				System.out.println("nome não encontrado");
			}else{
				aux.getLetra().getLista().alterarEmailEOuTelefone(nome);
			}
		}
	}
	public void exibirTodosContatos(){
		System.out.println("exibindo");
		if(isEmpty()==true){
			System.out.println("lista vazia");
		}else{
			NodeLetra aux = first;
			while (aux != null){
				aux.getLetra().getLista().exibirTodosContatosL();
				aux=aux.getNext();
			}
		}
	}
	public void exibirNomeComLetra(char letra){
		if(isEmpty()==true){
			System.out.println("lista vazia");
		}else{
			NodeLetra aux = buscaMelhorada(letra);
			if(aux==null){
				System.out.println("letra não encontrada");
			}
			else{
				aux.getLetra().getLista().exibirTodosContatosL();
			}
		}
	}
}