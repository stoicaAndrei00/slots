package map.project.slots.AdapterTest;

import map.project.slots.Model.Dto.Adapter.ProductAdapter;
import map.project.slots.Model.Dto.ProductDto;
import map.project.slots.Model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductAdapterTest {

    @Test
    public void adaptToDtoTest(){
        Product  product = new Product();
        product.setProdcutId(1L);
        product.setQuantity(15);
        product.setPrice(8L);
        product.setType("Beer");

        ProductDto productDto = new ProductAdapter().adaptToDto(product);
        Assertions.assertEquals(productDto.getProductId() , product.getProdcutId());
        Assertions.assertEquals(productDto.getPrice() , product.getPrice());
        Assertions.assertEquals(productDto.getQuantity() , product.getQuantity());
        Assertions.assertEquals(productDto.getType() , product.getType());
    }
}
