package control_framework;

import java.util.ArrayList;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/5/16.
 */
public class Controller {

    private ArrayList<Event<?>> eventArrayList = new ArrayList<>();

    public void add(Event event) {
        eventArrayList.add(event);
    }

    public void listen() {
        while (eventArrayList.size() > 0) {
            for (Event event : new ArrayList<Event>(eventArrayList)) {
                if (event.ready()) {
                    event.action();
                    eventArrayList.remove(event);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(23);
        integers.add(23213);
        integers.add(2312);
        integers.add(1);
//        double sum1 = integers.stream().filter(integer -> integer > 3).mapToDouble(Integer::doubleValue).sum();
//        System.out.println(sum1);
    }
}
