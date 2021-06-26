import java.util.HashMap;

public class Catalog implements Search {
    HashMap<String, List <Product> > productNames;

    @Override
    public List<Product> searchByName(String name) {
        return productNames.get(name);
    }
}
