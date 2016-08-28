package 高级容器;

import java.util.HashMap;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/1/16.
 */
public class Hashes {
    public static void main(String[] args) {
        HashMap<Key, Value> hashmap = new HashMap<>();
        hashmap.put(new Key(1), new Value("1"));
        hashmap.put(new Key(2), new Value("2"));
        hashmap.put(new Key(3), new Value("3"));
        hashmap.put(new Key(4), new Value("4"));
        hashmap.put(new Key(5), new Value("5"));
        hashmap.put(new Key(6), new Value("6"));
        System.out.println(hashmap);
        Key key = new Key(1);
        Value value = hashmap.get(key);
        System.out.println(value);
    }

    static class Key {
        private int key;

        public Key(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key + "";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key1 = (Key) o;

            return key == key1.key;

        }

        @Override
        public int hashCode() {
            return key;
        }
    }

    static class Value {
        private String value;

        public Value(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
