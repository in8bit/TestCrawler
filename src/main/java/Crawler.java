import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Crawler implements Runnable {

    private int crawlerID;
    private Thread thread;
    private String first_link;
    private int depth =1;
    private String pageData;
    private List<String> visited_links = new ArrayList<String>();

    /*
    constructor:
    takes link and crawler ID as arguments,
    creates a bot on a seperate thread.
     */
    public Crawler(String link, int crawlerID){
        this.first_link = link;
        this.crawlerID = crawlerID;
        this.thread = new Thread(this);
        thread.start();
    }

    /*
    request function:
    Takes a url as input,
    connects to the given url,
    if successful, adds this to the list of "visited_urls"
    returns the page as a document.
     */
    private Document request(String url){
        try{
            if (url.length()==0 || url ==null){
                System.out.println("empty url");
            }else{
                Connection connection = Jsoup.connect(url);
                Document document = connection.userAgent("Mozilla/5.0").get();
                thread.sleep(200);
                if(connection.response().statusCode() == 200){
                    visited_links.add(url);
                    return document;
                }else {
                    System.out.println("Status code: " + connection.response().statusCode());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*
       crawl function:
       Takes crawling level and url to crawl as arguments.
     */
    private void crawl(int level, String url) throws MalformedURLException, URISyntaxException {
        if(level < depth){
            Document document = request(url);
            if(document != null){
                //URLTreeNode urlTreeNode = new URLTreeNode(url);//this line needs a check
                System.out.println(document.title());
                for(Element data : document.getElementsByTag("tbody")){
                    pageData= data.text();
                    //urlTreeNode.setUrlData(pageData);
                }
                for (Element link: document.select("a[href]")){
                    String next_link = link.absUrl("href");
                    if(inDomain(url,next_link)){
                       // urlTreeNode.addURL(next_link);
                        if (visited_links.contains(next_link)==false){
                            crawl(level++,next_link);//recursion
                        }
                    }
                }//end of collecting all the links
            }
        }else{
            System.out.println("***********************************Max depth reached.System Exiting.***********************************");
            System.exit(0);
        }
    }

    //build this to compare domain
    private boolean inDomain(String firstUrlLink, String nextUrllink) throws MalformedURLException{
        URL url1 = new URL(firstUrlLink);
        URL url2 = new URL(nextUrllink);
        //url1.toURI();
        //url2.toURI();
        String host1= url1.getHost();
        String host2= url2.getHost();
        if (host1.equalsIgnoreCase(host2)){
            return true;
        }else
            return false  ;
    }

    //return thread - access thread
    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        try {
            crawl(0,first_link);
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    //Scrape contacts
    private ContactDetails scrapeContact(String body){
        ContactDetails contact = new ContactDetails();
        //find details using regex
        return  contact;
    }
}
