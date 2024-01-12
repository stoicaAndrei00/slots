package map.project.slots.AdapterTest;

import map.project.slots.Model.Dto.Adapter.SlotAdapter;
import map.project.slots.Model.Dto.SlotDto;
import map.project.slots.Model.Provider;
import map.project.slots.Model.Slot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlotAdapterTest {

    @Test
    public void adaptToDtoTest(){
        Provider provider = new Provider();
        provider.setProviderId(1L);
        provider.setName("Superbet");

        Slot slot = new Slot();
        slot.setSlotId(1L);
        slot.setTitle("Smeker");
        slot.setProvider(provider);

        SlotDto slotDto = new SlotAdapter().adaptToDto(slot);
        Assertions.assertEquals(slotDto.getSlotId() , slot.getSlotId());
        Assertions.assertEquals(slotDto.getTitle() , slot.getTitle());
        Assertions.assertEquals(slotDto.getProviderName() , slot.getProvider().getName());
    }
}
