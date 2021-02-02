package bases;

import abstractions.Base;
import abstractions.BaseRS;

public class Base600RS extends BaseRS {
    public Base600RS(String Port, String UUID) {
        super(Port, UUID);
        this.Command =  b600;
        this.boudrate =  4800;
    }


}
