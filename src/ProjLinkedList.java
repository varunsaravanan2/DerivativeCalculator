public class ProjLinkedList<T> {
	private ProjNode<T> head;
    private int size;
	public ProjLinkedList() {
		this.head = null;
	}

	public void add(Object data) {
		ProjNode<T> newNode = new ProjNode(data);
		newNode.setNext(head);
		this.head = newNode;
	}

    public T getAt(int index) {
        ProjNode<T> current = head;
        int count = 0;
        T t = null;
        while (current != null) {
            if (count == index) {
                t = current.getData();
            }
            count++;
            current = current.getNext();
        }

        return t;
    }

    
}
