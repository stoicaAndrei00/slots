package map.project.slots.Model.Dto;

import map.project.slots.Model.Slot;

public class CustomerSlotRecordsDto {

    private Long recordId;

    private CustomerDto customerDto;

    private SlotDto slotDto;

    public CustomerSlotRecordsDto(Long recordId, CustomerDto customerInformation, SlotDto slotDto) {
        this.recordId = recordId;
        this.customerDto = customerInformation;
        this.slotDto = slotDto;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public CustomerDto getCustomerInformation() {
        return customerDto;
    }

    public void setCustomerInformation(CustomerDto customerInformation) {
        this.customerDto = customerInformation;
    }

    public SlotDto getSlotDto() {
        return slotDto;
    }

    public void setSlotDto(SlotDto slotDto) {
        this.slotDto = slotDto;
    }

    @Override
    public String toString() {
        return "CustomerSlotRecordsDto{" +
                "recordId=" + recordId +
                ", customerInformation=" + customerDto+
                ", slotDto=" + slotDto +
                '}';
    }
}
