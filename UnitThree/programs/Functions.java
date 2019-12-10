public class Functions {
    // return: int, 1 parameter
    public static int f (int x) {
        return 10*x -1;
    }

    // return: String, 1 parameter
    public static String removeLastCharacter(String word) {
        word = word.substring(0, word.length()-1);
        return word;
    }

    // return: String, 2 parameter
    public static String repeatWord(String word, int times) {
        String output = "";
        for (int i = 0; i < times; i++) {
            output += word;
        }
        return output;
    }

    // returns String, uses 2 parmeters
    public static String getInitials(String fName, String lName) {
        String output = "" + fName.charAt(0) + lName.charAt(0);
        return output.toUpperCase();

    }

    // returns String, uses 1 parameter
    public static String doubleChar(String str) {
        String oldString = str;
        String newString = new String();
        for (int i = 0; i < str.length(); i++) {
          newString += str.charAt(i);
          newString += str.charAt(i);
        }
        return newString;
      }


    public static void main(String[] args) {
        System.out.println(removeLastCharacter(args[0]));
        System.out.println(repeatWord(args[0], Integer.parseInt(args[1]) ));
        System.out.println(getInitials("Chrome", "Puter"));
        System.out.println(doubleChar(args[2]));
    }

}