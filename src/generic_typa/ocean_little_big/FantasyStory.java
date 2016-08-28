package generic_typa.ocean_little_big;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/20/16.
 */

interface Generator<T> {

    T next();
}

class Ocean {
    public static void main(String[] args) {
        List<SmallFish> smallFishes = new ArrayList<>();
        Generators.fill(smallFishes, SmallFish.getSmallFishGenerator(), 10);
        List<BigFish> bigFishes = new ArrayList<>();
        Generators.fill(bigFishes, BigFish.getBigFishGenerator(), 2);
        for (SmallFish s : smallFishes) {
            Number random = Math.random() * 2;
            BigFish bigFish = bigFishes.get(random.intValue());
            System.out.println("big fish: " + bigFish.getId() + " eat small fish: " + s.getId());
        }
    }
}

class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> klass, int num) {
        for (int i = 0; i < num; i++) {
            coll.add(klass.next());
        }
        return coll;
    }
}

class BigFish {
    public int getId() {
        return id;
    }

    private static int counter = 0;

    private final int id = counter++;

    public static Generator<BigFish> getBigFishGenerator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}

class SmallFish {
    public int getId() {
        return id;
    }

    private static int counter = 0;

    private final int id = counter++;

    public static Generator<SmallFish> getSmallFishGenerator() {
        return new Generator<SmallFish>() {
            @Override
            public SmallFish next() {
                return new SmallFish();
            }
        };
    }

}