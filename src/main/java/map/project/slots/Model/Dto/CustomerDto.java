package map.project.slots.Model.Dto;

public class CustomerDto {

    private Long customerId;

    private String name;

    private String email;

    private int loyaltyPoints;

    private float totalSpendings;

    public CustomerDto(Long customerId, String name, String email, int loyaltyPoints, float totalSpendings) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
        this.totalSpendings = totalSpendings;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public float getTotalSpendings() {
        return totalSpendings;
    }

    public void setTotalSpendings(float totalSpendings) {
        this.totalSpendings = totalSpendings;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                ", totalSpendings=" + totalSpendings +
                '}';
    }
}
