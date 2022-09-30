package lrusystemdesignchannel;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {

    private Map<K, Node> lruStorage;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.lruStorage = new HashMap<>();
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
    }

    public V get(K key){
        if(lruStorage.containsKey(key)){
            //move it to the tail of the double linked list;
            return (V) lruStorage.get(key).value;
        }
        return null;
    }

    public void put(K key, V value){
        if(lruStorage.size() == capacity){
            deleteHeadOfTheList();
            Node newEntry = new Node(key, value);
            lruStorage.put(key, newEntry);
            // move newly added entry to the tail of the Doubly linked list
        }else{
            Node newEntry = new Node(key, value);
            lruStorage.put(key, newEntry);
            //addnewEntryToTail
        }
    }

    void deleteHeadOfTheList(){
        if(head == null){
            //throw exception;
        }
        if(head.next == null){
            head = null;
        }else{
            head = head.next;
        }
    }

    void detachNode(Node tempNode){
        if(tempNode.next == null && tempNode.prev == null){
            return ;
        }
        if(tempNode == tail){
            return;
        }
        if(tempNode == head){
            head.next.prev = null;
            head = head.next;
            return;
        }else{
            tempNode.next.prev = tempNode.prev;
            tempNode.prev.next = tempNode.next;
        }
    }

    void addNewEntryToTailOfList(Node tempNode){
        if(head == null && tail == null){
            head = tempNode;
            tail = tempNode;
            return;
        }

    }

}
