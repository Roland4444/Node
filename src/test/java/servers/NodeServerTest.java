package servers;

import org.junit.Test;
import util.Trimmer;

import static org.junit.Assert.*;

public class NodeServerTest {
    public String input = "ww000004.5kg";
    @Test
    public void parseWeight() {
        String weigth = "ww000004.5kg";
        assertNotEquals(null, NodeServer.parseWeight(weigth));
        System.out.println("OUT"+NodeServer.parseWeight(weigth));
    }

    @Test
    public void testParseWeight() {
    }

    @Test
    public void trimApply() {
        var trim2 = Trimmer.trimApply(input);
        assertEquals("4.50", trim2);
    }
}