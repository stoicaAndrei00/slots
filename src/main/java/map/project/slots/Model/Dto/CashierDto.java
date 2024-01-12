package map.project.slots.Model.Dto;

public class CashierDto {
    private Long cashierId;

    private String name;

    private String email;

    private float salary;

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public CashierDto(Long cashierId, String name, String email, float salary) {
        this.cashierId = cashierId;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "CashierDto{" +
                "cashierId=" + cashierId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
