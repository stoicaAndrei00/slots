package map.project.slots.UI;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Dto.ProductDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.Product;
import map.project.slots.Service.BarService;
import map.project.slots.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class ProductUI {
    @Autowired
    private ProductService productService;
    @Autowired
    private BarService barService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @ShellMethod(key = "products")
    public String findAllProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();

        for (Product product : productService.findAllProducts()) {
            productDtoList.add((ProductDto) proxyAdapter.adapt(product));
        }
        return productDtoList.toString();
    }

    @ShellMethod(key = "find product")
    public String findProductById(@ShellOption(value = {"product id"}, help = "id of the product") Long productId) {
        try {
            return proxyAdapter.adapt(this.productService.findProductById(productId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete product")
    public String deleteProductById(@ShellOption(value = {"product id"}, help = "id of the product") Long productId) {
        try {
            return proxyAdapter.adapt(this.productService.deleteProductById(productId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "add product")
    public String addProduct(@ShellOption(value = {"type"}, help = "type of product") String type,
                             @ShellOption(value = {"price"}, help = "price of the product") Long price,
                             @ShellOption(value = {"quantity"}, help = "quantity of the product") int quantity,
                             @ShellOption(value = {"bar id"}, help = "id of the bar") Long barId) {
        try {
            Bar bar = this.barService.findBarById(barId);
            Product product = new Product();
            product.setBar(bar);
            product.setType(type);
            product.setQuantity(quantity);
            product.setPrice(price);
            return proxyAdapter.adapt(this.productService.addProduct(product)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update product")
    public String updateProduct(@ShellOption(value = {"product id"}, help = "id of the product") Long productId,
                                @ShellOption(value = {"type"}, help = "type of product") String type,
                                @ShellOption(value = {"price"}, help = "price of the product") Long price,
                                @ShellOption(value = {"quantity"}, help = "quantity of the product") int quantity,
                                @ShellOption(value = {"bar id"}, help = "id of the bar") Long barId){
        try {
            Bar bar = this.barService.findBarById(barId);
            Product product = new Product();
            product.setPrice(price);
            product.setType(type);
            product.setProdcutId(productId);
            product.setBar(bar);
            product.setQuantity(quantity);

            return proxyAdapter.adapt(this.productService.updateProduct(product)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
