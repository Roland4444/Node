package bases;

import abstractions.BaseRS;


public class Base3000RS extends BaseRS {
    public Base3000RS(String Port, String UUID){
        super(Port, UUID);
        this.boudrate = 9600;
        this.Command =  b3000;
    }


}
