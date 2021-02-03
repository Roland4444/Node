package util;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class TrimmerTest {
    public String str = "ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg";
    @Test
    public void trimApply() {
        assertEquals("4.50", Trimmer.trimApply(str));
    }


    @Test
    public void hexToString() throws IOException {
        byte[] byteArray = Files.readAllBytes(Path.of("out600_0.bin"));
        String hex = new String(byteArray);
        System.out.println(hex + "->" + hex.substring(6,11));
        assertEquals("0.00",Trimmer.hexToString(hex));
    }
}