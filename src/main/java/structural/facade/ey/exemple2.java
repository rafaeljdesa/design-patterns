package structural.facade.ey;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

interface ProductOrderFacade {
    void generateOrder(List<Product> products);
}

class Product {}

class Order {

    private List<Product> products;
    private BigDecimal total;
    private BigDecimal totalDiscount;

    public Order(List<Product> products) {
        this.products = products;
    }

    public void calculateTotal() { /*...*/ }

    public boolean hasDiscount() { /*...*/ return true; }

    public void applyDiscount() { /*...*/ }

    public void closeOrder() { /*...*/ }
}

class ProductOrderFacadeImpl implements ProductOrderFacade {

    @Override
    public void generateOrder(List<Product> products) {

        Order order = new Order(products);

        if (order.hasDiscount()) {
            order.applyDiscount();
        }

        order.calculateTotal();

        order.closeOrder();

    }
}

class Demo {

    public static void main(String[] args) {

        ProductOrderFacade productOrderFacade = new ProductOrderFacadeImpl();

        List<Product> products = new ArrayList<>();

        productOrderFacade.generateOrder(products);
    }
}

