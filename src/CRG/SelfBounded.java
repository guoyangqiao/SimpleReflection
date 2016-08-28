package CRG;

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    public SelfBounded setElement(T element) {
        this.element = element;
        return this;
    }

    public T getElement() {
        return element;
    }

    void targetMethod() {
        System.out.println("dodo");
    }
}

class A extends SelfBounded<A> {
    @Override
    void targetMethod() {
        System.out.println("A dodo");
    }

    public static void main(String[] args) {
        A a = new A();
        a.targetMethod();
    }
}

class B extends SelfBounded<A> {
    public static void main(String[] args) {
        B b = new B();
        b.targetMethod();
    }
}