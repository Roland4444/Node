package bases;

import abstractions.BaseRS;
import jssc.SerialPortException;

public class Base3002RS extends BaseRS {
    public Base3002RS(String Port, String UUID) {
        super(Port, UUID);
        this.Command =  b3000;
        this.boudrate =  9600;
    }
    @Override
    public String getWeight()  {
        String hex;
        try {
            if (serialPort.openPort()) {
                serialPort.setParams(boudrate, 8, 1, 0);
            }
        } catch (SerialPortException e) {
            System.out.println(e.getExceptionType());
        }
        try {
            serialPort.writeByte(Command);
            hex = serialPort.readHexString();
        } catch (SerialPortException e) {
            System.out.println(e.getExceptionType());
            return "err";
        }
        return hex;
    }

}
