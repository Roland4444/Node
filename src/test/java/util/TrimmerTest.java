package util;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TrimmerTest {
    public String str = "ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg";
    public String s600 = "Ђ\u0005\u0015";
    @Test
    public void trimApply() {
        assertEquals("4.50", Trimmer.trimApply(str));
    }

    @Test
    public void parseWeight() throws IOException {
        System.out.println(Trimmer.parseWeight(s600));
    }
}