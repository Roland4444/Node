package bases;

import abstractions.BaseRS;
import util.Trimmer;

public class Base3000RS extends BaseRS {
    public Base3000RS(String Port, String UUID) {
        super(Port, UUID);
        this.boudrate = 9600;
        this.Command = b3000;
    }

    @Override
    public String getWeight() {
        return Trimmer.trimWeight(super.getWeight());
    }

}
