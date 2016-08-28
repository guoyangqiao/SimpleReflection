/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/21/16.
 */
public class ABC extends kuakua implements kaka {
    @Override
    public void kak() {
        System.out.println("abc kak");
    }

    public static void main(String[] args) {
        new ABC().kak();
    }
}

interface kaka {
    void kak();
}

class kuakua {
    void kak() {
        System.out.println("kuakua kak");
    }
}
