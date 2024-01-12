package map.project.slots.Controller;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Cashier;
import map.project.slots.Model.Dto.CashierDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Service.BarService;
import map.project.slots.Service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cashier")
public class CashierController {
    @Autowired
    private CashierService cashierService;

    @Autowired
    private BarService barService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @GetMapping("/all-cashiers")
    public List<CashierDto> findAllCashiers() {
        List<CashierDto> cashierDtos = new ArrayList<>();
        for (Cashier cashier : this.cashierService.findAllCashiers()) {
            cashierDtos.add((CashierDto) proxyAdapter.adapt(cashier));
        }
        return cashierDtos;
    }

    @GetMapping("/find-cashier")
    public CashierDto findCashierById(@RequestParam Long cashierId) {
        try {
            return (CashierDto) proxyAdapter.adapt(this.cashierService.findCashierById(cashierId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/delete-cashier")
    public CashierDto deleteCashier(@RequestParam Long cashierId) {
        try {
            return (CashierDto) proxyAdapter.adapt(this.cashierService.deleteCashierById(cashierId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/add-cashier")
    public CashierDto addCashier(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam Long salary,
                                 @RequestParam Long barId) {
        try {
            Bar bar = this.barService.findBarById(barId);
            Cashier cashier = new Cashier();
            cashier.setName(name);
            cashier.setEmail(email);
            cashier.setBar(bar);
            cashier.setSalary(salary);
            return (CashierDto) proxyAdapter.adapt(this.cashierService.addCashier(cashier));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/update-cashier")
    public CashierDto updateCashier(@RequestParam Long cashierId,
                                    @RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam Long salary,
                                    @RequestParam Long barId) {
        try {
            Bar bar = this.barService.findBarById(barId);
            Cashier cashier = new Cashier();
            cashier.setPersonId(cashierId);
            cashier.setName(name);
            cashier.setBar(bar);
            cashier.setSalary(salary);
            cashier.setEmail(email);
            return (CashierDto) proxyAdapter.adapt(this.cashierService.updateCashier(cashier));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
