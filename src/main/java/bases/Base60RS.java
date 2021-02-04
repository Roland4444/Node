package bases;

import abstractions.BaseRS;
import util.Trimmer;

public class Base60RS extends BaseRS {
    public Base60RS(String Port, String UUID) {
        super(Port, UUID);
        this.Command =  b60;
        this.boudrate = 9600;
    }

    @Override
    public String getWeight()  {
        return Trimmer.trimApply(Trimmer.parseWeight(super.getWeight()));
    }

}
