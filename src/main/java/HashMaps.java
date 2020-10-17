import java.sql.SQLOutput;
import java.util.*;


public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> ids = new HashMap<String, Integer>();
        ids.put("Tomek", 5);
        ids.put("Ania", ids.getOrDefault("Ania", 7) + 1);
        System.out.println(ids.get("Ania"));
    }

}

