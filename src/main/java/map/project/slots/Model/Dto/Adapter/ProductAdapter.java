package map.project.slots.Model.Dto.Adapter;

import map.project.slots.Model.Dto.ProductDto;
import map.project.slots.Model.Product;

public class ProductAdapter implements Adapter<Product, ProductDto> {
    @Override
    public ProductDto adaptToDto(Product object) {
        return new ProductDto(object.getProdcutId(),
                object.getType(),
                object.getPrice(),
                object.getQuantity());
    }
}
