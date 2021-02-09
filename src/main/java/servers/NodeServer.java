package servers;
import abstractions.Node;
import org.json.simple.parser.ParseException;
import util.LoaderJSON;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static spark.Spark.get;
public class NodeServer {
    private static String mockWeight = "0.00";
    public static void reload(Node currentNode) throws IOException, ParseException {
        currentNode.bases = LoaderJSON.loadJSON(new String(Files.readAllBytes(Path.of("config.json"))));
    }
    public static void main(String[] args) throws IOException, ParseException {
        Node currentNode = new Node();
        reload(currentNode);
        get("get-weight", (request, response) -> {
            var scaleId = request.queryParams("scaleId");
            var scale = currentNode.bases.get(scaleId);
            if (scale != null)
                return scale.getWeight();
            return -1;
        });
        get("set_mock", (req, res) -> {
            mockWeight = req.queryParams("weight");
            return mockWeight;
        });
        get("get_mock", (request, response) -> mockWeight);

        get("reload", (request, response) -> {
            reload(currentNode);;
            return "OK";
        });
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

