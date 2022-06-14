package cachesystem;

import cachesystem.Storage.Storage;
import cachesystem.exceptions.StorageFullException;
import cachesystem.policies.EvictionPolicy;

public class Cache <Key, Value>{

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value){
        try{
              this.storage.add(key, value);
              this.evictionPolicy.keyAccessed(key);
        }catch(StorageFullException e){
            System.out.println("Storage full, will try to evict");
            Key keyToRemove = evictionPolicy.evictKey();
            if(keyToRemove == null){
                // throw some exception;
            }
            this.storage.remove(keyToRemove);
            put(key, value);
        }
    }

    public Value get(Key key){
         Value value =  this.storage.get(key);
         if(value == null){
             System.out.println(" key not found in cache");
         }else{
             this.evictionPolicy.keyAccessed(key);
         }
         return value;
    }
}
