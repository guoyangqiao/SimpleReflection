package class_type_count;

import class_type_count.class_hierarchy.*;

import java.util.*;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/18/16.
 */
public class ClassCount {


    private Map<Class<?>, Integer> counter = new HashMap<>();

    private List<Class<?>> classBracer = new ArrayList<>();

    void countAppearance(Class<?> x) {
        counter.put(x, counter.get(x) == null ? 1 : counter.get(x) + 1);
        Class<?> superclass = x.getSuperclass();
        if (superclass != null) {
            countAppearance(superclass);
        }
    }

    void countApperanceList() {
        for (Class<?> xxx : classBracer) {
            countAppearance(xxx);
        }
    }

    void generateClasses() {
        List<Class<? extends Animal>> classes = Arrays.asList(Animal.class, BaiMao.class, BoSiMao.class, Cat.class, Dog.class, JinMao.class, SaMoYe.class);
        for (int i = 0; i < 3; i++) {
            classBracer.add(classes.get((int) (Math.random() * classes.size())));
        }
    }

    public static void main(String[] args) {
        ClassCount classCount = new ClassCount();
        classCount.generateClasses();
        Iterator<Class<?>> iterator = classCount.classBracer.iterator();
        while (iterator.hasNext()) {
            Class<?> next = iterator.next();
            System.out.println(next.getName());
        }
        System.out.println("-----------------");
        classCount.countApperanceList();
        Set<Map.Entry<Class<?>, Integer>> entries = classCount.counter.entrySet();
        for (Map.Entry<Class<?>, Integer> entry : entries) {
            System.out.println(entry.getKey().getSimpleName() + "=" + entry.getValue());
        }
    }
}

class X<T extends X<T>> {

}

class Y extends X {

}

class Z extends X<Z> {

}

class Zc extends X<Z> {

    public static void main(String[] args) {
        Integer[][] aa = new Integer[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        Arrays.fill(aa, new Integer(123));
        System.out.println(Arrays.deepToString(aa));
    }
}