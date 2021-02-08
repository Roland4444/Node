package abstractions;

import java.util.HashMap;

public class Node {
    public HashMap<String, Base> bases;

    public Node(HashMap<String, Base> base) {
        this.bases = base;
    }

    public Node() {
    }
}
