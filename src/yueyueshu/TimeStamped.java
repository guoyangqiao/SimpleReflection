package yueyueshu;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/29/16.
 */
public interface TimeStamped {
    Long getTimestamp();
}

class TimeStampedImp implements TimeStamped {
    private Long timestamp;

    @Override
    public Long getTimestamp() {
        return timestamp;
    }

    public TimeStampedImp() {
        timestamp = System.currentTimeMillis();
    }
}

interface Serinumber {
    Long getSerinumber();
}

class SerinumberImpl implements Serinumber {

    private static long counter = 0;

    @Override
    public Long getSerinumber() {
        return ++counter;
    }
}

interface Base {
    String getValue();

    void setValue(String value);
}

class BaseImp implements Base {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class Mix implements Base, Serinumber, TimeStamped {
    private Base baseImp = new BaseImp();
    private Serinumber serinumber = new SerinumberImpl();
    private TimeStamped timeStampedImp = new TimeStampedImp();

    @Override
    public String getValue() {
        return baseImp.getValue();
    }

    @Override
    public void setValue(String value) {
        baseImp.setValue(value);
    }

    @Override
    public Long getSerinumber() {
        return serinumber.getSerinumber();
    }

    @Override
    public Long getTimestamp() {
        return timeStampedImp.getTimestamp();
    }
}