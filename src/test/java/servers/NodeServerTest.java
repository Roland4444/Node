package servers;

import org.junit.Test;
import util.Trimmer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    @Test
    public void parse600() throws IOException {
        byte[] byteArray = Files.readAllBytes(Path.of("out.bin"));
        String hex = new String(byteArray);
        System.out.println(hex);
        //String res = NodeServer.parseWeight600(hex);

        //assertEquals(hex, res);
        //assertEquals("0.00", res);
    }
}