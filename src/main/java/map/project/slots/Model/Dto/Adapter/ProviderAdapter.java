package map.project.slots.Model.Dto.Adapter;

import map.project.slots.Model.Dto.ProviderDto;
import map.project.slots.Model.Provider;

public class ProviderAdapter implements Adapter<Provider, ProviderDto> {
    @Override
    public ProviderDto adaptToDto(Provider object) {
        return new ProviderDto(object.getProviderId(),
                object.getName());
    }
}
