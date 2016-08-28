package control_framework;

import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/5/16.
 */
public class AEvent extends Event<CacheRequest> {
    protected AEvent(long delay) {
        super(delay);
    }

    @Override
    public CacheRequest action(Object... params) {
        Class<? extends Object[]> aClass = params.getClass();
        String name = aClass.getName();
        System.out.println(name);
        return new CacheRequest() {
            @Override
            public OutputStream getBody() throws IOException {
                return new OutputStream() {
                    @Override
                    public void write(int b) throws IOException {

                    }
                };
            }

            @Override
            public void abort() {

            }
        };
    }
}
