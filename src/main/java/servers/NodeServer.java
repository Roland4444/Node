package servers;

import static spark.Spark.get;

public class NodeServer {

    public static void main(String [] args){
        ScaleServer sc = new ScaleServer();

        get("/get/:id", (request, response) -> {
            return sc.getWeigth(request.params(":id"));
        });
    }
}
