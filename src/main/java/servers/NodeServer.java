package servers;

import abstractions.Node;
import org.json.simple.parser.ParseException;
import util.LoaderJSON;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static spark.Spark.get;
import static util.Utils.startScales;

public class NodeServer {
    private static String mockWeight = "0.00";

    public static void main(String[] args) throws IOException, ParseException {
        Node currentNode = new Node();
        currentNode.bases = LoaderJSON.loadJSON(new String(Files.readAllBytes(Path.of("config.json"))));
        startScales(currentNode);
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
    }
}

