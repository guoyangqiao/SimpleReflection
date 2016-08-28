package generic_typa;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/19/16.
 */
public class LinkedStack<T> {
    private static class Node<I> {
        private I item;
        private Node<I> next;

        private Node(I item, Node<I> next) {
            this.item = item;
            this.next = next;
        }

        private Node() {
            item = null;
            next = null;
        }

        private boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();

    public void push(T t) {
        top = new Node<>(t, top);
    }

    public T pop() {
        if (top.end()) return null;
        T item = top.item;
        top = top.next;
        return item;
    }

    public static void main(String[] args) {
        LinkedStack<Number> ls = new LinkedStack<>();
        ls.push(3);
        ls.push(3.1);
        ls.push(3.14);
        ls.push(3.141);
        ls.push(3.1315);
        ls.push(3.14159);
        ls.push(3.141592);
        ls.push(3.1415926);
        for (int i = 0; i < 10; i++) {
            System.out.println(ls.pop());
        }

    }
}
