
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Spellchecker spellchecker = new Spellchecker();

        Scanner sc = new Scanner(System.in);
        System.out.println("press q  to quit the app");
        while (true) {
            System.out.println();
            System.out.println("type: ");
            String inputString = sc.nextLine();

            if (inputString.equalsIgnoreCase("q")) {
                System.out.println("app closed !");
                return;
            }

            System.out.println(spellcheck(inputString));
        }

    }

    public static String spellcheck(String string) {
        //metoda necesara pentru verificarea unei propozitii - se aplica si pt 1 cuv
        StringBuilder sb = new StringBuilder();
        sb.append("Did you mean: \n");

        String[] words = string.split(" ");
        String temp = "";
        int count = 0;

        //daca toate cuvintele exista in mapa/sunt corecte, nu e nevoie sa le printam
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(suggestWord(words[i]))){
                count++;
            }
        }

        if(count == words.length) {
            return "~speeling complete 100%~";
        }

        for(int i = 0; i < words.length; i++) {
            temp = suggestWord(words[i]);

            sb.append(temp);
            sb.append(" ");
        }

        return sb.toString();
    }


    public static String suggestWord(String string) {
        Map<String, Integer> map = Dictionar.dictionary();
        Spellchecker spellchecker = new Spellchecker();
        List<Integer> myList = new ArrayList<>();

        if(map.containsKey(string)){
            return string;
        }

        int biggest = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String rezultat = spellchecker.spellingOne(string, entry.getKey());

            if (!rezultat.equalsIgnoreCase("notOneEdit")) {
                myList.add(map.get(spellchecker.spellingOne(string, entry.getKey())));
            }
        }
        //in caz ca nu sunt cuvinte oneEditAway, ne uitam sa vedem daca sunt twoEditAway
        if(myList.size() == 0) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String rezultat = spellchecker.spellingOne(string, entry.getKey());

                if (!rezultat.equalsIgnoreCase("notTwoEdit")) {
                    myList.add(map.get(spellchecker.spellingTwo(string, entry.getKey())));
                }
            }
        }
        //??? marimea listei este 8000 si totusi primul element este null ??
        System.out.println("marimea listei:" + myList.size());
        System.out.println("primul elem din lista:" + myList.get(0));

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) > biggest) {
                biggest = myList.get(i);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //fara extra conditie, sunt afisate toate cuvintele cu aceeasi frecventa
            if (entry.getValue() == biggest &&
                    (spellchecker.oneEditAway(string, entry.getKey())||
                            spellchecker.twoEditAway(string, entry.getKey()))) {
                return entry.getKey();
            }
        }

        return "unknown word";
    }
}
