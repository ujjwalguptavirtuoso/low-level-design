package cachesystem.doublylinkedlist;

public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> prev;
    DoublyLinkedListNode<E> next;
    E element;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public DoublyLinkedListNode<E> getPrev() {
        return prev;
    }

    public DoublyLinkedListNode<E> getNext() {
        return next;
    }

    public E getElement() {
        return element;
    }
}
