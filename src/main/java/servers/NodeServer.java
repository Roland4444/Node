package servers;

import abstractions.Base;
import abstractions.Node;
import bases.Base3000RS;
import bases.Base60RS;
import org.json.simple.parser.ParseException;
import util.LoaderJSON;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static spark.Spark.get;
public class NodeServer {
    private static String mockWeight = "0.00";

    public static void main(String [] args) throws IOException, ParseException {

        Node currentNode = new Node();
        ///currentNode.bases = scales.scalesAZKK;
        currentNode.bases = LoaderJSON.loadJSON(new String(Files.readAllBytes(Path.of("config.json"))));
        get("get-weight", (request, response) -> {
            var scaleId = request.queryParams("scaleId");
            var scale = currentNode.bases.get(scaleId);
            if (scale != null)
                return scale.getWeight() ;
            return -1;
        });
        get("set_mock", (req, res) -> {
            mockWeight = req.queryParams("weight");
            return mockWeight;
        });
        get("get_mock", (request, response) -> {
            return mockWeight;
        });
    }

    public static class Scales {
        HashMap<String, Base> scalesAZKK;
        public void initAZKK(){
            this.scalesAZKK = new HashMap<>();
            Base60RS COM6 =  new Base60RS("COM6", "1");
            Base3000RS COM5 =  new Base3000RS("COM5", "2");

            this.scalesAZKK.put("1", COM6);
            this.scalesAZKK.put("2", COM5);
        };
        public Scales(){
            initAZKK();

        };
    }

    public static String parseWeight(String weight) {
        Pattern p = Pattern.compile(".*GS.*[0-9]{1,5}.*kg.*");//find strings with weight
        Matcher m = p.matcher(weight);
        if (m.find()) {
            p = Pattern.compile(" ([0-9]{1,5}) ");
            m = p.matcher(weight);
            if (m.find()) {
                return weight.substring(m.start() + 1, m.end() - 1);
            }
        }
        return "";
    }

}

