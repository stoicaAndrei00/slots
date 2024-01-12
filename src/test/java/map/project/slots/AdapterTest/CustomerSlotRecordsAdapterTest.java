package map.project.slots.AdapterTest;

import map.project.slots.Model.Customer;
import map.project.slots.Model.CustomerSlotRecords;
import map.project.slots.Model.Dto.Adapter.CustomerAdapter;
import map.project.slots.Model.Dto.Adapter.CustomerSlotRecordsAdapter;
import map.project.slots.Model.Dto.Adapter.SlotAdapter;
import map.project.slots.Model.Dto.CustomerDto;
import map.project.slots.Model.Dto.CustomerSlotRecordsDto;
import map.project.slots.Model.Dto.SlotDto;
import map.project.slots.Model.Provider;
import map.project.slots.Model.Slot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerSlotRecordsAdapterTest {
    @Test
    public void adaptToDtoTest(){
        Provider provider = new Provider();
        provider.setProviderId(1L);
        provider.setName("Superbet");

        Slot slot = new Slot();
        slot.setSlotId(1L);
        slot.setTitle("Smeker");
        slot.setProvider(provider);
        Customer customer = new Customer();
        customer.setPersonId(1L);
        customer.setEmail("toader@gmail.com");
        customer.setName("tudix");
        customer.setTotalSpendings(1500);
        customer.setLoyaltyPoints(44);

        CustomerSlotRecords records = new CustomerSlotRecords();
        records.setRecordId(1L);
        records.setSlot(slot);
        records.setCustomer(customer);
        records.setWinning(3000);

        CustomerSlotRecordsDto recordsDto = new CustomerSlotRecordsAdapter().adaptToDto(records);
        SlotDto slotDto = new SlotAdapter().adaptToDto(slot);
        CustomerDto customerDto = new CustomerAdapter().adaptToDto(customer);
        Assertions.assertEquals(recordsDto.getRecordId() , records.getRecordId());
        Assertions.assertEquals(recordsDto.getSlotDto().getSlotId() , slotDto.getSlotId());
        Assertions.assertEquals(recordsDto.getSlotDto().getTitle() , slotDto.getTitle());
        Assertions.assertEquals(recordsDto.getSlotDto().getProviderName() , slotDto.getProviderName());
        Assertions.assertEquals(recordsDto.getCustomerInformation().getCustomerId() , customerDto.getCustomerId());
        Assertions.assertEquals(recordsDto.getCustomerInformation().getTotalSpendings() , customerDto.getTotalSpendings());
        Assertions.assertEquals(recordsDto.getCustomerInformation().getEmail() , customerDto.getEmail());
        Assertions.assertEquals(recordsDto.getCustomerInformation().getName() , customerDto.getName());
        Assertions.assertEquals(recordsDto.getCustomerInformation().getTotalSpendings() , customerDto.getTotalSpendings());
    }
}
