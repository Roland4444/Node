package bases;
import abstractions.BaseRS;
import jssc.SerialPortException;
import util.Trimmer;
public class Base600RS extends BaseRS {
    public Base600RS(String Port, String UUID) {
        super(Port, UUID);
        this.Command =  b600;
        this.boudrate =  4800;
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
        return Trimmer.hexToString(hex);
    }


}
