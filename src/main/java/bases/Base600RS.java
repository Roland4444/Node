package bases;

import abstractions.base.Base;

public class Base600RS extends Base {
    public Base600RS(String Port) {
        super(Port);
        this.Command =  b600;
    }
}
