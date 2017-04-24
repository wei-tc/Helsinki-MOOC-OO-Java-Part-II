
public class Smileys {

    public static void main(String[] args) {
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }

    private static void printWithSmileys(String characterString) {
        printSmileys(characterString.length());
        printStringRow(characterString);
        printSmileys(characterString.length());
    }

    private static void printSmileys(int amount) {
        System.out.print(":)");
        if (amount % 2 == 1) {
            for (int i = 0; i < ((amount + 2) / 2) + 1; i++) {
                System.out.print(":)");
            }
        } else {
            for (int i = 0; i < ((amount + 2) / 2); i++) {
                System.out.print(":)");
            }
        }
        System.out.print(":)");
        System.out.println("");
    }

    private static void printStringRow(String characterString) {
        if (characterString.length() % 2 == 1) {
            System.out.println(":) " + characterString + "  :)");
        } else {
            System.out.println(":) " + characterString + " :)");
        }
    }
}
