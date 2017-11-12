
//
public class DLNode<T> {
		private T data;
		private DLNode<T> next;
		private DLNode<T> previous;

		public DLNode(T data, DLNode<T> nextNode) {
			this.data = data;
			next = nextNode;
		}

		public DLNode(T data) {
			this.data = data;
			this.next = null;
		}

		public void setData(T data) {
			this.data = data;
		}
		
		public T getData() {
			return data;
		}

		public DLNode<T> getNextNode() {
			return next;
		}

		public void setNext(DLNode<T> node) {
			next = node;
		}
		
		
		public void setPreviousNode(DLNode<T> node) {
				previous = node;
		}
		public DLNode<T> getPreviousNode(){
			return previous;
		}
		
	}