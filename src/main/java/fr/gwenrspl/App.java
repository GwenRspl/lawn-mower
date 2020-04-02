package fr.gwenrspl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MowersHandler handler = new MowersHandler();
        String result = handler.executeMowersHandler();
        System.out.println(result);

    }
}
