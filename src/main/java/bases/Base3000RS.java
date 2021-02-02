package bases;

import abstractions.base.Base;

public class Base3000RS extends Base {
    public Base3000RS(String Port) {
        super(Port);
        this.Command =  b3000;
    }
}
