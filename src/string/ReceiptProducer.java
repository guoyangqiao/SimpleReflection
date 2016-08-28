package string;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/14/16.
 */
public class ReceiptProducer {


    private ReceiptProducer() {
    }

    private static final ReceiptProducer producer = new ReceiptProducer();

    public static ReceiptProducer getProducer() {
        return producer;
    }

    private double total = 0D;
    private Formatter f = new Formatter(System.err);

    private void printHead() {
        f.format("%-15s %-5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %-5s %10s\n", "----", "---", "-----");
    }

    private void printProducts(Cart cart) {
        for (Map.Entry<Product, Integer> s : cart.getProducts().entrySet()) {
            double cost = s.getKey().getPrice() * s.getValue();
            f.format("%-15.15s %-5d %10.2f\n", s.getKey().getName(), s.getValue(), cost);
            total += cost;
        }
    }

    private void printTotal() {
        f.format("%-15s %-5s %10.2f\n", "Tax", "", total * 0.06);
        f.format("%-15s %-5s %10s\n", "", "", "-----");
        f.format("%-15s %-5s %10.2f\n", "Total", "", total * 1.06);

    }

    private void printReceipt(Cart cart) {
        printHead();
        printProducts(cart);
        printTotal();
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addProduct(new HashMap<Product, Integer>() {
            {
                put(new Product("AUDI A4L", 300000.00D), 1);
            }
        });
        cart.addProduct(new HashMap<Product, Integer>() {
            {
                put(new Product("MacBook Pro", 12000.00D), 2);
            }
        });
        ReceiptProducer.getProducer().printReceipt(cart);
    }

}

class Product {
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    private String name;
    private Double price;
}

class Cart {
    private Map<Product, Integer> productMap = new HashMap<>();

    public Map<Product, Integer> getProducts() {
        return productMap;
    }

    public void addProduct(Map<Product, Integer> products) {
        productMap.putAll(products);
    }
}
