/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/25/16.
 */
public class AudiA4L {
    static class kv {
        int num;
        String plat;

        public kv(int num, String plat) {
            this.num = num;
            this.plat = plat;
        }
    }

    public static void main(String[] args) {
        kv 淘宝 = new kv(1, "淘宝");
        kv 京东 = new kv(2, "京东");
        kv 一号店 = new kv(4, "一号店");
        kv 微店铺 = new kv(8, "微店铺");
        kv 拍拍 = new kv(16, "拍拍");
        kv 当当 = new kv(32, "当当");
        new kv(64, "当当");

    }
}
