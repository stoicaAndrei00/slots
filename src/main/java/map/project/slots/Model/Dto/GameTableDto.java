package map.project.slots.Model.Dto;

public class GameTableDto {

    private Long gameTableId;

    private String title;

    private String type;

    private int capacity;

    public GameTableDto(Long gameTableId, String title, String type, int capacity) {
        this.gameTableId = gameTableId;
        this.title = title;
        this.type = type;
        this.capacity = capacity;
    }

    public Long getGameTableId() {
        return gameTableId;
    }

    public void setGameTableId(Long gameTableId) {
        this.gameTableId = gameTableId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "GameTableDto{" +
                "gameTableId=" + gameTableId +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
