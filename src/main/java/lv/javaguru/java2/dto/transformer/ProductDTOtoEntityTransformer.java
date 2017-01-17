package lv.javaguru.java2.dto.transformer;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/13/2017.
 */
@Component
@Qualifier("ProductDTOtoEntity")
public class ProductDTOtoEntityTransformer implements DataTranformer<Product, ProductDTO>{
    @Override
    public Product transform(ProductDTO dataDTO) {
        Product product = new Product();
        product.setProductId(dataDTO.getProductId());
        product.setProductName(dataDTO.getProductName());
        product.setProductCategory(dataDTO.getProductCategory());
        product.setAddedTime(dataDTO.getAddedTime());

        return product;
    }
}
