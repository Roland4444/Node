package util;

import java.io.Serializable;

public class Rec implements Serializable {
    public byte[] bytes;
    public  String str;
    public  String hex;
    public Rec(byte[] bytes, String str, String hex){
        this.bytes = bytes;
        this.hex = hex;
        this.str = str;
    }

}
