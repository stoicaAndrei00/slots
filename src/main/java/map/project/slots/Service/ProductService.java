package map.project.slots.Service;

import jakarta.transaction.Transactional;
import map.project.slots.Model.Exceptions.ProductException;
import map.project.slots.Model.Product;
import map.project.slots.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return this.productRepository.findAll();
    }

    public Product findProductById(Long productId) throws ProductException {
        Optional<Product> product = this.productRepository.findByProdcutId(productId);
        if(product.isEmpty()){
            throw  new ProductException();
        }
        return product.get();
    }
    @Transactional
    public Product deleteProductById(Long productId) throws ProductException{
        Optional<Product> product = this.productRepository.findByProdcutId(productId);
        if (product.isEmpty()){
            throw new ProductException();
        }
        this.productRepository.deleteByProdcutId(productId);
        return product.get();
    }

    public Product addProduct(Product product) {
        this.productRepository.save(product);
        return product;
    }

    public Product updateProduct(Product product) throws ProductException {
        Optional<Product> optionalProduct = this.productRepository.findByProdcutId(product.getProdcutId());
        if(optionalProduct.isEmpty()){
            throw new ProductException();
        }
        if(product.getQuantity() == 0){
            product.getBar().notifyCustomers();
        }
        this.productRepository.save(product);
        return product;
    }
}
