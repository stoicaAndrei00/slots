package map.project.slots.UI;

import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.Dto.SlotDto;
import map.project.slots.Model.Provider;
import map.project.slots.Model.Slot;
import map.project.slots.Service.ProviderService;
import map.project.slots.Service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class SlotUI {
    @Autowired
    private SlotService slotService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();
    @Autowired
    private ProviderService providerService = new ProviderService();

    @ShellMethod(key = "slots")
    public String findAllSlots() {
        List<SlotDto> slotDtos = new ArrayList<>();
        for (Slot slot : this.slotService.findAllSlots()) {
            slotDtos.add((SlotDto) proxyAdapter.adapt(slot));
        }
        return slotDtos.toString();
    }

    @ShellMethod(key = "find slot")
    public String findSlotById(@ShellOption(value = {"slot id"}, help = "id of the slot") Long slotId) {
        try {
            return proxyAdapter.adapt(this.slotService.findSlotById(slotId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete slot")
    public String deleteSlot(@ShellOption(value = {"slot id"}, help = "id of the slot") Long slotId) {
        try {
            return proxyAdapter.adapt(this.slotService.deleteSlotById(slotId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "add slot")
    public String addSlot(@ShellOption(value = {"title"}, help = "title of the slot") String title,
                          @ShellOption(value = {"provider id"}, help = "provider id") Long providerId) {
        try {
            Provider provider = this.providerService.findProviderById(providerId);
            Slot slot = new Slot();
            slot.setProvider(provider);
            slot.setTitle(title);
            return proxyAdapter.adapt(this.slotService.addSlot(slot)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update slot")
    public String updateSlot(@ShellOption(value = {"slot id"}, help = "id of the slot") Long slotId,
                             @ShellOption(value = {"title"}, help = "title of the slot") String title,
                             @ShellOption(value = {"provider id"}, help = "provider id") Long providerId){
        try{
            Provider provider = this.providerService.findProviderById(providerId);
            Slot slot = new Slot();
            slot.setSlotId(slotId);
            slot.setProvider(provider);
            slot.setTitle(title);
            return proxyAdapter.adapt(this.slotService.updateSlot(slot)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
