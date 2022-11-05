package web.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TableExtractor {
    public static String getGDPByCountry(String country, String source) {
        String gdp = null;

        String url = "https://en.wikipedia.org/wiki/List_of_countries_by_GDP_(nominal)_per_capita";
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Element table = doc.select("table").get(1);
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            if (cols.size() > 0 && cols.get(0).text().contains(country)) {
                switch (source) {
                    case "IMF":
                        gdp = cols.get(2).text();
                        break;
                    case "World Bank":
                        gdp = cols.get(4).text();
                        break;
                    case "United Nations":
                        gdp = cols.get(6).text();
                        break;
                }
            }
        }

        return gdp;
    }
}
