package deal_input;

import java.util.Scanner;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/15/16.
 */
public class Haru {

    public static void main(String[] args) {
        Haru haru = new Haru();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\W+");
        haru.x = scanner.nextInt();
        haru.y = scanner.nextDouble();
        haru.z = scanner.nextFloat();
        haru.six = scanner.next();
        int i=1/0;
        System.out.println(haru.toString());
    }

    int x = 9;
    double y = 10;
    float z = 4;
    String six = "六神";

    @Override
    public String toString() {
        return "Haru{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", six='" + six + '\'' +
                '}';
    }
}
