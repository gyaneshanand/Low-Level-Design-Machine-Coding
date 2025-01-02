package SimpleFulfillmentService.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private int id;
    private int capacity;
    private List<ProductInventory> productInventories;
    private List<Product> products;

    public Inventory(int id) {
        this.id = id;
        productInventories = new ArrayList<>();
        products = new ArrayList<>();
    }
}
