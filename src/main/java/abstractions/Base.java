package abstractions;

public abstract class Base {
    public final byte[] b3000 = {0b0010000};
    public final byte[] b600 = {0b01001010};
    public final byte[] b60 =  {0b00000000};
    public byte[] Command;
    public String PORT;
    public int boudrate=4800;
    public Base(String Port){
        this.PORT = Port;
    };
}
