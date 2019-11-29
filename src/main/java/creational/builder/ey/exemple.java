package creational.builder.ey;

class Product {

    public String sku;
    public Double size;
    public String category;
    public boolean isActice;

    public Product(String sku, Double size, String category, boolean isActice) {
        this.sku = sku;
        this.size = size;
        this.category = category;
        this.isActice = isActice;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", size=" + size +
                ", category='" + category + '\'' +
                ", isActice=" + isActice +
                '}';
    }
}

class ProductBuilder {

    private Product product = new Product();

    public ProductBuilder withSku(String sku) {
        product.sku = sku;
        return this;
    }

    public ProductBuilder withSize(Double size) {
        product.size = size;
        return this;
    }

    public ProductBuilder withCategory(String category) {
        product.category = category;
        return this;
    }

    public ProductBuilder isActive(boolean isActive) {
        product.isActice = isActive;
        return this;
    }

    public Product build() {
        return product;
    }

}

class Demo {

    public static void main(String[] args) {

        Product product = new Product("Test/BR-123", 10.5, "A", true);

        Product product2 =
                new ProductBuilder()
                    .withSku("Test/BR-123")
                    .withSize(10.5)
                    .withCategory("A")
                    .isActive(true)
                    .build();

        // print "Product{sku='Test/BR-123', size=10.5, category='A', isActice=true}"
        System.out.println(product);
    }
}