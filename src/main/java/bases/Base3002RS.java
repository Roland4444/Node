package bases;

import abstractions.BaseRS;
import util.Trimmer;

public class Base3002RS extends BaseRS {
    public Base3002RS(String Port, String UUID) {
        super(Port, UUID);
        this.Command = b3000;
        this.boudrate = 9600;
    }

    @Override
    public String getWeight() {
        return Trimmer.parse3002(super.getWeight());
    }

}
