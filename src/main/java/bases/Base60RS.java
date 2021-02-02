package bases;

import abstractions.Base;
import abstractions.BaseRS;

public class Base60RS extends BaseRS {
    public Base60RS(String Port, String UUID) {
        super(Port, UUID);
        this.Command =  b60;
        this.boudrate = 9600;
    }


}
