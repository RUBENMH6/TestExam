import java.util.*;

public class Util {
    public static List<KeyAndList<String, List<Card>>> transform(Map<String, List<Card>> map) {
        for (String name : map.keySet()) {
            KeyAndList<String, Card> list = new KeyAndList<>(name,map.get(name));
        }
    }
}
