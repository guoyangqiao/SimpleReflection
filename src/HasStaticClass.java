/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/1/16.
 */
public interface HasStaticClass {

    void shout();

    class In implements HasStaticClass {

        @Override
        public void shout() {
            System.out.println("shout");
        }

        static void shutdown(HasStaticClass hasStaticClass) {
            System.out.println("shutDown");
            hasStaticClass.shout();
        }

        public static void main(String[] args) {
            HasStaticClass hi = new HasStaticClass() {

                @Override
                public void shout() {
                    System.out.println("hababa");
                }
            };
            hi.shout();
        }
    }
}
