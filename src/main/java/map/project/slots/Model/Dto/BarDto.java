package map.project.slots.Model.Dto;

/**
 * dto class for bar we will use the dtos for printing information
 * for UI and controller layer
 */
public class BarDto {

    private Long barId;

    private String barName;

    private int capacity;

    public Long getBarId() {
        return barId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "BarDto{" +
                "barId=" + barId +
                ", barName='" + barName + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    public BarDto(Long barId, String barName, int capacity) {
        this.barId = barId;
        this.barName = barName;
        this.capacity = capacity;
    }
}
