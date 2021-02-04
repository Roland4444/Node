package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class SaverTest {
    public Rec test = new Rec(new byte[]{(byte)0x00}, "STR", "HEX");
    @Test
    public void savedToBLOB() {
        byte[] save = Saver.savedToBLOB(test);
        Rec restored = (Rec) Saver.restored(save);
        assertEquals(test.str(), restored.str());
        System.out.println(restored.hex()+"::"+restored.str());
    }
}