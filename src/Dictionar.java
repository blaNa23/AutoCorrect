import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Dictionar {

    public static Map<String,Integer> dictionary() {

        Map<String, Integer> map = new HashMap<>();

        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader("dict.txt"));

            while(sc.hasNextLine()) {
                String word = sc.next();
                int frequency = sc.nextInt();
                sc.nextLine();
                map.put(word,frequency);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sc !=null) {
                sc.close();
            }
        }

        return map;
    }
}
