package map.project.slots.Model.Dto;

public class ProviderDto {

    private Long providerId;

    private String proiderName;

    public ProviderDto(Long providerId, String proiderName) {
        this.providerId = providerId;
        this.proiderName = proiderName;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getProiderName() {
        return proiderName;
    }

    public void setProiderName(String proiderName) {
        this.proiderName = proiderName;
    }

    @Override
    public String toString() {
        return "ProviderDto{" +
                "providerId=" + providerId +
                ", proiderName='" + proiderName + '\'' +
                '}';
    }
}
