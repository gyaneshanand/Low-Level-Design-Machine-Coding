package SimpleFulfillmentService.model;

public class Product {

    private int productId;
    private int name;
    // Other Product data like category, dimension etc

    public Product(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
