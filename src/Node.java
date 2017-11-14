
//
public class Node<T extends Comparable<T>> implements Comparable<Node <T>> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> nextNode) {
			this.data = data;
			next = nextNode;
		}

		public Node(T data) {
			this.data = data;
			this.next = null;
		}

		public T getData() {
			return data;
		}

		public Node<T> getNextNode() {
			return next;
		}

		public void setNext(Node<T> node) {
			next = node;
		}
		
		public int compareTo(Node<T> key) {
			return data.compareTo(key.data);
		}
		public void setData(T data) {
			this.data = data;
		}

		
		
		
	}
