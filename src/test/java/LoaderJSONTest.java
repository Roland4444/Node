import abstractions.Base;
import bases.Base3000RS;
import bases.Base60RS;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LoaderJSONTest {
    public HashMap<String, Base> expected = new HashMap<>();
    public Base60RS COM6 =  new Base60RS("COM6", "1");
    public Base3000RS COM5 =  new Base3000RS("COM5", "2");
    public String JSON =
                """
                [{"UUID":"1", "Port":"COM6", "Type":"Base60RS"},{"UUID":"2", "Port":"COM5", "Type":"Base3000RS"}]

                """;

    public String entry = """
{"UUID":"1", "Port":"COM6", "Type":"Base60RS"}
""";

    public LoaderJSONTest(){
        expected.put("1", COM6);
        expected.put("2", COM5);
    }
    @Test
    public void loadJSON() throws ParseException {
        assertEquals(expected.size(),LoaderJSON.loadJSON(JSON).size());

    }

    @Test
    public void jsTest() throws ParseException {
        System.out.println(JSON);
        assertNotEquals(null, LoaderJSON.js(JSON));
    }

    @Test
    public void genTest() throws ParseException {
        var js = new JSONParser().parse(entry);
        assertNotEquals(null, LoaderJSON.gen((JSONObject) js));
    }
}