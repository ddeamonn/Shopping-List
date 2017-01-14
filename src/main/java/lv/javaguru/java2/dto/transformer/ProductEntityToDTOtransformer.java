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
    public ProductDTO transform(Product data) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productDTO.getProductId());
        productDTO.setProductName(productDTO.getProductName());
        productDTO.setAddedTime(productDTO.getAddedTime());
        productDTO.setProductCategory(productDTO.getProductCategory());
        productDTO.setAddedIP(productDTO.getAddedIP());
        productDTO.setAddedCountry(productDTO.getAddedCountry());

        return productDTO;
    }
}
