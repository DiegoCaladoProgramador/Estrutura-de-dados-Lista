package trabalhoEstrutudaDeDados;

public class NodeNome {
	private NodeNome prev;
	private Contato info;
	private NodeNome next;
	public NodeNome (Contato value){
		info = value;
	}
	public NodeNome getPrev() {
		return prev;
	}
	public void setPrev(NodeNome prev) {
		this.prev = prev;
	}
	public Contato getInfo() {
		return info;
	}
	public void setInfo(Contato info) {
		this.info = info;
	}
	public NodeNome getNext() {
		return next;
	}
	public void setNext(NodeNome next) {
		this.next = next;
	}
}