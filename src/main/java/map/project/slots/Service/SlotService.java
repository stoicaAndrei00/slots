package map.project.slots.Service;

import jakarta.transaction.Transactional;
import map.project.slots.Model.Exceptions.SlotException;
import map.project.slots.Model.Slot;
import map.project.slots.Repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotService {

    @Autowired
    private SlotRepository slotRepository;

    public List<Slot> findAllSlots() {
        return this.slotRepository.findAll();
    }

    public Slot findSlotById(Long slotId) throws SlotException {
        Optional<Slot> slot = this.slotRepository.findBySlotId(slotId);
        if (slot.isEmpty()) {
            throw new SlotException();
        }
        return slot.get();
    }
    @Transactional
    public Slot deleteSlotById(Long slotId) throws SlotException {
        Optional<Slot> slot = this.slotRepository.findBySlotId(slotId);
        if (slot.isEmpty()) {
            throw new SlotException();
        }
        this.slotRepository.deleteBySlotId(slotId);
        return slot.get();
    }

    public Slot addSlot(Slot slot) {
        this.slotRepository.save(slot);
        return slot;
    }

    public Slot updateSlot(Slot slot) throws SlotException {
        Optional<Slot> optionalSlot = this.slotRepository.findBySlotId(slot.getSlotId());
        if (optionalSlot.isEmpty()) {
            throw new SlotException();
        }
        this.slotRepository.save(slot);
        return slot;
    }
}
