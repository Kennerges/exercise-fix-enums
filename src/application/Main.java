package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String nameClient = sc.nextLine();
        System.out.print("Email: ");
        String emailClient = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDateClient = sdf1.parse(sc.nextLine());

        Order order = new Order(new Date(),
                new Client(nameClient, emailClient, birthDateClient));

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        order.setStatus(OrderStatus.valueOf(sc.nextLine()));
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i ++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            Double priceProduct = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantityProduct = sc.nextInt();
            order.addItem(new OrderItem(quantityProduct,
                    priceProduct,
                    new Product(nameProduct)));
        }

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);

        sc.close();
    }
}
