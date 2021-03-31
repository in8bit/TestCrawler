import java.util.ArrayList;
import java.util.List;

public class URLTreeNode {
    private String nodeLink= null;
    private String urlData= null;
    private List<URLTreeNode> urlList = new ArrayList<URLTreeNode>();

    public URLTreeNode(String nodelink){
        this.nodeLink = nodelink;
    }

    public String getNodeLink() {
        return nodeLink;
    }

    public void setNodeLink(String nodeLink) {
        this.nodeLink = nodeLink;
    }

    public String getUrlData() {
        return urlData;
    }

    public void setUrlData(String urlData) {
        this.urlData = urlData;
    }

    public List<URLTreeNode> getUrlList() {
        return urlList;
    }
    /*
    write function to insert into the one url link, which is a treeNode and can have its own children
     */
    public void addURL(String nodeLink) {
        this.urlList.add(new URLTreeNode(nodeLink));
    }
    public void setUrlList(List<URLTreeNode> urlList){
        if(!urlList.isEmpty()){
            for(URLTreeNode utn: urlList){
                this.urlList.add(utn);
            }
        }
    }

    public String printTree(){
        String children = null;
        int index =0;
        for(URLTreeNode utn: urlList){
            children += "Child URL : " +index+ " " + utn.getNodeLink()+ "\n";
            index++;
        }
        return "URL: "+ this.nodeLink+
                "\n Data in this URL: "+ this.urlData+
                "\n"+ children;

    }

}
