class LRUCache {

LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

int val = -1;// variable to store key value
int cap;

public LRUCache(int capacity) {
    cap = capacity;// initializing capacity as cap
}


public int get(int key) {
    
    if(map.containsKey(key))
    {
        val = map.get(key);// storing value of key
        map.remove(key);// if key found remove & enter key once again as it becomes MRU key
        map.put(key, val);
    }
    else val = -1;
    return val;
}

public void put(int key, int value) {
    if(!map.containsKey(key))
    {
        if(map.size() >= cap)// if size >= cap, remove 1st key & put new key into map
        {
            for(Map.Entry mapElement : map.entrySet())// removing 1st key(LRU) from map
            {
                map.remove((int)mapElement.getKey());
                break;
            }
        }
        map.put(key, value);// if !(size >= cap), simply put new key into map
    }
    else// if map already contains key then just update new value into key
    {
        map.remove(key);
        map.put(key, value);
    }
}
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */