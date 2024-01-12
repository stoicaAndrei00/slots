package map.project.slots.Model.Dto;

public class ProductDto {

    private Long productId;

    private String type;

    private Long price;

    private int quantity;

    public ProductDto(Long productId, String type, Long price, int quantity) {
        this.productId = productId;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
