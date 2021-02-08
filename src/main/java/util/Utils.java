package util;

import abstractions.Base;
import abstractions.Node;

import java.util.Map;

public class Utils {
    public static void waiting(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e);
        }
    }

    public static void startScales(Node currentNode) {
        for (Map.Entry<String, Base> base : currentNode.bases.entrySet()) {
            base.getValue().start();
        }
    }
}
