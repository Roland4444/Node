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
        /*try {
            if (serialPort.openPort()) {
                serialPort.setParams(boudrate, 8, 1, 0);
            }
        } catch (SerialPortException e) {
            System.out.println(e.getExceptionType());
        }
        try {
            serialPort.writeByte(Command);
            String data = serialPort.readString();
            if (data.length()>=10)
                return Trimmer.trimApply(serialPort.readString());
            else
                return "errTrim";
        } catch (SerialPortException e) {
            System.out.println(e.getExceptionType());
            return "errr";
        }*/
        String data = super.getWeight();
        if (data.length()>=10)
            return Trimmer.trimApply(data);
        else
            return "errTrim";
    }


}
