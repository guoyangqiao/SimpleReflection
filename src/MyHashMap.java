import java.util.*;
/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/9/16.
 */
public class MyHashMap<K, V> implements Map<K, V> {

    private Object[][] keyValueDictionary = new Object[1024][2];
    private int dictionaryIndex = 0;
    private Deque<Integer> nullPositions = new LinkedList<>();

    private Set<K> keySet = new HashSet<>();

    @Override
    public int size() {
        return dictionaryIndex - nullPositions.size();
    }

    @Override
    public boolean isEmpty() {
        return (dictionaryIndex - nullPositions.size()) == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (Object[] single : keyValueDictionary) {
            if (single[1] == value) return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for (Object[] single : keyValueDictionary) {
            if ((K) (single[0]) == key)
                return (V) single[1];
        }
        return null;
    }

    @Override
    public synchronized V put(K key, V value) {
        boolean keyAdded = keySet.add(key);
        if (keyAdded) {
            if (!nullPositions.isEmpty() && nullPositions.size() > 0) {
                Integer peek = nullPositions.pollLast();
                keyValueDictionary[peek][0] = key;
                keyValueDictionary[peek][1] = value;
                return value;
            } else {
                keyValueDictionary[dictionaryIndex][0] = key;
                keyValueDictionary[dictionaryIndex][1] = value;
                dictionaryIndex += 1;
                return value;
            }
        } else {
            for (Object[] single : keyValueDictionary) {
                if (key == (K) single[0]) {
                    single[1] = value;
                    return value;
                }
            }
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        Object value;
        if (keySet.remove(key)) {
            for (int i = 0; i < keyValueDictionary.length; i++) {
                if (keyValueDictionary[i][0] == key) {
                    value = keyValueDictionary[i][1];
                    keyValueDictionary[i][0] = null;
                    keyValueDictionary[i][1] = null;
                    nullPositions.push(i);
                    return (V) value;
                }
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }


    public static void main(String[] args) {
        System.out.println(9% 0.32);
    }
}

