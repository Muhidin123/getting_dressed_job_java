import java.util.Hashtable;

public class HashTableResponses {

    public static Hashtable<Integer, String> hotResponse(){
        Hashtable<Integer, String> hotResponses = new Hashtable<>();

        hotResponses.put(1, "sandals");
        hotResponses.put(2, "sunglasses");
        hotResponses.put(3, "fail");
        hotResponses.put(4, "shirt");
        hotResponses.put(5, "fail");
        hotResponses.put(6, "shorts");
        hotResponses.put(7, "leaving house");
        hotResponses.put(8, "Removing Pjs");

        return hotResponses;
    }

    public static Hashtable<Integer, String> coldResponse() {
        Hashtable<Integer, String> coldResponses = new Hashtable<>();

        coldResponses.put(1, "boots");
        coldResponses.put(2, "hat");
        coldResponses.put(3, "socks");
        coldResponses.put(4, "shirt");
        coldResponses.put(5, "jacket");
        coldResponses.put(6, "pants");
        coldResponses.put(7, "leaving house");
        coldResponses.put(8, "Removing Pjs");

        return coldResponses;

    }
}

