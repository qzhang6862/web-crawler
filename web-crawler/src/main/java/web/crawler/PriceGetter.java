package web.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class PriceGetter {
    public static List<String> getPricesFromWebPage(String orderId) {
        String url = String.format("https://www.amazon.com/gp/your-account/order-details?orderID=%s", orderId);
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("doc: \n" + doc);

        return null;
    }
}
