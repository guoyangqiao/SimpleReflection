package super_man;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/21/16.
 */
interface SuperPower {
}

interface SuperHearing extends SuperPower {
    void hear();
}

interface SuperSpeaking extends SuperPower {
    void speak();
}

class SuperMan<POWER extends SuperPower> {
    POWER power;

    public SuperMan(POWER power) {
        this.power = power;
    }

    public POWER getPower() {
        return power;
    }
}

class HearingHero<POWER extends SuperHearing> extends SuperMan<POWER> {

    public HearingHero(POWER power) {
        super(power);
    }

    void hear() {
        power.hear();
    }
}