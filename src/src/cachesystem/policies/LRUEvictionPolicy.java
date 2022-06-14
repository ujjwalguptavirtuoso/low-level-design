package cachesystem.policies;

import cachesystem.doublylinkedlist.DoublyLinkedList;
import cachesystem.doublylinkedlist.DoublyLinkedListNode;

import java.util.HashMap;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    private DoublyLinkedList doublyLinkedList;
    private HashMap<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy(DoublyLinkedList doublyLinkedList, HashMap<Key, DoublyLinkedListNode<Key>> mapper) {
        this.doublyLinkedList = doublyLinkedList;
        this.mapper = new HashMap();
    }

    @Override
    public void keyAccessed(Key key) {
       if(mapper.containsKey(key)){
          doublyLinkedList.detachNode(mapper.get(key));
          doublyLinkedList.addNodeAtLast(mapper.get(key));
       }else{
           DoublyLinkedListNode<Key> newNode = doublyLinkedList.addElementAtLast(key);
           mapper.put(key, newNode);
       }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> first = doublyLinkedList.getFirst();
        if(first == null){
            return null;
        }
        doublyLinkedList.detachNode(first);
        return first.getElement();
    }
}
