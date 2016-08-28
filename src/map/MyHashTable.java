package map;

import java.util.*;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/6/16.
 */
public class MyHashTable<K, V> implements Map<K, V> {
    private transient Entry<?, ?>[] table;

    private int capacity;

    private int threshold;

    private float loadFactor;

    private int size;

    public MyHashTable(int initSize, float loadFactor) {
        this.loadFactor = loadFactor;
        this.capacity = initSize;
        this.threshold = (int) (loadFactor * initSize);
        table = new Entry<?, ?>[initSize];
    }

    private static class Entry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V temp = this.value;
            this.value = value;
            return temp;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = key.hashCode() % table.length;
        for (Entry<K, V> entry = (Entry<K, V>) table[index]; entry != null; entry = entry.next) {
            if (entry.hash == key.hashCode() && key.equals(entry.key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Entry<?, ?>[] tab = table;
        for (Entry entry : tab) {
            for (Entry entryS = entry; entryS != null; entryS = entryS.next) {
                if (entryS.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int keyHash = key.hashCode();
        int index = keyHash % table.length;
        for (Entry<K, V> existsEntry = (Entry<K, V>) table[index]; existsEntry != null; existsEntry = existsEntry.next) {
            if (existsEntry.hash == keyHash && key.equals(existsEntry.key)) {
                return existsEntry.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int keyHash = key.hashCode();
        int index = keyHash % table.length;
        for (Entry<K, V> existsEntry = (Entry<K, V>) table[index]; existsEntry != null; existsEntry = existsEntry.next) {
            if (existsEntry.hash == keyHash && existsEntry.key.equals(key)) {
                V old = existsEntry.value;
                existsEntry.value = value;
                return old;
            }
        }
        addEntry(keyHash, key, value, index);
        return null;
    }

    @Override
    public V remove(Object key) {
        if (key == null) return null;
        int keyHash = key.hashCode();
        int index = keyHash % table.length;
        Entry<K, V> previous = null;
        for (Entry<K, V> current = (Entry<K, V>) table[index]; current != null; previous = current, current = current.next) {
            if (current.hash == keyHash && key.equals(current.key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                --size;
                V old = current.value;
                current.value = null;
                return old;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> single : m.entrySet()) {
            put(single.getKey(), single.getValue());
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        return new KeySet();
    }

    private class KeySet extends AbstractSet<K> {
        private int count = size;
        private int tableIndex;
        private Entry<K, V> nextEntry;

        @Override
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                @Override
                public boolean hasNext() {
                    return count > 0;
                }

                @Override
                public K next() {
                    if (nextEntry != null) {
                        --count;
                        K old = nextEntry.key;
                        nextEntry = nextEntry.next;
                        return old;
                    }
                    Entry<K, V> e = (Entry<K, V>) table[tableIndex++];
                    while (e == null) {
                        e = (Entry<K, V>) table[tableIndex++];
                    }
                    nextEntry = e.next;
                    --count;
                    return e.key;
                }
            };
        }

        @Override
        public int size() {
            return size;
        }
    }

    @Override
    public Collection<V> values() {
        return new ValueList();
    }

    private class ValueList extends AbstractSequentialList<V> {

        LinkedList<V> list;

        public ValueList() {
            this.list = new LinkedList<>();
            Set<K> ks = keySet();
            for (K k : ks) {
                list.add(MyHashTable.this.get(k));
            }
        }

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public ListIterator<V> listIterator(int index) {
            return new ListIterator<V>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public V next() {
                    return null;
                }

                @Override
                public boolean hasPrevious() {
                    return false;
                }

                @Override
                public V previous() {
                    return null;
                }

                @Override
                public int nextIndex() {
                    return 0;
                }

                @Override
                public int previousIndex() {
                    return 0;
                }

                @Override
                public void remove() {

                }

                @Override
                public void set(V v) {

                }

                @Override
                public void add(V v) {

                }
            };
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    private void addEntry(int keyHash, K key, V value, int index) {
        Entry<K, V> oldEntry = (Entry<K, V>) table[index];
        Entry<K, V> entry = new Entry<>(keyHash, key, value, oldEntry);
        table[index] = entry;
        ++size;
        if (size > threshold) {
            rehash();
        }
    }

    private void rehash() {
        int newCapacity = (capacity << 1) + 1;
        Entry<?, ?>[] old = table;
        threshold = (int) (newCapacity * loadFactor);
        table = new Entry<?, ?>[newCapacity];
        for (Entry tableEntry : old) {
            if (tableEntry != null) {
                int index = tableEntry.hash % table.length;
                table[index] = tableEntry;
            }
        }
    }

    public static void main(String[] args) {
        MyHashTable<MyString, Integer> tt = new MyHashTable<>(8, 0.75F);
        tt.put(new MyString("1"), 1);
        tt.put(new MyString("2"), 2);
        tt.put(new MyString("31"), 31);
        tt.put(new MyString("41"), 41);
        tt.put(new MyString("51"), 51);
        tt.put(new MyString("633"), 633);
        tt.put(new MyString("733"), 733);
        tt.put(new MyString("833"), 833);
        tt.put(new MyString("833"), 1111);
        System.out.println(tt.get(new MyString("833")));
        Set<MyString> myStrings = tt.keySet();
        for (MyString x : myStrings) {
            System.out.println(x);
        }
    }
}


class MyString {
    private String value;

    public MyString(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyString myString = (MyString) o;

        return value != null ? value.equals(myString.value) : myString.value == null;

    }

    @Override
    public int hashCode() {
        String[] split = value.split("");
        return value != null ? split.length : 0;
    }

    @Override
    public String toString() {
        return "MyString{" +
                "defaultValue='" + value + '\'' +
                '}';
    }
}
