package map.project.slots.Model.Dto.Adapter;

import map.project.slots.Model.Dto.SlotDto;
import map.project.slots.Model.Slot;

public class SlotAdapter implements Adapter<Slot, SlotDto> {
    @Override
    public SlotDto adaptToDto(Slot object) {
        return new SlotDto(object.getSlotId(),
                object.getTitle(),
                object.getProvider().getName());
    }
}
