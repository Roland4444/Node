package util;


import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class HTTPClientTest {
    String fn = "out.bin";
    String url ="http://192.168.33.2:4567/get-weight?scaleId=3";
    @Test
    public void getGETResponcebinary() throws IOException, InterruptedException {
        var fos = new FileOutputStream(fn);
        fos.write(HTTPClient.getGETResponcebinary(url));
        fos.close();
    }
}