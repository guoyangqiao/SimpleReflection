package 高级容器;

import java.util.LinkedHashMap;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 6/1/16.
 */
public class TestLinkedHashMap {


    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(16, 0.75F, true);
        map.put("1", "克赛尼克");
        map.put("2", "奥迪");
        map.put("3", "别克");
        map.put("4", "雪佛兰");
        map.put("5", "大众");
        map.put("6", "玛莎拉蒂");
        System.out.println(map.toString());
        map.get("3");
        System.out.println(map.toString());
        map.get("2");
        System.out.println(map.toString());
        map.get("5");
        System.out.println(map.toString());
        map.get("1");
        System.out.println(map.toString());
    }
}
