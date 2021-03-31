import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {

  //      String url1 = "https://www.cccd.edu/employees/Directories.cfm";
        String url2 = "https://umdearborn.edu/cecs/about/faculty-directory";
//        String url3 = "https://www.vistaprint.com/?no_redirect=1&xnav=logo";
//        String url4 ="https://www.hotels.com/";
//        String url5 ="https://www.therealyellowpages.com/index.php?RelId=7.3.5.0.1";
//        String url6 ="https://www.yelp.com/";

        ArrayList<Crawler> crawlerList = new ArrayList<>();
 //       crawlerList.add(new Crawler(url1, 1));
      crawlerList.add(new Crawler(url2, 2));
//        crawlerList.add(new Crawler(url3, 3));
//        crawlerList.add(new Crawler(url4, 4));
//        crawlerList.add(new Crawler(url5, 5));
//        crawlerList.add(new Crawler(url6, 6));
//        crawlerList.add(new Crawler(url7, 7);


        for(Crawler c: crawlerList){
            try{
                c.getThread().join();// wait till the thread gets back, done with its calling.
            }catch(Exception e){
               e.printStackTrace();
            }
        }
    }
}