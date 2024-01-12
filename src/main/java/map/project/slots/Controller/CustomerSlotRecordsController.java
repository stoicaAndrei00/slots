package map.project.slots.Controller;

import map.project.slots.Model.Customer;
import map.project.slots.Model.CustomerSlotRecords;
import map.project.slots.Model.Dto.CustomerSlotRecordsDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.Slot;
import map.project.slots.Service.CustomerService;
import map.project.slots.Service.CustomerSlotRecordsService;
import map.project.slots.Service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/record")
public class CustomerSlotRecordsController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SlotService slotService;

    @Autowired
    private CustomerSlotRecordsService customerSlotRecordsService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @GetMapping("/records")
    public List<CustomerSlotRecordsDto> findAllRecords() {
        List<CustomerSlotRecordsDto> customerSlotRecordsDtoList = new ArrayList<>();
        for (CustomerSlotRecords customerSlotRecords : this.customerSlotRecordsService.findAllRecords()) {
            customerSlotRecordsDtoList.add((CustomerSlotRecordsDto) proxyAdapter.adapt(customerSlotRecords));
        }
        return customerSlotRecordsDtoList;
    }

    @GetMapping("/find-record")
    public CustomerSlotRecordsDto findRecordById(@RequestParam Long recordId) {
        try {
            return (CustomerSlotRecordsDto) proxyAdapter.adapt(this.customerSlotRecordsService.findRecordById(recordId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/delete-record")
    public CustomerSlotRecordsDto deleteRecord(@RequestParam Long recordId) {
        try {
            return (CustomerSlotRecordsDto) proxyAdapter.adapt(this.customerSlotRecordsService.deleteRecordById(recordId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/add-record")
    public CustomerSlotRecordsDto addRecord(@RequestParam Long slotId,
                                            @RequestParam Long customerId,
                                            @RequestParam Long winnings) {
        try {
            Slot slot = this.slotService.findSlotById(slotId);
            Customer customer = this.customerService.findCustomerById(customerId);
            CustomerSlotRecords customerSlotRecords = new CustomerSlotRecords();
            customerSlotRecords.setSlot(slot);
            customerSlotRecords.setCustomer(customer);
            customerSlotRecords.setWinning(winnings);
            return (CustomerSlotRecordsDto) proxyAdapter.adapt(this.customerSlotRecordsService.addRecord(customerSlotRecords));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/update-record")
    public CustomerSlotRecordsDto updateRecord(@RequestParam Long recordId,
                                               @RequestParam Long slotId,
                                               @RequestParam Long customerId,
                                               @RequestParam Long winnings) {
        try {
            Slot slot = this.slotService.findSlotById(slotId);
            Customer customer = this.customerService.findCustomerById(customerId);
            CustomerSlotRecords customerSlotRecords = new CustomerSlotRecords();
            customerSlotRecords.setRecordId(recordId);
            customerSlotRecords.setSlot(slot);
            customerSlotRecords.setCustomer(customer);
            customerSlotRecords.setWinning(winnings);
            return (CustomerSlotRecordsDto) proxyAdapter.adapt(this.customerSlotRecordsService.updateRecord(customerSlotRecords));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
