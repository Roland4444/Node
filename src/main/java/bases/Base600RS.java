package bases;

import abstractions.BaseRS;
import jssc.SerialPortException;
import util.Trimmer;

import static util.Utils.isPause;
import static util.Utils.waiting;

public class Base600RS extends BaseRS {
    public Base600RS(String Port, String UUID) {
        super(Port, UUID);
        this.Command = b600;
        this.boudrate = 4800;
    }

    @Override
    public void run() {
        while (!isPause) {
            System.out.println("run600" + currentThread());
            try {
                if (serialPort.openPort())
                    serialPort.setParams(boudrate, 8, 1, 0);
            } catch (SerialPortException ignored) {
            }
            try {
                serialPort.writeByte(Command);
                super.weight = Trimmer.hexToString(serialPort.readHexString());
            } catch (SerialPortException e) {
                super.weight = e.getExceptionType();
            }
            waiting(2000);
        }
    }

}

