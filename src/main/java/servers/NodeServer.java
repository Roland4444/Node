package servers;
import abstractions.Node;
import org.json.simple.parser.ParseException;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import spark.utils.IOUtils;
import util.Checker;
import util.LoaderJSON;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static spark.Spark.get;
import static spark.Spark.post;

public class NodeServer {
    private static String mockWeight = "0.00";
    public static void reload(Node currentNode) throws IOException, ParseException {
        currentNode.bases = LoaderJSON.loadJSON(new String(Files.readAllBytes(Path.of("config.json"))));
    }
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("LOADED NEW VERSION");
        Checker Checker = new Checker();
        Node currentNode = new Node();
        reload(currentNode);
        get("get-weight", (request, response) -> {
            var scaleId = request.queryParams("scaleId");
            System.out.println("REQUEST to read #"+scaleId);
            var scale = currentNode.bases.get(scaleId);
            if (scale != null) {
                var w = scale.getWeight();
                if (Checker.isnumber(w))
                    scale.LastWeight = Float.parseFloat(w);
                System.out.println("READED ::"+w);
                return scale.LastWeight;
            }
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

