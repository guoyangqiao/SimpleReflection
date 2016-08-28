package generic_type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/9/16.
 */
public class MultiplyType {


    public static void main(String[] args) {
        ArrayList<snow> snows = new ArrayList<>();
        Collections.addAll(snows, new big(), new small(), new holly(), new hollyshit());

//        List<snow> snows1 = Arrays.asList(new hollyshit());
        List<snow> snows2 = Arrays.<snow>asList(new hollyshit());
    }

}

class snow {
}

class big extends snow {
}

class small extends snow {
}

class holly extends snow {
}

class hollyshit extends holly {
}
