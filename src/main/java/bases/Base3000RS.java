package bases;

import abstractions.Base;

public class Base3000RS extends Base {
    public Base3000RS(String Port) {
        super(Port);
        this.boudrate = 9600;
        this.Command =  b3000;
    }
}
