package web.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Document doc;
        try {
            doc = Jsoup.connect("https://en.wikipedia.org/wiki/Jsoup").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("doc: " + doc);
    }
}
