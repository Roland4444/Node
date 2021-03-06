package util;

import org.junit.Test;
import java.io.FileOutputStream;
import java.io.IOException;


public class HTTPClientTest {
    String fn = "out.bin";
    String fn2 = "out.text";
    String magicfile ="magic.bin";
    String url ="http://192.168.22.3:4567/get-weight?scaleId=4";
    String magic ="http://192.168.22.3:4567/hole?scaleId=4";
    String magicstr ="magicstr.txt";
    String magichex ="magichex.txt";
    String magicbin ="magic.bin";

  //  @Test
    public void getGETResponcebinary() throws IOException, InterruptedException {
        var fos = new FileOutputStream(fn);
        fos.write(HTTPClient.getGETResponcebinary(url));
        fos.close();
    }

   // @Test
    public void getGETResponcebinary2() throws IOException, InterruptedException {
        var fos = new FileOutputStream(fn2);
        fos.write(HTTPClient.getGETResponceString(url).getBytes());
        fos.close();
    }




}