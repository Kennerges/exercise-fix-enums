package entities;

public class OrderItem {

    private final Integer quantity;
    private final Double price;

    private final Product product;


    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }


    public Double subTotal() {
        return quantity * price;
    }
}
