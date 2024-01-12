package map.project.slots.Model.Dto;

public class SlotDto {

    private Long slotId;

    private String title;

    private String providerName;

    public SlotDto(Long slotId, String title, String providerName) {
        this.slotId = slotId;
        this.title = title;
        this.providerName = providerName;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public String toString() {
        return "SlotDto{" +
                "slotId=" + slotId +
                ", title='" + title + '\'' +
                ", providerName='" + providerName + '\'' +
                '}';
    }
}
