package trabalhoEstrutudaDeDados;
public class Letra {
	private char info;
	private ListaNome lista;
	public Letra (char value){
		info = value;
		lista = new ListaNome();
	}
	public char getInfo() {
		return info;
	}
	public void setInfo(char info) {
		this.info = info;
	}
	public ListaNome getLista() {
		return lista;
	}
	public void setLista(ListaNome lista) {
		this.lista = lista;
	}
}
