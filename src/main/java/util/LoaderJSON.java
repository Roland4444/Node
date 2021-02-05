package util;
import abstractions.Base;
import bases.Base3000RS;
import bases.Base3002RS;
import bases.Base600RS;
import bases.Base60RS;
import abstractions.Type;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.HashMap;
public class LoaderJSON{
    public static JSONArray js(String json) throws ParseException {
        return (JSONArray) new JSONParser().parse(json);
    }
    public static Base gen(JSONObject input){
        String UUID = (String) input.get("UUID");
        String Port = (String) input.get("Port");
        Type type = Type.valueOf((String) input.get("Type"));
        Base result=null;
        switch (type) {
            case Base60RS -> result=(new Base60RS(Port, UUID));
            case Base3000RS-> result=(new Base3000RS(Port, UUID));
            case Base600RS -> result=(new Base600RS(Port, UUID));
            case Base3002RS ->  result=(new Base3002RS(Port, UUID));
        }
        return result;
    }
    public static HashMap<String, Base> loadJSON(String json) throws ParseException {
        HashMap <String, Base> map = new HashMap<>();
        js(json).forEach(a -> map.put(gen((JSONObject) a).UUID, gen((JSONObject) a)));
        return map;
    }
}