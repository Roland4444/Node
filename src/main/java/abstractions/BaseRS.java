package abstractions;
import jssc.SerialPort;
import jssc.SerialPortException;

public class BaseRS extends Base{

    public SerialPort serialPort;
    public BaseRS(String Port, String UUID){
        super(Port, UUID);
        serialPort = new SerialPort(Port);
    }

    public String getWeight()  {
        try {
            if (serialPort.openPort()) {
                serialPort.setParams(boudrate, 8, 1, 0);
            }
        } catch (SerialPortException e) {
            System.out.println(e.getExceptionType());
        }
        try {
            serialPort.writeByte(Command);
            return serialPort.readString();
        } catch (SerialPortException e) {
            System.out.println(e.getExceptionType());
            return "ReadErr";
        }
    }

}
