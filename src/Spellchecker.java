public class Spellchecker {

    String spellingOne(String first, String second) {
        //fara conditiile de mai jos, laptop si laptopppppp ar returna true
        String biggerString = first;
        String smallerString = second;
        if (first.length() < second.length()) {
            smallerString = first;
            biggerString = second;
        }

        if (first.length() == second.length()) {
            return replaceOne(first, second);
        } else if (biggerString.length() - smallerString.length() == 1) {
            return editOne(first, second);
        }

        return "notOneEdit";
    }

    private String replaceOne(String first, String second) {
        int count = 0;
        int len = first.length();

        for (int i = 0; i < len; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }

        if (count <= 1) {
            return second;
        }

        return "notOneEdit";
    }

    private String editOne(String s1, String s2) {
        String first, second;
        int index1 = 0;
        int index2 = 0;

        if (s1.length() > s2.length()) {
            first = s1;
            second = s2;
        } else {
            first = s2;
            second = s1;
        }

        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                index1++;
            } else {
                index1++;
                index2++;
            }
        }

        if (index1 - index2 <= 1) {
            return s2;
        }

        return "notOneEdit";
    }

    String spellingTwo(String first, String second) {
        //fara conditiile de mai jos, laptop si laptopppppp ar returna true
        String biggerString = first;
        String smallerString = second;
        if (first.length() < second.length()) {
            smallerString = first;
            biggerString = second;
        }

        if (first.length() == second.length()) {
            return replaceTwo(first, second);
        } else if (biggerString.length() - smallerString.length() == 2) {
            return editTwo(first, second);
        }

        return "notTwoEdit";
    }

    private String replaceTwo(String first, String second) {
        int count = 0;
        int len = first.length();

        for (int i = 0; i < len; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }

        if (count <= 2) {
            return second;
        }

        return "notTwoEdit";
    }

    private String editTwo(String s1, String s2) {
        String first, second;
        int index1 = 0;
        int index2 = 0;

        if (s1.length() > s2.length()) {
            first = s1;
            second = s2;
        } else {
            first = s2;
            second = s1;
        }

        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                index1++;
            } else {
                index1++;
                index2++;
            }
        }

        if (index1 - index2 <= 2) {
            return s2;
        }

        return "notTwoEdit";
    }


    boolean oneEditAway(String first, String second) {

        String biggerString = first;
        String smallerString = second;
        if (first.length() < second.length()) {
            smallerString = first;
            biggerString = second;
        }

        if (first.length() == second.length()) {
            return replaceOneAway(first, second);
        } else if (biggerString.length() - smallerString.length() == 1) {
            return editOneAway(first, second);
        }
        return false;
    }

    private boolean replaceOneAway(String first, String second) {
        int count = 0;
        int len = first.length();

        for (int i = 0; i < len; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }

        if (count <= 1) {
            return true;
        }

        return false;
    }

    private boolean editOneAway(String s1, String s2) {
        String first, second;
        int index1 = 0;
        int index2 = 0;

        if (s1.length() > s2.length()) {
            first = s1;
            second = s2;
        } else {
            first = s2;
            second = s1;
        }

        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                index1++;
            } else {
                index1++;
                index2++;
            }
        }

        if (index1 - index2 <= 1) {
            return true;
        }

        return false;
    }


    boolean twoEditAway(String first, String second) {
        String biggerString = first;
        String smallerString = second;
        if (first.length() < second.length()) {
            smallerString = first;
            biggerString = second;
        }

        if (first.length() == second.length()) {
            return replaceTwoAway(first, second);
        } else if ((biggerString.length() - smallerString.length() == 2)) {
            return editTwoAway(first, second);
        }
        return false;
    }

    private boolean replaceTwoAway(String first, String second) {
        int count = 0;
        int len = first.length();

        for (int i = 0; i < len; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }
        }

        if (count <= 2) {
            return true;
        }

        return false;
    }

    private boolean editTwoAway(String s1, String s2) {
        String first, second;
        int index1 = 0;
        int index2 = 0;

        if (s1.length() > s2.length()) {
            first = s1;
            second = s2;
        } else {
            first = s2;
            second = s1;
        }

        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                index1++;
            } else {
                index1++;
                index2++;
            }
        }
        System.out.println("index1:" + index1);
        System.out.println("index2:" + index2);
        System.out.println(index1 - index2);

        if (index1 - index2 <= 2) {
            return true;
        }

        return false;
    }
}
