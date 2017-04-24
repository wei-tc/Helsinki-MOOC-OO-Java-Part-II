public class Main {
    public static void main(String[] Container) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

    public static void addSuitcasesFullOfBricks(Container container) {
        for (int i = 0; i < 100; i++) {
              Thing brick = new Thing("brick", 1 + i);
              Suitcase suitcase = new Suitcase(100);
              suitcase.addThing(brick);
              container.addSuitcase(suitcase);
        }
    }
}
           