package klass;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/19/16.
 */
public class ViolateAccess {
    public void publicMethod() {
        System.out.println("publicMethod");
    }

    void packageMethod() {
        System.out.println("packageMethod");
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

}

