package map.project.slots.Controller;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Dto.ProductDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.Product;
import map.project.slots.Service.BarService;
import map.project.slots.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @Autowired
    private BarService barService;

    @GetMapping("/product")
    public List<ProductDto> findProdcuts(){
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product : this.productService.findAllProducts()){
            productDtoList.add((ProductDto) proxyAdapter.adapt(product));
        }
        return productDtoList;
    }

    @GetMapping("/find-product")
    public ProductDto findProductById(@RequestParam Long productId){
        try {
            return (ProductDto) proxyAdapter.adapt(this.productService.findProductById(productId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/delete-product")
    public ProductDto deleteProduct(@RequestParam Long productId){
        try {
            return (ProductDto) proxyAdapter.adapt(this.productService.deleteProductById(productId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/add-product")
    public ProductDto addProduct(@RequestParam String type,
                                 @RequestParam Long price,
                                 @RequestParam int quantity,
                                 @RequestParam Long barId){
        try {
            Bar bar = this.barService.findBarById(barId);
            Product product = new Product();
            product.setType(type);
            product.setPrice(price);
            product.setQuantity(quantity);
            return (ProductDto) proxyAdapter.adapt(this.productService.addProduct(product));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/update-product")
    public ProductDto updateProduct(@RequestParam Long productId,
                                    @RequestParam String type,
                                    @RequestParam Long price,
                                    @RequestParam int quantity,
                                    @RequestParam Long barId){
        try {
            Bar bar = this.barService.findBarById(barId);
            Product product = new Product();
            product.setProdcutId(productId);
            product.setType(type);
            product.setPrice(price);
            product.setQuantity(quantity);
            return (ProductDto) proxyAdapter.adapt(this.productService.updateProduct(product));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
