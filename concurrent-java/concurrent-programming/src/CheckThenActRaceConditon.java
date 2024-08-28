import java.util.HashMap;
import java.util.Map;

public class CheckThenActRaceConditon implements Runnable{
    private static Map<String, String> map= new HashMap<>();

    void addToMap() {
        map.put("key1", "val1");
    }

    @Override
    public void run() {
        if(map.containsKey("key1")) {
            String val= map.remove("key1");
            if(val == null) {
                System.out.println("value of key is empty");
            } else {
                map.put("key1", "val1");
            }
        }
    }
}
