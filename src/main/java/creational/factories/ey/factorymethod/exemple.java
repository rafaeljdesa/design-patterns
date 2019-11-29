package creational.factories.ey.factorymethod;

enum ProductSize {
    SMALL, MEDIUM, LARGE
}

abstract class Product {

    protected ProductSize productSize;
}

class SmallProduct extends Product {

    public SmallProduct() {
        productSize = ProductSize.SMALL;
    }
}
class MediumProduct extends Product {

    public MediumProduct() {
        productSize = ProductSize.MEDIUM;
    }
}
class LargeProduct extends Product {

    public LargeProduct() {
        productSize = ProductSize.LARGE;
    }
}

class ProductFactory {

    public static Product createProduct(Double size) {

        Product product = null;
        if (size <= 5) {
            product = new SmallProduct();
        } else if (size > 5 && size <= 10) {
            product = new MediumProduct();
        } else if (size > 10) {
            product = new LargeProduct();
        }
        return product;
    }

}

class Demo {

    public static void main(String[] args) {

        Product largeProduct = ProductFactory.createProduct(12.5);

        // print "LARGE"
        System.out.println(largeProduct.productSize);
    }
}