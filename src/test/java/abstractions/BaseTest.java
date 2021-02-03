package abstractions;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseTest {

    @Test
    public void getWeight() {
        byte b3000 =0b1010;
        byte b600 = 0b00001010;
        assertEquals(b600, b3000);
    }
}