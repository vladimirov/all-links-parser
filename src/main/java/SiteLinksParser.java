import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SiteLinksParser {

    public static void main(String[] args) throws IOException {

        String url = "";
        Elements links = getElements(url, "Total links: ");

        for (Element link : links) {
            String hrefUrl = link.attr("href");
            if (!hrefUrl.contains("#") && !hrefUrl.isEmpty() && !hrefUrl.contains("tel") && !hrefUrl.contains("@")) {
                System.out.println(hrefUrl);
                Elements linksInternal = getElements(hrefUrl, "Total internal links : ");
//                for (Element linkInternal : linksInternal) {
//                    String hrefInternalUrl = linkInternal.attr("href");
//                    if (!hrefUrl.contains("#") && !hrefUrl.contains("tel") && !hrefUrl.contains("@") && !hrefUrl.isEmpty()) {
//                        System.out.println(hrefInternalUrl);
//                    }
//                }
            }
        }

    }

    private static Elements getElements(String url, String s) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        System.out.println(s + links.size());
        return links;
    }

}
