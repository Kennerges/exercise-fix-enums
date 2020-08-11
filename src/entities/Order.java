package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private final Date moment;
    private OrderStatus status;

    private final Client client;
    private final List<OrderItem> orderItemList = new ArrayList<>();

    public Order(Date moment, Client client) {
        this.moment = moment;
        this.client = client;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }



    public void addItem(OrderItem item) {
        orderItemList.add(item);
    }

    public Double total() {
        double sum = 0.0;
        for (OrderItem item : orderItemList) {
            sum = sum + item.subTotal();
        } return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf2.format(moment)).append("\n");
        sb.append("Order status: ");
        sb.append(status).append("\n");
        sb.append("Client: ");
        sb.append(client.getName()).append(" ");
        sb.append("(").append(sdf1.format(client.getBirthDate())).append(")");
        sb.append(" - ").append(client.getEmail()).append("\n");
        sb.append("Order items: \n");
        for (OrderItem item : orderItemList) {
            sb.append(item.getProduct().getName()).append(", $ ");
            sb.append(String.format("%.2f", item.getPrice()));
            sb.append(", Quantity: ");
            sb.append(item.getQuantity()).append(", Subtotal: $ ");
            sb.append(String.format("%.2f\n", item.subTotal()));
        }
        sb.append("Total price: $ ").append(String.format("%.2f", total()));
        return sb.toString();
    }

}
