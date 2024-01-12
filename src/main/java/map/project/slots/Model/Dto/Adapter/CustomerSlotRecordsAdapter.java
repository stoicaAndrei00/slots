package map.project.slots.Model.Dto.Adapter;

import map.project.slots.Model.CustomerSlotRecords;
import map.project.slots.Model.Dto.CustomerSlotRecordsDto;

public class CustomerSlotRecordsAdapter implements Adapter<CustomerSlotRecords , CustomerSlotRecordsDto> {
    @Override
    public CustomerSlotRecordsDto adaptToDto(CustomerSlotRecords object) {
        return new CustomerSlotRecordsDto(object.getRecordId(),new CustomerAdapter().adaptToDto(object.getCustomer()),
                new SlotAdapter().adaptToDto(object.getSlot()));
    }
}
