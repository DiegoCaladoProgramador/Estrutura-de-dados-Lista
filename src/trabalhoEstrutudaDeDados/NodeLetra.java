package trabalhoEstrutudaDeDados;

public class NodeLetra {
	private NodeLetra prev;
	private Letra info;
	private NodeLetra next;
	
	public NodeLetra (Letra value){
		info = value;
	}
	public NodeLetra getPrev() {
		return prev;
	}
	public void setPrev(NodeLetra prev) {
		this.prev = prev;
	}
	public Letra getLetra() {
		return info;
	}
	public void setLetra(Letra value) {
		this.info = value;
	}
	public NodeLetra getNext() {
		return next;
	}
	public void setNext(NodeLetra next) {
		this.next = next;
	}
}