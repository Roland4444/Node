package bases;

import abstractions.Base;

public class Base60RS extends Base {
    public Base60RS(String Port) {
        super(Port);
        this.Command =  b60;
        this.boudrate = 9600;
    }
}
