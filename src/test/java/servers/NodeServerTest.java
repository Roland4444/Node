package servers;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeServerTest {

    @Test
    public void parseWeight() {
        String weigth = "GS12kg";
        assertNotEquals(null, NodeServer.parseWeight(weigth));
        System.out.println("OUT"+NodeServer.parseWeight(weigth));
    }
}