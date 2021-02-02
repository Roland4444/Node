package bases;

import abstractions.Base;

public class Base600RS extends Base {
    public Base600RS(String Port) {
        super(Port);
        this.Command =  b600;
        this.boudrate =  4800;
    }
}
