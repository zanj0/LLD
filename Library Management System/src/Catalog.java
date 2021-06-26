import java.util.HashMap;

public class Catalog implements Search {
    private HashMap <String, List <Book> > bookTitles;
    private HashMap <String, List <Book> > bookAuthor;
    public List<Book> searchByTitle(String query){
        return bookTitles.get(query);
    }
}

