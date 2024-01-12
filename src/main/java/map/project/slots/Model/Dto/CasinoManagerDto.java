package map.project.slots.Model.Dto;

import java.sql.Date;

public class CasinoManagerDto {
    private Long managerId;

    private String name;

    private String email;

    private float salary;

    private Date hireDate;

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public CasinoManagerDto(Long managerId, String name, String email, float salary, Date hireDate) {
        this.managerId = managerId;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "CasinoManagerDto{" +
                "managerId=" + managerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}
