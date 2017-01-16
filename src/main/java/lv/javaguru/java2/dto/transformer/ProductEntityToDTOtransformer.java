package lv.javaguru.java2.dto.transformer;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/13/2017.
 */
@Component
@Qualifier("ProductEntityToDTO")
public class ProductEntityToDTOtransformer implements DataTranformer<ProductDTO, Product>{
    @Override
    public ProductDTO transform(Product product) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setAddedTime(product.getAddedTime());
        productDTO.setProductCategory(product.getProductCategory());
        productDTO.setAddedIP(product.getAddedIP());
        productDTO.setAddedCountry(product.getAddedCountry());

        return productDTO;
    }
}
