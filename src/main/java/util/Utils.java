package util;

import abstractions.Base;
import abstractions.Node;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Utils {
    public static boolean isPause = false;

    public static void waiting(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e);
        }
    }

    public static void startScales(Node currentNode) {
        for (Map.Entry<String, Base> base : currentNode.bases.entrySet())
            base.getValue().start();
    }

    public static void reload(Node currentNode) throws IOException, ParseException {
        pauseScales(true);
        currentNode.bases = LoaderJSON.loadJSON(new String(Files.readAllBytes(Path.of("config.json"))));
        waiting(2500);
        pauseScales(false);
    }
    public static void pauseScales(boolean pause) {
        isPause = pause;
    }
}
