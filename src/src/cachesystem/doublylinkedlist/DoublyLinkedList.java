package cachesystem.doublylinkedlist;

public class DoublyLinkedList <E>{

    DoublyLinkedListNode<E> first;
    DoublyLinkedListNode<E> last;

    public DoublyLinkedList(){
        this.first = null;
        this.last = null;
    }

    public void detachNode(DoublyLinkedListNode node){
        if(node == null){
            return;
        }
        if(node.equals(first)){
            first = first.next;
            if(first!=null){
                first.prev = null;
            }
        }else if(node.equals(last)){
            last = last.prev;
            if(last != null){
                last.next = null;
            }
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode node){
        if(last == null){
            first = node;
            last = node;
        }else{
            node.prev = last;
            last.next = node;
            node.next = null;
            last = node;
        }
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element){
        DoublyLinkedListNode node = new DoublyLinkedListNode<>(element);
        addNodeAtLast(node);
        return node;
    }

    public DoublyLinkedListNode getFirst(){
        return first;
    }
}
