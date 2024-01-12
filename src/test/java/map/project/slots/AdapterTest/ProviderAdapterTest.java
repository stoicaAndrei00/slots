package map.project.slots.AdapterTest;

import map.project.slots.Model.Dto.Adapter.ProviderAdapter;
import map.project.slots.Model.Dto.ProviderDto;
import map.project.slots.Model.Provider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProviderAdapterTest {

    @Test
    public void adaptToDtoTest(){
        Provider provider = new Provider();
        provider.setProviderId(1L);
        provider.setName("Superbet");

        ProviderDto providerDto = new ProviderAdapter().adaptToDto(provider);

        Assertions.assertEquals(providerDto.getProviderId() , provider.getProviderId());
        Assertions.assertEquals(providerDto.getProiderName() , provider.getName());
    }
}
