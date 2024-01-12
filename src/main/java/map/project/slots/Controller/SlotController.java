package map.project.slots.Controller;

import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.Dto.SlotDto;
import map.project.slots.Model.Provider;
import map.project.slots.Model.Slot;
import map.project.slots.Service.ProviderService;
import map.project.slots.Service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/slot")
public class SlotController {

    @Autowired
    private SlotService slotService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();
    @Autowired
    private ProviderService providerService = new ProviderService();

    @GetMapping("/slots")
    public List<SlotDto> findSlots() {
        List<SlotDto> slotDtos = new ArrayList<>();
        for (Slot slot : this.slotService.findAllSlots()) {
            slotDtos.add((SlotDto) proxyAdapter.adapt(slot));
        }
        return slotDtos;
    }

    @GetMapping("/find-slot")
    public SlotDto findSlot(@RequestParam Long slotId) {
        try {
            return (SlotDto) proxyAdapter.adapt(this.providerService.findProviderById(slotId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/delete-slot")
    public SlotDto deleteSlot(@RequestParam Long slotId) {
        try {
            return (SlotDto) proxyAdapter.adapt(this.providerService.deleteProviderById(slotId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/add-slot")
    public SlotDto addSlot(@RequestParam String title,
                           @RequestParam Long providerId) {
        try {
            Provider provider = this.providerService.findProviderById(providerId);
            Slot slot = new Slot();
            slot.setProvider(provider);
            slot.setTitle(title);
            return (SlotDto) proxyAdapter.adapt(this.slotService.addSlot(slot));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/update-slot")
    public SlotDto updateSlot(@RequestParam Long slotId,
                              @RequestParam String title,
                              @RequestParam Long providerId){
        try {
            Provider provider = this.providerService.findProviderById(providerId);
            Slot slot = new Slot();
            slot.setSlotId(slotId);
            slot.setProvider(provider);
            slot.setTitle(title);
            return (SlotDto) proxyAdapter.adapt(this.slotService.updateSlot(slot));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
