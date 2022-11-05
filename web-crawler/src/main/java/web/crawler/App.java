package web.crawler;

public class App {
    public static void main(String[] args) {
        String country = "Iceland";
        // source can be "IMF", "World Bank" or "United Nations"
        String source = "IMF";

        String gdp = TableExtractor.getGDPByCountry(country, source);

        System.out.printf("GDP (nominal) per capita of \"%s\" from \"%s\" is \"$%s\"%n", country, source, gdp);
    }
}
