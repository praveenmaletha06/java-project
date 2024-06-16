import java.awt.*;
import java.awt.event.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private int itemCount;
    private double totalPrice;

    public ShoppingCart() {
        itemCount = 0;
        totalPrice = 0.0;
    }

    public void addItem(Product product) {
        itemCount++;
        totalPrice += product.getPrice();
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

public class OnlineShoppingAWT extends Frame implements ActionListener {
    private List productList;
    private Button addToCartButton;
    private Label cartLabel;
    private ShoppingCart cart;

    private Product[] products = {
        new Product("Laptop", 999.99),
        new Product("Smartphone", 499.99),
        new Product("Headphones", 99.99)
    };

    public OnlineShoppingAWT() {
        setLayout(new FlowLayout());

        productList = new List(4);
        for (Product product : products) {
            productList.add(product.getName() + " ($" + product.getPrice() + ")");
        }

        addToCartButton = new Button("Add to Cart");
        addToCartButton.addActionListener(this);

        cartLabel = new Label("Items in Cart: 0 | Total Price: $0.00");

        add(productList);
        add(addToCartButton);
        add(cartLabel);

        setTitle("Online Shopping");
        setSize(600, 400);
        setVisible(true);
        setBackground(Color.yellow);

        cart = new ShoppingCart();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToCartButton) {
            int selectedIndex = productList.getSelectedIndex();
            if (selectedIndex != -1) {
                Product selectedProduct = products[selectedIndex];
                cart.addItem(selectedProduct);
                updateCartLabel();
            }
        }
    }

    private void updateCartLabel() {
        cartLabel.setText("Items in Cart: " + cart.getItemCount() + " | Total Price: $" + cart.getTotalPrice());
    }

    public static void main(String[] args) {
        new OnlineShoppingAWT();
    }
}