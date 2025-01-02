package SimpleFulfillmentService.model;

public class ProductInventory {

    private int productId;
    private int quantity;
    private int inventoryId; // We can skip this for now

    public ProductInventory(int productId) {
        this.productId = productId;
    }

    public ProductInventory(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        // We need to handle concurrency in Set Quantity
        this.quantity = quantity;
    }
}
