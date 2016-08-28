import java.util.HashMap;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 3/31/16.
 */
public class InnerClassWithConstructor {

    public HashMap<String, Object> getInitHashMap(String key, String value) {
        return new HashMap<String, Object>() {
            //constructor begin
            {
                put(key, value);
            }
            //constructor end
        };
    }

    public static void main(String[] args) {
        InnerClassWithConstructor da = new InnerClassWithConstructor();
        HashMap<String, Object> initHashMap = da.getInitHashMap("key", "defaultValue");
        System.out.println(initHashMap.get("key"));
    }
}
