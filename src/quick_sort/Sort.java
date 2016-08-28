package quick_sort;

import java.beans.beancontext.BeanContext;
import java.beans.beancontext.BeanContextServicesSupport;
import java.util.*;

public class Sort {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("asda");
        objects.add(12312);
        objects.add(new HashMap<>());
        objects.add(232.321F);
        objects.add(232.32D);
        objects.add(new HashMap<>());
        ListIterator<Object> iterator = objects.listIterator(3);
        if (iterator.hasNext()) {
//            System.out.println(iterator.next());
            System.out.println("-" + iterator.next() + "-" + iterator.nextIndex());
            System.out.println("-" + iterator.next() + "-" + iterator.nextIndex());
        }
        System.out.println(objects);


        Stack<Character> stack = new Stack<>();
        String programer = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        char[] chars = programer.toCharArray();
        for (int i = 0; i < chars.length; ) {
            if (chars[i] == '+') {
                stack.push(chars[++i]);
                i++;
            } else if (chars[i] == '-') {
                Character pop = stack.pop();
                System.out.println(pop);
                ++i;
            } else {
                stack.push(chars[i]);
            }
        }
        System.out.println(stack.toString());


        Set<String> a = new TreeSet<>();
        a.add("asda3");
        a.add("asda2");
        a.add("asda1");
        System.out.println(a.toString());
        a.add("asda4");
        System.out.println(a.toString());
        a.add("asda5");
        a.add("asda51");
        a.add("asda512");
        a.add("asda52");
        System.out.println(a.toString());
        for (String nx : a) {
            System.out.println(nx + " -- " + nx.hashCode());
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(12);
        queue.add(13);
        queue.add(133);
        queue.add(113);
        queue.add(4113);
        queue.add(413);
        queue.add(4123);
        System.out.println(queue);

//        System.out.println(queue.element());
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.remove());
        queue.offer(1231);
        System.out.println(queue);

        System.out.println((int) (' '));
        System.out.println((int) ('A'));


        String aaa = "aaahttp://c.tb.cn/";

        System.out.println(aaa.indexOf("http://c.tb.cn/"));

        BeanContext bc = new BeanContextServicesSupport();
        bc.add("adas");
        bc.add("123");
        bc.add(123131);
        for (Object x : bc) {
            System.out.println(x);
        }
    }
}