public class ProjNode<T> {
	private T data;
	private ProjNode<T> next;


	public T getData() {
		return data;
	}
	public ProjNode<T> getNext() {
		return next;
	}
	public void setNext(ProjNode<T> next) {
		this.next = next;
	}

	public ProjNode(T data) {
		this.data = data;
		this.next = null;
	}

	public boolean equals(ProjNode<T> node) {
		return this.data.equals(node.data);
	}

	public String toString() {
		return data.toString();
	}



}
