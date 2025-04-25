import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
	
	public String title;
	public List<String> headings = new ArrayList<>();
	public List<String> links = new ArrayList<>();
	
	final String url = "https://bbc.com)./";
	
    public static void main(String[] args) {
        // TODO: Scrape a URL and print its title
    	try {
    	PageData pageData = new PageData();
    	pageData = GetData(url);
    	
    	pageData.getHeadings();
    	pageData.getLinks();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    private static PageData GetData(String url) throws IOException {
    	
    	javax.swing.text.Document doc = Jsoup.connect(url).get();
    	
    	PageData data = new PageData();
    	data.title = doc.title()  
    			
    	for (int i=1; i<=6; i++) {
    		Elements headings = doc.select("h" + i);
            for (Element h : headings) {
                data.headings.add(h.text());
            }
        }
    	
    	Elements links = doc.select("a[href]")
    	for(Element link : links) {
    		data.links.add(link.attr("href"))
    	}
    	return data;
    }
    
    static class PageData{
    	
    	public String title;
    	public List<String> headings = new ArrayList<>();
    	public List<String> links = new ArrayList<>();
    	
    	public void getHeadings() {
    		for(String h : headings) {
    			System.out.println(h)
    		}
    	}
    	
    	public void getLinks() {
    		for(String l : links) {
    			System.out.println(l)
    		}
    	}
    }
}
