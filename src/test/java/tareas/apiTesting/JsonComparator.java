package tareas.apiTesting;

import org.json.JSONObject;

import java.util.Set;

public class JsonComparator {
    public static String IGNORED = "######";

    public static boolean compare(String expectedJson, String actualJson) {
        return compare(new JSONObject(expectedJson), new JSONObject(actualJson));
    }

    public static boolean compare(JSONObject expectedJson, JSONObject actualJson) {
        if (expectedJson.length() != actualJson.length()){
            System.out.println("Los Objetos no contienen las mismas claves");
            return false;
        }

        for (String key : expectedJson.keySet()) {
            if (!actualJson.has(key)){
                System.out.println("El Objeto no contiene la clave: '"+key+"'");
                return false;
            }

            if (expectedJson.get(key).equals(IGNORED))
                continue;

            if (!actualJson.get(key).equals(expectedJson.get(key))){
                System.out.println("El valor de la clave: '"+key+"' no coincide");
                return false;
            }
        }
        return true;
    }
}
