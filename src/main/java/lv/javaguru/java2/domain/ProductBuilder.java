package lv.javaguru.java2.domain;

/**
 * Created by DMC on 11/23/2016.
 */
public class ProductBuilder {

    String productName;

    private ProductBuilder() {};

    public static ProductBuilder createProduct() {
        return new ProductBuilder();
    }

    public Product build() {
        Product product = new Product();
        product.setProductName(productName);

        return product;
    }

    public ProductBuilder withProductName(String productName) {
        this.productName = productName;
        return this;
    }
}
