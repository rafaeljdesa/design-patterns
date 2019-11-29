package creational.factories.ey.abstractfactory;

enum ProductSize {
    SMALL, MEDIUM, LARGE
}

enum ProductCategory {
    TECHNOLOGY, UTILITIES
}

interface ProductCategoryFactory<T extends Product> {
    T createTechnologyProduct(Double size);
    T createUtilitiesProduct(Double size);
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

class Product {

    protected ProductSize productSize;
    protected ProductCategory productCategory;
}

class ProductFactory implements ProductCategoryFactory {

    private Product product;

    @Override
    public Product createTechnologyProduct(Double size) {

        createProduct(size);

        product.productCategory = ProductCategory.TECHNOLOGY;

        return product;
    }

    @Override
    public Product createUtilitiesProduct(Double size) {

        createProduct(size);

        product.productCategory = ProductCategory.UTILITIES;

        return product;
    }

    private void createProduct(Double size) {

        if (size <= 5) {
            product = new SmallProduct();
        } else if (size > 5 && size <= 10) {
            product = new MediumProduct();
        } else if (size > 10) {
            product = new LargeProduct();
        }
    }
}

class Demo {

    public static void main(String[] args) {

        ProductFactory factory = new ProductFactory();

        Product product = factory.createTechnologyProduct(12.5);

        // print "TECHNOLOGY"
        System.out.println(product.productCategory);

        //print "LARGE"
        System.out.println(product.productSize);
    }
}

