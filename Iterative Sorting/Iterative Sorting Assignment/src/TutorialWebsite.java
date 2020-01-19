/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 */
public class TutorialWebsite {
    private String languageName;    //Languages name
    private String webDescription;  //Tutorial website description
    private String webUrl;          //Tutorial website URL

    //Constructor methods

    /*
    Default constructor
    Post-conditions: languageName = ""; webDescription = ""; webUrl = "";
    */
    public TutorialWebsite(){
        this.languageName = "";
        this.webDescription="";
        this.webUrl="";
    }

    /*
    Constructor with parameters
    TutorialWebsite is initialized with given parameters
    Post-conditions: languageName = name; webDescription = description; webUrl = url;
    */
    public TutorialWebsite(String name, String description, String url){
        this.languageName = name;
        this.webDescription= description;
        this.webUrl= url;
    }

    //Mutator Methods

    /*Method to set Language Name
     */
    public void setLanguageName(String languageName){
        this.languageName=languageName;
    }
    /*Method to set Web Description
     */
    public void setWebDescription(String webDescription){
        this.webDescription=webDescription;
    }
    /*Method to set Web URL
     */
    public void setWebUrl(String webUrl){
        this.webUrl=webUrl;
    }

    //Accessor Methods

    //Method to get Language Name
    public String getLanguageName(){
        return languageName;
    }
    //Method to get Web Description
    public String getWebDescription() {
        return webDescription;
    }
    //Method to get Web URL
    public String getWebUrl() {
        return webUrl;
    }

    //Method to compare by Language Name
    public int compareTo(TutorialWebsite other){
        return this.languageName.compareTo(other.getLanguageName());
    }

    //Method to return properties as string
    public String toString() {
        return languageName+","+webDescription+","+webUrl+"\n";
    }
}
