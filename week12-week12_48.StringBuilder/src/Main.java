
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < t.length; i++) {
            if (i % 4 == 0) {
                stringBuilder.append("\n ");
            }
            
            stringBuilder.append(t[i]);          
            
            if (i != t.length - 1) {
                stringBuilder.append(", ");
            }
        }

        return stringBuilder.append("\n}").toString();
    }
}
