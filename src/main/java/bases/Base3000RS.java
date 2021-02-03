package bases;

import abstractions.BaseRS;
import jssc.SerialPortException;
import util.Trimmer;


public class Base3000RS extends BaseRS {
    public Base3000RS(String Port, String UUID){
        super(Port, UUID);
        this.boudrate = 9600;
        this.Command =  b3000;
    }

    @Override
    public String getWeight()  {
        String data = super.getWeight();
        if (data.length()>=10)
            return Trimmer.trimWeight(data);
        else
            return "errTrim";
    }


}
