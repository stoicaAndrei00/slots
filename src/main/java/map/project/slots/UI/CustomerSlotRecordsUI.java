package map.project.slots.UI;

import map.project.slots.Model.Customer;
import map.project.slots.Model.CustomerSlotRecords;
import map.project.slots.Model.Dto.CustomerSlotRecordsDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.Slot;
import map.project.slots.Service.CustomerService;
import map.project.slots.Service.CustomerSlotRecordsService;
import map.project.slots.Service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class CustomerSlotRecordsUI {
    @Autowired
    private CustomerSlotRecordsService customerSlotRecordsService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SlotService slotService;

    @ShellMethod(key = "records")
    public String findAllRecords(){
        List<CustomerSlotRecordsDto> customerSlotRecordsDtoList = new ArrayList<>();
        for (CustomerSlotRecords customerSlotRecords : this.customerSlotRecordsService.findAllRecords()){
            customerSlotRecordsDtoList.add((CustomerSlotRecordsDto) proxyAdapter.adapt(customerSlotRecords));
        }
        return customerSlotRecordsDtoList.toString();
    }

    @ShellMethod(key = "find record")
    public String findRecordById(@ShellOption(value = {"record id"} , help = "id of the record") Long recordId){
        try {
            return proxyAdapter.adapt(this.customerSlotRecordsService.findRecordById(recordId)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete record")
    public String deleteRecordById(@ShellOption(value = {"record id"} , help = "id of the record") Long recordId){
        try {
            return proxyAdapter.adapt(this.customerSlotRecordsService.deleteRecordById(recordId)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "add record")
    public String addRecord(@ShellOption(value = {"slot id"} , help = "id of the slot") Long slotId,
                            @ShellOption(value = {"customer id"} , help = "id of the customer") Long customerId,
                            @ShellOption(value = {"winnings"} , help = "winning of the customer per slot") Long winnings){
        try {
            Slot slot = this.slotService.findSlotById(slotId);
            Customer customer = this.customerService.findCustomerById(customerId);
            CustomerSlotRecords customerSlotRecords = new CustomerSlotRecords();
            customerSlotRecords.setCustomer(customer);
            customerSlotRecords.setSlot(slot);
            customerSlotRecords.setWinning(winnings);
            return proxyAdapter.adapt(this.customerSlotRecordsService.addRecord(customerSlotRecords)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update record")
    public String updateRecord(@ShellOption(value = {"record id"} , help = "id of the record") Long recordId,
                               @ShellOption(value = {"winnings"} , help = "winnings of the customer per slot") Long winnings,
                               @ShellOption(value = {"customer id"} , help = "id of the customer") Long customerId,
                               @ShellOption(value = {"slot id"} , help = "id of the slot") Long slotId){
        try {
            CustomerSlotRecords customerSlotRecords = new CustomerSlotRecords();
            customerSlotRecords.setRecordId(recordId);
            customerSlotRecords.setWinning(winnings);
            Slot slot = this.slotService.findSlotById(slotId);
            Customer customer = this.customerService.findCustomerById(customerId);
            customerSlotRecords.setCustomer(customer);
            customerSlotRecords.setSlot(slot);
            return proxyAdapter.adapt(this.customerSlotRecordsService.updateRecord(customerSlotRecords)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

}
