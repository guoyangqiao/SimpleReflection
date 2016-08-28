package ComplexModel;

import java.util.HashSet;
import java.util.Set;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/20/16.
 */
abstract class Space<T extends PlaceAble> {
    int height;
    int width;
    int length;

    public Space(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    abstract void init();

    private Set<T> things = new HashSet<>();

    abstract void placeAThing(T t);

}

abstract class PlaceAble {
    int height;
    int width;
    int length;
}

class GrassLand extends Space {

    public GrassLand(int height, int width) {
        super(height, width, Integer.MAX_VALUE);
        init();
    }

    @Override
    void init() {
        System.out.println("let the land covered with grass!");
    }

    @Override
    void placeAThing(PlaceAble placeAble) {
        System.out.println("place the " + placeAble.getClass().getSimpleName() + " in");
    }
}
