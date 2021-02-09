package abstractions;

import jssc.SerialPort;
import jssc.SerialPortException;

import static util.Utils.*;

public class BaseRS extends Base {
    public SerialPort serialPort;
    public String weight;

    public BaseRS(String Port, String UUID) {
        super(Port, UUID);
        serialPort = new SerialPort(Port);
    }

    @Override
    public void run() {
        while (!isPause) {
            try {
                if (serialPort.openPort())
                    serialPort.setParams(boudrate, 8, 1, 0);
            } catch (SerialPortException ignored) {
            }
            try {
                serialPort.writeByte(Command);
                this.weight = serialPort.readString();
            } catch (SerialPortException e) {
                weight = e.getExceptionType();
            }
            waiting(2000);
        }

    }

    public String getWeight() {
        return this.weight;
    }

}
