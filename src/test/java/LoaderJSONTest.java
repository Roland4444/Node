import abstractions.Base;
import bases.Base3000RS;
import bases.Base60RS;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LoaderJSONTest {

    @Test
    public void loadJSON() {
        String JSON = "";
        HashMap<String, Base> expected = new HashMap<>();
        Base60RS COM6 =  new Base60RS("COM6", "1");
        Base3000RS COM5 =  new Base3000RS("COM5", "2");

        expected.put("1", COM6);
        expected.put("2", COM5);

        JSON = "[{\"UUID\":1, \"Port\":\"COM6\"},{\"UUID\":2, \"Port\":\"COM5\"}]";

        assertEquals(expected,LoaderJSON.loadJSON(JSON));

    }
}