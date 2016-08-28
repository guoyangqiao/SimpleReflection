package 隐式泛型;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/7/16.
 */
public class KKKK {
    public static void main(String[] args) {
        Context<Service> serviceContext = new Context<>();
        CollectionUtil.fillCollection(serviceContext, new Service(null), 10);
    }
}

class Context<T> implements Addable<T> {

    List<T> x = new ArrayList<>();

    @Override
    public void add(T t) {
        this.x.add(t);
    }
}


class Service implements Geneable<Service> {
    private Date x;

    public Service(Date x) {
        this.x = x;
    }


    public Date getX() {
        return x;
    }

    @Override
    public Service next() {
        return new Service(new Date());
    }
}

interface Geneable<T> {
    T next();
}


interface Addable<T> {
    void add(T t);
}

class CollectionUtil {
    static <T> void fillCollection(Addable<T> context, Geneable<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            context.add(generator.next());
        }
    }
}